package com.orderalittle.admin.services;

import com.orderalittle.admin.pojo.ManagerAuthInfo;

public interface ManagerAuthInfoService {
	
	public ManagerAuthInfo selectManagerAuthInfoByName(String name);

}
