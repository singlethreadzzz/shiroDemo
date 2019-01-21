package com.orderalittle.admin.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderalittle.admin.domain.ManagerInfo;
import com.orderalittle.admin.mapper.ManagerInfoMapper;
import com.orderalittle.admin.services.ManagerInfoService;

@Service
public class ManagerInfoServiceImpl implements ManagerInfoService{
	
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	public ManagerInfo selectManagerInfoByName(String name) {
		try {
			ManagerInfo managerInfo = this.managerInfoMapper.selectManagerInfoByName(name);
			return managerInfo;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public String addUser(ManagerInfo managerInfo) {
		try {
			this.managerInfoMapper.insertManagerInfo(managerInfo);
			return "新增用户成功";
		}catch (Exception e) {
			System.out.println(e);
			return "新增用户失败";
		}
	}

}
