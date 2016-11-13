package com.tc.tccp.web.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tc.tccp.core.entity.Studio;
import com.tc.tccp.core.page.PageParameter;
import com.tc.tccp.core.util.ResponseUtil;
import com.tc.tccp.web.service.StudioService;

/**
 * @author wangpei
 * @version 创建时间：2016年10月11日 下午5:55:27 studio管理，实现studio的增删改差
 */
@Controller
@RequestMapping(value = "/studio")
public class StudioController {

	@Resource
	private StudioService studioService;
	
	@RequestMapping(value = "/page")
	public String studio() {
		System.out.println("studiozhuye");
		return "test/list";
	}

	
	@RequestMapping("/add")
	public Boolean addStudio(HttpServletRequest request,
			HttpServletResponse response,String context) {
		Studio stu=new Studio();
		String studio_name=request.getParameter("studio_name");
		int  row=Integer.parseInt(request.getParameter("row"));
		int  col=Integer.parseInt(request.getParameter("col"));
		String introduction=request.getParameter("introduction");
		
		stu.setStudio_col_count(col);
		stu.setStudio_row_count(row);
		stu.setStudio_name(studio_name);
		stu.setStudio_introduction(introduction);
		stu.setStudio_flag(0);
		System.out.println("studio_name="+studio_name);
		System.out.println("studio_col="+col);
		System.out.println("studio_row="+row);
 		boolean result=false;
		result=studioService.addStudio(stu);
		return result;
}
	@RequestMapping("/delete")
	public void deleteStudio(/*@RequestParam(value="ids")String ids,*/HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=request.getParameter("ids") ;
		String[] idStr =ids.split(",");
		JSONObject jsonObject = new JSONObject();
		for (String id : idStr){
			studioService.deleteById(Integer.parseInt(id));
		}
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		//return null;
		
		//return result;
		
	}
	@RequestMapping("/update")
	public void updateStudio(HttpServletRequest request,
			HttpServletResponse response) {
		Boolean result=false;
		
		Studio stu=new Studio();
		int studio_id=Integer.parseInt(request.getParameter("studio_id"));
		String studio_name=request.getParameter("studio_name");
		int  row=Integer.parseInt(request.getParameter("row"));
		int  col=Integer.parseInt(request.getParameter("col"));
		String introduction=request.getParameter("introduction");
		stu.setStudio_id(studio_id);
		stu.setStudio_col_count(col);
		stu.setStudio_row_count(row);
		stu.setStudio_name(studio_name);
		stu.setStudio_introduction(introduction);
		System.out.println(studio_id);
		result=studioService.updateStudio(stu);
	
		
	}
	@RequestMapping("/findByUsername")
	public String find(HttpServletRequest request,
			HttpServletResponse response,String StudioName) {
		List<Studio> stu=null;
 		stu=studioService.findStudio(StudioName);
		return stu.toString();
		
	}
	
	

	@RequestMapping("getAll")
	@ResponseBody
	public Map<String, Object> get(HttpServletRequest request,
			HttpServletResponse response, 
			Integer page/* 当前页 */, Integer rows/* 每页显示的数量 */) {
		// 当前页
		int intPage = page == null ||  page <= 0 ? 1 : page;
		// 设置每页显示的数量
		int intPageSize = rows == null || rows <= 0 ? 10 : rows;
		PageParameter page1 = new PageParameter();
		System.out.println("当前页="+intPage);
		System.out.println("一页的条数="+intPageSize);
		page1.setCurrentPage(intPage);
		page1.setPageSize(intPageSize);
		PageHelper.startPage(intPage, intPageSize);
		List<Studio> d = studioService.findAllStudioByPage(page1); // 取商品列表
		PageInfo<Studio> pageInfo = new PageInfo<Studio>(d);
		Map<String, Object> reMap = new HashMap<String, Object>();
		// 取分页信息
		reMap.put("total", pageInfo.getTotal()); // 总条数
		reMap.put("pageSize", intPageSize); // 每页显示的数量
		reMap.put("pageNo", intPage); // 当前页数
		reMap.put("rows", d); // 从数据库中获取的列表信息

		long total = pageInfo.getTotal(); // 获取总记录数
		return reMap;
	}

}
