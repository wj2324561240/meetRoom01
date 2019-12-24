package com.meet.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 会议室实体
 * @author Pluto
 *
 */
public class Boardroom {
	
	private Integer boardroomid; //会议室id
	private String boardroomtype; //会议室类型
	private Integer boardroomconten; //会议室容纳人数
	private Integer state; //状态
	private Set<Meet> meet= new HashSet<Meet>(); //会议记录
	
	public Boardroom() {
	}
	
	public Boardroom(String boardroomtype, Integer boardroomconten, Integer state) {
		this.boardroomtype = boardroomtype;
		this.boardroomconten = boardroomconten;
		this.state = state;
	}
	
	public Boardroom(Integer boardroomid, String boardroomtype, Integer boardroomconten, Integer state) {
		super();
		this.boardroomid = boardroomid;
		this.boardroomtype = boardroomtype;
		this.boardroomconten = boardroomconten;
		this.state = state;
	}

	public Integer getBoardroomid() {
		return boardroomid;
	}

	public void setBoardroomid(Integer boardroomid) {
		this.boardroomid = boardroomid;
	}

	public String getBoardroomtype() {
		return boardroomtype;
	}

	public void setBoardroomtype(String boardroomtype) {
		this.boardroomtype = boardroomtype;
	}

	public Integer getBoardroomconten() {
		return boardroomconten;
	}

	public void setBoardroomconten(Integer boardroomconten) {
		this.boardroomconten = boardroomconten;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set<Meet> getMeet() {
		return meet;
	}

	public void setMeet(Set<Meet> meet) {
		this.meet = meet;
	}
	
}
