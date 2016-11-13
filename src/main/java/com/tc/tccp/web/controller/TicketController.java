package com.tc.tccp.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tc.tccp.web.dao.TicketDao;
 
/** 
 * @author wangpei 
 * @version 创建时间：2016年11月5日 下午12:55:09 
 * 类说明 
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
	@Resource
	private TicketDao ticketDao;
	
	
	
	@RequestMapping(value = "/page")
	public String studio(){
		System.out.println("studiozhuye");
		return "test/studio";
	}
	

}
