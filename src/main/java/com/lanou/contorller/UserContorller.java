package com.lanou.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.lanou.util.Page;

@Controller
@RequestMapping(value = "/user")
public class UserContorller {

	@Autowired
	private UserService userService;

	// 登录验证
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String confirmUser(User user, HttpServletRequest request) {
		String result = null;
		User nowUser = userService.confirmUser(user.getUsername());
		if (nowUser != null && user.getPassword().equals(nowUser.getPassword())) {
			request.setAttribute("user", nowUser);
			result = "success";
		} else {
			result = "error";// 用户名或密码错误
		}
		return result;
	}

	// 注册用户名失焦
	@RequestMapping(value = "/focusUsername", method = RequestMethod.GET)
	@ResponseBody
	public String focus(User user) {
		String result = null;
		User nowUser = userService.confirmUser(user.getUsername());
		if (nowUser == null) {
			result = "success";
		} else {
			result = "error";
		}
		return result;
	}

	// 注册邮箱失焦
	@RequestMapping(value = "/focusEmail", method = RequestMethod.GET)
	@ResponseBody
	public String focusEmail(User user) {
		String result = null;
		User nowUser = userService.focusEmail(user.getEmail());
		if (nowUser == null) {
			result = "success";
		} else {
			result = "error";
		}
		return result;
	}

	// 注册验证
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public String reg(User user, String password2) {
		
		if (!password2.equals(user.getPassword())) {
			return "error";// 两次密码不一致
		}
		userService.addUser(user);
		return "success";
	}

	// 修改密码
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public String updatePassword(User user, String oldPassword, String password2) {
		String result = null;
		User user2 = userService.selectUserByUId(user.getuId());
		if (user2 == null || !oldPassword.equals(user2.getPassword())) {
			return "error1";// 原密码错误
		} else {
			if (user.getPassword().equals(password2)) {
				userService.updatePassword(user);
				result = "success";
			} else {
				result = "error2";// 两次密码不一致
			}
		}
		return result;
	}

	// 查看个人资料
	@RequestMapping(value = "/lookPersonalInfo", method = RequestMethod.POST)
	@ResponseBody
	public User lookPersonalInfo(User user) {
		return userService.selectUserByUId(user.getuId());
	}

	// 修改个人资料
	@RequestMapping(value = "/updatePersonalInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updatePersonalInfo(User user) {

		userService.updateUserByUId(user);
		return "success";
	}

	//查找所有user分页展示
	@RequestMapping(value="/selectAllUserByNowPage",method=RequestMethod.GET)
	@ResponseBody
	public List<User> selectAllUserByNowPage(int nowPage) {
		Page page = new Page(userService.selectCountOfAllUser(), nowPage);
		return userService.selectAllUserByNowPage(page.getStartPos(), page.getPageSize()); 
	}
	
	@InitBinder("user")
	public void initUser(WebDataBinder wBinder) {
		wBinder.setFieldDefaultPrefix("user.");
	}

}
