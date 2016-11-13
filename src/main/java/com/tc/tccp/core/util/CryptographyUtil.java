package com.tc.tccp.core.util; 

import org.apache.shiro.crypto.hash.Md5Hash;

/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年9月25日 上午10:06:16 
 * md5加密类
 */
public class CryptographyUtil {
	

	    /** * @Description 使用Shiro中的md5加密 * @param str * @param salt * @return */
	    public static String md5(String str,String salt){
	        //Md5Hash是Shiro中的一个方法
	        return new Md5Hash(str, salt).toString();
	    }

	    //我自己生成一下测试用的
	    public static void main(String[] args) {
	        String password="123456";

	        System.out.println("Md5加密："+CryptographyUtil.md5(password, "eson_15"));
	    }
	}

 