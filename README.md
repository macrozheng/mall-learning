# mall学习教程
<p>
<a href="#公众号"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-macrozheng-blue.svg" alt="公众号"></a>
<a href="https://github.com/macrozheng/mall"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%90%8E%E5%8F%B0%E9%A1%B9%E7%9B%AE-mall-blue.svg" alt="后台项目"></a>
<a href="https://github.com/macrozheng/mall-admin-web"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%89%8D%E7%AB%AF%E9%A1%B9%E7%9B%AE-mall--admin--web-green.svg" alt="前端项目"></a>
<a href="https://github.com/macrozheng/mall-swarm"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/Cloud%E7%89%88%E6%9C%AC-mall--swarm-brightgreen.svg" alt="SpringCloud版本"></a>
</p>

## 简介
mall学习教程，架构、业务、技术要点全方位解析。mall项目（40k+star）是一套电商系统，使用现阶段主流技术实现。涵盖了SpringBoot 2.3.0、MyBatis 3.4.6、Elasticsearch 7.6.2、RabbitMQ 3.7.15、Redis 5.0、MongoDB 4.2.5、Mysql5.7等技术，采用Docker容器化部署。

## 项目地址
- 后台项目：[https://github.com/macrozheng/mall](https://github.com/macrozheng/mall)
- 前端项目：[https://github.com/macrozheng/mall-admin-web](https://github.com/macrozheng/mall-admin-web)
- 微服务项目：[https://github.com/macrozheng/mall-swarm](https://github.com/macrozheng/mall-swarm)

## 更好的阅读体验
- 文档地址：[http://www.macrozheng.com](http://www.macrozheng.com)
- 备用地址：[https://macrozheng.github.io/mall-learning](https://macrozheng.github.io/mall-learning)

## 序章
- [mall架构及功能概览](https://juejin.im/post/5cf7c305e51d4510b71da5c5)
- [mall学习所需知识点（推荐资料）](https://juejin.im/post/5cf7c3aef265da1ba84a7fdc)

## 架构篇
> 手把手教你搭建一个mall在使用的项目骨架

- [mall整合SpringBoot+MyBatis搭建基本骨架](https://juejin.im/post/5cf7c4a7e51d4577790c1c50)
- [mall整合Swagger-UI实现在线API文档](https://juejin.im/post/5cf9035cf265da1bb47d54f8)
- [mall整合Redis实现缓存功能](https://juejin.im/post/5cf90e9ee51d454f6f16eba0)
- [mall整合SpringSecurity和JWT实现认证和授权（一）](https://juejin.im/post/5cf90fa5e51d455d6d5357d3)
- [mall整合SpringSecurity和JWT实现认证和授权（二）](https://juejin.im/post/5cfa0933f265da1b8f1ab2da)
- [mall整合SpringTask实现定时任务](https://juejin.im/post/5cfa0ea16fb9a07eaf2b8261)
- [mall整合Elasticsearch实现商品搜索](https://juejin.im/post/5cfba3e9f265da1b614fea60)
- [mall整合Mongodb实现文档操作](https://juejin.im/post/5cfba5b0f265da1bcc1933fe)
- [mall整合RabbitMQ实现延迟消息](https://juejin.im/post/5cff98986fb9a07ed36ea139)
- [mall整合OSS实现文件上传](https://juejin.im/post/5cff9944e51d4577555508a9)

## 业务篇
> 全面解析mall中使用的数据库表结构

- [mall数据库表结构概览](https://juejin.im/post/5d34684c6fb9a07ef562724b)
- [商品模块数据库表解析（一）](https://juejin.im/post/5d385a7e518825680e4577ee)
- [商品模块数据库表解析（二）](https://juejin.im/post/5d39ba2cf265da1bc23fbd26)
- [订单模块数据库表解析（一）](https://juejin.im/post/5d4196fef265da03bd04fa31)
- [订单模块数据库表解析（二）](https://juejin.im/post/5d46db2a5188255d1e013ca0)
- [订单模块数据库表解析（三）](https://juejin.im/post/5d497f92e51d4561e0516a9d)
- [营销模块数据库表解析（一）](https://juejin.im/post/5d5012856fb9a06ad45135a6)
- [营销模块数据库表解析（二）](https://juejin.im/post/5d555c7ae51d453b386a6302)
- [营销模块数据库表解析（三）](https://juejin.im/post/5d5bf6676fb9a06b0703c0c5)
- [权限管理功能设计与优化](https://juejin.im/post/5e4bd8416fb9a07c9f3fd5dd)
- [商品SKU功能设计与优化](https://juejin.im/post/5e5cfaa9f265da574b7918f6)

## 技术要点篇
> mall中一些功能的技术要点解析

- [MyBatis Generator使用过程中踩过的一个坑](https://juejin.im/post/5d107037e51d45599e019de8)
- [SpringBoot应用中使用AOP记录接口访问日志](https://juejin.im/post/5d2001bb6fb9a07edf276593)
- [SpringBoot应用整合ELK实现日志收集](https://juejin.im/post/5d2738a2f265da1bac404299)
- [前后端分离项目，如何解决跨域问题](https://juejin.im/post/5d4c162351882560b9545358)
- [Java 8都出那么久了，Stream API了解下？](https://juejin.im/post/5d6d2016e51d453c135c5b25)
- [仅需四步，整合SpringSecurity+JWT实现登录认证！](https://juejin.im/post/5df0e79bf265da33dd2f52af)
- [前后端分离项目，如何优雅实现文件存储！](https://juejin.im/post/5e0ca2266fb9a0484a45969c)
- [前后端分离项目，引入Spring Cloud Gateway遇到的一个问题！](https://juejin.im/post/5e13248e5188253ab849d125)
- [手把手教你搞定权限管理，结合Spring Security实现接口的动态权限控制！](https://juejin.im/post/5e5519fd6fb9a07cc7473fcf)
- [手把手教你搞定权限管理，结合Vue实现菜单的动态权限控制！](https://juejin.im/post/5e57c8236fb9a07caf445ddc)
- [SpringBoot中处理校验逻辑的两种方式，真的很机智！](https://juejin.im/post/5e6636da6fb9a07cb24aaf00)
- [使用Redis+AOP优化权限管理功能，这波操作贼爽！](https://juejin.im/post/5e78b96b6fb9a07cb83e4a10)
- [Elasticsearch项目实战，商品搜索功能设计与实现！](https://juejin.im/post/5e94587f51882573be11cb83)
- [连RabbitMQ的5种核心消息模式都不懂，也敢说自己会用消息队列！](https://juejin.im/post/6844904184920162317)
- [给Swagger升级了新版本，没想到居然有这么多坑！](https://juejin.im/post/6850037281392099341)
- [Elasticsearch 升级 7.x 版本后，我感觉掉坑里了！](https://juejin.im/post/6856555431570735117)

## 部署篇
> mall开发及生产环境的搭建

- [mall在Windows环境下的部署](https://juejin.im/post/5d1362de51882551fe065b61)
- [mall在Linux环境下的部署（基于Docker容器）](https://juejin.im/post/5d1802ab6fb9a07f0a2df5ae)
- [mall在Linux环境下的部署（基于Docker Compose）](https://juejin.im/post/5d1c98d66fb9a07ebf4b8ad5)
- [mall在Linux环境下的自动化部署（基于Jenkins）](https://juejin.im/post/5e15d7b16fb9a0484f5c3931)
- [mall前端项目的安装与部署](https://juejin.im/post/5d2c7c6b518825076377d7b9)
- [mall-swarm在Windows环境下的部署](https://juejin.im/post/5de3c1a35188256e855b6e54)
- [mall-swarm在Linux环境下的部署（基于Docker容器）](https://juejin.im/post/5de65bffe51d4557f71a5ec1)
- [mall-swarm微服务电商系统如何部署？用Jenkins自动化部署是真的香！](https://juejin.cn/post/6893668816677502989)
- [我常用的自动化部署技巧，贼好用，推荐给大家！](https://juejin.im/post/6844904163424337928)


## 进阶篇
> 一套涵盖大部分核心组件使用的Spring Cloud教程，包括Spring Cloud Alibaba及分布式事务Seata，基于Spring Cloud Greenwich及SpringBoot 2.1.7

- [Spring Cloud 整体架构概览](https://juejin.im/post/5d764f05e51d4561fb04bfd7)
- [Spring Cloud Eureka：服务注册与发现](https://juejin.im/post/5d78cd53f265da03d55e8351)
- [Spring Cloud Ribbon：负载均衡的服务调用](https://juejin.im/post/5d7f9006f265da03951a260c)
- [Spring Cloud Hystrix：服务容错保护](https://juejin.im/post/5d822d27e51d45621479ad92)
- [Hystrix Dashboard：断路器执行监控](https://juejin.im/post/5d88cb58f265da03e4679eff)
- [Spring Cloud OpenFeign：基于Ribbon和Hystrix的声明式服务调用](https://juejin.im/post/5d9c85c3e51d45782c23fab6)
- [Spring Cloud Zuul：API网关服务](https://juejin.im/post/5d9f2dea6fb9a04e3e724067)
- [Spring Cloud Config：外部集中化配置管理](https://juejin.im/post/5da4709af265da5baa5b06ac)
- [Spring Cloud Bus：消息总线](https://juejin.im/post/5da70d1351882509615bea34)
- [Spring Cloud Sleuth：分布式请求链路跟踪](https://juejin.im/post/5dadb4d36fb9a04e02409a7d)
- [Spring Cloud Consul：服务治理与配置中心](https://juejin.im/post/5db05582f265da4d4c20180f)
- [Spring Cloud Gateway：新一代API网关服务](https://juejin.im/post/5db6eed6518825644076d0b6)
- [Spring Boot Admin：微服务应用监控](https://juejin.im/post/5db98a2d518825649c730f81)
- [Spring Cloud Security：Oauth2使用入门](https://juejin.im/post/5dc013bae51d456e817cec30)
- [Spring Cloud Security：Oauth2结合JWT使用](https://juejin.im/post/5dc2bec6f265da4d4f65bebe)
- [Spring Cloud Security：Oauth2实现单点登录](https://juejin.im/post/5dc95a675188256e040db43f)
- [Spring Cloud Alibaba：Nacos 作为注册中心和配置中心使用](https://juejin.im/post/5dcbf7bc5188250d1f5a78ea)
- [Spring Cloud Alibaba：Sentinel实现熔断与限流](https://juejin.im/post/5dd29bece51d4561e80f9053)
- [使用Seata彻底解决Spring Cloud中的分布式事务问题](https://juejin.im/post/5dd53a9d5188255d35425a08)
- [微服务权限终极解决方案，Spring Cloud Gateway + Oauth2 实现统一认证和鉴权！](https://juejin.im/post/6850037263707930631)
- [微服务聚合Swagger文档，这波操作是真的香！](https://juejin.im/post/6854573219916201997)
- [我扒了半天源码，终于找到了Oauth2自定义处理结果的最佳方案！](https://juejin.im/post/6857296054392471559)

## 参考篇
> mall相关技术的使用教程

- [开发者必备Mysql命令](https://juejin.im/post/5d00fd40f265da1bb67a11b3)
- [还在百度Linux命令？推荐一套我用起来特顺手的命令！](https://juejin.cn/post/6877337031605911566)
- [Linux防火墙Firewall和Iptables的使用](https://juejin.im/post/5d0253fe6fb9a07edb39420d)
- [还在百度Docker命令？推荐一套我用起来特顺手的命令！](https://juejin.cn/post/6895888125886332941)
- [使用Maven插件构建Docker镜像](https://juejin.im/post/5d08e3d26fb9a07ed8424488)
- [使用DockerFile为SpringBoot应用构建Docker镜像](https://juejin.im/post/5d0a25b76fb9a07ed524a438)
- [使用Docker Compose部署SpringBoot应用](https://juejin.im/user/5cf7c1d7f265da1bc07e28b7)
- [虚拟机安装及使用Linux，看这一篇就够了！](https://juejin.im/post/5ddfd1665188256ec024cb7c)
- [Nginx的这些妙用，你肯定有不知道的！](https://juejin.im/post/5dee499151882512444014eb)
- [使用Jenkins一键打包部署SpringBoot应用，就是这么6！](https://juejin.im/post/5df780d3e51d4557ff140b30)
- [使用Jenkins一键打包部署前端应用，就是这么6！](https://juejin.im/post/5e0360e951882512400ae872)
- [Github标星19K+Star，10分钟自建对象存储服务！](https://juejin.im/post/5e09f8fbe51d4575a46f05e5)
- [MySql主从复制，从原理到实践！](https://juejin.im/post/5e1daba46fb9a02fb75d5e92)
- [你还在代码里做读写分离么，试试这个中间件吧！](https://juejin.im/post/5e22b37ee51d454d523be24d)
- [Spring Data Redis 最佳实践！](https://juejin.im/post/5e6f703fe51d45270531a214)
- [Docker环境下秒建Redis集群，连SpringBoot也整上了！](https://juejin.im/post/5e81fd1ff265da47e84e5e2c)
- [Elasticsearch快速入门，掌握这些刚刚好！](https://juejin.im/post/5e8c7d65518825736512d097)
- [MongoDB快速入门，掌握这些刚刚好！](https://juejin.im/post/5eb4043cf265da7bf5368276)
- [Github标星34K+Star，这款开源项目助你秒建Git服务！](https://juejin.im/post/5ecd12076fb9a0479958376b)
- [连RabbitMQ的5种核心消息模式都不懂，也敢说自己会用消息队列！](https://juejin.im/post/6844904184920162317)
- [你居然还去服务器上捞日志，搭个日志收集系统难道不香么！](https://juejin.im/post/6844904196672585741)
- [性能优越的轻量级日志收集工具，微软、亚马逊都在用！](https://juejin.im/post/6844904205363183630)
- [听说你的JWT库用起来特别扭，推荐一款贼好用的！](https://juejin.im/post/6847902224325345288)
- [给Swagger换了个新皮肤，瞬间高大上了！](https://juejin.im/post/6854573214358732814)
- [Docker服务开放了这个端口，服务器分分钟变肉机！](https://juejin.im/post/6861749836249563143)
- [居然有人想白嫖我的日志，赶紧开启安全保护压压惊！](https://juejin.im/post/6865462161486184456)
- [面对成百上千台服务器产生的日志，试试这款轻量级日志搬运神器！](https://juejin.im/post/6866946088134410248)
- [还在手动部署SpringBoot应用？试试这个自动化插件！](https://juejin.im/post/6868060821927723021)
- [不要再重复造轮子了，这款开源工具类库贼好使！](https://juejin.im/post/6869914176941359118)
- [还在手写CRUD代码？这款开源框架助你解放双手！](https://juejin.im/post/6870659845029101576)
- [还在手写任务调度代码？试试这款可视化分布式调度框架！](https://juejin.im/post/6875854161561255944)
- [微服务应用性能如何？APM监控工具来告诉你！](https://juejin.im/post/6882530961406296077)
- [RabbitMQ实现即时通讯居然如此简单！连后端代码都省得写了？](https://juejin.im/post/6883273274248134663)
- [SpringBoot官方支持任务调度框架，轻量级用起来也挺香！](https://juejin.im/post/6885869364180942862)
- [如何让网站和API都支持HTTPS？在Nginx上做文章是个好选择！](https://juejin.im/post/6888467506588024845)
- [还在手动整合Swagger？Swagger官方Starter是真的香！](https://juejin.im/post/6890692970018766856)
- [MySQL如何实时同步数据到ES？试试这款阿里开源的神器！](https://juejin.im/post/6891435372824395784)
- [肝了一周总结的SpringBoot实战教程，太实用了！](https://juejin.cn/post/6898858833847222279)
- [Elasticsearch官方已支持SQL查询，用起来贼方便！](https://juejin.cn/post/6901827227013349383)

## 工具篇
> 一些常用开发工具的使用

- [IDEA常用设置及推荐插件](https://juejin.im/post/5d0458085188256aa76bc678)
- [Navicat实用功能：数据备份与结构同步](https://juejin.im/post/5d00fc865188255fc6384126)
- [Postman：API接口调试利器](https://juejin.im/post/5d5a9032e51d4561db5e3a4a)
- [10分钟搭建自己的Git仓库](https://juejin.im/post/5d63d600e51d453c135c5af3)
- [IDEA中的Git操作，看这一篇就够了！](https://juejin.im/post/5d667fc6e51d453b5d4d8da5)
- [虚拟机安装及使用Linux，看这一篇就够了！](https://juejin.im/post/5ddfd1665188256ec024cb7c)
- [推荐一个项目管理工具，落地基于Scrum的敏捷开发！](https://juejin.im/post/5e4200885188254944669a79)
- [IDEA中创建和启动SpringBoot应用的正确姿势](https://juejin.im/post/5d8b69366fb9a04e3348b06c)
- [盘点下我用的顺手的那些工具！](https://juejin.im/post/5e5f99c251882549281bfb09)
- [我用起来顺手的数据库设计工具，这次推荐给大家！](https://juejin.im/post/5ea6d2725188256da20e60ee)
- [我常用的IDEA插件大公开，个个是精品！](https://juejin.im/post/5eba9a5bf265da7bca50010c)
- [IDEA同款数据库管理工具，提示太全了，用起来贼香！](https://juejin.im/post/5ed4f2446fb9a047d5645a2b)
- [写了100多篇原创文章，我常用的在线工具网站推荐给大家！](https://juejin.im/post/6844904200640397325)
- [线上项目出BUG没法调试？推荐这款阿里开源的诊断神器！](https://juejin.im/post/6846687603471679496)
- [被我用烂的DEBUG调试技巧，专治各种搜索不到的问题！](https://juejin.im/post/6859166000932519944)
- [Github标星 8K+，免费又好用的Redis客户端工具！](https://juejin.im/post/6875109882006077448)
- [Swagger界面丑、功能弱怎么破？用Postman增强下就给力了！](https://juejin.cn/post/6896633644769607694)]
- [干掉Navicat！MySQL官方客户端到底行不行？](https://juejin.cn/post/6901085744618536973)


## 公众号

mall项目全套学习教程连载中，关注公众号「**macrozheng**」第一时间获取。

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)
