package com.tc.tccp.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tc.tccp.core.entity.Studio;
import com.tc.tccp.core.page.PageParameter;

/**
 * @author wangpei
 * @version 创建时间：2016年10月11日 下午6:20:32 类说明
 */

public interface StudioDao {
	public boolean addStudio(Studio stu);

	public List<Studio> findStudio(String StudioName);// 根据演出厅名称查找演出厅

	public List<Studio> findAllStudioByPage(PageParameter page);// 查找所有的演出厅

	public boolean deleteById(int id);// 根据演出厅名称删除演出厅

	public boolean updateStudio(Studio us);// 修改演出厅
	
	//public boolean deleteMany(int []id);//对多个含id的studio进行批量删除
	// public User findbyusernameandpassword(Map<String,String> map);
	// public User getbyusername(String currentUsername);
	// public List<String> getRoles(String username);
	// public List<Studio> findStudiorrr();
	

}
