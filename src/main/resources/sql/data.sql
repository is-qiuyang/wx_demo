
DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` bigint(4) NOT NULL AUTO_INCREMENT,
  `title` varchar(124) DEFAULT NULL COMMENT '资讯标题',
  `text` varchar(2024) DEFAULT NULL COMMENT '资讯内容',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`id`,`title`,`text`,`update_time`) values (1,'教育部提醒高校不要简化封闭式管理','几天前，教育部新型冠状病毒肺炎领导小组办公室发出提醒函，改进学校管理方式。要求各地尽快调查高校管理情况和措施，鼓励高校广泛听取和合理采纳学生和教职工对校门管理的意见和建议。','2021-04-28'),(2,'全国人大常委会举办宪法历史文献资料展览','人民网北京12月4日电 （梁秋坪）为弘扬宪法精神，讲好宪法故事，在第七个“国家宪法日”到来之际，由全国人大常委会举办的宪法历史文献资料展览在京开幕。全国人大常委会副秘书长信春鹰、宪法和法律委员会主任委员李飞、法工委主任沈春耀等出席活动。此外，教育部政策法规司巡视员王家勤带领部分第五届全国学生“学宪法讲宪法”活动总决赛师生代表参加了开幕式。\r\n\r\n参加开幕式的领导充分肯定了举办宪法历史文献资料展览的重要意义，一致认为借助立法机关档案资料的优势，系统整理展示新中国宪法制定和修改的进程，是把弘扬宪法精神、坚定宪法自信、讲好宪法故事落实落细的具体举措。未来，仍要持续增强宪法意识，树立宪法权威，展现人大机关干部时不我待、奋发有为的精神风貌，为推进法治中国建设贡献力量。\r\n\r\n据了解，此次展览展期为12月4日至11日，整个展览分为五个板块。第一个板块集中展示习近平法治思想和关于依宪治国、依宪执政的重要论述。第二、第三个板块呈现历次宪法制定、修改的文本，以及立宪修宪过程中的会议资料、手稿手迹、草案修改花脸稿等。第四个板块主要展出1982年宪法修改委员会关于群众来信的意见简报、基层人民群众的来信手稿、多种少数民族文字印制的宪法文本等。第五个板块则展示了法国、德国、西班牙、委内瑞拉等20多个国家的宪法文本，记录着全国人大与世界各国议会交往中的宪法交流。\r\n\r\n','2021-05-01'),(3,'第一届全国技能大赛在广州举行 选手平均年龄21.8岁','人民网广州12月11日电 （孟植良）12月10日，第一届全国技能大赛在广州举行。大赛以“新时代、新技能、新梦想”为主题，是新中国成立以来，首次举办的赛事规格最高、竞赛项目最多、参赛规模最大、技能水平最高的综合性国家职业技能大赛。','2021-04-30'),(4,'吉林公布“熟蛋孵小鸡”调查结果','记者30日从吉林省新闻出版局获悉，根据进驻《写真地理》的工作组初步调查，《写真地理》杂志作为宣传地理、旅游方面知识的期刊，刊期为周刊，未经新闻出版行政管理部门审批，超业务范围发表学术论文。\r\n\r\n　　吉林省新闻出版局在调查中还发现，2019年12月，《写真地理》杂志擅自与北京创想辉煌文化传媒有限公司签订合作经营协议，违规转让出版权并存在收费行为。 同时，《写真地理》杂志没有严格落实“三审三校”制度，未按要求对出版内容进行严格审核。\r\n\r\n　　上述行为违反出版管理相关条例法规，吉林省新闻出版局对《写真地理》杂志作出停刊整顿、主要负责人责令辞职的处理。目前深入调查正在进行，将根据调查情况依法依规依纪进行后续处理。（记者姚湜）','2021-05-01');

/*Table structure for table `leaderboard` */

DROP TABLE IF EXISTS `leaderboard`;

CREATE TABLE `leaderboard` (
  `leaderboard_title` varchar(128) DEFAULT NULL COMMENT '榜单名',
  `bod_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '榜单id',
  PRIMARY KEY (`bod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `leaderboard` */

insert  into `leaderboard`(`leaderboard_title`,`bod_id`) values ('中国高校毕业生薪酬指数排名1',1),('2020年中国大学排行榜',2);

/*Table structure for table `leaderboard_value` */

DROP TABLE IF EXISTS `leaderboard_value`;

CREATE TABLE `leaderboard_value` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `value` varchar(256) DEFAULT NULL,
  `rank` int(4) DEFAULT NULL,
  `bod_id` int(8) DEFAULT NULL COMMENT '榜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `leaderboard_value` */

insert  into `leaderboard_value`(`id`,`value`,`rank`,`bod_id`) values (1,'计算机类',1,1),(2,'电子信息类',2,1),(3,'自动化类',3,1),(4,'北京大学',1,2),(5,'清华大学',2,2),(6,'复旦大学',3,2),(7,'浙江大学',4,2);

/*Table structure for table `major` */

DROP TABLE IF EXISTS `major`;

CREATE TABLE `major` (
  `school_major_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `school_major_name` varchar(256) DEFAULT NULL COMMENT '专业名',
  `school_id` varchar(8) DEFAULT NULL COMMENT '学校id',
  `major_description` varchar(1204) DEFAULT NULL COMMENT '专业简介',
  PRIMARY KEY (`school_major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `major` */

insert  into `major`(`school_major_id`,`school_major_name`,`school_id`,`major_description`) values (1,'信息与计算科学','1','数学与计算机'),(2,'数应','1,2','师范'),(3,'网络','1,2','不是连网线的');

/*Table structure for table `school_like` */

DROP TABLE IF EXISTS `school_like`;

CREATE TABLE `school_like` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `skey` varchar(256) DEFAULT NULL COMMENT '用户身份标志',
  `school_id` int(24) DEFAULT NULL COMMENT '学校id',
  `collectFalg` tinyint(1) DEFAULT NULL COMMENT '收藏状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `school_like` */

insert  into `school_like`(`id`,`skey`,`school_id`,`collectFalg`) values (3,'abc',1,1),(4,'b564d149-d61c-4087-8c51-4d9a0d805251',1,1),(5,'b564d149-d61c-4087-8c51-4d9a0d805251',2,1);

/*Table structure for table `school_massege` */

DROP TABLE IF EXISTS `school_massege`;

CREATE TABLE `school_massege` (
  `school_id` int(24) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(256) DEFAULT NULL COMMENT '学校名',
  `school_major_id` varchar(256) DEFAULT NULL COMMENT '学校拥有的专业id',
  `school_text` varchar(2048) DEFAULT NULL COMMENT '学校简介',
  `school_score` int(24) DEFAULT NULL COMMENT '录取分数线',
  `build_time` int(24) DEFAULT NULL COMMENT '创办时间',
  `nature` varchar(24) DEFAULT NULL COMMENT '大学性质',
  `address` varchar(258) DEFAULT NULL COMMENT '学校地址',
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `school_massege` */

insert  into `school_massege`(`school_id`,`school_name`,`school_major_id`,`school_text`,`school_score`,`build_time`,`nature`,`address`) values (1,'陕西理工大学','1,2,3','学校坚持“立足陕西，服务基层”的办学定位，秉承“明德、砺志、博学、笃行”的校训，致力于培养“具有创新精神和实践能力的高级应用型人才”。现拥有机械设计制造及其自动化专业、物理学、材料成型及控制工程、计算机科学与技术4个国家一流专业建设点，经济学、汉语言文学、生物科学等14个省级一流本科专业建设点，2个国家级特色专业，1个国家级和6个省级专业综合改革试点建设项目，6个省级特色专业，3个省级名牌专业，8个省级实验教学示范中心，7个省级人才培养模式创新实验区，2个省级创新创业教育试点学院，10个省级教学团队，12名省级教学名师，1个国家级和4个省级大学生校外实践教育基地。建校以来，学校累计为国家培养了13万余名专业技术人才，其中绝大多数已经成为所在行业、部门或地区的业务骨干、学术带头人和优秀管理人才，受到社会各界的广泛好评。',460,1958,'公办大学','陕西汉中'),(2,'陕西大学','2,3','test',500,1966,'公办大学','陕西西安');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`) values (1,'反馈信息测试?'),(2,'小袁');

/*Table structure for table `wx_user` */

DROP TABLE IF EXISTS `wx_user`;

CREATE TABLE `wx_user` (
  `open_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'open_id',
  `skey` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'skey',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `last_visit_time` date DEFAULT NULL COMMENT '最后登录时间',
  `session_key` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'session_key',
  `city` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '市',
  `province` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '省',
  `country` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '国',
  `avatar_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网名',
  PRIMARY KEY (`open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='微信用户信息';

/*Data for the table `wx_user` */

insert  into `wx_user`(`open_id`,`skey`,`create_time`,`last_visit_time`,`session_key`,`city`,`province`,`country`,`avatar_url`,`gender`,`nick_name`) values ('addaada','adasad',NULL,NULL,'adsdaad',NULL,NULL,NULL,NULL,NULL,'反馈信息测试?'),('o_SMu43UCoay8_hPIj5jvb-UMcKI','b564d149-d61c-4087-8c51-4d9a0d805251','2021-04-27','2021-05-01','9XWyLFPqqeUw+eNLJJpJuw==','','','','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,'微信用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
