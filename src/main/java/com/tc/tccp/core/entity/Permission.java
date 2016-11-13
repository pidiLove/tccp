package com.tc.tccp.core.entity; 

import java.io.Serializable;
import java.util.List;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年9月23日 下午12:37:55 
 * 类说明 
 */
public class Permission implements Serializable {  
	  
    private static final long serialVersionUID = -8025597823572680802L;  
  
    private String id;  
    private String permissionName;  
    private List<Role> role;  
    public Permission() {  
        super();  
    }  
  
    // --------------------------------------------------------------------------------------  
  
    @Override  
    public int hashCode() {  
        final int prime = 31;  
        int result = 1;  
        result = prime * result + ((id == null) ? 0 : id.hashCode());  
        return result;  
    }  
  
    @Override  
    public boolean equals(Object obj) {  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Permission other = (Permission) obj;  
        if (id == null) {  
            if (other.id != null)  
                return false;  
        } else if (!id.equals(other.id))  
            return false;  
        return true;  
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	
  
    // --------------------------------------------------------------------------------------  
  
  
  
}  