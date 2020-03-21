package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
//客户管理DAO实现类
//添加事务@Transactional
@Transactional
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	//DAO带条件统计个数的方法
	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0) {
			System.out.println("list.get(0).intValue()--"+list.get(0).intValue());
			return list.get(0).intValue();
		}
		return null;
	}
	//分页查询客户的方法
	@Override
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<Customer>)this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	//DAO中根据id查询客户的方法
	@Override
	public Customer findById(Long cust_id) {
		
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

}
