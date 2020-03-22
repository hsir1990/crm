package com.itheima.crm.service.impl;

import com.itheima.crm.dao.LinkManDao;
import com.itheima.crm.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
	//注入DAO
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
}
