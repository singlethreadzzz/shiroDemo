package com.orderalittle.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.orderalittle.admin.pojo.ManagerAuthInfo;

@Repository
public interface ManagerAuthInfoMapper {
	
	@Results(id = "managerAuthInfo", value = 
		{ @Result(property = "roleName", column = "role_name"), 
		  @Result(property = "roleCnname", column = "role_cnname")})
	@Select("select a.role_name,a.role_cnname from t_role_info a,t_manager_info b,t_manager_role c where b.uid = c.manager_id and a.uuid = c.role_id and b.name = #{name}")
	public ManagerAuthInfo selectManagerAuthInfoByName(@Param("name") String name);

}
