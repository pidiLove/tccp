package com.tc.tccp.core.shiro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.tc.tccp.core.entity.Permission;
import com.tc.tccp.core.entity.Role;
import com.tc.tccp.core.entity.User;
import com.tc.tccp.web.dao.UserDao;

/**
 * @author wangpei
 * @version 创建时间：2016年9月24日 下午1:53:20 
 * 类说明
 */
public class MyRealm extends AuthorizingRealm {
	@Autowired
	UserDao userService;

	/*
	 * 授权
	 */ 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = String.valueOf(principals.getPrimaryPrincipal());
		System.out.println(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("***********"+userService.getRoleByUsername(username));
        authorizationInfo.addRole(userService.getRoleByUsername(username));
       authorizationInfo.addStringPermissions(userService.getPermissionByUsername(username));
        return authorizationInfo;
	}

	/*
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = (String) token.getPrincipal(); // 根据刚刚传过来的获取用户名
		String password = new String((char[]) token.getCredentials());
		System.out.println(username);
		System.out.println(password);
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);

		User us = userService.getUserByUsername(username); // 根据用户名从数据库中查询us信息

		if (us != null) {
			SecurityUtils.getSubject().getSession().setAttribute("user", us);// 把当前用户存到session中
			SecurityUtils.getSubject().getSession().setTimeout(1000);  
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
			us.getUsername(), us.getPassword(), "MyRealm");
			return authcInfo;
		} else {
			return null;
		}

	}


}
