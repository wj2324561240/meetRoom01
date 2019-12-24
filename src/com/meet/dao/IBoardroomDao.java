package com.meet.dao;

import java.util.List;

import com.meet.entity.Boardroom;

/**
 * 会议室持久层dao接口
 * @author Pluto
 *
 */
public interface IBoardroomDao {
	
	/**   
	 * 分页查询   
	 * @param hql  查询条件   
	 * @param offset  开始记录   
	 * @param length  一次查询几条记录   
	 * @return 查询的记录集合   
	 */  
	public List<Boardroom> queryForPage(final String hql,final int offset,final int length); 
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
	public List<Boardroom> findByTJ(final String hql,final int offset,final int length,String name);
	/**
	 * 添加
	 * @throws Exception
	 */
	public void addBoardroom(Boardroom room) throws Exception;
	/**
	 * 删除
	 * @throws Exception
	 */
	public void deleteBoardroom(int id) throws Exception;
	/**
	 * 更新
	 * @throws Exception
	 */
	public void updateBoardroom(Boardroom room) throws Exception;
	/**
	 * 查找所有
	 * @throws Exception
	 */
	public List<Boardroom> findAllBoardroom() throws Exception;
	/**
	 * 通过id查找
	 * @throws Exception
	 */
	public Boardroom findByIdBoardroom(int id) throws Exception;
	/**
	 * 查找空闲
	 * @return
	 * @throws Exception
	 */
	public List<Boardroom> findkxBoardroom() throws Exception;
}
