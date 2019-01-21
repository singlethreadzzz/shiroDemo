package com.orderalittle.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.orderalittle.admin.domain.ManagerInfo;

@Repository
public interface demo {
	
	@Results(id = "ManagerInfo", value = 
		{ @Result(property = "uid", column = "uid"), 
		       @Result(property = "ManagerName", column = "Manager_name"),
		       @Result(property = "ManagerPassword", column = "Manager_password"),
			   @Result(property = "ManagerNickname", column = "Manager_nickname"),
			   @Result(property = "ManagerType", column = "Manager_type"),
			   @Result(property = "ManagerState", column = "Manager_state")})
	@Select("SELECT uid,Manager_name,Manager_password,Manager_nickname,Manager_type,Manager_state FROM t_Manager_info WHERE uid = #{uid}")
	public ManagerInfo selectManagerInfoByUid(@Param("uid") int uid);

	@Insert("insert into t_Manager_info(Manager_name,Manager_password,Manager_nickname,Manager_type,Manager_state) values(#{ManagerName}, #{ManagerPassword}, #{ManagerNickname}, #{ManagerType}, #{ManagerState})")
	public void insertManagerInfo(ManagerInfo ManagerInfo);

	@Delete("DELETE from t_Manager_info where uid = #{uid}")
	public void deleteManagerInfoByUid(@Param("uid") int uid);

	@Update("UPDATE t_Manager_info SET Manager_password = #{ManagerPassword},Manager_nickname = #{ManagerNickname} WHERE uid = #{uid}")
	public void updateManagerInfoByUid(ManagerInfo ManagerInfo);

    @ResultMap("ManagerInfo")
	@Select("SELECT uid,Manager_name,Manager_password,Manager_nickname,Manager_type,Manager_state FROM t_Manager_info")
	public List<ManagerInfo> selectAllManagerInfo();
    
    @ResultMap("ManagerInfo")
	@Select("SELECT uid,Manager_name,Manager_password,Manager_nickname,Manager_type,Manager_state FROM t_Manager_info WHERE Manager_name = #{ManagerName}")
	public ManagerInfo selectManagerInfoByManagerName(@Param("ManagerName") String ManagerName);

}