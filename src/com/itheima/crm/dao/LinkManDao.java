package com.itheima.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.LinkMan;

public interface LinkManDao {

	Integer findCount(DetachedCriteria detachedCriteria);

	List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

}
