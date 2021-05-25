学习不走弯路，[关注公众号](#公众号) 回复「学习路线」，获取mall项目专属学习路线！

# 还在百度Docker命令？推荐一套我用起来特顺手的命令！

> 平时经常使用Docker来搭建各种环境，简单又好用！但是有时候往往会忘记命令，总结了一套非常实用的Docker命令，对于Java开发来说基本上够用了，希望对大家有所帮助！

## Docker简介

Docker是一个开源的应用容器引擎，让开发者可以打包应用及依赖包到一个可移植的镜像中，然后发布到任何流行的Linux或Windows机器上。使用Docker可以更方便地打包、测试以及部署应用程序。

## Docker环境安装

- 安装`yum-utils`；

```bash
yum install -y yum-utils device-mapper-persistent-data lvm2
```

- 为yum源添加docker仓库位置；

```bash
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```

- 安装docker服务；

```bash
yum install docker-ce
```

- 启动docker服务。

```bash
systemctl start docker
```

## Docker镜像常用命令

### 搜索镜像

```bash
docker search java
```

![](../images/docker_command_01.png)

### 下载镜像

```bash
docker pull java:8
```

### 查看镜像版本

> 由于`docker search`命令只能查找出是否有该镜像，不能找到该镜像支持的版本，所以我们需要通过`Docker Hub`来搜索支持的版本。

- 进入`Docker Hub`的官网，地址：https://hub.docker.com

- 然后搜索需要的镜像：

![](../images/docker_command_02.png)

- 查看镜像支持的版本：

![](../images/docker_command_03.png)

- 进行镜像的下载操作：

```bash
docker pull nginx:1.17.0
```

### 列出镜像

```bash
docker images
```

![](../images/docker_command_04.png)

### 删除镜像

- 指定名称删除镜像：

```bash
docker rmi java:8
```

- 指定名称删除镜像（强制）：

```bash
docker rmi -f java:8
```

- 删除所有没有引用的镜像：

```bash
docker rmi `docker images | grep none | awk '{print $3}'`
```

- 强制删除所有镜像：

```bash
docker rmi -f $(docker images)
```

### 打包镜像

```bash
# -t 表示指定镜像仓库名称/镜像名称:镜像标签 .表示使用当前目录下的Dockerfile文件
docker build -t mall/mall-admin:1.0-SNAPSHOT .
```

### 推送镜像

```bash
# 登录Docker Hub
docker login
# 给本地镜像打标签为远程仓库名称
docker tag mall/mall-admin:1.0-SNAPSHOT macrodocker/mall-admin:1.0-SNAPSHOT
# 推送到远程仓库
docker push macrodocker/mall-admin:1.0-SNAPSHOT
```

## Docker容器常用命令

### 新建并启动容器

```bash
docker run -p 80:80 --name nginx \
-e TZ="Asia/Shanghai" \
-v /mydata/nginx/html:/usr/share/nginx/html \
-d nginx:1.17.0
```
- -p：将宿主机和容器端口进行映射，格式为：宿主机端口:容器端口；
- --name：指定容器名称，之后可以通过容器名称来操作容器；
- -e：设置容器的环境变量，这里设置的是时区；
- -v：将宿主机上的文件挂载到宿主机上，格式为：宿主机文件目录:容器文件目录；
- -d：表示容器以后台方式运行。

### 列出容器

- 列出运行中的容器：

```bash
docker ps
```

![](../images/docker_command_05.png)

- 列出所有容器：

```bash
docker ps -a
```

![](../images/docker_command_06.png)

### 停止容器

注意：`$ContainerName`表示容器名称，`$ContainerId`表示容器ID，可以使用容器名称的命令，基本也支持使用容器ID，比如下面的停止容器命令。

```bash
docker stop $ContainerName(or $ContainerId)
```

例如：

```bash
docker stop nginx
#或者
docker stop c5f5d5125587
```

### 强制停止容器

```bash
docker kill $ContainerName
```

### 启动容器

```bash
docker start $ContainerName
```

### 进入容器

- 先查询出容器的`pid`：

```bash
docker inspect --format "{{.State.Pid}}" $ContainerName
```

- 根据容器的pid进入容器：

```bash
nsenter --target "$pid" --mount --uts --ipc --net --pid
```

![](../images/docker_command_07.png)

### 删除容器

- 删除指定容器：

```bash
docker rm $ContainerName
```

- 按名称通配符删除容器，比如删除以名称`mall-`开头的容器：

```bash
docker rm `docker ps -a | grep mall-* | awk '{print $1}'`
```

- 强制删除所有容器；

```bash
docker rm -f $(docker ps -a -q)
```

### 查看容器的日志

- 查看容器产生的全部日志：

```bash
docker logs $ContainerName
```

![](../images/docker_command_08.png)

- 动态查看容器产生的日志：

```bash
docker logs -f $ContainerName
```

### 查看容器的IP地址

```bash
docker inspect --format '{{ .NetworkSettings.IPAddress }}' $ContainerName
```

![](../images/docker_command_09.png)

### 修改容器的启动方式

```bash
# 将容器启动方式改为always
docker container update --restart=always $ContainerName
```

### 同步宿主机时间到容器

```bash
docker cp /etc/localtime $ContainerName:/etc/
```

### 指定容器时区

```bash
docker run -p 80:80 --name nginx \
-e TZ="Asia/Shanghai" \
-d nginx:1.17.0
```

### 查看容器资源占用状况

- 查看指定容器资源占用状况，比如cpu、内存、网络、io状态：

```bash
docker stats $ContainerName
```

![](../images/docker_command_10.png)

- 查看所有容器资源占用情况：

```bash
docker stats -a
```

![](../images/docker_command_11.png)

### 查看容器磁盘使用情况

```bash
docker system df
```

![](../images/docker_command_16.png)

### 执行容器内部命令

```bash
docker exec -it $ContainerName /bin/bash
```

![](../images/docker_command_12.png)

### 指定账号进入容器内部

```bash
# 使用root账号进入容器内部
docker exec -it --user root $ContainerName /bin/bash
```

### 查看所有网络

```bash
docker network ls
```

```bash
[root@local-linux ~]# docker network ls
NETWORK ID          NAME                     DRIVER              SCOPE
59b309a5c12f        bridge                   bridge              local
ef34fe69992b        host                     host                local
a65be030c632        none     
```

### 创建外部网络

```bash
docker network create -d bridge my-bridge-network
```

### 指定容器网络

```bash
docker run -p 80:80 --name nginx \
--network my-bridge-network \
-d nginx:1.17.0
```

## 修改镜像的存放位置

- 查看Docker镜像的存放位置：

```bash
docker info | grep "Docker Root Dir"
```

![](../images/docker_command_13.png)

- 关闭Docker服务：

```bash
systemctl stop docker
```

- 先将原镜像目录移动到目标目录：

```bash
mv /var/lib/docker /mydata/docker
```

- 建立软连接：

```bash
ln -s /mydata/docker /var/lib/docker
```

![](../images/docker_command_14.png)

- 再次查看可以发现镜像存放位置已经更改。

![](../images/docker_command_15.png)

## Docker容器清理

- 查看Docker占用的磁盘空间情况：

```bash
docker system df
```

- 删除所有关闭的容器：

```bash
docker ps -a | grep Exit | cut -d ' ' -f 1 | xargs docker rm
```

- 删除所有`dangling`镜像(没有Tag的镜像)：

```bash
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
```

- 删除所有`dangling`数据卷(即无用的 volume)：

```bash
docker volume rm $(docker volume ls -qf dangling=true)
```

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)

