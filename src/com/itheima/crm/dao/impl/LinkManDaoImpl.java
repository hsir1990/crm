package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.LinkManDao;
import com.itheima.crm.domain.LinkMan;

@Transactional
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao{

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//dao中统计个数的方法
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
			
		return null;
	}

	@Override
	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//dao的分页查询
		detachedCriteria.setProjection(null);
		List<LinkMan> list = (List<LinkMan>)this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}

	//DAO中根据ID查询联系人的方法
	@Override
	public LinkMan findById(Long lkm_id) {
		
		return this.getHibernateTemplate().get(LinkMan.class, lkm_id);
	}

	//DAO中修改联系人的方法
	@Override
	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
	}

}
