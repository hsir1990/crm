package com.itheima.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.LinkMan;
import com.itheima.crm.domain.PageBean;
import com.itheima.crm.service.CustomerService;
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
	//注入客户管理的Service
	private CustomerService customerService;
	

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
	//保存联系人
	public String saveUI() {
		//查询所有的客户，要调用客户业务层的代码，所以要调用注入客户管理
		List<Customer> list= customerService.findAll();
		//对象用push，list用 set   将list集合保存到值栈中
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	//保存客户的方法：save
	public String save() {
		//调用业务层保存
		linkManService.save(linkMan);
		return "saveSuccess";
	}
}
