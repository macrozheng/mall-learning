mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# 仅需四步，整合SpringSecurity+JWT实现登录认证！

> 学习过我的mall项目的应该知道，`mall-admin`模块是使用SpringSecurity+JWT来实现登录认证的，而`mall-portal`模块是使用的SpringSecurity基于Session的默认机制来实现登陆认证的。很多小伙伴都找不到`mall-portal`的登录接口，最近我把这两个模块的登录认证给统一了，都使用SpringSecurity+JWT的形式实现。
主要是通过把登录认证的通用逻辑抽取到了`mall-security`模块来实现的，下面我们讲讲如何使用`mall-security`模块来实现登录认证，仅需四步即可。

## 整合步骤

> 这里我们以`mall-portal`改造为例来说说如何实现。

- 第一步，给需要登录认证的模块添加`mall-security`依赖：

```xml
<dependency>
    <groupId>com.macro.mall</groupId>
    <artifactId>mall-security</artifactId>
</dependency>
```

- 第二步，添加MallSecurityConfig配置类，继承`mall-security`中的SecurityConfig配置，并且配置一个UserDetailsService接口的实现类，用于获取登录用户详情：

```java
/**
 * mall-security模块相关配置
 * Created by macro on 2019/11/5.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MallSecurityConfig extends SecurityConfig {

    @Autowired
    private UmsMemberService memberService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> memberService.loadUserByUsername(username);
    }
}
```

- 第三步，在application.yml中配置下不需要安全保护的资源路径：

```yaml
secure:
  ignored:
    urls: #安全路径白名单
      - /swagger-ui.html
      - /swagger-resources/**
      - /swagger/**
      - /**/v2/api-docs
      - /**/*.js
      - /**/*.css
      - /**/*.png
      - /**/*.ico
      - /webjars/springfox-swagger-ui/**
      - /druid/**
      - /actuator/**
      - /sso/**
      - /home/**
```

- 第四步，在UmsMemberController中实现登录和刷新token的接口：

```java
/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password) {
        String token = memberService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = memberService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
```

## 实现原理

> 将SpringSecurity+JWT的代码封装成通用模块后，就可以方便其他需要登录认证的模块来使用，下面我们来看看它是如何实现的，首先我们看下`mall-security`的目录结构。

### 目录结构

``` lua
mall-security
├── component
|    ├── JwtAuthenticationTokenFilter -- JWT登录授权过滤器
|    ├── RestAuthenticationEntryPoint -- 自定义返回结果：未登录或登录过期
|    └── RestfulAccessDeniedHandler -- 自定义返回结果：没有权限访问时
├── config
|    ├── IgnoreUrlsConfig -- 用于配置不需要安全保护的资源路径
|    └── SecurityConfig -- SpringSecurity通用配置
└── util
     └── JwtTokenUtil -- JWT的token处理工具类
```

### 做了哪些变化

> 其实我也就添加了两个类，一个IgnoreUrlsConfig，用于从application.yml中获取不需要安全保护的资源路径。一个SecurityConfig提取了一些SpringSecurity的通用配置。

- IgnoreUrlsConfig中的代码：

```java
/**
 * 用于配置不需要保护的资源路径
 * Created by macro on 2018/11/5.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

}
```

- SecurityConfig中的代码：

```java
/**
 * 对SpringSecurity的配置的扩展，支持自定义白名单资源路径和查询用户逻辑
 * Created by macro on 2019/11/5.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        //不需要保护的资源路径允许访问
        for (String url : ignoreUrlsConfig().getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        // 任何请求需要身份认证
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

}
```

## 项目源码地址

[https://github.com/macrozheng/mall](https://github.com/macrozheng/mall)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)