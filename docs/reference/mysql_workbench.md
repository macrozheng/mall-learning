学习不走弯路，[关注公众号](#公众号) 回复「学习路线」，获取mall项目专属学习路线！

# 干掉Navicat！MySQL官方客户端到底行不行？

> 在我们选择工具的时候，往往会优先选择那些免费又好用的工具！Navicat作为一款付费软件，虽然功能强大，但也阻止不了我们探索新工具的步伐。最近体验了一把MySQL的官方客户端工具`MySQL Workbench`，本文将对其和Navicat做个对比，看看它能否取代Navicat!

## 安装

> 我们先把`MySQL Workbench`安装好，其中有个小坑需要注意下。

- 首先我们需要下载`MySQL Workbench`的安装包，下载地址：https://dev.mysql.com/downloads/workbench/

![](../images/mysql_workbench_01.png)

- 下载完成后我们双击安装会遇到一个问题，`MySQL Workbench 8.0`版本安装需要先安装`Visual C++ 2019 Redistributable Package`依赖；

![](../images/mysql_workbench_02.png)

- 下载`Visual C++ 2019 Redistributable Package`，下载地址：https://support.microsoft.com/en-us/help/2977003/the-latest-supported-visual-c-downloads

![](../images/mysql_workbench_03.png)

- 下载完成后安装`Visual C++ 2019 Redistributable Package`，一直点击下一步即可；

![](../images/mysql_workbench_04.png)

- 之后重新双击`MySQL Workbench`的安装包，一路点击下一步即可顺利安装了。

![](../images/mysql_workbench_05.png)

## 使用

> 接下来我们将通过基础的数据库管理功能，来体验下`MySQL Workbench`的使用。

### 建立新连接

双击打开`MySQL Workbench`，然后输入数据库连接信息即可建立新连接。

![](../images/mysql_workbench_06.png)

### 外观设置

由于默认的编辑器字体比较小，可以改大一些，通过`Edit->Preferences`选项来修改，不过这里只能通过输入字体名称和大小来改变，有点不太方便！

![](../images/mysql_workbench_07.png)

### 表管理

- 查看数据库表结构，通过右击表选择`Table Inspector`来查看；

![](../images/mysql_workbench_08.png)

- 修改数据库表结构，通过右击表选择`Alter Table`来修改。

![](../images/mysql_workbench_09.png)

### 数据管理

- 查看表数据，通过右击表选择`Select Rows`来查看，我们可以发现在SQL编辑器中自动生成了SELECT语句；

![](../images/mysql_workbench_10.png)

- 修改表数据，我们需要双击需要修改的表字段，然后点击`Apply`来应用；

![](../images/mysql_workbench_11.png)

- 我们可以发现最后工具中的修改被转化为了UPDATE语句，可见`MySQL Workbench`中的数据操作最终会转化为语句来执行。

![](../images/mysql_workbench_12.png)

### SQL操作

- 我们可以使用SQL编辑器来执行SQL语句，使用左上角的按钮可以创建一个SQL编辑器；

![](../images/mysql_workbench_13.png)

- `MySQL Workbench`的SQL提示还是挺全的，来写个SQL试试，基本能够满足平时编辑SQL的需求。

![](../images/mysql_workbench_14.gif)

### 实例管理

- 查看MySQL服务状态信息；

![](../images/mysql_workbench_15.png)

- 管理MySQL用户和权限；

![](../images/mysql_workbench_16.png)

- 管理MySQL实例，实现启动和关闭；

![](../images/mysql_workbench_17.png)

- 查看展示MySQL服务性能信息的仪表盘。

![](../images/mysql_workbench_18.png)

## 对比Navicat

- Navicat中有个非常好用的数据库设计功能，为此我抛弃了笨重的PowerDesigner，很显然`MySQL Workbench`并不支持该功能。

![](../images/mysql_workbench_19.png)

- 使用Navicat设计数据库，具体可以参考[《我用起来顺手的数据库设计工具，这次推荐给大家！》](https://mp.weixin.qq.com/s/SJI0x7qQw5JkCvDWou7XaQ)。

- Navicat具有强大的数据备份和结构同步功能，平时用来数据备份，同步测试环境的数据库结构到生产环境很好用，如果使用`MySQL Workbench`估计就只能将SQL进行导入导出了。

![](../images/mysql_workbench_20.png)

- 使用Navicat实现数据备份和结构同步，具体可以参考[《Navicat实用功能：数据备份与结构同步》](https://mp.weixin.qq.com/s/Km7lg-T0p9Kzb_WeyHVaqw)。

- `MySQL Workbench`中特有的实例管理功能是Navicat所不具备的。

- Navicat能支持MySQL、MariaDB、MongoDB、SQL Server、Oracle、PostgreSQL等多种数据库，很显然`MySQL Workbench`只能支持MySQL。

## 总结

总的来说，`MySQL Workbench`作为一款MySQL数据库管理工具显然足够了，但是Navicat的很多功能它是无法取代的。如果你想设计数据库，拥有更好的数据库运维功能，或者你需要使用多种不同的数据库，那还是使用Navicat吧！

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)