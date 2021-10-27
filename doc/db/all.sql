drop table if exists `chapter`;
create table `chapter` (
  `id` char(8) not null comment 'ID',
  `course_id` char(8) comment '课程ID',
  `name` varchar(50) comment '名称',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='大章';

insert into `chapter` (id, course_id, name) values ('000001', '000000', 'test001');
insert into `chapter` (id, course_id, name) values ('000002', '000000', 'test002');
insert into `chapter` (id, course_id, name) values ('000003', '000000', 'test003');
insert into `chapter` (id, course_id, name) values ('000004', '000000', 'test004');
insert into `chapter` (id, course_id, name) values ('000005', '000000', 'test005');
insert into `chapter` (id, course_id, name) values ('000006', '000000', 'test006');
insert into `chapter` (id, course_id, name) values ('000007', '000000', 'test007');
insert into `chapter` (id, course_id, name) values ('000008', '000000', 'test008');
insert into `chapter` (id, course_id, name) values ('000009', '000000', 'test009');
insert into `chapter` (id, course_id, name) values ('000010', '000000', 'test010');
insert into `chapter` (id, course_id, name) values ('000011', '000000', 'test011');
insert into `chapter` (id, course_id, name) values ('000012', '000000', 'test012');
insert into `chapter` (id, course_id, name) values ('000013', '000000', 'test013');
insert into `chapter` (id, course_id, name) values ('000014', '000000', 'test014');
insert into `chapter` (id, course_id, name) values ('000015', '000000', 'test015');
insert into `chapter` (id, course_id, name) values ('000016', '000000', 'test016');
insert into `chapter` (id, course_id, name) values ('000017', '000000', 'test017');
insert into `chapter` (id, course_id, name) values ('000018', '000000', 'test018');
insert into `chapter` (id, course_id, name) values ('000019', '000000', 'test019');




---------------------- 测试

drop table if exists `test`;
create table `test`(
    `id` char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment="测试";

insert into `test` (`id`, `name`) values(1, '测试');