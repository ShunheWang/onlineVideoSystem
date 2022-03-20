-- category
drop table if exists `category`;
create table `category` (
	`id` char(8) not null default '' comment 'id',
    `parent` char(8) not null default '' comment 'parent-id',
    `name` varchar(50) not null comment 'name',
    `sort` int comment 'sort',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='分类';

insert into `category` (id, parent, name, sort) values('00000100', '00000000', '前端技术', 100);
insert into `category` (id, parent, name, sort) values('00000101', '00000100', 'html/css', 101);
insert into `category` (id, parent, name, sort) values('00000102', '00000100', 'JavaScript', 102);
insert into `category` (id, parent, name, sort) values('00000103', '00000100', 'vue.js', 103);
insert into `category` (id, parent, name, sort) values('00000104', '00000100', 'react.js', 104);
insert into `category` (id, parent, name, sort) values('00000105', '00000100', 'angular', 105);
insert into `category` (id, parent, name, sort) values('00000106', '00000100', 'NodeJs', 106);
insert into `category` (id, parent, name, sort) values('00000107', '00000100', 'JQuery', 107);
insert into `category` (id, parent, name, sort) values('00000108', '00000100', '小程序', 108);

insert into `category` (id, parent, name, sort) values('00000200', '00000000', '后端技术', 200);
insert into `category` (id, parent, name, sort) values('00000201', '00000200', 'JAVA', 201);
insert into `category` (id, parent, name, sort) values('00000202', '00000200', 'SpringBoot', 202);
insert into `category` (id, parent, name, sort) values('00000203', '00000200', 'SpringCloud', 203);
insert into `category` (id, parent, name, sort) values('00000204', '00000200', 'ssm', 204);
insert into `category` (id, parent, name, sort) values('00000205', '00000200', 'Python', 205);
insert into `category` (id, parent, name, sort) values('00000206', '00000200', '爬虫', 206);

insert into `category` (id, parent, name, sort) values('00000300', '00000000', '移动开发', 300);
insert into `category` (id, parent, name, sort) values('00000301', '00000300', 'Andriod', 301);
insert into `category` (id, parent, name, sort) values('00000302', '00000300', 'iOS', 302);
insert into `category` (id, parent, name, sort) values('00000303', '00000300', 'React native', 303);
insert into `category` (id, parent, name, sort) values('00000304', '00000300', 'WEEX', 304);

insert into `category` (id, parent, name, sort) values('00000400', '00000000', '计算机基础', 400);
insert into `category` (id, parent, name, sort) values('00000401', '00000400', '计算机网络', 401);
insert into `category` (id, parent, name, sort) values('00000402', '00000400', '算法与数据结构', 402);
insert into `category` (id, parent, name, sort) values('00000403', '00000400', '数学', 403);
insert into `category` (id, parent, name, sort) values('00000404', '00000400', 'Mysql', 404);
insert into `category` (id, parent, name, sort) values('00000405', '00000400', 'Redis', 405);
insert into `category` (id, parent, name, sort) values('00000406', '00000400', 'MongoDB', 406);
insert into `category` (id, parent, name, sort) values('00000407', '00000400', 'Oracle', 407);
insert into `category` (id, parent, name, sort) values('00000408', '00000400', 'SQL Server', 408);
insert into `category` (id, parent, name, sort) values('00000409', '00000400', 'NoSql', 409);

insert into `category` (id, parent, name, sort) values('00000500', '00000000', '前沿技术', 500);
insert into `category` (id, parent, name, sort) values('00000501', '00000500', '微服务', 501);
insert into `category` (id, parent, name, sort) values('00000502', '00000500', '区块链', 502);
insert into `category` (id, parent, name, sort) values('00000503', '00000500', '以太坊', 503);
insert into `category` (id, parent, name, sort) values('00000504', '00000500', '机器学习', 504);
insert into `category` (id, parent, name, sort) values('00000505', '00000500', '深度学习', 505);
insert into `category` (id, parent, name, sort) values('00000506', '00000500', '计算机视觉', 506);
insert into `category` (id, parent, name, sort) values('00000507', '00000500', '自然语言处理', 507);
insert into `category` (id, parent, name, sort) values('00000508', '00000500', '数据分析&挖掘', 508);
insert into `category` (id, parent, name, sort) values('00000509', '00000500', '大数据', 509);
insert into `category` (id, parent, name, sort) values('00000510', '00000500', 'Hadoop', 510);
insert into `category` (id, parent, name, sort) values('00000511', '00000500', 'Spark', 511);
insert into `category` (id, parent, name, sort) values('00000512', '00000500', 'Hbase', 512);
insert into `category` (id, parent, name, sort) values('00000513', '00000500', 'Flink', 513);
insert into `category` (id, parent, name, sort) values('00000514', '00000500', 'Storm', 514);
insert into `category` (id, parent, name, sort) values('00000515', '00000500', '云计算', 515);
insert into `category` (id, parent, name, sort) values('00000516', '00000500', 'AWS', 516);
insert into `category` (id, parent, name, sort) values('00000517', '00000500', 'Docker', 517);
insert into `category` (id, parent, name, sort) values('00000518', '00000500', 'Kubernetes', 518);

insert into `category` (id, parent, name, sort) values('00000600', '00000000', '测试运维', 600);
insert into `category` (id, parent, name, sort) values('00000601', '00000600', '运维', 601);
insert into `category` (id, parent, name, sort) values('00000602', '00000600', '自动化运维', 602);
insert into `category` (id, parent, name, sort) values('00000603', '00000600', '运维工具', 603);
insert into `category` (id, parent, name, sort) values('00000604', '00000600', '中间件', 604);
insert into `category` (id, parent, name, sort) values('00000605', '00000600', 'Linux', 605);
insert into `category` (id, parent, name, sort) values('00000606', '00000600', '测试', 606);
insert into `category` (id, parent, name, sort) values('00000607', '00000600', '功能测试', 607);
insert into `category` (id, parent, name, sort) values('00000608', '00000600', '性能测试', 608);
insert into `category` (id, parent, name, sort) values('00000609', '00000600', '自动化测试', 609);
insert into `category` (id, parent, name, sort) values('00000610', '00000600', '接口测试', 610);
insert into `category` (id, parent, name, sort) values('00000611', '00000600', '安全测试', 611);

--- 计算视频时长sql
update course c set `time` = (select sum(`time`) from `section` where course_id = '000001')
where c.id = '000001';

--- course table

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

---------------------- 课程分类
drop table if exists `course_category`;
create table `course_category` (
 `id` char(8) not null default '' comment 'id',
 `course_id` char(8) comment '课程|course.id',
 `category_id` char(8) comment '分类|category.id',
 primary key(`id`)
) engine=innodb default charset=utf8mb4 comment='课程分类';

---------------------- 课程内容
drop table if exists `course_content`;
create table `course_content` (
 `id` char(8) not null default '' comment '课程id',
 `content` mediumtext not null comment '课程内容',
 primary key(`id`)
) engine=innodb default charset=utf8mb4 comment='课程内容';

---------------------- 讲师
drop table if exists `teacher`;
create table `teacher` (
 `id` char(8) not null default '' comment 'id',
 `name` varchar(50) not null comment '名称',
 `nickname` varchar(50) comment '昵称',
 `image` varchar(100) comment '头像',
 `position` varchar(50) comment '职位',
 `motto` varchar(50) comment '座右铭',
 `intro` varchar(500) comment '简介',
 primary key(`id`)
) engine=innodb default charset=utf8mb4 comment='讲师';

alter table `course` add column (`teacher_id` char(8) comment '讲师|teacher.id');

---------------------- 测试

drop table if exists `test`;
create table `test`(
    `id` char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment="测试";

insert into `test` (`id`, `name`) values(1, '测试');