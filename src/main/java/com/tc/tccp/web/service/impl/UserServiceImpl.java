package com.tc.tccp.web.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tc.tccp.core.entity.User;
import com.tc.tccp.core.exception.EntityException;
import com.tc.tccp.web.dao.UserDao;
import com.tc.tccp.web.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	
	
	@Autowired
	private static UserDao userDao;
	

	@Override
	public User getUserByUsername(String username) {
		//User us=null;
		String name="wp";
		try{
			
			return  userDao.getUserByUsername(name);
			//return us;
		}catch(EntityException e){
			System.out.println("查找用户失败");
			 throw new EntityException("查找用户错误",e);
		}
	
	}



	@Override
	public String getRoleByUsername(String username) {
		try{
			String rolename=userDao.getRoleByUsername(username);
			return rolename;
		}catch(EntityException e){
			 throw new EntityException("查找用户对应的角色错误",e);
			 }
	}



	@Override
	public List<String> getPermissionByUsername(String username) {
		try{
			List<String> permissionname=userDao.getPermissionByUsername(username);
			return permissionname;
		}catch(EntityException e){
			 throw new EntityException("查找角色对应的权限错误",e);
		}
	}
public static void main(String[] args) {
	User d=userDao.getUserByUsername("wp");
	System.out.println(d.toString());
}

}
