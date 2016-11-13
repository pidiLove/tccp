package com.tc.tccp.core.entity; 

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年9月23日 上午11:56:09 
 * 角色表
 */
public class Role implements Serializable {  
	  
    private static final long serialVersionUID = -4987248128309954399L;  
  
    private String id;  
    private String rolename;  
  //  private String permissionId ;  
    private List<Permission> permission;   

    public Role() {  
        super();  
    }  
      
    // --------------------------------------------------------------------------------  
  
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
        Role other = (Role) obj;  
        if (id == null) {  
            if (other.id != null)  
                return false;  
        } else if (!id.equals(other.id))  
            return false;  
        return true;  
    }  
      
    // --------------------------------------------------------------------------------  
  
    
  
    

	public String getId() {
		return id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	
  
    
  
}  