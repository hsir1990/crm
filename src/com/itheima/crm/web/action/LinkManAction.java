package com.itheima.crm.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.LinkMan;
import com.itheima.crm.domain.PageBean;
import com.itheima.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//联系人的Action类
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	
	//模型驱动
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	//注入Service
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	//分页参数
	private  Integer currPage = 1;
	private  Integer pageSize = 3;
	
	public void setCurrPage(Integer currPage) {
		if(currPage == null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize==null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	//查询联系人列表
	public String  findAll() {
		//创建离线条件查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//设置条件
		//调用业务
		PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria, currPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
}
