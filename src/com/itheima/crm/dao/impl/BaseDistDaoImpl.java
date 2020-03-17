package com.itheima.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.BaseDistDao;
import com.itheima.crm.domain.BaseDist;

//字典的DAO包实现类
public class BaseDistDaoImpl extends HibernateDaoSupport implements BaseDistDao {

	@Override
	public List<BaseDist> findByTypeCode(String dict_type_code) {
		//根据类型编码查询字典数据
		return (List<BaseDist>)this.getHibernateTemplate().find("from BaseDist where dict_type_code=?", dict_type_code);
	}


}
