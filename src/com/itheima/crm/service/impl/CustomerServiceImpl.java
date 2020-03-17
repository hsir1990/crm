package com.itheima.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
//import com.itheima.crm.domain.Customer;
import com.itheima.crm.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注入客户的DAO
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	//业务层保存客户
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	
	
	
	}
