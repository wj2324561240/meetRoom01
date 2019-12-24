package com.meet.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.meet.dao.IBoardroomDao;
import com.meet.entity.Boardroom;
import com.meet.service.IBoardroomService;
import com.meet.util.RoomPageBean;

/**
 * 会议室服务层service接口实现
 * @author Pluto
 *
 */
public class BoardroomServiceImpl implements IBoardroomService {
	
	private IBoardroomDao roomDao;
	/**
	 * 添加
	 */
	@Override
	public void addBoardroom(Boardroom room) throws Exception {
		roomDao.addBoardroom(room);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteBoardroom(int id) throws Exception {
		roomDao.deleteBoardroom(id);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateBoardroom(Boardroom room) throws Exception {
		roomDao.updateBoardroom(room);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Boardroom> findAllBoardroom() throws Exception {
		return roomDao.findAllBoardroom();
	}

	/**
	 * 根据id查找
	 */
	@Override
	public Boardroom findByIdBoardroom(int id) throws Exception {
		return roomDao.findByIdBoardroom(id);
	}

	public void setRoomDao(IBoardroomDao roomDao) {
		this.roomDao = roomDao;
	}

	/**
	 * 查找空闲的会议室
	 */
	@Override
	public List<Boardroom> findkxBoardroom() throws Exception {
		return roomDao.findkxBoardroom();
	}

	/**
	 * 分页查询
	 */
	@Override
	public RoomPageBean queryForPage(int pageSize, int page) {
		// select * from user where oid not in (7)
		final String hql = "from Boardroom "; // 查询语句
		int allRow = roomDao.getAllRowCount(hql); // 总记录数
		int totalPage = RoomPageBean.countTatalPage(pageSize, allRow); // 总页数
		final int offset = RoomPageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = RoomPageBean.countCurrentPage(page); // 当前页
		List list = roomDao.queryForPage(hql, offset, length); //
		// 把分页信息保存到Bean当中
		RoomPageBean pageBean = new RoomPageBean();
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
	public RoomPageBean findByTJ(int pageSize, int page, String name) {
		StringBuilder hql = new StringBuilder("from Boardroom room where 1=1 "); //查询语句    
		if (!StringUtils.isEmpty(name)) {
			hql.append(" and room.boardroomtype like '").append(name).append("%' ");
		}
		int allRow = roomDao.getAllRowCount(hql.toString(),name);  //总记录数    
		int totalPage = RoomPageBean.countTatalPage(pageSize, allRow); //总页数    
		final int offset = RoomPageBean.countOffset(pageSize, page); //当前页开始记录    
		final int length = offset + pageSize; // 每页记录数    
		final int currentPage = RoomPageBean.countCurrentPage(page); // 当前页    
		List list = roomDao.findByTJ(hql.toString(), offset, length, name); //   
		//把分页信息保存到Bean当中    
		RoomPageBean pageBean  = new RoomPageBean();    
		pageBean.setPageSize(pageSize);    
		pageBean.setCurrentPage(currentPage);    
		pageBean.setAllRow(allRow);    
		pageBean.setTotalPage(totalPage);    
		pageBean.setList(list);    
		pageBean.init();    
		return pageBean;    
	}

}
