package com.tc.tccp.web.service;

import java.util.List;
import java.util.Map;

import com.tc.tccp.core.entity.User;


public interface UserService {
	public User getUserByUsername(String username);
	public String getRoleByUsername(String username);
	public List<String> getPermissionByUsername(String username);

}
