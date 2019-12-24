package com.meet.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.meet.dao.IMeetDao;
import com.meet.entity.Meet;
import com.meet.service.IMeetService;
import com.meet.util.MeetPageBean;

/**
 * 会议管理服务层service接口实现
 * @author Pluto
 *
 */
public class MeetServiceImpl implements IMeetService {

	private IMeetDao meetDao;
	/**
	 * 添加
	 */
	@Override
	public void addMeet(Meet meet) throws Exception {
		meetDao.addMeet(meet);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteMeet(int id) throws Exception {
		meetDao.deleteMeet(id);
	}

	/**
	 * 更新
	 */
	@Override
	public void updateMeet(Meet meet) throws Exception {
		meetDao.updateMeet(meet);
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Meet> findAllMeet() throws Exception {
		return meetDao.findAllMeet();
	}

	/**
	 * 通过id查找
	 */
	@Override
	public Meet findByIdMeet(int id) throws Exception {
		return meetDao.findByIdMeet(id);
	}

	public void setMeetDao(IMeetDao meetDao) {
		this.meetDao = meetDao;
	}

	/**
	 * 分页查询
	 */
	@Override
	public MeetPageBean queryForPage(int pageSize, int page) {
		// select * from user where oid not in (7)
		final String hql = "from Meet "; // 查询语句
		int allRow = meetDao.getAllRowCount(hql); // 总记录数
		int totalPage = MeetPageBean.countTatalPage(pageSize, allRow); // 总页数
		final int offset = MeetPageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = MeetPageBean.countCurrentPage(page); // 当前页
		List list = meetDao.queryForPage(hql, offset, length); //
		// 把分页信息保存到Bean当中
		MeetPageBean pageBean = new MeetPageBean();
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
	public MeetPageBean findByTJ(int pageSize, int page, String name) {
		StringBuilder hql = new StringBuilder("from Meet meet where 1=1 "); //查询语句    
		if (!StringUtils.isEmpty(name)) {
			hql.append(" and meet.meetname like '").append(name).append("%' ");
		}
		int allRow = meetDao.getAllRowCount(hql.toString(),name);  //总记录数    
		int totalPage = MeetPageBean.countTatalPage(pageSize, allRow); //总页数    
		final int offset = MeetPageBean.countOffset(pageSize, page); //当前页开始记录    
		final int length = offset + pageSize; // 每页记录数    
		final int currentPage = MeetPageBean.countCurrentPage(page); // 当前页    
		List list = meetDao.findByTJ(hql.toString(), offset, length, name); //   
		//把分页信息保存到Bean当中    
		MeetPageBean pageBean  = new MeetPageBean();    
		pageBean.setPageSize(pageSize);    
		pageBean.setCurrentPage(currentPage);    
		pageBean.setAllRow(allRow);    
		pageBean.setTotalPage(totalPage);    
		pageBean.setList(list);    
		pageBean.init();    
		return pageBean;    
	}

}
