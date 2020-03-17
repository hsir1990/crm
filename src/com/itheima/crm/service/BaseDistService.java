package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.domain.BaseDist;

public interface BaseDistService {

	List<BaseDist> findByTypeCode(String dict_item_code);

}
