# mall学习教程
<p>
    <a href="#公众号"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-macrozheng-blue.svg" alt="公众号"></a>
    <a href="#公众号"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E4%BA%A4%E6%B5%81-%E5%BE%AE%E4%BF%A1%E7%BE%A4-2BA245.svg" alt="交流"></a>
    <a href="https://github.com/macrozheng/mall"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%90%8E%E5%8F%B0%E9%A1%B9%E7%9B%AE-mall-blue.svg" alt="后台项目"></a>
    <a href="https://github.com/macrozheng/mall-admin-web"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%89%8D%E7%AB%AF%E9%A1%B9%E7%9B%AE-mall--admin--web-green.svg" alt="前端项目"></a>
    <a href="https://github.com/macrozheng/mall-swarm"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/Cloud%E7%89%88%E6%9C%AC-mall--swarm-brightgreen.svg" alt="SpringCloud版本"></a>
</p>

## 简介
mall学习教程，架构、业务、技术要点全方位解析。mall项目（50k+star）是一套电商系统，使用现阶段主流技术实现。涵盖了SpringBoot 2.3.0、MyBatis 3.4.6、Elasticsearch 7.6.2、RabbitMQ 3.7.15、Redis 5.0、MongoDB 4.2.5、Mysql5.7等技术，采用Docker容器化部署。

## 项目地址
- 后台项目：[https://github.com/macrozheng/mall](https://github.com/macrozheng/mall)
- 前端项目：[https://github.com/macrozheng/mall-admin-web](https://github.com/macrozheng/mall-admin-web)
- 微服务项目：[https://github.com/macrozheng/mall-swarm](https://github.com/macrozheng/mall-swarm)

## 更好的阅读体验
- 文档地址：[https://www.macrozheng.com](https://www.macrozheng.com)
- 备用地址：[https://macrozheng.github.io/mall-learning](https://macrozheng.github.io/mall-learning)

## 序章

> 项目架构及数据库概览，推荐一些项目学习所需知识点。

- [mall架构及功能概览](https://www.macrozheng.com/mall/foreword/mall_foreword_01.html)
- [mall学习所需知识点（推荐资料）](https://www.macrozheng.com/mall/foreword/mall_foreword_02.html)

## 架构篇

> 手把手教你搭建一个mall在使用的项目骨架，带你逐步熟悉mall所使用的技术栈。

- [mall整合SpringBoot+MyBatis搭建基本骨架](https://www.macrozheng.com/mall/architect/mall_arch_01.html)
- [mall整合Swagger-UI实现在线API文档](https://www.macrozheng.com/mall/architect/mall_arch_02.html)
- [mall整合Redis实现缓存功能](https://www.macrozheng.com/mall/architect/mall_arch_03.html)
- [mall整合SpringSecurity和JWT实现认证和授权（一）](https://www.macrozheng.com/mall/architect/mall_arch_04.html)
- [mall整合SpringSecurity和JWT实现认证和授权（二）](https://www.macrozheng.com/mall/architect/mall_arch_05.html)
- [mall整合SpringTask实现定时任务](https://www.macrozheng.com/mall/architect/mall_arch_06.html)
- [mall整合Elasticsearch实现商品搜索](https://www.macrozheng.com/mall/architect/mall_arch_07.html)
- [mall整合Mongodb实现文档操作](https://www.macrozheng.com/mall/architect/mall_arch_08.html)
- [mall整合RabbitMQ实现延迟消息](https://www.macrozheng.com/mall/architect/mall_arch_09.html)
- [mall整合OSS实现文件上传](https://www.macrozheng.com/mall/architect/mall_arch_10.html)

## 业务篇

> 全面解析mall中使用的数据库表结构，带你熟悉mall项目中的电商业务。

- [mall数据库表结构概览](https://www.macrozheng.com/mall/database/mall_database_overview.html)
- [商品模块数据库表解析（一）](https://www.macrozheng.com/mall/database/mall_pms_01.html)
- [商品模块数据库表解析（二）](https://www.macrozheng.com/mall/database/mall_pms_02.html)
- [订单模块数据库表解析（一）](https://www.macrozheng.com/mall/database/mall_oms_01.html)
- [订单模块数据库表解析（二）](https://www.macrozheng.com/mall/database/mall_oms_02.html)
- [订单模块数据库表解析（三）](https://www.macrozheng.com/mall/database/mall_oms_03.html)
- [营销模块数据库表解析（一）](https://www.macrozheng.com/mall/database/mall_sms_01.html)
- [营销模块数据库表解析（二）](https://www.macrozheng.com/mall/database/mall_sms_02.html)
- [营销模块数据库表解析（三）](https://www.macrozheng.com/mall/database/mall_sms_03.html)
- [权限管理功能设计与优化](https://www.macrozheng.com/mall/database/mall_permission.html)

## 技术要点篇

> mall中一些功能的技术要点解析，这些技术要点和业务结合地比较紧密。

- [MyBatis Generator使用过程中踩过的一个坑](https://www.macrozheng.com/mall/technology/mybatis_mapper.html)
- [SpringBoot应用中使用AOP记录接口访问日志](https://www.macrozheng.com/mall/technology/aop_log.html)
- [前后端分离项目，如何解决跨域问题](https://www.macrozheng.com/mall/technology/springboot_cors.html)
- [Java 8都出那么久了，Stream API了解下？](https://www.macrozheng.com/mall/technology/java_stream.html)
- [仅需四步，整合SpringSecurity+JWT实现登录认证！](https://www.macrozheng.com/mall/technology/springsecurity_use.html)
- [前后端分离项目，如何优雅实现文件存储！](https://www.macrozheng.com/mall/technology/minio_use.html)
- [前后端分离项目，引入Spring Cloud Gateway遇到的一个问题！](https://www.macrozheng.com/mall/technology/gateway_cors.html)
- [手把手教你搞定权限管理，结合Spring Security实现接口的动态权限控制！](https://www.macrozheng.com/mall/technology/permission_back.html)
- [手把手教你搞定权限管理，结合Vue实现菜单的动态权限控制！](https://www.macrozheng.com/mall/technology/permission_front.html)
- [商品SKU功能设计与优化](https://www.macrozheng.com/mall/technology/product_sku.html)
- [SpringBoot中处理校验逻辑的两种方式，真的很机智！](https://www.macrozheng.com/mall/technology/springboot_validator.html)
- [使用Redis+AOP优化权限管理功能，这波操作贼爽！](https://www.macrozheng.com/mall/technology/redis_permission.html)
- [Elasticsearch项目实战，商品搜索功能设计与实现！](https://www.macrozheng.com/mall/technology/product_search.html)
- [RabbitMQ实现延迟消息居然如此简单，整个插件就完事了！](https://www.macrozheng.com/mall/technology/rabbitmq_delay.html)
- [给Swagger升级了新版本，没想到居然有这么多坑！](https://www.macrozheng.com/mall/technology/swagger_upgrade.html)
- [Elasticsearch 升级 7.x 版本后，我感觉掉坑里了！](https://www.macrozheng.com/mall/technology/elasticsearch_upgrade.html)
- [搞定Mall项目中的权限管理功能，弄懂这些问题就妥了！](https://www.macrozheng.com/mall/technology/mall_permission_question.html)

## 部署篇

> mall开发及生产环境的搭建，涵盖Windows、Docker、K8S及自动化部署。

- [mall在Windows环境下的部署](https://www.macrozheng.com/mall/deploy/mall_deploy_windows.html)
- [mall在Linux环境下的部署（基于Docker容器）](https://www.macrozheng.com/mall/deploy/mall_deploy_docker.html)
- [mall在Linux环境下的部署（基于Docker Compose）](https://www.macrozheng.com/mall/deploy/mall_deploy_docker_compose.html)
- [mall前端项目的安装与部署](https://www.macrozheng.com/mall/deploy/mall_deploy_web.html)
- [mall-swarm在Windows环境下的部署](https://www.macrozheng.com/mall/deploy/mall_swarm_deploy_windows.html)
- [mall-swarm在Linux环境下的部署（基于Docker容器）](https://www.macrozheng.com/mall/deploy/mall_swarm_deploy_docker.html)
- [mall使用Jenkins实现自动化部署](https://www.macrozheng.com/mall/deploy/mall_deploy_jenkins.html)
- [mall-swarm使用Jenkins实现自动化部署](https://www.macrozheng.com/mall/deploy/mall_swarm_deploy_jenkins.html)
- [mall-swarm微服务项目在K8S下的实践！](https://www.macrozheng.com/mall/deploy/mall_swarm_deploy_k8s.html)

## 参考篇

> mall相关技术的参考教程，每篇都是可以独立学习的教程，学习过程中遇到不懂的知识点可以从这里找找。

- [开发者必备Mysql命令](https://www.macrozheng.com/mall/reference/mysql.html)
- [还在百度Linux命令？推荐一套我用起来特顺手的命令！](https://www.macrozheng.com/mall/reference/linux_command.html)
- [Linux防火墙Firewall和Iptables的使用](https://www.macrozheng.com/mall/reference/linux_firewall.html)
- [还在百度Docker命令？推荐一套我用起来特顺手的命令！](https://www.macrozheng.com/mall/reference/docker_command.html)
- [使用Maven插件为SpringBoot应用构建Docker镜像](https://www.macrozheng.com/mall/reference/docker_maven.html)
- [使用DockerFile为SpringBoot应用构建Docker镜像](https://www.macrozheng.com/mall/reference/docker_file.html)
- [使用Docker Compose部署SpringBoot应用](https://www.macrozheng.com/mall/reference/docker_compose.html)
- [Hutool中那些常用的工具类和方法 ](https://www.macrozheng.com/mall/reference/hutool_start.html)
- [Nginx的这些妙用，你肯定有不知道的！](https://www.macrozheng.com/mall/reference/nginx.html)
- [使用Jenkins一键打包部署SpringBoot应用，就是这么6！](https://www.macrozheng.com/mall/reference/jenkins.html)
- [使用Jenkins一键打包部署前端应用，就是这么6！](https://www.macrozheng.com/mall/reference/jenkins_vue.html)
- [Github标星19K+Star，10分钟自建对象存储服务！](https://www.macrozheng.com/mall/reference/minio.html)
- [Spring Data Redis 最佳实践！](https://www.macrozheng.com/mall/reference/spring_data_redis.html)
- [Elasticsearch快速入门，掌握这些刚刚好！](https://www.macrozheng.com/mall/reference/elasticsearch_start.html)
- [MongoDB快速入门，掌握这些刚刚好！](https://www.macrozheng.com/mall/reference/mongodb_start.html)
- [我常用的自动化部署技巧，贼好用，推荐给大家！](https://www.macrozheng.com/mall/reference/springboot_auto_deploy.html)
- [连RabbitMQ的5种核心消息模式都不懂，也敢说自己会用消息队列！](https://www.macrozheng.com/mall/reference/rabbitmq_start.html)
- [SpringBoot应用整合ELK实现日志收集](https://www.macrozheng.com/mall/reference/mall_tiny_elk.html)
- [你居然还去服务器上捞日志，搭个日志收集系统难道不香么！](https://www.macrozheng.com/mall/reference/mall_elk_advance.html)
- [给Swagger换了个新皮肤，瞬间高大上了！](https://www.macrozheng.com/mall/reference/knife4j_start.html)
- [Docker服务开放了这个端口，服务器分分钟变肉机！](https://www.macrozheng.com/mall/reference/docker_protect_socket.html)
- [居然有人想白嫖我的日志，赶紧开启安全保护压压惊！](https://www.macrozheng.com/mall/reference/elk_security.html)
- [Nginx如何支持HTTPS？手把手教贼简单！](https://www.macrozheng.com/mall/reference/nginx_https_start.html)
- [还在手动整合Swagger？Swagger官方Starter是真的香！](https://www.macrozheng.com/mall/reference/swagger_starter.html)
- [肝了一周总结的SpringBoot实战教程，太实用了！](https://www.macrozheng.com/mall/reference/springboot_start.html)
- [解放双手！MyBatis官方代码生成工具给力！](https://www.macrozheng.com/mall/reference/mybatis_generator_start.html)
- [Lombok有啥牛皮的？SpringBoot和IDEA官方都要支持它！](https://www.macrozheng.com/mall/reference/lombok_start.html)


## 公众号

学习不走弯路，关注公众号「**macrozheng**」，回复「**学习路线**」，获取mall项目专属学习路线！

加微信群交流，公众号后台回复「**加群**」即可。

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)
