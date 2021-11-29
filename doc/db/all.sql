
update course c set `time` = (select sum(`time`) from `section` where course_id = '000001')
where c.id = '000001';

------------------------- 计算视频时长sql --------------------------



drop table if exists course;
create table course (
  id char(8) not null default '' comment 'id',
  name varchar(50) not null comment '名称',
  summary varchar(2000) comment '概述',
  time int default 0 comment '时长|单位秒',
  price decimal(8,2) default 0.00 comment '价格（元）',
  image varchar(100) comment '封面',
  level char(1) comment '级别|枚举[CourseLevelEnum]：ONE("1", "初级"),TWO("2", "中级"),THREE("3", "高级")',
  charge char(1) comment '收费|枚举[CourseChargeEnum]：CHARGE("C", "收费"),FREE("F", "免费")',
  status char(1) comment '状态|枚举[CourseStatusEnum]：PUBLISH("P", "发布"),DRAFT("D", "草稿")',
  enroll integer default 0 comment '报名数',
  sort int comment '顺序',
  created_at datetime(3) comment '创建时间',
  updated_at datetime(3) comment '修改时间',
  primary key (id)
) engine=innodb default charset=utf8mb4 comment='课程';

INSERT INTO course (id, name, summary, time, price, image, level, charge, status, enroll, sort, created_at, updated_at)
VALUES ('00000001', '测试课程01', '这是一门测试课程', 7200, 19.9, '', 0, 'C', 'D', 100, 0, now(), now());


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

----------------------- Section --------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `id` CHAR(8) NOT NULL DEFAULT '' COMMENT 'ID',
  `title` VARCHAR(50) NOT NULL COMMENT '标题',
  `course_id` CHAR(8) COMMENT '课程|course.id',
  `chapter_id` CHAR(8) COMMENT '大章|chapter.id',
  `video` VARCHAR(200) COMMENT '视频',
  `time` INT COMMENT '时长|单位秒',
  `charge` CHAR(1) COMMENT '收费|C 收费；F 免费',
  `sort` INT COMMENT '顺序',
  `created_at` DATETIME(3) COMMENT '创建时间',
  `updated_at` DATETIME(3) COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小节';

INSERT INTO `section` (id, title, course_id, chapter_id, video, time, charge, sort, created_at, updated_at)
VALUES ('00000001', '测试小节01', '00000001', '00000000', '', 500, 'F', 1, now(), now());



---------------------- 测试

drop table if exists `test`;
create table `test`(
    `id` char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment="测试";

insert into `test` (`id`, `name`) values(1, '测试');