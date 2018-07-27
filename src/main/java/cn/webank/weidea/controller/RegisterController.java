package cn.webank.weidea.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import cn.webank.weidea.entity.User;
import cn.webank.weidea.service.RegisterService;

@Controller
public class RegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	RegisterService registerService;

	@ResponseBody
	@RequestMapping(value = "api/register")
	public boolean register(HttpServletRequest req, @RequestBody String requestBody) {
		//获取json数据
		JSONObject jsonObject=null;
		if(requestBody!=null) {
			jsonObject = JSONObject.parseObject(requestBody.toString());
		}		
		User user=new User();
		if(jsonObject!=null) {
			LOGGER.info("获取到用户注册信息: "+jsonObject.toString());
			user.setIdCard(jsonObject.getString("idCard"));
			user.setUsername(jsonObject.getString("userName"));
			user.setToken(jsonObject.getString("password"));
			user.setPhone(jsonObject.getString("phone"));
			if(jsonObject.getString("sex")!=null) {
				user.setSex(Integer.parseInt(jsonObject.getString("sex")));
			}			
		}
		registerService.register(user);
		return true;
	}

}
