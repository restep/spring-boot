show databases;
drop database springboot;
create database springboot;
use springboot;

DROP TABLE IF EXISTS user;
CREATE TABLE if not exists user (
  id         bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键id',
  username   varchar(32) not null                COMMENT '用户名',
  password   varchar(32) not NULL                COMMENT '密码',
  user_sex   varchar(32)                         comment '性别',
  nick_name  varchar(32)                         comment '昵称',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;