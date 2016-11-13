package com.tc.tccp.core.entity; 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年10月11日 下午6:17:25 
 * studio
 */
public class Studio {
	private int studio_id;
	private String studio_name;
	private int studio_row_count;
	private int studio_col_count;
	private String studio_introduction;
	private int studio_flag;
	public Studio(){
		
	}
	public Studio(int studio_id, String studio_name, int studio_row_count, int studio_col_count,
			String studio_introduction, int studio_flag) {
		this.studio_id=studio_id;
		this.studio_name=studio_name;
		this.studio_row_count=studio_row_count;
		this.studio_col_count=studio_col_count;
		this.studio_introduction=studio_introduction;
		this.studio_flag=studio_flag;
	}
	
	public int getStudio_id() {
		return studio_id;
	}
	public void setStudio_id(int studio_id) {
		this.studio_id = studio_id;
	}
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	public int getStudio_row_count() {
		return studio_row_count;
	}
	public void setStudio_row_count(int studio_row_count) {
		this.studio_row_count = studio_row_count;
	}
	public int getStudio_col_count() {
		return studio_col_count;
	}
	public void setStudio_col_count(int studio_col_count) {
		this.studio_col_count = studio_col_count;
	}
	public String getStudio_introduction() {
		return studio_introduction;
	}
	public void setStudio_introduction(String studio_introduction) {
		this.studio_introduction = studio_introduction;
	}
	public int getStudio_flag() {
		return studio_flag;
	}
	public void setStudio_flag(int studio_flag) {
		this.studio_flag = studio_flag;
	}
	public String toString(){
		return "studio_id="+studio_id+"studio_name="
	+studio_name+"studio_row_count=_"+studio_row_count+"studio_col_count="+studio_col_count+
	"studio_introduction="+studio_introduction+"studio_flag="+studio_flag;
		
	}
	
 

}
 