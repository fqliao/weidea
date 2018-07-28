package cn.webank.weidea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.webank.weidea.entity.User;
import cn.webank.weidea.model.LoginRequest;
import cn.webank.weidea.model.Result;
import cn.webank.weidea.service.UserService;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		User user = new Gson().fromJson("", new TypeToken<Result<String>>() {
		}.getType());
		System.out.println(user.getName());
	}

	@ResponseBody
	@RequestMapping(value = "api/login", method = RequestMethod.POST)
	public boolean login(@RequestBody String requestBody, HttpSession session) {
		LoginRequest loginReq = new Gson().fromJson(requestBody, LoginRequest.class);

		User user = new User();
		user.setIdCard(loginReq.getIdCard());
		user.setUsername(loginReq.getName());
		user.setPassword(loginReq.getPassword());

		LOGGER.debug("user:" + user);
		userService.login(user);
		session.setAttribute("user", user);
		return true;
	}

}
