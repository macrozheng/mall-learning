mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# 开发者必备Linux命令

> 开发者必备Linux常用命令，掌握这些命令绝对够了，基于CenterOS7.6。

## 系统服务管理

### systemctl
- 输出系统中各个服务的状态：
```shell
systemctl list-units --type=service
```
![](../images/refer_screen_01.png)
- 查看服务的运行状态：
```shell
systemctl status firewalld
```
![](../images/refer_screen_02.png)
- 关闭服务：
```shell
systemctl stop firewalld
```
![](../images/refer_screen_03.png)
- 启动服务：
```shell
systemctl start firewalld
```
![](../images/refer_screen_04.png)
- 重新启动服务（不管当前服务是启动还是关闭）：
```shell
systemctl restart firewalld
```
- 重新载入配置信息而不中断服务：
```shell
systemctl reload firewalld
```
- 禁止服务开机自启动：
```shell
systemctl disable firewalld
```
![](../images/refer_screen_05.png)
- 设置服务开机自启动：
```shell
systemctl enable firewalld
```
![](../images/refer_screen_06.png)

## 文件管理

### ls
列出当前目录(/)下的所有文件：
```shell
ls -l /
```
![](../images/refer_screen_07.png)

### pwd
获取目前所在工作目录的绝对路径

![](../images/refer_screen_08.png)

### cd
改变当前工作目录：
```shell
cd /usr/local
```

![](../images/refer_screen_09.png)

### date
显示或修改系统时间与日期；
```shell
date '+%Y-%m-%d %H:%M:%S'
```
![](../images/refer_screen_10.png)

### passwd
用于设置用户密码：
```shell
passwd root
```

![](../images/refer_screen_11.png)

### su
改变用户身份（切换到超级用户）：
```shell
su -
```
### clear
用于清除屏幕信息

### man
显示指定命令的帮助信息：
```shell
man ls
```
### who
- 查询系统处于什么运行级别：
```shell
who -r
```
![](../images/refer_screen_12.png)
- 显示目前登录到系统的用户：
```shell
who -buT
```
![](../images/refer_screen_13.png)

### free
显示系统内存状态（单位MB）：
```shell
free -m
```
![](../images/refer_screen_14.png)

### ps
显示系统进程运行动态：
```shell
ps -ef
```
查看sshd进程的运行动态：
```shell
ps -ef | grep sshd
```
![](../images/refer_screen_15.png)

### top
查看即时活跃的进程，类似Windows的任务管理器

![](../images/refer_screen_16.png)

### mkdir
创建目录

![](../images/refer_screen_17.png)

### more
用于文件过长时分页查看文件内容
每页10行查看boot.log文件
```shell
more -c -10 /var/log/boot.log
```
![](../images/refer_screen_18.png)

### cat
查看Linux启动日志文件文件，并标明行号：
```shell
cat -Ab /var/log/boot.log
```

![](../images/refer_screen_19.png)

### touch
创建text.txt文件：
```shell
touch text.txt
```

![](../images/refer_screen_20.png)

### rm
- 删除文件：
```shell
rm text.txt
```
- 强制删除某个目录及其子目录：
```shell
rm -rf testdir/
```

![](../images/refer_screen_21.png)

### cp
将test1目录复制到test2目录
```shell
cp -r /mydata/tes1 /mydata/test2
```
### mv
移动或覆盖文件：
```shell
mv text.txt text2.txt
```

## 压缩与解压

### tar
- 将/etc文件夹中的文件归档到文件etc.tar（并不会进行压缩）：
```shell
tar -cvf /mydata/etc.tar /etc
```
- 用gzip压缩文件夹/etc中的文件到文件etc.tar.gz：
```shell
tar -zcvf /mydata/etc.tar.gz /etc
```
- 用bzip2压缩文件夹/etc到文件/etc.tar.bz2：
```shell
tar -jcvf /mydata/etc.tar.bz2 /etc
```
![](../images/refer_screen_22.png)
- 分页查看压缩包中内容（gzip）：
```shell
tar -ztvf /mydata/etc.tar.gz |more -c -10
```
![](../images/refer_screen_24.png)
- 解压文件到当前目录（gzip）：
```shell
tar -zxvf /mydata/etc.tar.gz
```

## 磁盘和网络管理

### df
查看磁盘空间占用情况：
```shell
df -hT
```
![](../images/refer_screen_25.png)

### dh
查看当前目录下的文件及文件夹所占大小：
```shell
du -h --max-depth=1 ./*
```
![](../images/refer_screen_26.png)

### ifconfig
显示当前网络接口状态

![](../images/refer_screen_27.png)

### netstat

- 查看当前路由信息：
```shell
netstat -rn
```
![](../images/refer_screen_28.png)

- 查看所有有效TCP连接：
```shell
netstat -an
```
- 查看系统中启动的监听服务：
```shell
netstat -tulnp
```
![](../images/refer_screen_29.png)

- 查看处于连接状态的系统资源信息：
```shell
netstat -atunp
```

### wget
从网络上下载文件

![](../images/refer_screen_30.png)

## 文件上传下载

### 安装上传下载工具

```bash
yum install -y lrzsz
```

### 上传文件

```bash
rz
```

### 下载文件

```bash
sz fileName
```

## 软件的安装与管理

### rpm

- 安装软件包：rpm -ivh nginx-1.12.2-2.el7.x86_64.rpm
- 模糊搜索软件包：rpm -qa | grep nginx
- 精确查找软件包：rpm -qa nginx
- 查询软件包的安装路径：rpm -ql nginx-1.12.2-2.el7.x86_64
- 查看软件包的概要信息：rpm -qi nginx-1.12.2-2.el7.x86_64
- 验证软件包内容和安装文件是否一致：rpm -V nginx-1.12.2-2.el7.x86_64
- 更新软件包：rpm -Uvh nginx-1.12.2-2.el7.x86_64
- 删除软件包：rpm -e nginx-1.12.2-2.el7.x86_64

### yum

- 安装软件包： yum install nginx
- 检查可以更新的软件包：yum check-update
- 更新指定的软件包：yum update nginx
- 在资源库中查找软件包信息：yum info nginx*
- 列出已经安装的所有软件包：yum info installed
- 列出软件包名称：yum list nginx*
- 模糊搜索软件包：yum search nginx

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)
