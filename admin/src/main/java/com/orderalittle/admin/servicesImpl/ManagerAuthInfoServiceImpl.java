package com.orderalittle.admin.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderalittle.admin.mapper.ManagerAuthInfoMapper;
import com.orderalittle.admin.pojo.ManagerAuthInfo;
import com.orderalittle.admin.services.ManagerAuthInfoService;

@Service
public class ManagerAuthInfoServiceImpl implements ManagerAuthInfoService {
	
	@Autowired
	private ManagerAuthInfoMapper managerAuthInfoMapper;

	@Override
	public ManagerAuthInfo selectManagerAuthInfoByName(String name) {
		try {
			ManagerAuthInfo managerAuthInfo = this.managerAuthInfoMapper.selectManagerAuthInfoByName(name);
			return managerAuthInfo;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
