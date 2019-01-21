package com.orderalittle.admin.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderalittle.admin.domain.ManagerInfo;
import com.orderalittle.admin.pojo.ManagerAuthInfo;
import com.orderalittle.admin.services.ManagerAuthInfoService;
import com.orderalittle.admin.services.ManagerInfoService;

@Component
public class AdminRealm extends AuthorizingRealm {
	
	@Autowired
	private ManagerInfoService managerInfoService;
	
	@Autowired
	private ManagerAuthInfoService managerAuthInfoService;
	
	/**
	 * <p>Method ：doGetAuthenticationInfo
	 * <p>Description : 用户名密码认证
	 *
	 * @param token
	 * @return
	 * @throws AuthenticationException 
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken UPtoken = (UsernamePasswordToken)token;
		String name = UPtoken.getUsername();	
		
		ManagerInfo managerInfo = this.managerInfoService.selectManagerInfoByName(name);
		
		if(managerInfo == null) {
			throw new UnknownAccountException("查询出错");
		}
		
		String password = managerInfo.getPassword();

		if(password != null) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(managerInfo, password, ByteSource.Util.bytes(name + "LoveLive"), getName());
			return info;
		}else {
		    throw new UnknownAccountException("用户名错误");
		}

	}

	/**
	 * <p>Method ：doGetAuthorizationInfo
	 * <p>Description : 权限认证
	 *
	 * @param principals
	 * @return 
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ManagerInfo principal = (ManagerInfo)principals.getPrimaryPrincipal();
		ManagerAuthInfo managerAuthInfo = this.managerAuthInfoService.selectManagerAuthInfoByName(principal.getName());
		Set<String> roles = new HashSet<>();
		if(managerAuthInfo != null) {
			roles.add(managerAuthInfo.getRoleName());
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
		return simpleAuthorizationInfo;
	}

}
