package com.tc.tccp.core.entity; 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年10月11日 上午11:22:57 
 * 类说明 
 */
/**
 * @author wp
 *
 */
public class RolePermission {
	private String id;
	private String roleid;
	private String permissionid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}
	
}
 