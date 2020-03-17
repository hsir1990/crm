package com.itheima.crm.web.action;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//模型驱动使用的对象
	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//注入Service
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//客户管理：跳转到添加页面的方法
	public String saveUI() {
		return "saveUI";
	}
	
	//保存客户
	public String save() {
		customerService.save(customer);
		return NONE;
	}
	

}
