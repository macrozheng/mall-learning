CREATE TABLE `magic_api_file`
(
  `id`           bigint(255) NOT NULL AUTO_INCREMENT,
  `file_path`    varchar(255) DEFAULT NULL,
  `file_content` text,
  PRIMARY KEY (`id`)
)