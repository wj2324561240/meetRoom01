package com.meet.dao;

import java.util.List;

import com.meet.entity.Group;

/**
 * 部门持久层dao接口
 * @author Pluto
 *
 */
public interface IGroupDao {
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
	
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */  
	public List<Group> queryForPage(final String hql,final int offset,final int length); 
	/**   
	 * 查询所有的记录数   
	 * @param hql 查询条件   
	 * @return 总记录数   
	 */    
	public int getAllRowCount(String hql);
	/**
	 * 所有记录数
	 * @param hql
	 * @param name
	 * @return
	 */
	public int getAllRowCount(String hql,String name);
	/**
	 * 条件查询
	 * @param hql 查询条件
	 * @param offset 开始记录
	 * @param length 一次查询几条记录   
	 * @param name 查询的记录集合
	 * @return
	 */
	public List<Group> findByTJ(final String hql,final int offset,final int length,String name);
}
