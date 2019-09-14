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
  nickname  varchar(32)                         comment '昵称',
  primary key (id)
) engine=InnoDB default charset=utf8;

insert into user
(username, password, user_sex, nickname)
values
('user01','password01','MAN','昵称01'),
('user02','password02','MAN','昵称02'),
('user03','password03','MAN','昵称03'),
('user04','password04','MAN','昵称04'),
('user05','password05','MAN','昵称05');