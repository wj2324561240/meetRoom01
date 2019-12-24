package com.meet.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.meet.dao.IMeetDao;
import com.meet.entity.Meet;

/**
 * 会议管理持久层dao接口实现
 * @author Pluto
 *
 */
public class MeetDaoImpl extends HibernateDaoSupport implements IMeetDao {

	/**
	 * 添加
	 */
	@Override
	public void addMeet(Meet meet) throws Exception {
		this.getHibernateTemplate().save(meet);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteMeet(int id) throws Exception {
		Meet meet=this.getHibernateTemplate().load(Meet.class, id);
		this.getHibernateTemplate().delete(meet);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateMeet(Meet meet) throws Exception {
		this.getHibernateTemplate().update(meet);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Meet> findAllMeet() throws Exception {
		@SuppressWarnings("unchecked")
		List<Meet> meetList=this.getHibernateTemplate().find("from Meet");
		return meetList;
	}

	/**
	 * 通过id查找
	 */
	@Override
	public Meet findByIdMeet(int id) throws Exception {
		Meet meet=this.getHibernateTemplate().get(Meet.class, id);
		return meet;
	}

	/**
	 * 分页查询   
	 */
	@Override
	public List<Meet> queryForPage(String hql, int offset, int length) {
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Meet> list=q.list();
		//System.out.println(list.size());
		session.close();
		return list;
	}

	/**
	 * 查询所有的记录数
	 */
	@Override
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find("from Meet").size();
	}

	/**
	 * 所有记录数
	 */
	@Override
	public int getAllRowCount(String hql, String name) {
		StringBuilder allRowCountHQL = new StringBuilder("from Meet where 1=1 ");
		if (StringUtils.isNotEmpty(name)) {
			allRowCountHQL.append(" and meetname like '%").append("%' ");
		}
		
		return this.getHibernateTemplate().find(allRowCountHQL.toString()).size();
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<Meet> findByTJ(String hql, int offset, int length, String name) {
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Meet> list=q.list();
		//System.out.println(list.size());
		session.close();
		return list;
	}

	// queryString HQL语句
	// pageSize每页显示多少条
	// page当前所在页
	public List<Object> queryListObjectAllForPage(String queryString, int pageSize, int page) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(queryString);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Object> list = (List<Object>) query.list();
		session.close();
		return list;
	}
}
