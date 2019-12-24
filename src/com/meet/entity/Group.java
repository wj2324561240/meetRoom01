package com.meet.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 * 
 * @author Pluto
 *
 */
public class Group {

	private Integer groupid; // 部门id
	private String groupname; // 部门名称
	private String membernumber; // 部门人数
	private Set<User> user= new HashSet<User>(); //会议记录

	public Group() {
	}

	public Group(String groupname, String membernumber) {
		this.groupname = groupname;
		this.membernumber = membernumber;
	}

	public Group(Integer groupid, String groupname, String membernumber) {
		super();
		this.groupid = groupid;
		this.groupname = groupname;
		this.membernumber = membernumber;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getMembernumber() {
		return membernumber;
	}

	public void setMembernumber(String membernumber) {
		this.membernumber = membernumber;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
}
