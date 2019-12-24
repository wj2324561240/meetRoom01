package com.meet.service.impl;

import java.util.List;

import com.meet.dao.IGroupDao;
import com.meet.entity.Group;
import com.meet.service.IGroupService;

/**
 * 用户服务层service接口实现
 * @author Pluto
 *
 */
public class GroupServiceImpl implements IGroupService {

	private IGroupDao groupDao;
	/**
	 * 添加
	 */
	@Override
	public void addGroup(Group group) throws Exception {
		groupDao.addGroup(group);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteGroup(int id) throws Exception {
		groupDao.deleteGroup(id);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateGroup(Group group) throws Exception {
		groupDao.updateGroup(group);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Group> findAllGroup() throws Exception {
		return groupDao.findAllGroup();
	}

	/**
	 * 查找所有
	 */
	@Override
	public Group findByIdGroup(int id) throws Exception {
		return groupDao.findByIdGroup(id);
	}

	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	
}
