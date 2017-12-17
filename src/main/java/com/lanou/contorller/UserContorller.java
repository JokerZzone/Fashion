package com.lanou.contorller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String confirmUser(User user, HttpSession session) {
		User nowUser = userService.confirmUser(user.getUsername());
		if (nowUser != null && user.getPassword().equals(nowUser.getPassword())) {
			session.setAttribute("user", nowUser);
			return "success";
		} else {
			return "error";// 用户名或密码错误
		}
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
	public int reg(User user, String password2,HttpSession session) {
		
		if (!password2.equals(user.getPassword())) {
			return 0;// 两次密码不一致
		}
		userService.addUser(user);
		session.setAttribute("user", userService.confirmUser(user.getUsername()));
		return userService.confirmUser(user.getUsername()).getuId();
	}

	// 修改密码
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public String updatePassword(User user, String oldPassword, String password2,HttpSession session) {
		User user3 = (User) session.getAttribute("user");
		int uId = user3.getuId();
		String result = null;
		User user2 = userService.selectUserByUId(uId);
		if (user2 == null || !oldPassword.equals(user2.getPassword())) {
			return "error1";// 原密码错误
		} else {
			if (user.getPassword().equals(password2)) {
				user.setuId(uId);
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
	public User lookPersonalInfo(HttpSession session) {
		User user3 = (User) session.getAttribute("user");
		System.out.println(user3);
		int uId = user3.getuId();
		return userService.selectUserByUId(uId);
	}

	// 修改个人资料
	@RequestMapping(value = "/updatePersonalInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updatePersonalInfo(User user,HttpSession session) {
		User user3 = (User) session.getAttribute("user");
		user.setuId(user3.getuId());
		userService.updateUserByUId(user);
		return "success";
	}

	
	//卖家版
	
	//查找所有user分页展示
	//会员名称模糊查询
	@RequestMapping(value="/selectUserByNowPage",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectUserByNowPage(@RequestParam(value="username",required=false,defaultValue="") String username,
			int nowPage) {
		Page page = new Page(userService.selectUserCount(username), nowPage);
		Map<String, Object> map = new HashMap<>();
		map.put("userList", userService.selectUserByNowPage(username, page.getStartPos(), page.getPageSize()));
		map.put("page", page);
		return map;
	}
	
	//退出登录
	@RequestMapping("/exit")
	public void exit(HttpSession session) {
		session.removeAttribute("user");
	}
	
	@InitBinder("user")
	public void initUser(WebDataBinder wBinder) {
		wBinder.setFieldDefaultPrefix("user.");
	}

}
