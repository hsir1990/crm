package com.itheima.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

//通用DAO的接口
//在类上定义T，所有非静态的都可以使用T
public interface BaseDao <T>{
	
	public void save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public T findById(Serializable id);
	//查询所有
	public List<T> findAll();
	//统计个数
	public Integer findCount(DetachedCriteria detachedCriteria);
	//分页查询的方法
	public List<T> findByPage(DetachedCriteria detachedCriteria,Integer begin, Integer pageSize);
	
}
