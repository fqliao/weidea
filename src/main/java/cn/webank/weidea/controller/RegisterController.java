package cn.webank.weidea.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.webank.weidea.entity.User;

@Controller
public class RegisterController {
	
	@ResponseBody	
	@RequestMapping(value="api/register")
	public boolean register(HttpServletRequest req,HttpServletResponse res){
		
		User user=new User();
		user.setIdCard(req.getParameter("idCard"));
		user.setUsername(req.getParameter("userName"));
//		user.setPassword(req.getParameter("password"));
		user.setPhone(req.getParameter("phone"));
		if(req.getParameter("sex")!=null) {
			user.setSex(Integer.parseInt(req.getParameter("sex")));
		}
			
		//ceshi
		System.out.println(user.toString());
		
		//加密
		
		//调sdk上链	
	
		return true;
	}
	
	
	
	
	
	
}
