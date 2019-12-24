package com.meet.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.meet.dao.IUserDao;
import com.meet.entity.User;
import com.meet.service.IUserService;
import com.meet.util.SessionUtil;
import com.meet.util.UserPageBean;

/**
 * 用户服务层service接口实现
 * @author Pluto
 *
 */
public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * 添加
	 */
	@Override
	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}
	/**
	 * 删除
	 */
	@Override
	public void deleteUser(int id) throws Exception {
		userDao.deleteUser(id);
	}
	/**
	 * 更新
	 */
	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}
	/**
	 * 查找所有
	 */
	@Override
	public List<User> findAllUser() throws Exception {
		return userDao.findAllUser();
	}
	/**
	 * 查找单个
	 */
	@Override
	public User findByIdUser(int id) throws Exception {
		return userDao.findByIdUser(id);
	}
	/**
	 * 登录验证
	 */
	@Override
	public User login(String userName, String password) throws Exception {
		return userDao.login(userName, password);
	}
	/**
	 * 验证用户角色
	 */
	@Override
	public boolean findRoleByuserName(String userName) throws Exception {
		return userDao.findRoleByuserName(userName);
	}
	/**
	 * 根据用户名查到用户
	 */
	@Override
	public List<User> findByUserName(String userName) throws Exception {
		return userDao.findByUserName(userName);
	}
	/**
	 * 分页查询
	 */
	@Override
	public UserPageBean queryForPage(int pageSize, int page) {
		//select * from user where oid not in (7)
		final String hql = "from User where oid !="+SessionUtil.getCurrentUserId(); //查询语句    
		int allRow = userDao.getAllRowCount(hql);  //总记录数    
		int totalPage = UserPageBean.countTatalPage(pageSize, allRow); //总页数    
		final int offset = UserPageBean.countOffset(pageSize, page); //当前页开始记录    
		final int length = pageSize; // 每页记录数    
		final int currentPage = UserPageBean.countCurrentPage(page); // 当前页    
		List list = userDao.queryForPage(hql, offset, length); //    
		//把分页信息保存到Bean当中    
		UserPageBean pageBean  = new UserPageBean();    
		pageBean.setPageSize(pageSize);    
		pageBean.setCurrentPage(currentPage);    
		pageBean.setAllRow(allRow);    
		pageBean.setTotalPage(totalPage);    
		pageBean.setList(list);    
		pageBean.init();    
		return pageBean;    
	}
	/**
	 * 分页条件
	 */
	@Override
	public UserPageBean findByTJ(int pageSize, int page, String name) {
		StringBuilder hql = new StringBuilder("from User user where 1=1 "); //查询语句    
		hql.append(" and user.oid != ").append(SessionUtil.getCurrentUserId());
		if (!StringUtils.isEmpty(name)) {
			hql.append(" and user.username like '").append(name).append("%' ");
		}
		int allRow = userDao.getAllRowCount(hql.toString(),name);  //总记录数    
		int totalPage = UserPageBean.countTatalPage(pageSize, allRow); //总页数    
		final int offset = UserPageBean.countOffset(pageSize, page); //当前页开始记录    
		final int length = offset + pageSize; // 每页记录数    
		final int currentPage = UserPageBean.countCurrentPage(page); // 当前页    
		List list = userDao.findByTJ(hql.toString(), offset, length, name); //   
		//把分页信息保存到Bean当中    
		UserPageBean pageBean  = new UserPageBean();    
		pageBean.setPageSize(pageSize);    
		pageBean.setCurrentPage(currentPage);    
		pageBean.setAllRow(allRow);    
		pageBean.setTotalPage(totalPage);    
		pageBean.setList(list);    
		pageBean.init();    
		return pageBean;    
	}
}
