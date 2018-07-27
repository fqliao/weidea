package cn.webank.weidea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.webank.weidea.dto.DecryptReq;
import cn.webank.weidea.dto.KeyManagementRsp;
import cn.webank.weidea.dto.SecretKeyReq;
import cn.webank.weidea.entity.KeyManagement;
import cn.webank.weidea.service.KeyManagementService;


@Controller
public class KeyManagementController {
	private static final Logger LOGGER = LoggerFactory.getLogger(KeyManagementController.class);
	
	@Autowired
	KeyManagementService  keyManagementService;
	
	@RequestMapping(value="/secretKey",method=RequestMethod.POST)
	public @ResponseBody String secretKey(
			@RequestBody String requestBody,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		Gson response = new Gson();
		//获取前端提交的信息
		Gson request = new Gson();
		SecretKeyReq keyManagementReq = new SecretKeyReq();
		keyManagementReq = request.fromJson(requestBody,SecretKeyReq.class);
		
		
		KeyManagement keyManagement = new KeyManagement();
		keyManagement.setIdCard(keyManagementReq.getIdCard());
		keyManagement.setToken(keyManagementReq.getToken());
		
		KeyManagementRsp keyManagementRsp = keyManagementService.secretKey(keyManagement);
		String Response = response.toJson(keyManagementRsp);
		
		return Response;
	}
	
	
	@RequestMapping(value="/decrypt",method=RequestMethod.POST)
	public @ResponseBody Gson Decrypt(
			@RequestBody String requestBody,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		Gson response = new Gson();
		//获取前端提交的信息
		Gson request = new Gson();
		DecryptReq decryptReq = new DecryptReq();
		decryptReq = request.fromJson(requestBody,DecryptReq.class);
		
		
		KeyManagement keyManagement = new KeyManagement();
		keyManagement.setIdCard(decryptReq.getIdCard());
		keyManagement.setToken(decryptReq.getToken());
		
		
		
		
		return response;
	}
	
}
