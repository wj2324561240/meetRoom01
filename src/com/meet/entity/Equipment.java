package com.meet.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 设备实体
 * @author Pluto
 *
 */
public class Equipment {
	
	private Integer equipmentid; //设备id
	private String equipmentname; //设备名
	private Set<Meet> meet= new HashSet<Meet>(); //会议记录
	
	public Equipment() {
	}
	
	public Equipment(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	
	public Equipment(Integer equipmentid, String equipmentname) {
		super();
		this.equipmentid = equipmentid;
		this.equipmentname = equipmentname;
	}

	public Integer getEquipmentid() {
		return equipmentid;
	}
	public void setEquipmentid(Integer equipmentid) {
		this.equipmentid = equipmentid;
	}
	public String getEquipmentname() {
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public Set<Meet> getMeet() {
		return meet;
	}
	public void setMeet(Set<Meet> meet) {
		this.meet = meet;
	}
}
