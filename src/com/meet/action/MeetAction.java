package com.meet.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.meet.entity.Meet;
import com.meet.service.IMeetService;
import com.meet.util.MeetPageBean;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 会议管理控制层
 * @author Pluto
 *
 */
public class MeetAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMeetService meetService;
	private Meet meet;
	private Map<String, Object> sessionMap;
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	private MeetPageBean meetpageBean; //封装了分页信息和数据内容的pageBean 
	private List<Meet> listMeet;//用于储存pageBean当中被封装的User信息
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String addMeet() throws Exception{
		meetService.addMeet(meet);
		return "addMeet";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteMeet() throws Exception{
		meetService.deleteMeet(meet.getMeetid());
		return "deleteMeet";
	}
	/**
	 * 更新
	 * @return
	 * @throws Exception
	 */
	public String updateMeet() throws Exception{
		meetService.updateMeet(meet);
		return "updateMeet";
	}
	/**
	 * 通过id查找
	 * @return
	 * @throws Exception
	 */
	public String findByIdMeet() throws Exception{
		this.meet=meetService.findByIdMeet(meet.getMeetid());
		return "findByIdMeet";
	}
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public String findAllMeet() throws Exception{
		//List<Meet> meetList=meetService.findAllMeet();
		//sessionMap.put("meetList", meetList);
		this.meetpageBean = meetService.queryForPage(5, page);//获取封装了分页信息和数据的pageBean    
		List<Meet> meetList= this.meetpageBean.getList(); //获取数据 
		sessionMap.put("meetList", meetList);
		sessionMap.put("meetpageBean", meetpageBean);
		return "findAllMeet";
	}
	
	/**
	 * 条件查询
	 * @return
	 * @throws Exception
	 */
	public String findByTJ() throws Exception{
		this.meetpageBean=meetService.findByTJ(5, page, null == meet ? null : meet.getMeetname());
		this.listMeet=this.meetpageBean.getList();
		sessionMap.put("meetpageBean", meetpageBean);
		sessionMap.put("meetList", listMeet);
		return "findByTJ";
	}
	
	public void setMeetService(IMeetService meetService) {
		this.meetService = meetService;
	}

	public Meet getMeet() {
		return meet;
	}
	
	public void setMeet(Meet meet) {
		this.meet = meet;
	}
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public MeetPageBean getMeetpageBean() {
		return meetpageBean;
	}
	public void setMeetpageBean(MeetPageBean meetpageBean) {
		this.meetpageBean = meetpageBean;
	}
	public List<Meet> getListMeet() {
		return listMeet;
	}
	public void setListMeet(List<Meet> listMeet) {
		this.listMeet = listMeet;
	}
}
