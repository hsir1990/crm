package com.itheima.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.PageBean;
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

	//业务层分页查询客户的方法
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录页
		pageBean.setPageSize(pageSize);
		//封装总记录数
		//调用DAO
		Integer totalCount= customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示数据的集合
		Integer begin = (currPage -1 ) * pageSize;
		List<Customer> list= customerDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
		
	}

	@Override
	public Customer findById(Long cust_id) {
		
		return customerDao.findById(cust_id);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	
	
	
	}
