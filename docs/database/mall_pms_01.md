mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# 商品模块数据库表解析（一）

> 本文主要对商品分类、品牌管理、商品类型这三个功能的表进行解析，采用功能与表结构对照的形式。表解析只会标注一些需要理解的字段，简单字段请自行对照表注释。

## 商品分类

### 商品分类表

```sql
create table pms_product_category
(
   id                   bigint not null auto_increment,
   parent_id            bigint comment '上级分类的编号：0表示一级分类',
   name                 varchar(64) comment '名称',
   level                int(1) comment '分类级别：0->1级；1->2级',
   product_count        int comment '商品数量',
   product_unit         varchar(64) comment '商品单位',
   nav_status           int(1) comment '是否显示在导航栏：0->不显示；1->显示',
   show_status          int(1) comment '显示状态：0->不显示；1->显示',
   sort                 int comment '排序',
   icon                 varchar(255) comment '图标',
   keywords             varchar(255) comment '关键字',
   description          text comment '描述',
   primary key (id)
);
```

### 管理端展现

- 商品分类列表
![](../images/database_screen_02.png)
- 添加商品分类
![](../images/database_screen_01.png)


### 移动端展现

![](../images/database_screen_03.png)

## 品牌管理

### 商品品牌表

```sql
create table pms_brand
(
   id                   bigint not null auto_increment,
   name                 varchar(64) comment '名称',
   first_letter         varchar(8) comment '首字母',
   sort                 int comment '排序',
   factory_status       int(1) comment '是否为品牌制造商：0->不是；1->是',
   show_status          int(1) comment '是否显示',
   product_count        int comment '产品数量',
   product_comment_count int comment '产品评论数量',
   logo                 varchar(255) comment '品牌logo',
   big_pic              varchar(255) comment '专区大图',
   brand_story          text comment '品牌故事',
   primary key (id)
);
```

### 管理端展现

- 品牌列表
![](../images/database_screen_04.png)
- 添加品牌
![](../images/database_screen_05.png)

### 移动端展现

![](../images/database_screen_06.png)

## 商品类型

> 商品类型即商品属性，主要是指商品的规格和参数，规格用于用户购买商品时选择，参数用于标示商品属性及搜索时筛选。

### 相关表结构

#### 商品属性分类表

```sql
create table pms_product_attribute_category
(
   id                   bigint not null auto_increment,
   name                 varchar(64) comment '名称',
   attribute_count      int comment '属性数量',
   param_count          int comment '参数数量',
   primary key (id)
);
```

#### 商品属性表

> type字段用于控制其是规格还是参数

```sql
create table pms_product_attribute
(
   id                   bigint not null auto_increment,
   product_attribute_category_id bigint comment '商品属性分类id',
   name                 varchar(64) comment '名称',
   select_type          int(1) comment '属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；',
   input_type           int(1) comment '属性录入方式：0->手工录入；1->从列表中选取',
   input_list           varchar(255) comment '可选值列表，以逗号隔开',
   sort                 int comment '排序字段：最高的可以单独上传图片',
   filter_type          int(1) comment '分类筛选样式：1->普通；1->颜色',
   search_type          int(1) comment '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
   related_status       int(1) comment '相同属性产品是否关联；0->不关联；1->关联',
   hand_add_status      int(1) comment '是否支持手动新增；0->不支持；1->支持',
   type                 int(1) comment '属性的类型；0->规格；1->参数',
   primary key (id)
);
```

#### 商品属性值表

> 如果对应的参数是规格且规格支持手动添加，那么该表用于存储手动新增的值；如果对应的商品属性是参数，那么该表用于存储参数的值。

```sql
create table pms_product_attribute_value
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   product_attribute_id bigint comment '商品属性id',
   value                varchar(64) comment '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
   primary key (id)
);
```

#### 商品分类和属性的关系表

> 用于选中分类后搜索时生成筛选属性。

```sql
create table pms_product_category_attribute_relation
(
   id                   bigint not null auto_increment,
   product_category_id  bigint comment '商品分类id',
   product_attribute_id bigint comment '商品属性id',
   primary key (id)
);
```

### 管理端展现

- 商品属性分类列表
![](../images/database_screen_07.png)
- 添加商品属性分类  
![](../images/database_screen_08.png)
- 商品规格列表
![](../images/database_screen_09.png)
- 商品参数列表
![](../images/database_screen_10.png)
- 添加商品属性
![](../images/database_screen_11.png)
- 添加商品时，选中商品属性分类，就会显示该分类的属性，用于生成sku
![](../images/database_screen_12.png)
- 添加商品时，选中商品属性分类，会显示该分类的参数用于录入
![](../images/database_screen_13.png)

### 移动端展现

- 选择商品规格  
![](../images/database_screen_14.png)
- 查看商品参数  
![](../images/database_screen_15.png)
- 搜索商品时用于选择分类后的筛选  
![](../images/database_screen_16.png)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)