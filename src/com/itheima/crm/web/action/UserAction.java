package com.itheima.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



//用户管理Action的类
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	//注入Service业务层
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	//用户注册的方法：regist
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}
	
	
	//用户登录的方法
	public String login() {
//		调用业务查询用户
		User existUser = userService.login(user);
		if(existUser == null) {
			//登录失败添加错误信息
			this.addActionError("用户登录账号或密码错误");
			return LOGIN;

		}else {
			//登录成功  两种方式
//			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
	}
}
