package com.tc.tccp.web.dao;

import com.tc.tccp.core.entity.Ticket;

/** 
 * @author wangpei 
 * @version 创建时间：2016年11月5日 下午12:05:54 
 * 类说明 
 */
public interface TicketDao {
	//对票锁定30分钟
	//删除票的信息
	//票锁
	public int lockTicket(Ticket ticket);
	//票解锁
	public int unlockTicket(int ID);
	

}
