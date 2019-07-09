mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# 开发者必备Docker命令

> 本文主要讲解Docker环境的安装以及Docker常用命令的使用，掌握这些对Docker环境下应用的部署具有很大帮助。

## Docker 简介

 Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的镜像中，然后发布到任何流行的 Linux或Windows机器上。使用Docker可以更方便低打包、测试以及部署应用程序。

## Docker 环境安装
- 安装yum-utils：
```shell
yum install -y yum-utils device-mapper-persistent-data lvm2
```
- 为yum源添加docker仓库位置：
```shell
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```
- 安装docker:
```shell
yum install docker-ce
```
- 启动docker:
```shell
systemctl start docker
```

## Docker 镜像常用命令

### 搜索镜像
```shell
docker search java
```
![展示图片](../images/refer_screen_51.png)
### 下载镜像
```shell
docker pull java:8
```
### 如何查找镜像支持的版本
> 由于docker search命令只能查找出是否有该镜像，不能找到该镜像支持的版本，所以我们需要通过docker hub来搜索支持的版本。

- 进入docker hub的官网，地址：[https://hub.docker.com](https://hub.docker.com)
- 然后搜索需要的镜像：
![展示图片](../images/refer_screen_52.png)
- 查看镜像支持的版本：
![展示图片](../images/refer_screen_53.png)

- 进行镜像的下载操作：
```shell
docker pull nginx:1.17.0
```

### 列出镜像
```shell
docker images
```
![展示图片](../images/refer_screen_54.png)
### 删除镜像
- 指定名称删除镜像
```shell
docker rmi java:8
```
- 指定名称删除镜像（强制）
```shell
docker rmi -f java:8
```
- 强制删除所有镜像
```shell
docker rmi -f $(docker images)
```

## Docker 容器常用命令
### 新建并启动容器
```shell
docker run -p 80:80 --name nginx -d nginx:1.17.0
```
- -d选项：表示后台运行
- --name选项：指定运行后容器的名字为nginx,之后可以通过名字来操作容器
- -p选项：指定端口映射，格式为：hostPort:containerPort

### 列出容器
- 列出运行中的容器：
```shell
docker ps
```
![展示图片](../images/refer_screen_55.png)
- 列出所有容器
```shell
docker ps -a
```
![展示图片](../images/refer_screen_56.png)
### 停止容器
```shell
# $ContainerName及$ContainerId可以用docker ps命令查询出来
docker stop $ContainerName(或者$ContainerId)
```
比如：
```shell
docker stop nginx
#或者
docker stop c5f5d5125587
```
### 强制停止容器
```shell
docker kill $ContainerName(或者$ContainerId)
```
### 启动已停止的容器
```shell
docker start $ContainerName(或者$ContainerId)
```
### 进入容器
- 先查询出容器的pid：
```shell
docker inspect --format "{{.State.Pid}}" $ContainerName(或者$ContainerId)
```
- 根据容器的pid进入容器：
```shell
nsenter --target "$pid" --mount --uts --ipc --net --pid
```
![展示图片](../images/refer_screen_57.png)
### 删除容器
- 删除指定容器：
```shell
docker rm $ContainerName(或者$ContainerId)
```
- 强制删除所有容器；
```shell
docker rm -f $(docker ps -a -q)
```
### 查看容器的日志
```shell
docker logs $ContainerName(或者$ContainerId)
```
![展示图片](../images/refer_screen_58.png)
### 查看容器的IP地址
```shell
docker inspect --format '{{ .NetworkSettings.IPAddress }}' $ContainerName(或者$ContainerId)
```
![展示图片](../images/refer_screen_59.png)
### 同步宿主机时间到容器
```shell
docker cp /etc/localtime $ContainerName(或者$ContainerId):/etc/
```
### 在宿主机查看docker使用cpu、内存、网络、io情况
- 查看指定容器情况：
```shell
docker stats $ContainerName(或者$ContainerId)
```
![展示图片](../images/refer_screen_60.png)
- 查看所有容器情况：
```shell
docker stats -a
```
![展示图片](../images/refer_screen_61.png)
### 进入Docker容器内部的bash
```shell
docker exec -it $ContainerName /bin/bash
```
![展示图片](../images/refer_screen_62.png)

## 修改Docker镜像的存放位置
- 查看Docker镜像的存放位置：
```shell
docker info | grep "Docker Root Dir"
```
![展示图片](../images/refer_screen_63.png)
- 关闭Docker服务：
```shell
systemctl stop docker
```
- 移动目录到目标路径：
```shell
mv /var/lib/docker /mydata/docker
```
- 建立软连接：
```shell
ln -s /mydata/docker /var/lib/docker
```
![展示图片](../images/refer_screen_64.png)
![展示图片](../images/refer_screen_65.png)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)

