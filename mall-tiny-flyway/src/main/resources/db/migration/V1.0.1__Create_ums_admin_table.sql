CREATE TABLE `ums_admin`
(
  `id`          bigint(20) NOT NULL AUTO_INCREMENT,
  `username`    varchar(64)  DEFAULT NULL,
  `password`    varchar(64)  DEFAULT NULL,
  `icon`        varchar(500) DEFAULT NULL COMMENT '头像',
  `email`       varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name`   varchar(200) DEFAULT NULL COMMENT '昵称',
  `note`        varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
  `login_time`  datetime     DEFAULT NULL COMMENT '最后登录时间',
  `status`      int(1)       DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8 COMMENT ='后台用户表';