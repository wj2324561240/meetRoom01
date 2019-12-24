package com.meet.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.meet.dao.IGroupDao;
import com.meet.entity.Group;

/**
 * 部门持久层dao接口实现
 * @author Pluto
 *
 */
public class GroupDaoImpl extends HibernateDaoSupport implements IGroupDao {

	/**
	 * 添加
	 */
	@Override
	public void addGroup(Group group) throws Exception {
		this.getHibernateTemplate().save(group);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteGroup(int id) throws Exception {
		Group group=this.getHibernateTemplate().load(Group.class, id);
		this.getHibernateTemplate().delete(group);
	}

	/**
	 * 更改
	 */
	@Override
	public void updateGroup(Group group) throws Exception {
		this.getHibernateTemplate().update(group);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Group> findAllGroup() throws Exception {
		@SuppressWarnings("unchecked")
		List<Group> groupList=this.getHibernateTemplate().find("from Group");
		return groupList;
	}

	/**
	 * 通过id查找
	 */
	@Override
	public Group findByIdGroup(int id) throws Exception {
		Group group=this.getHibernateTemplate().get(Group.class, id);
		return group;
	}

	@Override
	public List<Group> queryForPage(String hql, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllRowCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllRowCount(String hql, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Group> findByTJ(String hql, int offset, int length, String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
