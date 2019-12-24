package com.meet.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.meet.dao.IUserDao;
import com.meet.entity.User;
import com.meet.util.SessionUtil;
/**
 * 用户持久层dao接口实现
 * @author Pluto
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
	/**
	 * 添加
	 */
	@Override
	public void addUser(User user) throws Exception {
		this.getHibernateTemplate().save(user);
	}
	/**
	 * 删除
	 */
	@Override
	public void deleteUser(int id) throws Exception {
		User user=(User) this.getHibernateTemplate().load(User.class, id);
		this.getHibernateTemplate().delete(user);
	}
	/**
	 * 更新
	 */
	@Override
	public void updateUser(User user) throws Exception {
		this.getHibernateTemplate().update(user);
	}
	/**
	 * 查找所有
	 */
	@Override
	public List<User> findAllUser() throws Exception {
		@SuppressWarnings("unchecked")
		List<User> userList=this.getHibernateTemplate().find("from User");
		return userList;
	}
	/**
	 * 通过id查找
	 */
	@Override
	public User findByIdUser(int id) throws Exception {
		return this.getHibernateTemplate().get(User.class, id);
	}
	/**
	 * 用户登录
	 */
	@Override
	public User login(String username, String password) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> userList=this.getHibernateTemplate().find("from User where username='"+username+"' and password='"+password+"'");
		if(userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 通过用户名查用户角色
	 */
	@Override
	public boolean findRoleByuserName(String userName) {
		@SuppressWarnings("unchecked")
		List<User> user=this.getHibernateTemplate().find("from User where username='"+userName+"' and role='admin'");
		if(user.size()>0){
			return true;
		}
		return false;
	}
	/**
	 * 通过用户名查找
	 */
	@Override
	public List<User> findByUserName(String userName) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> userList=this.getHibernateTemplate().find("from User where username='"+userName+"'");
		return userList;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public List<User> queryForPage(String hql, int offset, int length) {
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<User> list=q.list();
		//System.out.println(list.size());
		session.close();
		return list;
	}
	
	/**
	 * 查询所有的记录数
	 */
	@Override
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find("from User where oid !="+SessionUtil.getCurrentUserId()).size();
	}
	
	/**
	 * 所有记录数
	 */
	@Override
	public int getAllRowCount(String hql, String name) {
		StringBuilder allRowCountHQL = new StringBuilder("from User where 1=1 ");
		allRowCountHQL.append(" and oid != ").append(SessionUtil.getCurrentUserId());
		if (StringUtils.isNotEmpty(name)) {
			allRowCountHQL.append(" and username like '%").append("%' ");
		}
		
		return this.getHibernateTemplate().find(allRowCountHQL.toString()).size();
	}
	
	/**
	 * 条件查询
	 */
	@Override
	public List<User> findByTJ(String hql, int offset, int length, String name) {
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<User> list=q.list();
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
