package com.tc.tccp.web.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tc.tccp.core.entity.Permission;
import com.tc.tccp.core.entity.Role;
import com.tc.tccp.core.entity.User;

public interface UserDao {
	public User getUserByUsername(String username);
	public String getRoleByUsername(String username);
	public List<String> getPermissionByUsername(String username);
}
