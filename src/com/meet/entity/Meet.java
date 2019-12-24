package com.meet.entity;

/**
 * 会议记录实体
 * @author PLuto
 *
 */
public class Meet {
	
	private Integer meetid; //会议id
	private String meetname; //会议名
	private User user;//用户
	private Boardroom room; //会议室
	private Equipment equipment; //设备
	private String starttime; //开始时间
	private String endtime; //开始时间
	
	public Meet() {
	}
	
	public Integer getMeetid() {
		return meetid;
	}
	public void setMeetid(Integer meetid) {
		this.meetid = meetid;
	}
	public String getMeetname() {
		return meetname;
	}
	public void setMeetname(String meetname) {
		this.meetname = meetname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boardroom getRoom() {
		return room;
	}
	public void setRoom(Boardroom room) {
		this.room = room;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
