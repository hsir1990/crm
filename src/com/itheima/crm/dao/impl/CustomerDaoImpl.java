package com.itheima.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
//客户管理DAO实现类
//添加事务@Transactional
@Transactional
public class CustomerDaoImpl  extends BaseDaoImpl<Customer> implements CustomerDao {

//	//方法一  在父类中提供了有参的构造方法，在子类中继承了父类，提供了构造方法，在子类的构造中，调用父类的有参数的构造
//	public CustomerDaoImpl() {
//		super(Customer.class);
//		
//	}
	
	
//	//DAO带条件统计个数的方法
//	@Override
//	public Integer findCount(DetachedCriteria detachedCriteria) {
//		detachedCriteria.setProjection(Projections.rowCount());
//		List<Long> list = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
//		if(list.size()>0) {
//			System.out.println("list.get(0).intValue()--"+list.get(0).intValue());
//			return list.get(0).intValue();
//		}
//		return null;
//	}
//	//分页查询客户的方法
//	@Override
//	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
//		detachedCriteria.setProjection(null);
//		return (List<Customer>)this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
//	}
//
////	//DAO中根据id查询客户的方法
////	@Override
////	public Customer findById(Long cust_id) {
////		
////		return this.getHibernateTemplate().get(Customer.class, cust_id);
////	}
//
//
//	@Override
//	public List<Customer> findAll() {
//		
//		return (List<Customer>)this.getHibernateTemplate().find("from Customer");
//	}
//	@Override
//	public void save(Customer t) {
//		this.getHibernateTemplate().save(t);
//	}
//	@Override
//	public void update(Customer t) {
//		this.getHibernateTemplate().update(t);
//	}
//	@Override
//	public void delete(Customer t) {
//		this.getHibernateTemplate().delete(t);
//	}
//	
//	@Override
//	public Customer findById(Serializable id) {
//		
//		return null;
//	}

}
