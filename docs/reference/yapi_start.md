学习不走弯路，[关注公众号](#公众号) 回复「学习路线」，获取mall项目专属学习路线！

# 当Swagger遇上YApi，瞬间高大上了！

> Swagger经常被人吐槽界面不够好看、功能不够强大，其实有很多工具可以和Swagger结合使用，结合之后就会变得非常好用。之前写过一篇文章[《Swagger界面丑、功能弱怎么破？用Postman增强下就给力了！》](https://mp.weixin.qq.com/s/rbKUJAhv6WorFWgDNUDWTg)，有朋友留言说YApi也很好用。最近体验了一把YApi，发现确实不错，推荐给大家！

## YApi简介

YApi是高效、易用、功能强大的API管理平台，旨在为开发、产品、测试人员提供更优雅的接口管理服务。YApi在Github上已累计获得了18K+Star，具有优秀的交互体验，YApi不仅提供了常用的接口管理功能，还提供了权限管理、Mock数据、Swagger数据导入等功能，总之功能很强大！

## 安装

### 环境准备

> 本地部署YApi需要先安装nodejs和MongoDB，我们先把它们安装好。

- 安装nodejs，直接下载安装包双击安装即可，这里安装的是`12.14.0`版本，下载地址：https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi;

- 安装MongoDB，参考[《MongoDB快速入门，掌握这些刚刚好！》](https://mp.weixin.qq.com/s/E8sDVWkxaLBdmZPj-6om2A)中的安装即可，这里安装的是`4.2.5`版本。

### 安装yapi-cli

> `yapi-cli`是YApi官方提供的安装工具，可以通过可视化界面来部署YApi服务，非常方便！

- 使用npm命令来安装`yapi-cli`：

```bash
npm install -g yapi-cli --registry https://registry.npm.taobao.org
```

- 安装成功后控制台输出如下内容；

![](../images/yapi_start_01.png)

- 安装成功后使用`yapi server`命令来启动YApi的可视化部署界面。

```bash
yapi server
```

### 安装YApi

- 通过可视化部署界面安装YApi服务，访问地址：http://localhost:9090

![](../images/yapi_start_02.png)

- 安装完成后会输出如下信息，提示YApi的默认管理员账号密码及访问地址；

![](../images/yapi_start_03.png)

- 进入YApi的安装目录，使用node命令启动YApi服务：

```bash
node vendors/server/app.js
```

- 启动成功后控制台输出信息如下；

![](../images/yapi_start_04.png)

- 通过页面访问Yapi，默认账号密码为`admin@admin.com:ymfe.org`，访问地址：http://localhost:3000

![](../images/yapi_start_05.png)

## 使用

### 从Swagger导入数据

- 使用管理员账号登录成功后，先创建一个`mall-tiny-group`分组；

![](../images/yapi_start_06.png)

- 创建分组成功后，在该分组下点击`创建项目`，添加`mall-tiny-swagger`项目；

![](../images/yapi_start_07.png)

- 之后启动我们之前的`mall-tiny-swagger`项目，启动成功后Swagger接口文档访问地址：http://localhost:8088/swagger-ui/

![](../images/yapi_start_08.png)

- 选择好YApi的`数据管理`功能，配置好Swagger的api-docs路径，然后进行数据导入；

![](../images/yapi_start_09.png)

- 至此Swagger中的API接口已成功导入到YApi，点击`接口`标签查看所有导入接口。

![](../images/yapi_start_10.png)

### 接口管理

- 打开`添加商品`的接口看看，可以看到非常完善的接口文档信息，注释都有了；

![](../images/yapi_start_11.png)

- 来试试接口运行功能，我们会发现默认的接口请求地址并不符合我们的要求，需要在`环境配置`中设置；

![](../images/yapi_start_12.png)

- 由于是跨域请求，Chrome浏览器需要安装跨域请求插件，下载地址：https://github.com/YMFE/cross-request/archive/master.zip

![](../images/yapi_start_13.png)

- 由于我们的部分接口在请求头中添加token才能访问，所以我们先调用登录接口获取token；

![](../images/yapi_start_14.png)

- 之后在`设置->环境配置`中添加Authorization头；

![](../images/yapi_start_15.png)

- 再次调用需要登录的接口，可以正常获取到数据，返回数据虽然格式化了，但是没有折叠功能，数据太长的话就不太好看了；

![](../images/yapi_start_16.png)

### Mock功能

- 在我们调用POST接口提交JSON数据时，默认Mock的JSON数据有点不太符合我们的要求；

![](../images/yapi_start_17.png)

- 可以通过接口信息中的`编辑->高级设置`进行修改；

![](../images/yapi_start_18.png)

- 我们可以发现每一个接口信息中都有个Mock地址，当我们后台接口已经定义好格式，但是没有实现时，前端可以使用该地址来Mock数据进行调试；

![](../images/yapi_start_19.png)

- 调用Mock地址可以获取到一些测试数据，数据取值返回可以通过上面的Mock设置自行修改；

![](../images/yapi_start_20.png)

### 从Swagger自动同步

- 当我们的接口修改了，API文档如何同步呢，我们可以通过`设置->Swagger自动同步`来开启自动同步功能，有三种数据同步模式可以选择；

![](../images/yapi_start_21.png)

### 权限管理

> 如果有新的成员加入进来，需要查看API文档怎么办？

- 首先可以通过注册界面注册一个成员账号，此处账号为`test@qq.com:123456`；

![](../images/yapi_start_22.png)

- 之后使用管理员账号登录，然后通过`成员列表->添加成员`，将用户添加到相应分组；

![](../images/yapi_start_23.png)

- 最后使用成员账号登录即可访问相应API文档了。

![](../images/yapi_start_24.png)

## 总结

YApi结合Swagger使用果然很强大！之前使用Postman结合Swagger使用时，文档查看、自动同步的问题都得到了解决，为了保证我们API文档访问的安全性还提供了权限管理功能。当API数据格式定义好后，Mock功能让前端无需后台实现也可以调试接口。不过对于JSON格式支持有点偏弱，要是能对JSON数据进行折叠显示就更好了！

## 参考资料

官方文档：https://hellosean1025.github.io/yapi/documents/index.html

## 项目源码地址

https://github.com/macrozheng/mall-learning/tree/master/mall-tiny-swagger

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)