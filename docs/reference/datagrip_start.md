学习不走弯路，[关注公众号](#公众号) 回复「学习路线」，获取mall项目专属学习路线！

# IDEA同款数据库管理工具，提示太全了，用起来贼香！

> 最近体验了一把Jetbrains出品的数据库管理工具`DataGrip`，发现SQL提示真的很全，写起SQL来特别顺手，各种数据库支持也很全。整理了下其用法和使用技巧，助大家码出更高质量的SQL。

## 下载

> 直接从Jetbrains的官网下载即可，下载地址：https://www.jetbrains.com/datagrip/

![](../images/datagrip_start_30.png)

## 外观配置

> 有时候我们的电脑屏幕过大，需要调整下字体大小，要不然看起来太小不适应，可以修改下下面两个配置。

- 软件的外观配置，通过`File->Settings`打开软件设置（用过IDEA的朋友一定很熟悉），然后可以设置软件外观的字体大小；

![](../images/datagrip_start_05.png)

- 编辑器字体大小配置，通过软件设置中的`Editor->Font`配置可以调整编辑器字体大小。

![](../images/datagrip_start_06.png)

## 创建数据源

> 使用DataGrip操作数据库时，我们需要首先创建数据源。

- 我们可以通过`左上角的加号->Data Source->MySQL`来创建一个MySQL的数据源；

![](../images/datagrip_start_01.png)

- 输入相关数据库配置以后，点击`测试连接`，我们发现连接失败了，缺少`serverTimezone`参数的配置；

![](../images/datagrip_start_02.png)

- 只需在`高级`选项中，设置`serverTimezone`属性的值为`Asia/Shanghai`即可；

![](../images/datagrip_start_03.png)

- 设置成功后，点击`测试连接`，就会返回连接成功的信息了。

![](../images/datagrip_start_04.png)

## 管理表相关操作

> 我们先来介绍下数据库表相关操作，包括设计表、查看表数据及导出表数据。

- 连接成功后，在左侧就可以查看数据库中所有的表了；

![](../images/datagrip_start_07.png)

- 选中表`右键->修改表`即可查看数据库表的相关信息；

![](../images/datagrip_start_08.png)

- 双击表就可以分页查看表中存储的数据了；

![](../images/datagrip_start_09.png)

- 有时候有些列的数据我们并不关心，可以右键表头选择隐藏列来隐藏它；

![](../images/datagrip_start_10.png)

- 我们可以在顶部的过滤条件中直接编写WHERE语句来实现对数据的过滤筛选；

![](../images/datagrip_start_11.png)

- 我们可以通过右键数据库名称，选择新建表；

![](../images/datagrip_start_12.png)

- 新建时可以添加表中的列，并且可以预览对应的SQL脚本；

![](../images/datagrip_start_13.png)

- 数据导出功能，可以将数据导出为CSV、Html、Excel、JSON等格式。

![](../images/datagrip_start_14.png)

## SQL操作技巧

> 下面再介绍下在DataGrip中编写SQL的各种小技巧！

- 打开查询控制台，右键数据库，选择`Open Query Console`打开编辑器；

![](../images/datagrip_start_15.png)

- 强大的提示功能，对于SQL语句、数据库中的表和列均有提示；

![](../images/datagrip_start_16.gif)

- 编写`SELECT *`语句并不是好习惯，可以通过选中`*`再使用`Alt+Enter`快捷键来直接扩展成相关列；

![](../images/datagrip_start_17.gif)

- 当我们查询的表取了别名以后，可以通过`Alt+Enter`快捷键来直接为所有查询的列添加前缀；

![](../images/datagrip_start_18.gif)

- 当我们使用`INSERT INTO`语句时，可用直接生成所有需要插入的列名；

![](../images/datagrip_start_19.gif)

- 当我们把鼠标悬停在函数上方时，会显示非常详细的函数使用说明；

![](../images/datagrip_start_20.png)

- 使用`Ctrl+Alt+L`快捷键可以格式化我们的SQL语句；

![](../images/datagrip_start_21.gif)

- 对于执行的各种操作都会显示SQL日志；

![](../images/datagrip_start_22.png)

- 查看代码历史，直接右键编辑器，选择`Local History->Show History`可以打开查看SQL执行的历史记录；

![](../images/datagrip_start_23.png)

- 查看执行计划，选中目标SQL并右键，选择`Explain Plain`，即可在底部查看。

![](../images/datagrip_start_24.png)

![](../images/datagrip_start_25.png)

## MongoDB支持

> DataGrip不仅对关系型数据库有所支持，对非关系型数据库也有所支持，下面简单介绍下如何用它管理MongoDB数据库。

- 创建数据源，通过`左上角的加号->Data Source->MongoDB`来创建一个MongoDB的数据源；

![](../images/datagrip_start_26.png)

- 修改数据源配置并测试连接；

![](../images/datagrip_start_27.png)

- 查看集合中的信息，可以设置筛选条件；

![](../images/datagrip_start_28.png)

- 往集合中插入数据。

![](../images/datagrip_start_29.png)

## 总结

本文主要讲述了在DataGrip中管理MySQL和MongoDB的常用操作及使用技巧，用过Jetbrains公司其他产品的朋友应该很容易就可以上手了！

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)