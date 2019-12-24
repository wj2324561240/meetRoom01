package com.meet.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.meet.dao.IBoardroomDao;
import com.meet.entity.Boardroom;
import com.meet.entity.Meet;

/**
 * 会议室持久层dao接口实现
 * @author Pluto
 *
 */
public class BoardroomDaoImpl extends HibernateDaoSupport implements IBoardroomDao {
	
	/**
	 * 添加
	 */
	@Override
	public void addBoardroom(Boardroom room) throws Exception {
		this.getHibernateTemplate().save(room);
	}
	/**
	 * 删除
	 */
	@Override
	public void deleteBoardroom(int id) throws Exception {
		Boardroom room=this.getHibernateTemplate().load(Boardroom.class, id);
		this.getHibernateTemplate().delete(room);
	}
	/**
	 * 更新
	 */
	@Override
	public void updateBoardroom(Boardroom room) throws Exception {
		this.getHibernateTemplate().update(room);
	}
	/**
	 * 查找所有
	 */
	@Override
	public List<Boardroom> findAllBoardroom() throws Exception {
		@SuppressWarnings("unchecked")
		List<Boardroom> roomList=this.getHibernateTemplate().find("from Boardroom");
		return roomList;
	}
	/**
	 * 通过id查找
	 */
	@Override
	public Boardroom findByIdBoardroom(int id) throws Exception {
		Boardroom room=this.getHibernateTemplate().get(Boardroom.class, id);
		return room;
	}
	/**
	 * 查找空闲的会议室
	 */
	@Override
	public List<Boardroom> findkxBoardroom() throws Exception {
		@SuppressWarnings("unchecked")
		List<Boardroom> roomkx=this.getHibernateTemplate().find("from Boardroom where state=1");
		return roomkx;
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<Boardroom> queryForPage(String hql, int offset, int length) {
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Boardroom> list=q.list();
		//System.out.println(list.size());
		session.close();
		return list;
	}
	/**
	 * 查询所有的记录数   
	 */
	@Override
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find("from Boardroom").size();
	}
	/**
	 * 所有记录数
	 */
	@Override
	public int getAllRowCount(String hql, String name) {
		StringBuilder allRowCountHQL = new StringBuilder("from Boardroom where 1=1 ");
		if (StringUtils.isNotEmpty(name)) {
			allRowCountHQL.append(" and boardroomtype like '%").append("%' ");
		}
		
		return this.getHibernateTemplate().find(allRowCountHQL.toString()).size();
	}
	/**
	 * 条件查询
	 */
	@Override
	public List<Boardroom> findByTJ(String hql, int offset, int length, String name) {
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Boardroom> list=q.list();
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
