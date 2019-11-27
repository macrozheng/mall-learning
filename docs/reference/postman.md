mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# Postman：API接口调试利器

> Postman是一款API接口调试工具，使用它可以很方便的对接口进行测试，并且后端人员可以将自己的调试结果导出，方便前端人员调试。

## 安装

- 下载地址：https://www.getpostman.com/downloads/
- 下载完安装包后直接双击安装即可。

## 设置

### 主题设置

这里不得不说，Postman的界面还是做的很好的，比起Swagger来说好多了，Postman默认提供了两种主题，一种亮色和一种暗色，可以通过左上角的File->Settings按钮打开。

![](../images/postman_screen_01.png)

![](../images/postman_screen_02.png)

### 调整字体大小

可能界面默认的字体大小并不适合你，尤其是大屏幕的电脑，可以在View下的Zoom In和Zoom Out按钮进行放大和缩小。

![](../images/postman_screen_03.png)

## 进行接口调试

> 测试接口均来自mall-admin后台，启动后可以直接测试。

### 调用GET请求

![](../images/postman_screen_04.png)

### 调用POST请求提交JSON格式数据

![](../images/postman_screen_05.png)

### 调用POST请求提交表单

![](../images/postman_screen_06.png)

### 调用文件上传接口

![](../images/postman_screen_07.png)

![](../images/postman_screen_08.png)

### 调用需要登录的接口

### 调用登录接口获取令牌

![](../images/postman_screen_09.png)

### 设置令牌头并调用需要登录的接口

![](../images/postman_screen_10.png)

## 调试文件的导入与导出

### 将调试接口信息进行保存

![](../images/postman_screen_11.png)

![](../images/postman_screen_12.png)

### 导出Collection中的调试信息

![](../images/postman_screen_17.png)

### 导入Collection中的调试信息

![](../images/postman_screen_18.png)

![](../images/postman_screen_19.png)

## 使用过程中的一些技巧

### 设置不同的环境
我们开发时，都会分本地环境和测试环境，本地环境用于本机调试接口，测试环境用于前后端联调接口。上面我们把[http://localhost:8080](http://localhost:8080)这个ip端口直接写在请求路径之中，当我们要调试测试环境接口时，就会产生麻烦。定义多个环境变量，在接口地址中进行引用，可以解决这个问题。

#### 添加本地环境

![](../images/postman_screen_13.png)

#### 添加测试环境

![](../images/postman_screen_14.png)

#### 引用环境变量

![](../images/postman_screen_15.png)

#### 环境变量的切换

![](../images/postman_screen_16.png)

### 设置通用的登录令牌

当我们有很多接口需要登录令牌头时，如果以前使用的令牌失效了，那所有接口的令牌头都会需要修改，这里可以把登录令牌定义好，再引用，这样令牌失效了，只需要修改一处即可。

![](../images/postman_screen_20.png)

![](../images/postman_screen_21.png)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)

