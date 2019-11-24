mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# 商品模块数据库表解析（二）

> 接上一篇文章，本文主要对编辑商品、商品评价及回复、商品操作记录这三块功能的表进行解析，采用数据库表与功能对照的形式。

## 编辑商品

### 相关表结构

#### 商品表

> 商品信息主要包括四部分：商品的基本信息、商品的促销信息、商品的属性信息、商品的关联，商品表是整个商品的基本信息部分。

```sql
create table pms_product
(
   id                   bigint not null auto_increment,
   brand_id             bigint comment '品牌id',
   product_category_id  bigint comment '品牌分类id',
   feight_template_id   bigint comment '运费模版id',
   product_attribute_category_id bigint comment '品牌属性分类id',
   name                 varchar(64) not null comment '商品名称',
   pic                  varchar(255) comment '图片',
   product_sn           varchar(64) not null comment '货号',
   delete_status        int(1) comment '删除状态：0->未删除；1->已删除',
   publish_status       int(1) comment '上架状态：0->下架；1->上架',
   new_status           int(1) comment '新品状态:0->不是新品；1->新品',
   recommand_status     int(1) comment '推荐状态；0->不推荐；1->推荐',
   verify_status        int(1) comment '审核状态：0->未审核；1->审核通过',
   sort                 int comment '排序',
   sale                 int comment '销量',
   price                decimal(10,2) comment '价格',
   promotion_price      decimal(10,2) comment '促销价格',
   gift_growth          int default 0 comment '赠送的成长值',
   gift_point           int default 0 comment '赠送的积分',
   use_point_limit      int comment '限制使用的积分数',
   sub_title            varchar(255) comment '副标题',
   description          text comment '商品描述',
   original_price       decimal(10,2) comment '市场价',
   stock                int comment '库存',
   low_stock            int comment '库存预警值',
   unit                 varchar(16) comment '单位',
   weight               decimal(10,2) comment '商品重量，默认为克',
   preview_status       int(1) comment '是否为预告商品：0->不是；1->是',
   service_ids          varchar(64) comment '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
   keywords             varchar(255) comment '关键字',
   note                 varchar(255) comment '备注',
   album_pics           varchar(255) comment '画册图片，连产品图片限制为5张，以逗号分割',
   detail_title         varchar(255) comment '详情标题',
   detail_desc          text comment '详情描述',
   detail_html          text comment '产品详情网页内容',
   detail_mobile_html   text comment '移动端网页详情',
   promotion_start_time datetime comment '促销开始时间',
   promotion_end_time   datetime comment '促销结束时间',
   promotion_per_limit  int comment '活动限购数量',
   promotion_type       int(1) comment '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
   product_category_name varchar(255) comment '产品分类名称',
   brand_name           varchar(255) comment '品牌名称',
   primary key (id)
);
```

#### 商品SKU表

> SKU(Stock Keeping Unit)是指库存量单位，SPU(Standard Product Unit)是指标准产品单位。举个例子：iphone xs是一个SPU，而iphone xs 公开版 64G 银色是一个SKU。

```sql
create table pms_sku_stock
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   sku_code             varchar(64) not null comment 'sku编码',
   price                decimal(10,2) comment '价格',
   stock                int default 0 comment '库存',
   low_stock            int comment '预警库存',
   sp1                  varchar(64) comment '规格属性1',
   sp2                  varchar(64) comment '规格属性2',
   sp3                  varchar(64) comment '规格属性3',
   pic                  varchar(255) comment '展示图片',
   sale                 int comment '销量',
   promotion_price      decimal(10,2) comment '单品促销价格',
   lock_stock           int default 0 comment '锁定库存',
   primary key (id)
);
```

#### 商品阶梯价格表

> 商品优惠相关表，购买同商品满足一定数量后，可以使用打折价格进行购买。如：买两件商品可以打八折。

```sql
create table pms_product_ladder
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   count                int comment '满足的商品数量',
   discount             decimal(10,2) comment '折扣',
   price                decimal(10,2) comment '折后价格',
   primary key (id)
);
```

#### 商品满减表

> 商品优惠相关表，购买同商品满足一定金额后，可以减免一定金额。如：买满1000减100元。

```sql
create table pms_product_full_reduction
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   full_price           decimal(10,2) comment '商品满足金额',
   reduce_price         decimal(10,2) comment '商品减少金额',
   primary key (id)
);
```

#### 商品会员价格表

> 根据不同会员等级，可以以不同的会员价格购买。此处设计有缺陷，可以做成不同会员等级可以减免多少元或者按多少折扣进行购买。

```sql
create table pms_member_price
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   member_level_id      bigint comment '会员等级id',
   member_price         decimal(10,2) comment '会员价格',
   member_level_name    varchar(100) comment '会员等级名称',
   primary key (id)
);
```

### 管理端展现

#### 填写商品信息
![](../images/database_screen_22.png)

#### 填写商品促销
![](../images/database_screen_17.png)
##### 特惠促销
![](../images/database_screen_18.png)
##### 会员价格
![](../images/database_screen_19.png)
##### 阶梯价格
![](../images/database_screen_20.png)
##### 满减价格
![](../images/database_screen_21.png)

#### 填写商品属性
![](../images/database_screen_23.png)
![](../images/database_screen_24.png)
![](../images/database_screen_25.png)

#### 选择商品关联

![](../images/database_screen_26.png)

### 移动端展现

#### 商品介绍
![](../images/database_screen_27.png)
#### 图文详情
![](../images/database_screen_28.png)
#### 相关专题
![](../images/database_screen_29.png)

## 商品评价及回复

### 相关表结构

#### 商品评价表
```sql
create table pms_comment
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   member_nick_name     varchar(255) comment '会员昵称',
   product_name         varchar(255) comment '商品名称',
   star                 int(3) comment '评价星数：0->5',
   member_ip            varchar(64) comment '评价的ip',
   create_time          datetime comment '创建时间',
   show_status          int(1) comment '是否显示',
   product_attribute    varchar(255) comment '购买时的商品属性',
   collect_couont       int comment '收藏数',
   read_count           int comment '阅读数',
   content              text comment '内容',
   pics                 varchar(1000) comment '上传图片地址，以逗号隔开',
   member_icon          varchar(255) comment '评论用户头像',
   replay_count         int comment '回复数',
   primary key (id)
);
```

#### 产品评价回复表

```sql
create table pms_comment_replay
(
   id                   bigint not null auto_increment,
   comment_id           bigint comment '评论id',
   member_nick_name     varchar(255) comment '会员昵称',
   member_icon          varchar(255) comment '会员头像',
   content              varchar(1000) comment '内容',
   create_time          datetime comment '创建时间',
   type                 int(1) comment '评论人员类型；0->会员；1->管理员',
   primary key (id)
);
```

### 移动端展现

#### 商品评价列表
![](../images/database_screen_30.png)

#### 商品评价详情
![](../images/database_screen_31.png)

#### 商品回复列表
![](../images/database_screen_32.png)


## 商品审核及操作记录

### 相关表结构

#### 商品审核记录表
> 用于记录商品审核记录

```sql
create table pms_product_vertify_record
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   create_time          datetime comment '创建时间',
   vertify_man          varchar(64) comment '审核人',
   status               int(1) comment '审核后的状态：0->未通过；2->已通过',
   detail               varchar(255) comment '反馈详情',
   primary key (id)
);
```
#### 商品操作记录表
> 用于记录商品操作记录

```sql
create table pms_product_operate_log
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   price_old            decimal(10,2) comment '改变前价格',
   price_new            decimal(10,2) comment '改变后价格',
   sale_price_old       decimal(10,2) comment '改变前优惠价',
   sale_price_new       decimal(10,2) comment '改变后优惠价',
   gift_point_old       int comment '改变前积分',
   gift_point_new       int comment '改变后积分',
   use_point_limit_old  int comment '改变前积分使用限制',
   use_point_limit_new  int comment '改变后积分使用限制',
   operate_man          varchar(64) comment '操作人',
   create_time          datetime comment '创建时间',
   primary key (id)
);
```

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)
