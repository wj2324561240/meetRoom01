package com.meet.service;

import java.util.List;

import com.meet.entity.Group;

/**
 * 部门服务层service接口
 * @author Pluto
 *
 */
public interface IGroupService {
	/**
	 * 添加
	 * @throws Exception
	 */
	public void addGroup(Group group) throws Exception;
	/**
	 * 删除
	 * @throws Exception
	 */
	public void deleteGroup(int id) throws Exception;
	/**
	 * 更新
	 * @throws Exception
	 */
	public void updateGroup(Group group) throws Exception;
	/**
	 * 查找所有
	 * @throws Exception
	 */
	public List<Group> findAllGroup() throws Exception;
	/**
	 * 通过id查找
	 * @throws Exception
	 */
	public Group findByIdGroup(int id) throws Exception;
}
