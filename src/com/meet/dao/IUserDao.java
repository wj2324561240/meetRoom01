package com.meet.dao;

import java.util.List;

import com.meet.entity.User;

/**
 * 用户持久层dao接口
 * @author Pluto
 *
 */
public interface IUserDao {
	
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */  
	public List<User> queryForPage(final String hql,final int offset,final int length); 
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
	public List<User> findByTJ(final String hql,final int offset,final int length,String name);
	/**
	 * 添加
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	/**
	 * 删除
	 * @throws Exception
	 */
	public void deleteUser(int id) throws Exception;
	/**
	 * 更新
	 * @throws Exception
	 */
	public void updateUser(User user) throws Exception;
	/**
	 * 查找所有
	 * @throws Exception
	 */
	public List<User> findAllUser() throws Exception;
	/**
	 * 通过id查找
	 * @throws Exception
	 */
	public User findByIdUser(int id) throws Exception;
	/**
	 * 登录验证
	 * @return
	 * @throws Exception
	 */
	public User login(String userName,String password) throws Exception;
	/**
	 * 通过用户名查的角色
	 * @param userName
	 * @return
	 */
	public boolean findRoleByuserName(String userName) throws Exception;
	/**
	 * 根据用户名查到用户
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public List<User> findByUserName(String userName) throws Exception;
}
