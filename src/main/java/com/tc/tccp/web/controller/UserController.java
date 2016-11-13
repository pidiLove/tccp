package com.tc.tccp.web.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.tc.tccp.core.entity.User;
import com.tc.tccp.core.util.CryptographyUtil;
import com.tc.tccp.core.util.ValidateCode;
import com.tc.tccp.web.dao.UserDao;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private UserDao userDao;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	// public void doGet(HttpServletRequest request, HttpServletResponse
	// response) {
	// // 得到请求参数method,判断当前是什么操作
	// String method = request.getParameter("method");
	//
	// if ("login".equals(method)) { // 登录操作台
	// login(request, response);
	// } else if ("regist".equals(method)) { // 注册操作
	// regist(request, response);
	// } else if ("logout".equals(method)) {
	// // 注销操作
	// logout(request, response);
	// } else if ("activeuser".equals(method)) {
	// activecode(request, response);
	// }
	//
	// }
	/* 用户登录操作 */
	@RequestMapping(value = "/login")
	public String login(User us, HttpServletRequest request) {

		// 判断验证码
		String code = (String) request.getParameter("validateCode"); // 获取到的验证码
		String submitCode = WebUtils.getCleanParam(request, "validateCode"); // 获取到提交的验证码
		System.out.println(code);
		System.out.println(submitCode);
		if (code == null || !code.equals(submitCode)) {
			System.out.println("验证码不正确");
			return "test/login";
		}

		// us.setUsername("wpwpwp");
		// us.setPassword("123123");
		System.out.println("***" + request.getParameter("username"));
		System.out.println("****" + request.getParameter("password"));

		System.out.println(us.getUsername());
		System.out.println(us.getPassword());
		String username = us.getUsername();
		String password = us.getPassword();
		if (username == null || password == null) {
			System.out.println("登录失败:请检查您的用户名和密码！");
			return "test/login";
		}
		Subject subject = SecurityUtils.getSubject(); // 获取当前登陆的主体
		Session session = subject.getSession();
		session.setTimeout(60000);
		System.out.println(session.getTimeout());
		String newpassword = CryptographyUtil.md5(password, "eson_15");// 将密码使用md5加密
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				newpassword);
		try {
			subject.login(token); // 会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证

			return "test/zhuye";

		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("用户名或密码错误");
			// request.setAttribute("user", us);
			// request.setAttribute("errorInfo", "用户名或密码错误");
			return "test/login"; // 如果认证失败，则跳会登录页面并提示错误信息
		}

	}
	
	@RequestMapping(value = "/page")
	public String studio(){
		System.out.println("studiozhuye");
		return "test/studio";
	}

	// @RequestMapping(value = "/login")
	// public String regist(User us, HttpServletRequest request) {
	//
	// // 判断验证码
	// String code = (String) request.getParameter("validateCode"); //获取到的验证码
	// String submitCode = WebUtils.getCleanParam(request, "validateCode");
	// //获取到提交的验证码
	// System.out.println(code);
	// System.out.println(submitCode);
	// if (code==null || !code.equals(submitCode))
	// {
	// System.out.println("验证码不正确");
	// return "test/login";
	// }
	//
	//
	// System.out.println("***"+request.getParameter("emp_no"));
	// System.out.println("****"+request.getParameter("password"));
	//
	// System.out.println(us.getUsername());
	// System.out.println(us.getPassword());
	// String username = us.getUsername();
	// String password = us.getPassword();
	// if (username == null || password == null) {
	// System.out.println("注册失败:请输入非空的用户名和密码！");
	// return "test/login";
	// }
	//
	//
	//
	// String newpassword = CryptographyUtil.md5(password, "eson_15");//
	// 将密码使用md5加密
	//
	// try {
	// userDao.insert(us);
	// return "test/login";
	//
	// } catch (AuthenticationException e) {
	// e.printStackTrace();
	// //request.setAttribute("user", us);
	// //request.setAttribute("errorInfo", "用户名或密码错误");
	// return "test/login"; // 如果认证失败，则跳会登录页面并提示错误信息
	// }
	//
	// }
	//

	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/validateCode")
	public void validateCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-cache");
		String verifyCode = ValidateCode.generateTextCode(
				ValidateCode.TYPE_NUM_ONLY, 4, null);
		request.getSession().setAttribute("validateCode", verifyCode);
		response.setContentType("image/jpeg");
		BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30,
				3, true, Color.WHITE, Color.BLACK, null);
		ImageIO.write(bim, "JPEG", response.getOutputStream());
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String shouquan(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject(); // 获取当前登陆的主体
		if (subject.hasRole("admin")) {
			System.out.println("sdssdds");
			return "/test/zhuye";
		} else {
			System.out.println("wrong");
			return "/test/admin";

		}

	}

	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("userInfo");
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/test/loginout";

	}

}