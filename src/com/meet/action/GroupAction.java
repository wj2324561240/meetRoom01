package com.meet.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.meet.entity.Group;
import com.meet.service.IGroupService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 部门控制层
 * @author Pluto
 *
 */
public class GroupAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Group group;
	private IGroupService groupService;
	private Map<String, Object> sessionMap;
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String addGroup() throws Exception{
		if(group.getGroupid()==null){
			groupService.addGroup(group);
		}else{
			updateGroup();
		}
		return "addGroup";
	}
	/**
	 * 更新
	 * @return
	 * @throws Exception
	 */
	public String updateGroup() throws Exception{
		groupService.updateGroup(group);
		return "updateGroup";
	}
	
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public String findListGroup() throws Exception{
		List<Group> groupList=groupService.findAllGroup();
		sessionMap.put("groupList", groupList);
		return "findListGroup";
	}
	
	/**
	 * 通过id查找
	 * @return
	 * @throws Exception
	 */
	public String findByIdGroup() throws Exception{
		this.group=groupService.findByIdGroup(group.getGroupid());
		return "findByIdGroup";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String deleteGroup() throws Exception{
		groupService.deleteGroup(group.getGroupid());
		return "deleteGroup";
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
}
