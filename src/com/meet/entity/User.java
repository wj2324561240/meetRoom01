package com.meet.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体
 * @author Pluto
 *
 */
public class User {
	private Integer oid;//唯一id
	private String username;//用户名
	private String password;//密码
	private String repwd;//确认密码
	private String age;//年龄
	private String sex;//性别
	private String phone;//手机号码
	private String email;//邮箱
	private String role;//所属角色
	private Group group;//所属部门
	private Set<Meet> meet= new HashSet<Meet>(); //会议记录
	
	
	public User() {
	}
	
	public User(String username, String password, String repwd, String age, String sex, String phone,
			String email, String role) {
		this.username = username;
		this.password = password;
		this.repwd = repwd;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}

	public User(Integer oid, String username, String age, String sex, String phone, String email, String role,
			Group group, Set<Meet> meet) {
		super();
		this.oid = oid;
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.group = group;
		this.meet = meet;
	}

	public User(Integer oid, String username, String password, String repwd, String age, String sex, String phone,
			String email, String role) {
		super();
		this.oid = oid;
		this.username = username;
		this.password = password;
		this.repwd = repwd;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}

	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Meet> getMeet() {
		return meet;
	}
	public void setMeet(Set<Meet> meet) {
		this.meet = meet;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public boolean isAdmin() {
		return "admin".equals(getRole());
	}
	
}

