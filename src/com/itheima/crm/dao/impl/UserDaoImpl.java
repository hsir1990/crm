package com.itheima.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.UserDao;
//用户管理的DAO的实现类
import com.itheima.crm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	//DAO中保存用户的方法
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?",user.getUser_code(),user.getUser_password());
		//因为返回的是list所以要判断一下
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

}
