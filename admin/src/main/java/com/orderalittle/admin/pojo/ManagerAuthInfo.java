package com.orderalittle.admin.pojo;

import java.io.Serializable;

public class ManagerAuthInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleName;
	
	private String roleCnname;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCnname() {
		return roleCnname;
	}

	public void setRoleCnname(String roleCnname) {
		this.roleCnname = roleCnname;
	}
	
}
