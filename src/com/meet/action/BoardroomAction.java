package com.meet.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.meet.entity.Boardroom;
import com.meet.entity.Meet;
import com.meet.service.IBoardroomService;
import com.meet.util.MeetPageBean;
import com.meet.util.RoomPageBean;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 会议室控制层
 * @author Pluto
 *
 */
public class BoardroomAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boardroom room;
	private IBoardroomService roomService;
	private Map<String, Object> sessionMap;
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	private RoomPageBean roompageBean; //封装了分页信息和数据内容的pageBean 
	private List<Boardroom> listRoom;//用于储存pageBean当中被封装的User信息
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String addRoom() throws Exception{
		if(room.getBoardroomid()==null){			
			roomService.addBoardroom(room);
		}else{
			updateRoom();
		}
		return "addRoom";
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String updateRoom() throws Exception{
		roomService.updateBoardroom(room);
		return "updateRoom";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteRoom() throws Exception{
		roomService.deleteBoardroom(room.getBoardroomid());
		return "deleteRoom";
	}
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public String findAllBoardroom() throws Exception{
		//List<Boardroom> roomList=roomService.findAllBoardroom();
		//sessionMap.put("roomList", roomList);
		this.roompageBean = roomService.queryForPage(5, page);//获取封装了分页信息和数据的pageBean    
		List<Boardroom> roomList= this.roompageBean.getList(); //获取数据 
		sessionMap.put("roomList", roomList);
		sessionMap.put("roompageBean", roompageBean);
		return "findAllBoardroom";
	}
	
	/**
	 * 条件查询
	 * @return
	 * @throws Exception
	 */
	public String findByTJ() throws Exception{
		this.roompageBean=roomService.findByTJ(5, page, null == room ? null : room.getBoardroomtype());
		this.listRoom=this.roompageBean.getList();
		sessionMap.put("roompageBean", roompageBean);
		sessionMap.put("roomList", listRoom);
		return "findByTJ";
	}
	
	/**
	 * 查找空闲的
	 * @return
	 * @throws Exception
	 */
	public String findkxBoardroom() throws Exception{
		List<Boardroom> roomkx=roomService.findkxBoardroom();
		sessionMap.put("roomkx", roomkx);
		return "findkxBoardroom";
	}
	/**
	 * 通过id查找
	 * @return
	 * @throws Exception
	 */
	public String findByIdRoom() throws Exception{
		this.room=roomService.findByIdBoardroom(room.getBoardroomid());
		return "findByIdRoom";
	}
	public Boardroom getRoom() {
		return room;
	}
	public void setRoom(Boardroom room) {
		this.room = room;
	}
	public void setRoomService(IBoardroomService roomService) {
		this.roomService = roomService;
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
	public RoomPageBean getRoompageBean() {
		return roompageBean;
	}
	public void setRoompageBean(RoomPageBean roompageBean) {
		this.roompageBean = roompageBean;
	}
	public List<Boardroom> getListRoom() {
		return listRoom;
	}
	public void setListRoom(List<Boardroom> listRoom) {
		this.listRoom = listRoom;
	}
}
