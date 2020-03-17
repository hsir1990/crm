package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.domain.BaseDist;

public interface BaseDistDao {

	List<BaseDist> findByTypeCode(String dict_type_code);

}
