package com.macro.mall.tiny.config;

import com.macro.mall.tiny.component.JwtAuthenticationTokenFilter;
import com.macro.mall.tiny.component.RestAuthenticationEntryPoint;
import com.macro.mall.tiny.component.RestfulAccessDeniedHandler;
import com.macro.mall.tiny.dto.AdminUserDetails;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;


/**
 * SpringSecurity的配置
 */
@Configuration
@EnableWebSecurity //todo:注解使得SpringMVC集成了Spring Security的web安全支持
@EnableGlobalMethodSecurity(prePostEnabled=true)//前置注解[@PreAuthorize,@PostAuthorize,..] 是否启用
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //todo：@Lazy可防止循环注入问题
    @Lazy //Requested bean is currently in creation: Is there an unresolvable circular reference?
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    /**
     * 自定义Security策略
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()// 由于使用的是JWT，我们这里不需要csrf(默认开启了CSRF)
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Spring Security永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
                .and()
                .authorizeRequests()  //authorizeRequests()配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                .antMatchers("/admin/login", "/admin/register")// 对登录注册要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
//                .antMatchers("/**")//测试时全部运行访问
//                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter ，在UsernamePasswordAuthenticationFilter 之前添加jwtAuthenticationTokenFilter
        // 在用户名和密码校验前添加的过滤器，如果请求中有jwt的token且有效，会取出token中的用户名，然后调用SpringSecurity的API进行登录操作。
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)            //当访问接口没有权限时，自定义的返回结果
                .authenticationEntryPoint(restAuthenticationEntryPoint);    //当未登录或者token失效访问接口时，自定义的返回结果
//        httpSecurity.formLogin().loginPage("/login"); //没登录时自动登陆
    }

    /**
     * 自定义认证策略
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    /**
     * todo：@bean因为调用该方法是会首先判断时候已经通过cglib代理创建了实例，如果已经创建好了的话，则返回当前的实例
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UmsAdmin admin = adminService.getAdminByUsername(username); //得到用户名
                if (admin != null) {
                    List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId()); //得到权限
                    return new AdminUserDetails(admin,permissionList); //将查询到的用户名和权限列表放在UserDetails中
                }
                throw new UsernameNotFoundException("用户名或密码错误");
            }
        };
        //获取登录用户信息
//        return username -> {
//            UmsAdmin admin = adminService.getAdminByUsername(username);
//            if (admin != null) {
//                List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId());
//                return new AdminUserDetails(admin,permissionList);
//            }
//            throw new UsernameNotFoundException("用户名或密码错误");
//        };
    }

    /**
     * todo：采用此方式可以有效避免循环注入问题。
     * todo：并且-----不要对有@Configuration注解的配置类进行Field级的依赖注入。
     * @return
     * @throws Exception
     */
//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
//        return new JwtAuthenticationTokenFilter();
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
