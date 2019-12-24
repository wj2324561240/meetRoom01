package com.meet.service;

import java.util.List;

import com.meet.entity.User;
import com.meet.util.UserPageBean;

/**
 * 用户服务层service接口
 * @author Pluto
 *
 */
public interface IUserService {
	
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public UserPageBean queryForPage(int pageSize,int page);
	/**
	 * 分页条件
	 * @param pageSize
	 * @param page
	 * @param name
	 * @return
	 */
	public UserPageBean findByTJ(int pageSize,int page,String name);
	
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
	public boolean findRoleByuserName(String userName) throws Exception ;
	/**
	 * 根据用户名查到用户
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public List<User> findByUserName(String userName) throws Exception;
}
