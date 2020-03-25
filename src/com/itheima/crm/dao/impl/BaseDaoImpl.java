package com.itheima.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.BaseDao;
import com.itheima.crm.domain.Customer;
//通用DAO的实现类
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

//	
//	//解决T.class问题  方法一：提供构造方法：在构造方法中传入一个具体的class
//	
//	private Class clazz;
//	public BaseDaoImpl(Class clazz) {
//		this.clazz = clazz;
//	}
	//解决T.class问题  方法一：泛型的反射 
	//不想在子类上有构造方法，必须在父类中提供无参数的构造，在无参构造中获得具体类型的Class
	//具体类型的class是参数类型中的实际类型参数。
	private Class clazz;
	public BaseDaoImpl() {
		//反射第一步获得Class
		Class clazz = this.getClass(); //正在被调用的那个类的Class，  customer，linkMan，user
		//查看JDK的API
		Type type = clazz.getGenericSuperclass();  //获取参数化类型 BaseDaoImpl<Customer>  BaseDaoImpl<LinkMan>
		//得到这个type就是一个参数化类型，将type强转成参数化的类型
		ParameterizedType pType = (ParameterizedType)type;
		//通过参数化类型获得实际类型参数，得到一个实际类型参数的数组?Map<String,Integer>
		Type[] types = pType.getActualTypeArguments();
		//只获得第一个实际类型参数即可
		this.clazz  = (Class)types[0]; //得到  Customer LinkMan User
	
	}
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		
		return (T)this.getHibernateTemplate().get(clazz, id);
	}
	@Override
	public List<T> findAll() {
		
		return (List<T>) this.getHibernateTemplate().find("form" + clazz.getSimpleName());
	}
	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//设置统计个数的条件
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}
	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<T>)this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

}
