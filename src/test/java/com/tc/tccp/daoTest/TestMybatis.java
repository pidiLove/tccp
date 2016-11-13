package com.tc.tccp.daoTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tc.tccp.core.entity.Permission;
import com.tc.tccp.core.entity.Studio;
import com.tc.tccp.core.entity.Ticket;
import com.tc.tccp.core.entity.User;
import com.tc.tccp.core.page.PageParameter;
import com.tc.tccp.web.dao.StudioDao;
import com.tc.tccp.web.dao.TicketDao;
import com.tc.tccp.web.dao.UserDao;

 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-application.xml")
public class TestMybatis {
	
	@Autowired
	private TicketDao test;
	
	@org.junit.Test
	public void testInsert(){
		PageParameter k=new PageParameter();
		
		k.setCurrentPage(1);
		k.setPageSize(5);
		 /* 
String abcValue = sdf.format(now);
String sql = "update table set abc='"+abcValue+"' where ......";*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		Ticket d=new Ticket();
		String abcValue = sdf.format(now);
 		d.setTicket_id(1);
		d.setTicket_locked_time(abcValue);
		System.out.println(test.lockTicket(d));
	}
	
	
	
	
//	@org.junit.Test
//	public void testFind(){
//		System.out.println(test.find("04131004").toString());
//	}
//	
//	@org.junit.Test
//	public void testUpdate(){
//		Test test1 = new Test("04131004", "updateName");
//		System.out.println(test.update(test1));
//	}
//	
//	@org.junit.Test
//	public void testFindAll(){
//		List<Test> list = test.findAll();
//		for (Test test : list) {
//			System.out.println(test.toString());
//		}
//	}
//	
//	@org.junit.Test
//	public void testDelete(){
//		System.out.println(test.delete("04131004"));
//	}
//	
//	
}
