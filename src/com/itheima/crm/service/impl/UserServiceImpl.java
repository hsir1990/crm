package com.itheima.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.utils.MD5Utils;

//用户管理的实现类接口
@Transactional
public class UserServiceImpl implements UserService {
	
	//注入DAO
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//注册用户的方法
	@Override
	public void regist(User user) {
		//对密码进行加密的处理
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		
		//调用Dao
		userDao.save(user);
	}

	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		
		//调用Dao
		return userDao.login(user);	
	}

}
