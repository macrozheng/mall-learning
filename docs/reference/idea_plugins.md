学习不走弯路，[关注公众号](#公众号) 回复「学习路线」，获取mall项目专属学习路线！

# 我常用的IDEA插件大公开，个个是精品！

> 总结了平时工作中常用的12款IDEA插件，后端和前端的都有了，附上我的使用技巧，看完之后开发效率杠杠的！

## Lombok

> Lombok为Java项目提供了非常有趣的附加功能，使用它的注解可以有效的地解决那些繁琐又重复的代码，例如 Setter、Getter、toString、equals、hashCode 以及非空判断等。

- 举个例子，我们给一个类添加@Getter和@Setter注解：

```java
/**
 * 修改订单费用信息参数
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsMoneyInfoParam {
    private Long orderId;
    private BigDecimal freightAmount;
    private BigDecimal discountAmount;
    private Integer status;
}
```

- Lombok就会为我们自动生成所有属性的Getter和Setter方法。

![](../images/idea_plugins_01.png)

## Free MyBatis Plugin

> MyBatis扩展插件，可以在Mapper接口的方法和xml实现之间自由跳转，也可以用来一键生成某些xml实现。

- 我们可以通过Mapper接口中方法左侧的箭头直接跳转到对应的xml实现中去；

![](../images/idea_plugins_02.png)

- 也可以从xml中Statement左侧的箭头直接跳转到对应的Mapper接口方法中去；

![](../images/idea_plugins_03.png)

- 还可以通过`Alt+Enter`键组合直接生成新方法的xml实现，使用起来是不是很方便！

![](../images/idea_plugins_04.png)

## MyBatis Log Plugin

> 有时候我们需要运行过程中产生的SQL语句来帮助我们排查某些问题，这款插件可以把Mybatis输出的SQL日志还原成完整的SQL语句，就不需要我们去手动转换了。

- 首先我们需要打开这款插件的窗口；

![](../images/idea_plugins_05.png)

- 当我们调用方法，控制台输出Mybatis的SQL日志时；

```
2020-04-28 15:52:20.455 DEBUG 13960 --- [nio-8081-exec-1] c.m.m.m.UmsAdminMapper.selectByExample   : ==>  Preparing: select id, username, password, icon, email, nick_name, note, create_time, login_time, status from ums_admin WHERE ( username = ? ) 
2020-04-28 15:52:20.456 DEBUG 13960 --- [nio-8081-exec-1] c.m.m.m.UmsAdminMapper.selectByExample   : ==> Parameters: admin(String)
2020-04-28 15:52:20.463 DEBUG 13960 --- [nio-8081-exec-1] c.m.m.m.UmsAdminMapper.selectByExample   : <==      Total: 1
```

- 该插件会自动帮我们转换成对应的SQL语句；

```
1  2020-04-28 15:50:40.487 DEBUG 9512 --- [nio-8081-exec-9] c.m.m.m.UmsAdminMapper.selectByExample   : ==>
select id, username, password, icon, email, nick_name, note, create_time, login_time, status
 FROM ums_admin
 WHERE ( username = 'admin' );
```

- 有的时候我们需要转换的日志并不在自己的控制台上，这时可以使用插件的`SQL Text`功能：

![](../images/idea_plugins_06.png)

- 直接复制我们需要转换的日志，然后点击`Restore Sql`按钮即可。

![](../images/idea_plugins_07.png)

## RestfulToolkit

> 一套Restful服务开发辅助工具集，提供了项目中的接口概览信息，可以根据URL跳转到对应的接口方法中去，内置了HTTP请求工具，对请求方法做了一些增强功能，总之功能很强大！

- 可以通过右上角的`RestServices`按钮显示项目中接口的概览信息；

![](../images/idea_plugins_08.png)

- 可以通过搜索按钮，根据URL搜索对应接口；

![](../images/idea_plugins_09.png)

- 可以通过底部的HTTP请求工具来发起接口测试请求；

![](../images/idea_plugins_10.png)

- 通过在接口方法上右键可以生成查询参数、请求参数、请求URL；

![](../images/idea_plugins_11.png)

- 通过在实体类上右键可以直接生成实体类对应的JSON；

![](../images/idea_plugins_12.png)

## Translation

> 一款翻译插件，支持Google、有道、百度翻译，对我们看源码时看注释很有帮助！

- 直接选中需要翻译的内容，点击右键即可找到翻译按钮；

![](../images/idea_plugins_13.png)

- 直接使用`翻译文档`可以将整个文档都进行翻译；

![](../images/idea_plugins_14.png)

- 还可以通过右上角的翻译按钮直接翻译指定内容。

![](../images/idea_plugins_15.png)

## GsonFormat

> 这款插件可以把JSON格式的字符串转化为实体类，当我们要根据JSON字符串来创建实体类的时候用起来很方便。

- 首先我们需要先创建一个实体类，然后在类名上右键`Generate`，之后选择`GsonFormat`；

![](../images/idea_plugins_16.png)

- 输入我们需要转换的JSON字符串：

![](../images/idea_plugins_17.png)

- 选择性更改属性名称和类型：

![](../images/idea_plugins_18.png)

- 点击确定后直接生成实体类。

![](../images/idea_plugins_19.png)

## Grep Console

> 一款帮你分析控制台日志的插件，可以对不同级别的日志进行不同颜色的高亮显示，还可以用来按关键字搜索日志内容。

- 当项目打印日志的时候，可以发现不同日志级别的日志会以不同颜色来显示；

![](../images/idea_plugins_20.png)

- 如果你需要修改配色方案的话，可以通过`Tools`打开该插件的配置菜单；

![](../images/idea_plugins_21.png)

- 然后通过配置菜单修改配色方案；

![](../images/idea_plugins_22.png)

- 可以通过在控制台右键并使用`Grep`按钮来调出日志分析的窗口：

![](../images/idea_plugins_23.png)

- 然后直接通过关键字来搜索即可。

![](../images/idea_plugins_24.png)

## Alibaba Java Coding Guidelines

> 阿里巴巴《Java 开发手册》配套插件，可以实时检测代码中不符合手册规约的地方，助你码出高效，码出质量。

- 比如说手册里有这么一条；

![](../images/idea_plugins_25.png)

- 当我们违反手册规约时，该插件会自动检测并进行提示；

![](../images/idea_plugins_26.png)

- 同时提供了一键检测所有代码规约情况和切换语言的功能；

![](../images/idea_plugins_27.png)

- 如果你想修改某条规约的检测规则的话，可以通过设置的`Editor->Inspections`进行修改。

![](../images/idea_plugins_28.png)

## Maven Helper

> 解决Maven依赖冲突的好帮手，可以快速查找项目中的依赖冲突，并予以解决！

- 我们可以通过`pom.xml`文件底部的`依赖分析`标签页查看当前项目中的所有依赖；

![](../images/idea_plugins_29.png)

- 通过`冲突`按钮我们可以筛选出所有冲突的依赖，当前项目`guava`依赖有冲突，目前使用的是`18.0`版本；

![](../images/idea_plugins_30.png)

- 选中有冲突的依赖，点击`Exclude`按钮可以直接排除该依赖；

![](../images/idea_plugins_31.png)

- 同时`pom.xml`中也会对该依赖添加`<exclusion>`标签，是不是很方便啊！

![](../images/idea_plugins_32.png)

## Statistic

> 一款代码统计工具，可以用来统计当前项目中代码的行数和大小。

- 我们可以通过顶部菜单中的`View->Tool Windows->Statistic`按钮开启该功能；

![](../images/idea_plugins_33.png)

- 此时就可以看到我们项目代码的统计情况了，比如我的开源项目`mall`中`java`代码大小为`2818kB`，行数为`85645`。

![](../images/idea_plugins_34.png)

## Vue.js

> Vue.js支持插件，写过前端的朋友肯定用过，可以根据模板创建`.vue`文件，也可以对Vue相关代码进行智能提示。

- 启用该插件后，可以根据模板新建`.vue`文件；

![](../images/idea_plugins_35.png)

- 当我们在标签中写入以`v-`开头的代码时，会提示Vue中的相关指令。

![](../images/idea_plugins_36.png)

## element

> Element-UI支持插件，可以对Element-UI中的标签进行智能提示，有了它就不用盲写相关代码了！

- 当我们写入以`el-`开头的标签时，会提示Element-UI相关组件。

![](../images/idea_plugins_37.png)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)

