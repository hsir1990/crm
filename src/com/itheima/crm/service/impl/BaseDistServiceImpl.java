package com.itheima.crm.service.impl;

import java.util.List;

import com.itheima.crm.dao.BaseDistDao;
import com.itheima.crm.domain.BaseDist;
import com.itheima.crm.service.BaseDistService;

public class BaseDistServiceImpl implements BaseDistService {

//	字典业务层实现类
	private BaseDistDao baseDistDao;

	public void setBaseDistDao(BaseDistDao baseDistDao) {
		this.baseDistDao = baseDistDao;
	}

	@Override
	public List<BaseDist> findByTypeCode(String dict_type_code) {
		return baseDistDao.findByTypeCode(dict_type_code);
	}
	
	
	
}
