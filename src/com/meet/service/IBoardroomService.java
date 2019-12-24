package com.meet.service;

import java.util.List;

import com.meet.entity.Boardroom;
import com.meet.util.RoomPageBean;

/**
 * 会议室服务层service接口
 * @author Pluto
 *
 */
public interface IBoardroomService {

	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public RoomPageBean queryForPage(int pageSize,int page);
	/**
	 * 分页条件
	 * @param pageSize
	 * @param page
	 * @param name
	 * @return
	 */
	public RoomPageBean findByTJ(int pageSize,int page,String name);
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
