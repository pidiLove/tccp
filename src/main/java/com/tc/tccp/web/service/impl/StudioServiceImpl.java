package com.tc.tccp.web.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.tccp.core.entity.Studio;
import com.tc.tccp.core.page.PageParameter;
import com.tc.tccp.web.dao.StudioDao;
import com.tc.tccp.web.service.StudioService;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年10月11日 下午6:22:08 
 * 类说明 
 */
@Service ("studioService" )
public class StudioServiceImpl implements StudioService {
	
String emp=null;
	
	@Autowired
	private StudioDao studioDao;
	
	
	@Override
	public boolean addStudio(Studio stu) {
		try{
			 return studioDao.addStudio(stu); 
		}catch(Exception e){
			System.out.println("查找用户失败");
			// throw Exception("查找用户错误",e);
			 return false;
		}
 		 
	}
	
	
	
	

	@Override
	public List<Studio> findStudio(String StudioName) {
		List<Studio> stu = null;
		try {
			 stu=studioDao.findStudio(StudioName);
			
		}catch(Exception e){
			// throw new Exception("查找用户错误",e);
			System.out.println("查找用户失败");
		}
		
		return stu;
	}
	
	
	 
	@Override
	public List<Studio> findAllStudioByPage(PageParameter page){
		try{
         return studioDao.findAllStudioByPage(page);
         }catch(Exception e){
        	 System.out.println("impl异常");
         	 return null;
         }
		
   }
	
	@Override
	public boolean deleteById(int id) {
		Boolean b=false;
		try{
			b = studioDao.deleteById(id);
			 
		}catch(Exception e){
			// throw new EntityException("Error！ when insert the entity",e);
			System.out.println("删除失败");
		}
		return b;
	}

	@Override
	public boolean updateStudio(Studio us) {
		Boolean b=false;

		try{
			b=studioDao.updateStudio(us);
			
		}catch(Exception e){
			// throw new EntityException("Error！ when insert the entity",e);
			System.out.println("更新用户失败");
		}
		return b;
	}
	public static void main(String[] args) {
		PageParameter page=new PageParameter();
		page.setCurrentPage(1);
		page.setPageSize(5);
		System.out.println(new StudioServiceImpl().findAllStudioByPage(page));
		 
	
 	}





//	@Override
//	public boolean deleteMany(int[] id) {
//		Boolean b=false;
//
//		try{
//			b=studioDao.deleteMany(id);
//			
//		}catch(Exception e){
//			// throw new EntityException("Error！ when insert the entity",e);
//			System.out.println("批量删除失败");
//		}
//		return b;
//	
//
// 	}
//
//
//


	

}
 