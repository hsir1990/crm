package com.itheima.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.BaseDist;
import com.itheima.crm.service.BaseDistService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDistAction extends ActionSupport implements ModelDriven<BaseDist> {

//	模型驱动使用对象
	private BaseDist baseDist = new BaseDist();
	
	@Override
	public BaseDist getModel() {
		return baseDist;
	}
//	注入service
	private BaseDistService baseDistService;

	public void setBaseDistService(BaseDistService baseDistService) {
		this.baseDistService = baseDistService;
	}
	//根据类型名称查询字典的方法
	public String findByTypeCode() throws IOException {
		System.out.println("findByTypeCode方法执行了     "+baseDist.getDict_type_code());
		List<BaseDist> list = baseDistService.findByTypeCode(baseDist.getDict_type_code());
		//将list转为json --- 两种类方案jsonlib   fastjson
		//JSONConfig : 转JSON的配置对象
		//JOSNArray : 将数组和list集合转为json
		//JSONObject : 将对象和Map集合转为JSON
		JsonConfig jsonConfig = new JsonConfig();
		//将不用的字段去除
		jsonConfig.setExcludes(new String[] {"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		System.out.println(jsonArray.toString());
		
		//将JSON打印到页面
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
