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
public interface ManagerInfoMapper {
	
	@Results(id = "managerInfo", value = 
		{ @Result(property = "uid", column = "uid"), 
		       @Result(property = "name", column = "name"),
		       @Result(property = "password", column = "password"),
			   @Result(property = "nickname", column = "nickname"),
			   @Result(property = "state", column = "state")})
	@Select("select uid,name,password,nickname,state from t_manager_info where uid = #{uid}")
	public ManagerInfo selectManagerInfoByUid(@Param("uid") int uid);

	@Insert("insert into t_manager_info(name,password,nickname,state) values(#{name}, #{password}, #{nickname}, #{state})")
	public void insertManagerInfo(ManagerInfo managerInfo);

	@Delete("delete from t_manager_info where uid = #{uid}")
	public void deleteManagerInfoByUid(@Param("uid") int uid);

	@Update("update t_manager_info SET password = #{password},nickname = #{nickname} where uid = #{uid}")
	public void updateManagerInfoByUid(ManagerInfo managerInfo);

    @ResultMap("managerInfo")
	@Select("select uid,name,password,nickname,state from t_manager_info")
	public List<ManagerInfo> selectAllManagerInfo();
    
    @ResultMap("managerInfo")
	@Select("select uid,name,password,nickname,state from t_manager_info where name = #{name}")
	public ManagerInfo selectManagerInfoByName(@Param("name") String name);

}