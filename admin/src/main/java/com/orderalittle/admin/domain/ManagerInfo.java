package com.orderalittle.admin.domain;

import java.io.Serializable;

public class ManagerInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int uid;
	
	private String name;
	
	private String password;
	
	private String nickname;
	
	private String state;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
