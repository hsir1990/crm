package com.itheima.crm.web.action;



import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.crm.domain.PageBean;
import com.itheima.crm.domain.SaleVisit;
import com.itheima.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	
	//模型驱动管理
	private SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		
		return saleVisit;
	}

	
	//在 Action 中注入Service,使用注解可以不用set方法
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	
	
	
	//接受分页数据
	private Integer currPage = 1;
	private Integer pageSize = 3;
	
	
	public void setCurrPage(Integer currPage) {
		if(currPage == null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}


	public void setPageSize(Integer pageSize) {
		if(pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}


	
	//接收数据
	private Date visit_end_time;
	public void setVisit_end_time(Date visit_end_time) {
		this.visit_end_time = visit_end_time;
	}


	//查询拜访记录列表的方法：findAll
	public String findAll() {
		//创建离线的条件查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		//设置条件
		if(saleVisit.getVisit_time() != null) {
			//ge是大于等于  gt大于
			detachedCriteria.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
		}
		if(visit_end_time != null) {
			//小于等于le
			detachedCriteria.add(Restrictions.le("visit_end_time",visit_end_time));
		}
		
		
		//调用业务层
		PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria, currPage, pageSize);
		//存入到值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转保存拜访记录
	public String saveUI() {
		//注意不要出现死循环，比如客户里有联系人，联系人里面有客户
		return "saveUI";
	}
	
	//保存客户拜访记录的方法;save
	public String save() {
		saleVisitService.save(saleVisit);
		return "saveSuccess";
	}
}
