package com.orderalittle.admin.services;

import com.orderalittle.admin.domain.ManagerInfo;

public interface ManagerInfoService {
	
	public ManagerInfo selectManagerInfoByName(String name);
	
	public String addUser(ManagerInfo managerInfo);

}
