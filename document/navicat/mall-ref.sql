/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/4/15 14:40:15                           */
/*==============================================================*/


drop table if exists cms_help;

drop table if exists cms_help_category;

drop table if exists cms_member_report;

drop table if exists cms_prefrence_area;

drop table if exists cms_prefrence_area_product_relation;

drop table if exists cms_subject;

drop table if exists cms_subject_category;

drop table if exists cms_subject_comment;

drop table if exists cms_subject_product_relation;

drop table if exists cms_topic;

drop table if exists cms_topic_category;

drop table if exists cms_topic_comment;

drop table if exists oms_cart_item;

drop table if exists oms_company_address;

drop table if exists oms_order;

drop table if exists oms_order_item;

drop table if exists oms_order_operate_history;

drop table if exists oms_order_return_apply;

drop table if exists oms_order_return_reason;

drop table if exists oms_order_setting;

drop table if exists pms_album;

drop table if exists pms_album_pic;

drop table if exists pms_brand;

drop table if exists pms_comment;

drop table if exists pms_comment_replay;

drop table if exists pms_feight_template;

drop table if exists pms_member_price;

drop table if exists pms_product;

drop table if exists pms_product_attribute;

drop table if exists pms_product_attribute_category;

drop table if exists pms_product_attribute_value;

drop table if exists pms_product_category;

drop table if exists pms_product_category_attribute_relation;

drop table if exists pms_product_full_reduction;

drop table if exists pms_product_ladder;

drop table if exists pms_product_operate_log;

drop table if exists pms_product_vertify_record;

drop table if exists pms_sku_stock;

drop table if exists sms_coupon;

drop table if exists sms_coupon_history;

drop table if exists sms_coupon_product_category_relation;

drop table if exists sms_coupon_product_relation;

drop table if exists sms_flash_promotion;

drop table if exists sms_flash_promotion_log;

drop table if exists sms_flash_promotion_product_relation;

drop table if exists sms_flash_promotion_session;

drop table if exists sms_home_advertise;

drop table if exists sms_home_brand;

drop table if exists sms_home_new_product;

drop table if exists sms_home_recommend_product;

drop table if exists sms_home_recommend_subject;

drop table if exists ums_admin;

drop table if exists ums_admin_login_log;

drop table if exists ums_admin_permission_relation;

drop table if exists ums_admin_role_relation;

drop table if exists ums_growth_change_history;

drop table if exists ums_integration_change_history;

drop table if exists ums_integration_consume_setting;

drop table if exists ums_member;

drop table if exists ums_member_level;

drop table if exists ums_member_login_log;

drop table if exists ums_member_member_tag_relation;

drop table if exists ums_member_product_category_relation;

drop table if exists ums_member_receive_address;

drop table if exists ums_member_rule_setting;

drop table if exists ums_member_statistics_info;

drop table if exists ums_member_tag;

drop table if exists ums_member_task;

drop table if exists ums_menu;

drop table if exists ums_permission;

drop table if exists ums_resource;

drop table if exists ums_resource_category;

drop table if exists ums_role;

drop table if exists ums_role_menu_relation;

drop table if exists ums_role_permission_relation;

drop table if exists ums_role_resource_relation;

/*==============================================================*/
/* Table: cms_help                                              */
/*==============================================================*/
create table cms_help
(
   id                   bigint not null auto_increment,
   category_id          bigint,
   icon                 varchar(500),
   title                varchar(100),
   show_status          int(1),
   create_time          datetime,
   read_count           int(1),
   content              text,
   primary key (id)
);

alter table cms_help comment '帮助表';

/*==============================================================*/
/* Table: cms_help_category                                     */
/*==============================================================*/
create table cms_help_category
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   icon                 varchar(500) comment '分类图标',
   help_count           int comment '专题数量',
   show_status          int(2),
   sort                 int,
   primary key (id)
);

alter table cms_help_category comment '帮助分类表';

/*==============================================================*/
/* Table: cms_member_report                                     */
/*==============================================================*/
create table cms_member_report
(
   id                   bigint,
   report_type          int(1) comment '举报类型：0->商品评价；1->话题内容；2->用户评论',
   report_member_name   varchar(100) comment '举报人',
   create_time          datetime,
   report_object        varchar(100),
   report_status        int(1) comment '举报状态：0->未处理；1->已处理',
   handle_status        int(1) comment '处理结果：0->无效；1->有效；2->恶意',
   note                 varchar(200)
);

alter table cms_member_report comment '用户举报表';

/*==============================================================*/
/* Table: cms_prefrence_area                                    */
/*==============================================================*/
create table cms_prefrence_area
(
   id                   bigint not null auto_increment,
   name                 varchar(255),
   sub_title            varchar(255),
   pic                  varbinary(500) comment '展示图片',
   sort                 int,
   show_status          int(1),
   primary key (id)
);

alter table cms_prefrence_area comment '优选专区';

/*==============================================================*/
/* Table: cms_prefrence_area_product_relation                   */
/*==============================================================*/
create table cms_prefrence_area_product_relation
(
   id                   bigint not null auto_increment,
   prefrence_area_id    bigint,
   product_id           bigint,
   primary key (id)
);

alter table cms_prefrence_area_product_relation comment '优选专区和产品关系表';

/*==============================================================*/
/* Table: cms_subject                                           */
/*==============================================================*/
create table cms_subject
(
   id                   bigint not null auto_increment,
   category_id          bigint,
   title                varchar(100),
   pic                  varchar(500) comment '专题主图',
   product_count        int comment '关联产品数量',
   recommend_status     int(1),
   create_time          datetime,
   collect_count        int,
   read_count           int,
   comment_count        int,
   album_pics           varchar(1000) comment '画册图片用逗号分割',
   description          varchar(1000),
   show_status          int(1) comment '显示状态：0->不显示；1->显示',
   content              text,
   forward_count        int comment '转发数',
   category_name        varchar(200) comment '专题分类名称',
   primary key (id)
);

alter table cms_subject comment '专题表';

/*==============================================================*/
/* Table: cms_subject_category                                  */
/*==============================================================*/
create table cms_subject_category
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   icon                 varchar(500) comment '分类图标',
   subject_count        int comment '专题数量',
   show_status          int(2),
   sort                 int,
   primary key (id)
);

alter table cms_subject_category comment '专题分类表';

/*==============================================================*/
/* Table: cms_subject_comment                                   */
/*==============================================================*/
create table cms_subject_comment
(
   id                   bigint not null auto_increment,
   subject_id           bigint,
   member_nick_name     varchar(255),
   member_icon          varchar(255),
   content              varchar(1000),
   create_time          datetime,
   show_status          int(1),
   primary key (id)
);

alter table cms_subject_comment comment '专题评论表';

/*==============================================================*/
/* Table: cms_subject_product_relation                          */
/*==============================================================*/
create table cms_subject_product_relation
(
   id                   bigint not null auto_increment,
   subject_id           bigint,
   product_id           bigint,
   primary key (id)
);

alter table cms_subject_product_relation comment '专题商品关系表';

/*==============================================================*/
/* Table: cms_topic                                             */
/*==============================================================*/
create table cms_topic
(
   id                   bigint not null auto_increment,
   category_id          bigint,
   name                 varchar(255),
   create_time          datetime,
   start_time           datetime,
   end_time             datetime,
   attend_count         int comment '参与人数',
   attention_count      int comment '关注人数',
   read_count           int,
   award_name           varchar(100) comment '奖品名称',
   attend_type          varchar(100) comment '参与方式',
   content              text comment '话题内容',
   primary key (id)
);

alter table cms_topic comment '话题表';

/*==============================================================*/
/* Table: cms_topic_category                                    */
/*==============================================================*/
create table cms_topic_category
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   icon                 varchar(500) comment '分类图标',
   subject_count        int comment '专题数量',
   show_status          int(2),
   sort                 int,
   primary key (id)
);

alter table cms_topic_category comment '话题分类表';

/*==============================================================*/
/* Table: cms_topic_comment                                     */
/*==============================================================*/
create table cms_topic_comment
(
   id                   bigint not null auto_increment,
   member_nick_name     varchar(255),
   topic_id             bigint,
   member_icon          varchar(255),
   content              varchar(1000),
   create_time          datetime,
   show_status          int(1),
   primary key (id)
);

alter table cms_topic_comment comment '专题评论表';

/*==============================================================*/
/* Table: oms_cart_item                                         */
/*==============================================================*/
create table oms_cart_item
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   product_sku_id       bigint,
   member_id            bigint,
   quantity             int comment '购买数量',
   price                decimal(10,2) comment '添加到购物车的价格',
   product_pic          varchar(1000) comment '商品主图',
   product_name         varchar(500) comment '商品名称',
   product_brand        varchar(200),
   product_sn           varchar(200),
   product_sub_title    varchar(500) comment '商品副标题（卖点）',
   product_sku_code     varchar(200) comment '商品sku条码',
   member_nickname      varchar(500) comment '会员昵称',
   create_date          datetime comment '创建时间',
   modify_date          datetime comment '修改时间',
   delete_status        int(1) default 0 comment '是否删除',
   product_category_id  bigint comment '商品的分类',
   product_attr         varchar(500) comment '商品销售属性:[{"key":"颜色","value":"银色"},{"key":"容量","value":"4G"}]',
   primary key (id)
);

alter table oms_cart_item comment '购物车表';

/*==============================================================*/
/* Table: oms_company_address                                   */
/*==============================================================*/
create table oms_company_address
(
   id                   bigint not null auto_increment,
   address_name         varchar(200) comment '地址名称',
   send_status          int(1) comment '默认发货地址：0->否；1->是',
   receive_status       int(1) comment '是否默认收货地址：0->否；1->是',
   name                 varchar(64) comment '收发货人姓名',
   phone                varchar(64) comment '收货人电话',
   province             varchar(64) comment '省/直辖市',
   city                 varchar(64) comment '市',
   region               varchar(64) comment '区',
   detail_address       varchar(200) comment '详细地址',
   primary key (id)
);

alter table oms_company_address comment '公司收发货地址表';

/*==============================================================*/
/* Table: oms_order                                             */
/*==============================================================*/
create table oms_order
(
   id                   bigint not null auto_increment comment '订单id',
   member_id            bigint not null,
   coupon_id            bigint,
   order_sn             varchar(64) comment '订单编号',
   create_time          datetime comment '提交时间',
   member_username      varchar(64) comment '用户帐号',
   total_amount         decimal(10,2) comment '订单总金额',
   pay_amount           decimal(10,2) comment '应付金额（实际支付金额）',
   freight_amount       decimal(10,2) comment '运费金额',
   promotion_amount     decimal(10,2) comment '促销优化金额（促销价、满减、阶梯价）',
   integration_amount   decimal(10,2) comment '积分抵扣金额',
   coupon_amount        decimal(10,2) comment '优惠券抵扣金额',
   discount_amount      decimal(10,2) comment '管理员后台调整订单使用的折扣金额',
   pay_type             int(1) comment '支付方式：0->未支付；1->支付宝；2->微信',
   source_type          int(1) comment '订单来源：0->PC订单；1->app订单',
   status               int(1) comment '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
   order_type           int(1) comment '订单类型：0->正常订单；1->秒杀订单',
   delivery_company     varchar(64) comment '物流公司(配送方式)',
   delivery_sn          varchar(64) comment '物流单号',
   auto_confirm_day     int comment '自动确认时间（天）',
   integration          int comment '可以获得的积分',
   growth               int comment '可以活动的成长值',
   promotion_info       varchar(100) comment '活动信息',
   bill_type            int(1) comment '发票类型：0->不开发票；1->电子发票；2->纸质发票',
   bill_header          varchar(200) comment '发票抬头',
   bill_content         varchar(200) comment '发票内容',
   bill_receiver_phone  varchar(32) comment '收票人电话',
   bill_receiver_email  varchar(64) comment '收票人邮箱',
   receiver_name        varchar(100) not null comment '收货人姓名',
   receiver_phone       varchar(32) not null comment '收货人电话',
   receiver_post_code   varchar(32) comment '收货人邮编',
   receiver_province    varchar(32) comment '省份/直辖市',
   receiver_city        varchar(32) comment '城市',
   receiver_region      varchar(32) comment '区',
   receiver_detail_address varchar(200) comment '详细地址',
   note                 varchar(500) comment '订单备注',
   confirm_status       int(1) comment '确认收货状态：0->未确认；1->已确认',
   delete_status        int(1) not null default 0 comment '删除状态：0->未删除；1->已删除',
   use_integration      int comment '下单时使用的积分',
   payment_time         datetime comment '支付时间',
   delivery_time        datetime comment '发货时间',
   receive_time         datetime comment '确认收货时间',
   comment_time         datetime comment '评价时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table oms_order comment '订单表';

/*==============================================================*/
/* Table: oms_order_item                                        */
/*==============================================================*/
create table oms_order_item
(
   id                   bigint not null auto_increment,
   order_id             bigint comment '订单id',
   order_sn             varchar(64) comment '订单编号',
   product_id           bigint,
   product_pic          varchar(500),
   product_name         varchar(200),
   product_brand        varchar(200),
   product_sn           varchar(64),
   product_price        decimal(10,2) comment '销售价格',
   product_quantity     int comment '购买数量',
   product_sku_id       bigint comment '商品sku编号',
   product_sku_code     varchar(50) comment '商品sku条码',
   product_category_id  bigint comment '商品分类id',
   promotion_name       varchar(200) comment '商品促销名称',
   promotion_amount     decimal(10,2) comment '商品促销分解金额',
   coupon_amount        decimal(10,2) comment '优惠券优惠分解金额',
   integration_amount   decimal(10,2) comment '积分优惠分解金额',
   real_amount          decimal(10,2) comment '该商品经过优惠后的分解金额',
   gift_integration     int not null default 0 comment '商品赠送积分',
   gift_growth          int not null default 0 comment '商品赠送成长值',
   product_attr         varchar(500) comment '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
   primary key (id)
);

alter table oms_order_item comment '订单中所包含的商品';

/*==============================================================*/
/* Table: oms_order_operate_history                             */
/*==============================================================*/
create table oms_order_operate_history
(
   id                   bigint not null auto_increment,
   order_id             bigint comment '订单id',
   operate_man          varchar(100) comment '操作人：用户；系统；后台管理员',
   create_time          datetime comment '操作时间',
   order_status         int(1) comment '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
   note                 varchar(500) comment '备注',
   primary key (id)
);

alter table oms_order_operate_history comment '订单操作历史记录';

/*==============================================================*/
/* Table: oms_order_return_apply                                */
/*==============================================================*/
create table oms_order_return_apply
(
   id                   bigint not null auto_increment,
   order_id             bigint comment '订单id',
   company_address_id   bigint comment '收货地址表id',
   product_id           bigint comment '退货商品id',
   order_sn             varchar(64) comment '订单编号',
   create_time          datetime comment '申请时间',
   member_username      varchar(64) comment '会员用户名',
   return_amount        decimal(10,2) comment '退款金额',
   return_name          varchar(100) comment '退货人姓名',
   return_phone         varchar(100) comment '退货人电话',
   status               int(1) comment '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
   handle_time          datetime comment '处理时间',
   product_pic          varchar(500) comment '商品图片',
   product_name         varchar(200) comment '商品名称',
   product_brand        varchar(200) comment '商品品牌',
   product_attr         varchar(500) comment '商品销售属性：颜色：红色；尺码：xl;',
   product_count        int comment '退货数量',
   product_price        decimal(10,2) comment '商品单价',
   product_real_price   decimal(10,2) comment '商品实际支付单价',
   reason               varchar(200) comment '原因',
   description          varchar(500) comment '描述',
   proof_pics           varchar(1000) comment '凭证图片，以逗号隔开',
   handle_note          varchar(500) comment '处理备注',
   handle_man           varchar(100) comment '处理人员',
   receive_man          varchar(100) comment '收货人',
   receive_time         datetime comment '收货时间',
   receive_note         varchar(500) comment '收货备注',
   primary key (id)
);

alter table oms_order_return_apply comment '订单退货申请';

/*==============================================================*/
/* Table: oms_order_return_reason                               */
/*==============================================================*/
create table oms_order_return_reason
(
   id                   bigint not null auto_increment,
   name                 varchar(100) comment '退货类型',
   sort                 int,
   status               int(1) comment '状态：0->不启用；1->启用',
   create_time          datetime comment '添加时间',
   primary key (id)
);

alter table oms_order_return_reason comment '退货原因表';

/*==============================================================*/
/* Table: oms_order_setting                                     */
/*==============================================================*/
create table oms_order_setting
(
   id                   bigint not null auto_increment,
   flash_order_overtime int comment '秒杀订单超时关闭时间(分)',
   normal_order_overtime int comment '正常订单超时时间(分)',
   confirm_overtime     int comment '发货后自动确认收货时间（天）',
   finish_overtime      int comment '自动完成交易时间，不能申请售后（天）',
   comment_overtime     int comment '订单完成后自动好评时间（天）',
   primary key (id)
);

alter table oms_order_setting comment '订单设置表';

/*==============================================================*/
/* Table: pms_album                                             */
/*==============================================================*/
create table pms_album
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   cover_pic            varchar(1000),
   pic_count            int,
   sort                 int,
   description          varchar(1000),
   primary key (id)
);

alter table pms_album comment '相册表';

/*==============================================================*/
/* Table: pms_album_pic                                         */
/*==============================================================*/
create table pms_album_pic
(
   id                   bigint not null auto_increment,
   album_id             bigint,
   pic                  varchar(1000),
   primary key (id)
);

alter table pms_album_pic comment '画册图片表';

/*==============================================================*/
/* Table: pms_brand                                             */
/*==============================================================*/
create table pms_brand
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   first_letter         varchar(8) comment '首字母',
   sort                 int,
   factory_status       int(1) comment '是否为品牌制造商：0->不是；1->是',
   show_status          int(1),
   product_count        int comment '产品数量',
   product_comment_count int comment '产品评论数量',
   logo                 varchar(255) comment '品牌logo',
   big_pic              varchar(255) comment '专区大图',
   brand_story          text comment '品牌故事',
   primary key (id)
);

alter table pms_brand comment '品牌表';

/*==============================================================*/
/* Table: pms_comment                                           */
/*==============================================================*/
create table pms_comment
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   member_nick_name     varchar(255),
   product_name         varchar(255),
   star                 int(3) comment '评价星数：0->5',
   member_ip            varchar(64) comment '评价的ip',
   create_time          datetime,
   show_status          int(1),
   product_attribute    varchar(255) comment '购买时的商品属性',
   collect_couont       int,
   read_count           int,
   content              text,
   pics                 varchar(1000) comment '上传图片地址，以逗号隔开',
   member_icon          varchar(255) comment '评论用户头像',
   replay_count         int,
   primary key (id)
);

alter table pms_comment comment '商品评价表';

/*==============================================================*/
/* Table: pms_comment_replay                                    */
/*==============================================================*/
create table pms_comment_replay
(
   id                   bigint not null auto_increment,
   comment_id           bigint,
   member_nick_name     varchar(255),
   member_icon          varchar(255),
   content              varchar(1000),
   create_time          datetime,
   type                 int(1) comment '评论人员类型；0->会员；1->管理员',
   primary key (id)
);

alter table pms_comment_replay comment '产品评价回复表';

/*==============================================================*/
/* Table: pms_feight_template                                   */
/*==============================================================*/
create table pms_feight_template
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   charge_type          int(1) comment '计费类型:0->按重量；1->按件数',
   first_weight         decimal(10,2) comment '首重kg',
   first_fee            decimal(10,2) comment '首费（元）',
   continue_weight      decimal(10,2),
   continme_fee         decimal(10,2),
   dest                 varchar(255) comment '目的地（省、市）',
   primary key (id)
);

alter table pms_feight_template comment '运费模版';

/*==============================================================*/
/* Table: pms_member_price                                      */
/*==============================================================*/
create table pms_member_price
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   member_level_id      bigint,
   member_price         decimal(10,2) comment '会员价格',
   member_level_name    varchar(100),
   primary key (id)
);

alter table pms_member_price comment '商品会员价格表';

/*==============================================================*/
/* Table: pms_product                                           */
/*==============================================================*/
create table pms_product
(
   id                   bigint not null auto_increment,
   brand_id             bigint,
   product_category_id  bigint,
   feight_template_id   bigint,
   product_attribute_category_id bigint,
   name                 varchar(64) not null,
   pic                  varchar(255),
   product_sn           varchar(64) not null comment '货号',
   delete_status        int(1) comment '删除状态：0->未删除；1->已删除',
   publish_status       int(1) comment '上架状态：0->下架；1->上架',
   new_status           int(1) comment '新品状态:0->不是新品；1->新品',
   recommand_status     int(1) comment '推荐状态；0->不推荐；1->推荐',
   verify_status        int(1) comment '审核状态：0->未审核；1->审核通过',
   sort                 int comment '排序',
   sale                 int comment '销量',
   price                decimal(10,2),
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
   keywords             varchar(255),
   note                 varchar(255),
   album_pics           varchar(255) comment '画册图片，连产品图片限制为5张，以逗号分割',
   detail_title         varchar(255),
   detail_desc          text,
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

alter table pms_product comment '商品信息';

/*==============================================================*/
/* Table: pms_product_attribute                                 */
/*==============================================================*/
create table pms_product_attribute
(
   id                   bigint not null auto_increment,
   product_attribute_category_id bigint,
   name                 varchar(64),
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

alter table pms_product_attribute comment '商品属性参数表';

/*==============================================================*/
/* Table: pms_product_attribute_category                        */
/*==============================================================*/
create table pms_product_attribute_category
(
   id                   bigint not null auto_increment,
   name                 varchar(64),
   attribute_count      int comment '属性数量',
   param_count          int comment '参数数量',
   primary key (id)
);

alter table pms_product_attribute_category comment '产品属性分类表';

/*==============================================================*/
/* Table: pms_product_attribute_value                           */
/*==============================================================*/
create table pms_product_attribute_value
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   product_attribute_id bigint,
   value                varchar(64) comment '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
   primary key (id)
);

alter table pms_product_attribute_value comment '存储产品参数信息的表';

/*==============================================================*/
/* Table: pms_product_category                                  */
/*==============================================================*/
create table pms_product_category
(
   id                   bigint not null auto_increment,
   parent_id            bigint comment '上机分类的编号：0表示一级分类',
   name                 varchar(64),
   level                int(1) comment '分类级别：0->1级；1->2级',
   product_count        int,
   product_unit         varchar(64),
   nav_status           int(1) comment '是否显示在导航栏：0->不显示；1->显示',
   show_status          int(1) comment '显示状态：0->不显示；1->显示',
   sort                 int,
   icon                 varchar(255) comment '图标',
   keywords             varchar(255),
   description          text comment '描述',
   primary key (id)
);

alter table pms_product_category comment '产品分类';

/*==============================================================*/
/* Table: pms_product_category_attribute_relation               */
/*==============================================================*/
create table pms_product_category_attribute_relation
(
   id                   bigint not null auto_increment,
   product_category_id  bigint,
   product_attribute_id bigint,
   primary key (id)
);

alter table pms_product_category_attribute_relation comment '产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）';

/*==============================================================*/
/* Table: pms_product_full_reduction                            */
/*==============================================================*/
create table pms_product_full_reduction
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   full_price           decimal(10,2),
   reduce_price         decimal(10,2),
   primary key (id)
);

alter table pms_product_full_reduction comment '产品满减表(只针对同商品)';

/*==============================================================*/
/* Table: pms_product_ladder                                    */
/*==============================================================*/
create table pms_product_ladder
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   count                int comment '满足的商品数量',
   discount             decimal(10,2) comment '折扣',
   price                decimal(10,2) comment '折后价格',
   primary key (id)
);

alter table pms_product_ladder comment '产品阶梯价格表(只针对同商品)';

/*==============================================================*/
/* Table: pms_product_operate_log                               */
/*==============================================================*/
create table pms_product_operate_log
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   price_old            decimal(10,2),
   price_new            decimal(10,2),
   sale_price_old       decimal(10,2),
   sale_price_new       decimal(10,2),
   gift_point_old       int comment '赠送的积分',
   gift_point_new       int,
   use_point_limit_old  int,
   use_point_limit_new  int,
   operate_man          varchar(64) comment '操作人',
   create_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: pms_product_vertify_record                            */
/*==============================================================*/
create table pms_product_vertify_record
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   create_time          datetime,
   vertify_man          varchar(64) comment '审核人',
   status               int(1) comment '审核后的状态：0->未通过；2->已通过',
   detail               varchar(255) comment '反馈详情',
   primary key (id)
);

alter table pms_product_vertify_record comment '商品审核记录';

/*==============================================================*/
/* Table: pms_sku_stock                                         */
/*==============================================================*/
create table pms_sku_stock
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   sku_code             varchar(64) not null comment 'sku编码',
   price                decimal(10,2),
   stock                int default 0 comment '库存',
   low_stock            int comment '预警库存',
   pic                  varchar(255) comment '展示图片',
   sale                 int comment '销量',
   promotion_price      decimal(10,2) comment '单品促销价格',
   lock_stock           int default 0 comment '锁定库存',
   sp_data              varchar(500) comment '商品销售属性，json格式',
   primary key (id)
);

alter table pms_sku_stock comment 'sku的库存';

/*==============================================================*/
/* Table: sms_coupon                                            */
/*==============================================================*/
create table sms_coupon
(
   id                   bigint not null auto_increment,
   type                 int(1) comment '优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券',
   name                 varchar(100),
   platform             int(1) comment '使用平台：0->全部；1->移动；2->PC',
   count                int comment '数量',
   amount               decimal(10,2) comment '金额',
   per_limit            int comment '每人限领张数',
   min_point            decimal(10,2) comment '使用门槛；0表示无门槛',
   start_time           datetime,
   end_time             datetime,
   use_type             int(1) comment '使用类型：0->全场通用；1->指定分类；2->指定商品',
   note                 varchar(200) comment '备注',
   publish_count        int comment '发行数量',
   use_count            int comment '已使用数量',
   receive_count        int comment '领取数量',
   enable_time          datetime comment '可以领取的日期',
   code                 varchar(64) comment '优惠码',
   member_level         int(1) comment '可领取的会员类型：0->无限时',
   primary key (id)
);

alter table sms_coupon comment '优惠卷表';

/*==============================================================*/
/* Table: sms_coupon_history                                    */
/*==============================================================*/
create table sms_coupon_history
(
   id                   bigint not null auto_increment,
   coupon_id            bigint,
   member_id            bigint,
   order_id             bigint comment '订单id',
   coupon_code          varchar(64),
   member_nickname      varchar(64) comment '领取人昵称',
   get_type             int(1) comment '获取类型：0->后台赠送；1->主动获取',
   create_time          datetime,
   use_status           int(1) comment '使用状态：0->未使用；1->已使用；2->已过期',
   use_time             datetime comment '使用时间',
   order_sn             varchar(100) comment '订单号码',
   primary key (id)
);

alter table sms_coupon_history comment '优惠券使用、领取历史表';

/*==============================================================*/
/* Table: sms_coupon_product_category_relation                  */
/*==============================================================*/
create table sms_coupon_product_category_relation
(
   id                   bigint not null auto_increment,
   coupon_id            bigint,
   product_category_id  bigint,
   product_category_name varchar(200) comment '产品分类名称',
   parent_category_name varchar(200) comment '父分类名称',
   primary key (id)
);

alter table sms_coupon_product_category_relation comment '优惠券和产品分类关系表';

/*==============================================================*/
/* Table: sms_coupon_product_relation                           */
/*==============================================================*/
create table sms_coupon_product_relation
(
   id                   bigint not null auto_increment,
   coupon_id            bigint,
   product_id           bigint,
   product_name         varchar(500) comment '商品名称',
   product_sn           varchar(200) comment '商品编码',
   primary key (id)
);

alter table sms_coupon_product_relation comment '优惠券和产品的关系表';

/*==============================================================*/
/* Table: sms_flash_promotion                                   */
/*==============================================================*/
create table sms_flash_promotion
(
   id                   bigint not null auto_increment,
   title                varchar(200),
   start_date           date comment '开始日期',
   end_date             date comment '结束日期',
   status               int(1) comment '上下线状态',
   create_time          datetime comment '秒杀时间段名称',
   primary key (id)
);

alter table sms_flash_promotion comment '限时购表';

/*==============================================================*/
/* Table: sms_flash_promotion_log                               */
/*==============================================================*/
create table sms_flash_promotion_log
(
   id                   int not null auto_increment,
   member_id            bigint,
   product_id           bigint,
   member_phone         varchar(64),
   product_name         varchar(100),
   subscribe_time       datetime comment '会员订阅时间',
   send_time            datetime,
   primary key (id)
);

alter table sms_flash_promotion_log comment '限时购通知记录';

/*==============================================================*/
/* Table: sms_flash_promotion_product_relation                  */
/*==============================================================*/
create table sms_flash_promotion_product_relation
(
   id                   bigint not null auto_increment comment '编号',
   flash_promotion_id   bigint,
   flash_promotion_session_id bigint comment '编号',
   product_id           bigint,
   flash_promotion_price decimal(10,2) comment '限时购价格',
   flash_promotion_count int comment '限时购数量',
   flash_promotion_limit int comment '每人限购数量',
   sort                 int comment '排序',
   primary key (id)
);

alter table sms_flash_promotion_product_relation comment '商品限时购与商品关系表';

/*==============================================================*/
/* Table: sms_flash_promotion_session                           */
/*==============================================================*/
create table sms_flash_promotion_session
(
   id                   bigint not null auto_increment comment '编号',
   name                 varchar(200) comment '场次名称',
   start_time           time comment '每日开始时间',
   end_time             time comment '每日结束时间',
   status               int(1) comment '启用状态：0->不启用；1->启用',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table sms_flash_promotion_session comment '限时购场次表';

/*==============================================================*/
/* Table: sms_home_advertise                                    */
/*==============================================================*/
create table sms_home_advertise
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   type                 int(1) comment '轮播位置：0->PC首页轮播；1->app首页轮播',
   pic                  varchar(500),
   start_time           datetime,
   end_time             datetime,
   status               int(1) comment '上下线状态：0->下线；1->上线',
   click_count          int comment '点击数',
   order_count          int comment '下单数',
   url                  varchar(500) comment '链接地址',
   note                 varchar(500) comment '备注',
   sort                 int default 0 comment '排序',
   primary key (id)
);

alter table sms_home_advertise comment '首页轮播广告表';

/*==============================================================*/
/* Table: sms_home_brand                                        */
/*==============================================================*/
create table sms_home_brand
(
   id                   bigint not null auto_increment,
   brand_id             bigint,
   brand_name           varchar(64),
   recommend_status     int(1),
   sort                 int,
   primary key (id)
);

alter table sms_home_brand comment '首页推荐品牌表';

/*==============================================================*/
/* Table: sms_home_new_product                                  */
/*==============================================================*/
create table sms_home_new_product
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   product_name         varchar(64),
   recommend_status     int(1),
   sort                 int(1),
   primary key (id)
);

alter table sms_home_new_product comment '新鲜好物表';

/*==============================================================*/
/* Table: sms_home_recommend_product                            */
/*==============================================================*/
create table sms_home_recommend_product
(
   id                   bigint not null auto_increment,
   product_id           bigint,
   product_name         varchar(64),
   recommend_status     int(1),
   sort                 int(1),
   primary key (id)
);

alter table sms_home_recommend_product comment '人气推荐商品表';

/*==============================================================*/
/* Table: sms_home_recommend_subject                            */
/*==============================================================*/
create table sms_home_recommend_subject
(
   id                   bigint not null auto_increment,
   subject_id           bigint,
   subject_name         varchar(64),
   recommend_status     int(1),
   sort                 int,
   primary key (id)
);

alter table sms_home_recommend_subject comment '首页推荐专题表';

/*==============================================================*/
/* Table: ums_admin                                             */
/*==============================================================*/
create table ums_admin
(
   id                   bigint not null auto_increment,
   username             varchar(64) comment '用户名',
   password             varchar(64) comment '密码',
   icon                 varchar(500) comment '头像',
   email                varchar(100) comment '邮箱',
   nick_name            varchar(200) comment '昵称',
   note                 varchar(500) comment '备注信息',
   create_time          datetime comment '创建时间',
   login_time           datetime comment '最后登录时间',
   status               int(1) default 1 comment '帐号启用状态：0->禁用；1->启用',
   primary key (id)
);

alter table ums_admin comment '后台用户表';

/*==============================================================*/
/* Table: ums_admin_login_log                                   */
/*==============================================================*/
create table ums_admin_login_log
(
   id                   bigint not null auto_increment,
   admin_id             bigint,
   create_time          datetime,
   ip                   varchar(64),
   address              varchar(100),
   user_agent           varchar(100) comment '浏览器登录类型',
   primary key (id)
);

alter table ums_admin_login_log comment '后台用户登录日志表';

/*==============================================================*/
/* Table: ums_admin_permission_relation                         */
/*==============================================================*/
create table ums_admin_permission_relation
(
   id                   bigint not null auto_increment,
   admin_id             bigint,
   permission_id        bigint,
   type                 int(1),
   primary key (id)
);

alter table ums_admin_permission_relation comment '后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

/*==============================================================*/
/* Table: ums_admin_role_relation                               */
/*==============================================================*/
create table ums_admin_role_relation
(
   id                   bigint not null auto_increment,
   admin_id             bigint,
   role_id              bigint,
   primary key (id)
);

alter table ums_admin_role_relation comment '后台用户和角色关系表';

/*==============================================================*/
/* Table: ums_growth_change_history                             */
/*==============================================================*/
create table ums_growth_change_history
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   create_time          datetime,
   change_type          int(1) comment '改变类型：0->增加；1->减少',
   change_count         int comment '积分改变数量',
   operate_man          varchar(100) comment '操作人员',
   operate_note         varchar(200) comment '操作备注',
   source_type          int(1) comment '积分来源：0->购物；1->管理员修改',
   primary key (id)
);

alter table ums_growth_change_history comment '成长值变化历史记录表';

/*==============================================================*/
/* Table: ums_integration_change_history                        */
/*==============================================================*/
create table ums_integration_change_history
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   create_time          datetime,
   change_type          int(1) comment '改变类型：0->增加；1->减少',
   change_count         int comment '积分改变数量',
   operate_man          varchar(100) comment '操作人员',
   operate_note         varchar(200) comment '操作备注',
   source_type          int(1) comment '积分来源：0->购物；1->管理员修改',
   primary key (id)
);

alter table ums_integration_change_history comment '积分变化历史记录表';

/*==============================================================*/
/* Table: ums_integration_consume_setting                       */
/*==============================================================*/
create table ums_integration_consume_setting
(
   id                   bigint not null auto_increment,
   deduction_per_amount int comment '每一元需要抵扣的积分数量',
   max_percent_per_order int comment '每笔订单最高抵用百分比',
   use_unit             int comment '每次使用积分最小单位100',
   coupon_status        int(1) comment '是否可以和优惠券同用；0->不可以；1->可以',
   primary key (id)
);

alter table ums_integration_consume_setting comment '积分消费设置';

/*==============================================================*/
/* Table: ums_member                                            */
/*==============================================================*/
create table ums_member
(
   id                   bigint not null auto_increment,
   member_level_id      bigint,
   username             varchar(64) comment '用户名',
   password             varchar(64) comment '密码',
   nickname             varchar(64) comment '昵称',
   phone                varchar(64) comment '手机号码',
   status               int(1) comment '帐号启用状态:0->禁用；1->启用',
   create_time          datetime comment '注册时间',
   icon                 varchar(500) comment '头像',
   gender               int(1) comment '性别：0->未知；1->男；2->女',
   birthday             date comment '生日',
   city                 varchar(64) comment '所做城市',
   job                  varchar(100) comment '职业',
   personalized_signature varchar(200) comment '个性签名',
   source_type          int(1) comment '用户来源',
   integration          int comment '积分',
   growth               int comment '成长值',
   luckey_count         int comment '剩余抽奖次数',
   history_integration  int comment '历史积分数量',
   primary key (id)
);

alter table ums_member comment '会员表';

/*==============================================================*/
/* Table: ums_member_level                                      */
/*==============================================================*/
create table ums_member_level
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   growth_point         int,
   default_status       int(1) comment '是否为默认等级：0->不是；1->是',
   free_freight_point   decimal(10,2) comment '免运费标准',
   comment_growth_point int comment '每次评价获取的成长值',
   priviledge_free_freight int(1) comment '是否有免邮特权',
   priviledge_sign_in   int(1) comment '是否有签到特权',
   priviledge_comment   int(1) comment '是否有评论获奖励特权',
   priviledge_promotion int(1) comment '是否有专享活动特权',
   priviledge_member_price int(1) comment '是否有会员价格特权',
   priviledge_birthday  int(1) comment '是否有生日特权',
   note                 varchar(200),
   primary key (id)
);

alter table ums_member_level comment '会员等级表';

/*==============================================================*/
/* Table: ums_member_login_log                                  */
/*==============================================================*/
create table ums_member_login_log
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   create_time          datetime,
   ip                   varchar(64),
   city                 varchar(64),
   login_type           int(1) comment '登录类型：0->PC；1->android;2->ios;3->小程序',
   province             varchar(64),
   primary key (id)
);

alter table ums_member_login_log comment '会员登录记录';

/*==============================================================*/
/* Table: ums_member_member_tag_relation                        */
/*==============================================================*/
create table ums_member_member_tag_relation
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   tag_id               bigint,
   primary key (id)
);

alter table ums_member_member_tag_relation comment '用户和标签关系表';

/*==============================================================*/
/* Table: ums_member_product_category_relation                  */
/*==============================================================*/
create table ums_member_product_category_relation
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   product_category_id  bigint,
   primary key (id)
);

alter table ums_member_product_category_relation comment '会员与产品分类关系表（用户喜欢的分类）';

/*==============================================================*/
/* Table: ums_member_receive_address                            */
/*==============================================================*/
create table ums_member_receive_address
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   name                 varchar(100) comment '收货人名称',
   phone_number         varchar(64),
   default_status       int(1) comment '是否为默认',
   post_code            varchar(100) comment '邮政编码',
   province             varchar(100) comment '省份/直辖市',
   city                 varchar(100) comment '城市',
   region               varchar(100) comment '区',
   detail_address       varchar(128) comment '详细地址(街道)',
   primary key (id)
);

alter table ums_member_receive_address comment '会员收货地址表';

/*==============================================================*/
/* Table: ums_member_rule_setting                               */
/*==============================================================*/
create table ums_member_rule_setting
(
   id                   bigint not null auto_increment,
   continue_sign_day    int comment '连续签到天数',
   continue_sign_point  int comment '连续签到赠送数量',
   consume_per_point    decimal(10,2) comment '每消费多少元获取1个点',
   low_order_amount     decimal(10,2) comment '最低获取点数的订单金额',
   max_point_per_order  int comment '每笔订单最高获取点数',
   type                 int(1) comment '类型：0->积分规则；1->成长值规则',
   primary key (id)
);

alter table ums_member_rule_setting comment '会员积分成长规则表';

/*==============================================================*/
/* Table: ums_member_statistics_info                            */
/*==============================================================*/
create table ums_member_statistics_info
(
   id                   bigint not null auto_increment,
   member_id            bigint,
   consume_amount       decimal(10,2) comment '累计消费金额',
   order_count          int comment '订单数量',
   coupon_count         int comment '优惠券数量',
   comment_count        int comment '评价数',
   return_order_count   int comment '退货数量',
   login_count          int comment '登录次数',
   attend_count         int comment '关注数量',
   fans_count           int comment '粉丝数量',
   collect_product_count int,
   collect_subject_count int,
   collect_topic_count  int,
   collect_comment_count int,
   invite_friend_count  int,
   recent_order_time    datetime comment '最后一次下订单时间',
   primary key (id)
);

alter table ums_member_statistics_info comment '会员统计信息';

/*==============================================================*/
/* Table: ums_member_tag                                        */
/*==============================================================*/
create table ums_member_tag
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   finish_order_count   int comment '自动打标签完成订单数量',
   finish_order_amount  decimal(10,2) comment '自动打标签完成订单金额',
   primary key (id)
);

alter table ums_member_tag comment '用户标签表';

/*==============================================================*/
/* Table: ums_member_task                                       */
/*==============================================================*/
create table ums_member_task
(
   id                   bigint not null auto_increment,
   name                 varchar(100),
   growth               int comment '赠送成长值',
   intergration         int comment '赠送积分',
   type                 int(1) comment '任务类型：0->新手任务；1->日常任务',
   primary key (id)
);

alter table ums_member_task comment '会员任务表';

/*==============================================================*/
/* Table: ums_menu                                              */
/*==============================================================*/
create table ums_menu
(
   id                   bigint not null auto_increment,
   parent_id            bigint comment '父级ID',
   create_time          datetime comment '创建时间',
   title                varchar(100) comment '菜单名称',
   level                int(4) comment '菜单级数',
   sort                 int(4) comment '菜单排序',
   name                 varchar(100) comment '前端名称',
   icon                 varchar(200) comment '前端图标',
   hidden               int(1) comment '前端隐藏',
   primary key (id)
);

alter table ums_menu comment '后台菜单表';

/*==============================================================*/
/* Table: ums_permission                                        */
/*==============================================================*/
create table ums_permission
(
   id                   bigint not null auto_increment,
   pid                  bigint comment '父级权限id',
   name                 varchar(100) comment '名称',
   value                varchar(200) comment '权限值',
   icon                 varchar(500) comment '图标',
   type                 int(1) comment '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
   uri                  varchar(200) comment '前端资源路径',
   status               int(1) comment '启用状态；0->禁用；1->启用',
   create_time          datetime comment '创建时间',
   sort                 int comment '排序',
   primary key (id)
);

alter table ums_permission comment '后台用户权限表';

/*==============================================================*/
/* Table: ums_resource                                          */
/*==============================================================*/
create table ums_resource
(
   id                   bigint not null auto_increment,
   category_id          bigint comment '资源分类ID',
   create_time          datetime comment '创建时间',
   name                 varchar(200) comment '资源名称',
   url                  varchar(200) comment '资源URL',
   description          varchar(500) comment '描述',
   primary key (id)
);

alter table ums_resource comment '后台资源表';

/*==============================================================*/
/* Table: ums_resource_category                                 */
/*==============================================================*/
create table ums_resource_category
(
   id                   bigint not null auto_increment,
   create_time          datetime comment '创建时间',
   name                 varchar(200) comment '分类名称',
   sort                 int(4) comment '排序',
   primary key (id)
);

alter table ums_resource_category comment '资源分类表';

/*==============================================================*/
/* Table: ums_role                                              */
/*==============================================================*/
create table ums_role
(
   id                   bigint not null auto_increment,
   name                 varchar(100) comment '名称',
   description          varchar(500) comment '描述',
   admin_count          int comment '后台用户数量',
   create_time          datetime comment '创建时间',
   status               int(1) default 1 comment '启用状态：0->禁用；1->启用',
   sort                 int default 0,
   primary key (id)
);

alter table ums_role comment '后台用户角色表';

/*==============================================================*/
/* Table: ums_role_menu_relation                                */
/*==============================================================*/
create table ums_role_menu_relation
(
   id                   bigint not null auto_increment,
   role_id              bigint comment '角色ID',
   menu_id              bigint comment '菜单ID',
   primary key (id)
);

alter table ums_role_menu_relation comment '后台角色菜单关系表';

/*==============================================================*/
/* Table: ums_role_permission_relation                          */
/*==============================================================*/
create table ums_role_permission_relation
(
   id                   bigint not null auto_increment,
   role_id              bigint,
   permission_id        bigint,
   primary key (id)
);

alter table ums_role_permission_relation comment '后台用户角色和权限关系表';

/*==============================================================*/
/* Table: ums_role_resource_relation                            */
/*==============================================================*/
create table ums_role_resource_relation
(
   id                   bigint not null auto_increment,
   role_id              bigint comment '角色ID',
   resource_id          bigint comment '资源ID',
   primary key (id)
);

alter table ums_role_resource_relation comment '后台角色资源关系表';

alter table cms_help add constraint FK_Reference_32 foreign key (category_id)
      references cms_help_category (id) on delete restrict on update restrict;

alter table cms_prefrence_area_product_relation add constraint FK_Reference_18 foreign key (prefrence_area_id)
      references cms_prefrence_area (id) on delete restrict on update restrict;

alter table cms_prefrence_area_product_relation add constraint FK_Reference_19 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table cms_subject add constraint FK_Reference_28 foreign key (category_id)
      references cms_subject_category (id) on delete restrict on update restrict;

alter table cms_subject_comment add constraint FK_Reference_29 foreign key (subject_id)
      references cms_subject (id) on delete restrict on update restrict;

alter table cms_subject_product_relation add constraint FK_Reference_26 foreign key (subject_id)
      references cms_subject (id) on delete restrict on update restrict;

alter table cms_subject_product_relation add constraint FK_Reference_27 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table cms_topic add constraint FK_Reference_31 foreign key (category_id)
      references cms_topic_category (id) on delete restrict on update restrict;

alter table cms_topic_comment add constraint FK_Reference_30 foreign key (topic_id)
      references cms_topic (id) on delete restrict on update restrict;

alter table oms_cart_item add constraint FK_Reference_65 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table oms_cart_item add constraint FK_Reference_66 foreign key (product_sku_id)
      references pms_sku_stock (id) on delete restrict on update restrict;

alter table oms_cart_item add constraint FK_Reference_67 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table oms_order add constraint FK_Reference_57 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table oms_order add constraint FK_Reference_61 foreign key (coupon_id)
      references sms_coupon (id) on delete restrict on update restrict;

alter table oms_order_item add constraint FK_Reference_58 foreign key (order_id)
      references oms_order (id) on delete restrict on update restrict;

alter table oms_order_item add constraint FK_Reference_59 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table oms_order_operate_history add constraint FK_Reference_62 foreign key (order_id)
      references oms_order (id) on delete restrict on update restrict;

alter table oms_order_return_apply add constraint FK_Reference_63 foreign key (order_id)
      references oms_order (id) on delete restrict on update restrict;

alter table oms_order_return_apply add constraint FK_Reference_64 foreign key (company_address_id)
      references oms_company_address (id) on delete restrict on update restrict;

alter table oms_order_return_apply add constraint FK_Reference_75 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_album_pic add constraint FK_Reference_25 foreign key (album_id)
      references pms_album (id) on delete restrict on update restrict;

alter table pms_comment add constraint FK_Reference_23 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_comment_replay add constraint FK_Reference_24 foreign key (comment_id)
      references pms_comment (id) on delete restrict on update restrict;

alter table pms_member_price add constraint FK_Reference_60 foreign key (member_level_id)
      references ums_member_level (id) on delete restrict on update restrict;

alter table pms_member_price add constraint FK_Reference_9 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_product add constraint FK_Reference_1 foreign key (brand_id)
      references pms_brand (id) on delete restrict on update restrict;

alter table pms_product add constraint FK_Reference_13 foreign key (product_attribute_category_id)
      references pms_product_attribute_category (id) on delete restrict on update restrict;

alter table pms_product add constraint FK_Reference_5 foreign key (product_category_id)
      references pms_product_category (id) on delete restrict on update restrict;

alter table pms_product add constraint FK_Reference_6 foreign key (feight_template_id)
      references pms_feight_template (id) on delete restrict on update restrict;

alter table pms_product_attribute add constraint FK_Reference_12 foreign key (product_attribute_category_id)
      references pms_product_attribute_category (id) on delete restrict on update restrict;

alter table pms_product_attribute_value add constraint FK_Reference_14 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_product_attribute_value add constraint FK_Reference_15 foreign key (product_attribute_id)
      references pms_product_attribute (id) on delete restrict on update restrict;

alter table pms_product_category add constraint FK_Reference_20 foreign key (parent_id)
      references pms_product_category (id) on delete restrict on update restrict;

alter table pms_product_category_attribute_relation add constraint FK_Reference_21 foreign key (product_category_id)
      references pms_product_category (id) on delete restrict on update restrict;

alter table pms_product_category_attribute_relation add constraint FK_Reference_22 foreign key (product_attribute_id)
      references pms_product_attribute (id) on delete restrict on update restrict;

alter table pms_product_full_reduction add constraint FK_Reference_11 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_product_ladder add constraint FK_Reference_10 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_product_operate_log add constraint FK_Reference_4 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_product_vertify_record add constraint FK_Reference_3 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table pms_sku_stock add constraint FK_Reference_2 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table sms_coupon_history add constraint FK_Reference_37 foreign key (coupon_id)
      references sms_coupon (id) on delete restrict on update restrict;

alter table sms_coupon_history add constraint FK_Reference_38 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table sms_coupon_history add constraint FK_Reference_76 foreign key (order_id)
      references oms_order (id) on delete restrict on update restrict;

alter table sms_coupon_product_category_relation add constraint FK_Reference_35 foreign key (coupon_id)
      references sms_coupon (id) on delete restrict on update restrict;

alter table sms_coupon_product_category_relation add constraint FK_Reference_36 foreign key (product_category_id)
      references pms_product_category (id) on delete restrict on update restrict;

alter table sms_coupon_product_relation add constraint FK_Reference_33 foreign key (coupon_id)
      references sms_coupon (id) on delete restrict on update restrict;

alter table sms_coupon_product_relation add constraint FK_Reference_34 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table sms_flash_promotion_log add constraint FK_Reference_44 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table sms_flash_promotion_log add constraint FK_Reference_45 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table sms_flash_promotion_product_relation add constraint FK_Reference_77 foreign key (flash_promotion_id)
      references sms_flash_promotion (id) on delete restrict on update restrict;

alter table sms_flash_promotion_product_relation add constraint FK_Reference_78 foreign key (flash_promotion_session_id)
      references sms_flash_promotion_session (id) on delete restrict on update restrict;

alter table sms_flash_promotion_product_relation add constraint FK_Reference_79 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table sms_home_brand add constraint FK_Reference_39 foreign key (brand_id)
      references pms_brand (id) on delete restrict on update restrict;

alter table sms_home_new_product add constraint FK_Reference_40 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table sms_home_recommend_product add constraint FK_Reference_41 foreign key (product_id)
      references pms_product (id) on delete restrict on update restrict;

alter table sms_home_recommend_subject add constraint FK_Reference_42 foreign key (subject_id)
      references cms_subject (id) on delete restrict on update restrict;

alter table ums_admin_login_log add constraint FK_Reference_46 foreign key (admin_id)
      references ums_admin (id) on delete restrict on update restrict;

alter table ums_admin_permission_relation add constraint FK_Reference_73 foreign key (admin_id)
      references ums_admin (id) on delete restrict on update restrict;

alter table ums_admin_permission_relation add constraint FK_Reference_74 foreign key (permission_id)
      references ums_permission (id) on delete restrict on update restrict;

alter table ums_admin_role_relation add constraint FK_Reference_69 foreign key (admin_id)
      references ums_admin (id) on delete restrict on update restrict;

alter table ums_admin_role_relation add constraint FK_Reference_70 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_growth_change_history add constraint FK_Reference_56 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_integration_change_history add constraint FK_Reference_55 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_member add constraint FK_Reference_47 foreign key (member_level_id)
      references ums_member_level (id) on delete restrict on update restrict;

alter table ums_member_login_log add constraint FK_Reference_52 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_member_member_tag_relation add constraint FK_Reference_53 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_member_member_tag_relation add constraint FK_Reference_54 foreign key (tag_id)
      references ums_member_tag (id) on delete restrict on update restrict;

alter table ums_member_product_category_relation add constraint FK_Reference_48 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_member_product_category_relation add constraint FK_Reference_49 foreign key (product_category_id)
      references pms_product_category (id) on delete restrict on update restrict;

alter table ums_member_receive_address add constraint FK_Reference_51 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_member_statistics_info add constraint FK_Reference_50 foreign key (member_id)
      references ums_member (id) on delete restrict on update restrict;

alter table ums_menu add constraint FK_Reference_80 foreign key (parent_id)
      references ums_menu (id) on delete restrict on update restrict;

alter table ums_permission add constraint FK_Reference_68 foreign key (pid)
      references ums_permission (id) on delete restrict on update restrict;

alter table ums_resource add constraint FK_Reference_85 foreign key (category_id)
      references ums_resource_category (id) on delete restrict on update restrict;

alter table ums_role_menu_relation add constraint FK_Reference_81 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_menu_relation add constraint FK_Reference_82 foreign key (menu_id)
      references ums_menu (id) on delete restrict on update restrict;

alter table ums_role_permission_relation add constraint FK_Reference_71 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_permission_relation add constraint FK_Reference_72 foreign key (permission_id)
      references ums_permission (id) on delete restrict on update restrict;

alter table ums_role_resource_relation add constraint FK_Reference_83 foreign key (role_id)
      references ums_role (id) on delete restrict on update restrict;

alter table ums_role_resource_relation add constraint FK_Reference_84 foreign key (resource_id)
      references ums_resource (id) on delete restrict on update restrict;

