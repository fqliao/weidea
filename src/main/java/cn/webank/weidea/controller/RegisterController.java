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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.webank.weidea.entity.User;

@Controller
public class RegisterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	@ResponseBody
	@RequestMapping(value = "api/register")
	public boolean register(HttpServletRequest request) {
		BufferedReader br;
		StringBuilder sb = null;
		JSONObject jsonObject = null;
		try {
			br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line = null;
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			jsonObject = JSONObject.parseObject(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		User user=new User();
		if(jsonObject!=null) {
			user.setIdCard(jsonObject.getString("idCard"));
			user.setUsername(jsonObject.getString("userName"));
			user.setToken(jsonObject.getString("password"));
			user.setPhone(jsonObject.getString("phone"));
			if(jsonObject.getString("sex")!=null) {
				user.setSex(Integer.parseInt(jsonObject.getString("sex")));
			}			
		}
		System.out.println(user.toString());

		// 加密

		// 调sdk上链

		return true;
	}

}
