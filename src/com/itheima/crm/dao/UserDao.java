package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.domain.User;

//用户管理的DAO的接口
public interface UserDao {

	void save(User user);

	User login(User user);

	List<User> findAll();

}
