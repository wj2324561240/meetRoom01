package com.meet.service;

import java.util.List;

import com.meet.entity.Meet;
import com.meet.util.MeetPageBean;

/**
 * 会议管理服务层service接口
 * @author Pluto
 *
 */
public interface IMeetService {
	
	/**   
	 * 分页查询     
	 * @param pageSize  每页显示多少记录   
	 * @param currentPage 当前页   
	 * @return 封装了分页信息的bean   
	 */    
	public MeetPageBean queryForPage(int pageSize,int page);
	/**
	 * 分页条件
	 * @param pageSize
	 * @param page
	 * @param name
	 * @return
	 */
	public MeetPageBean findByTJ(int pageSize,int page,String name);
	/**
	 * 添加
	 * @throws Exception
	 */
	public void addMeet(Meet meet) throws Exception;
	/**
	 * 删除
	 * @throws Exception
	 */
	public void deleteMeet(int id) throws Exception;
	/**
	 * 更新
	 * @throws Exception
	 */
	public void updateMeet(Meet meet) throws Exception;
	/**
	 * 查找所有
	 * @throws Exception
	 */
	public List<Meet> findAllMeet() throws Exception;
	/**
	 * 通过id查找
	 * @throws Exception
	 */
	public Meet findByIdMeet(int id) throws Exception;
}
