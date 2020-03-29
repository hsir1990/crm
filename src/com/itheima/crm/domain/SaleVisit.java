package com.itheima.crm.domain;

import java.util.Date;

//CREATE TABLE `sale_visit` (
//		  `visit_id` varchar(32) NOT NULL,
//		  `visit_cust_id` bigint(32) DEFAULT NULL COMMENT '客户id',
//		  `visit_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
//		  `visit_time` datetime   DEFAULT NULL COMMENT '拜访时间',
//		  `visit_addr` varchar(128) DEFAULT NULL COMMENT '拜访地点',
//		  `visit_detail` varchar(256) DEFAULT NULL COMMENT '拜访详情',
//		  `visit_nexttime` date DEFAULT NULL COMMENT '下次拜访时间',
//		  PRIMARY KEY (`visit_id`),
//		  KEY `FK_sale_visit_cust_id` (`visit_cust_id`),
//		  KEY `FK_sale_visit_user_id` (`visit_user_id`),
//		  CONSTRAINT `FK_sale_visit_cust_id` FOREIGN KEY (`visit_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
//		  CONSTRAINT `FK_sale_visit_user_id` FOREIGN KEY (`visit_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//客户拜访记录管理的实体
public class SaleVisit {
	private String visit_id;
	private Date visit_time;
	private String visit_addr;
	private String visit_detail;
	private Date visit_nexttime;

	
}
