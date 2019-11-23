mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

## Linux防火墙Firewall和Iptables的使用

> Linux中有两种防火墙软件，ConterOS7.0以上使用的是firewall，ConterOS7.0以下使用的是iptables，本文将分别介绍两种防火墙软件的使用。

## Firewall

- 开启防火墙：
```shell
systemctl start firewalld
```
- 关闭防火墙：
```shell
systemctl stop firewalld
```
- 查看防火墙状态：
```shell
systemctl status firewalld
```
- 设置开机启动：
```shell
systemctl enable firewalld
```
- 禁用开机启动：
```shell
systemctl disable firewalld
```
- 重启防火墙：
```shell
firewall-cmd --reload
```
- 开放端口（修改后需要重启防火墙方可生效）：
```shell
firewall-cmd --zone=public --add-port=8080/tcp --permanent
```
![](../images/refer_screen_31.png)
- 查看开放的端口：
```shell
firewall-cmd --list-ports
```
![](../images/refer_screen_32.png)
- 关闭端口：
```shell
firewall-cmd --zone=public --remove-port=8080/tcp --permanent
```
![](../images/refer_screen_33.png)

## Iptables

### 安装

> 由于CenterOS7.0以上版本并没有预装Iptables,我们需要自行装。

- 安装前先关闭firewall防火墙
![](../images/refer_screen_34.png)
- 安装iptables:
```shell
yum install iptables
```
- 安装iptables-services:
```shell
yum install iptables-services
```

### 使用

- 开启防火墙：
```shell
systemctl start iptables.service
```
![](../images/refer_screen_35.png)
- 关闭防火墙：
```shell
systemctl stop iptables.service
```
- 查看防火墙状态：
```shell
systemctl status iptables.service
```
- 设置开机启动：
```shell
systemctl enable iptables.service
```
- 禁用开机启动：
```shell
systemctl disable iptables.service
```
- 查看filter表的几条链规则(INPUT链可以看出开放了哪些端口)：
```shell
iptables -L -n
```
![](../images/refer_screen_36.png)
- 查看NAT表的链规则：
```shell
iptables -t nat -L -n
```
![](../images/refer_screen_37.png)
- 清除防火墙所有规则：
```shell
iptables -F
```
```shell
iptables -X
```
```shell
iptables -Z
```
- 给INPUT链添加规则（开放8080端口）：
```shell
iptables -I INPUT -p tcp --dport 8080 -j ACCEPT
```
![](../images/refer_screen_38.png)
- 查找规则所在行号：
```shell
iptables -L INPUT --line-numbers -n
```
![](../images/refer_screen_39.png)
- 根据行号删除过滤规则（关闭8080端口）：
```shell
iptables -D INPUT 1
```
![](../images/refer_screen_40.png)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)
