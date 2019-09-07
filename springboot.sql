show databases;
drop database springboot;
create database springboot;
use springboot;

drop table if exists user;
create table if not exists user (
  id         int(11)     not null auto_increment comment '主键id',
  username   varchar(32) not null                comment '用户名',
  password   varchar(32) not null                comment '密码',
  user_sex   varchar(32)                         comment '性别',
  nick_name  varchar(32)                         comment '昵称',
  primary key (id)
) engine=InnoDB default charset=utf8;