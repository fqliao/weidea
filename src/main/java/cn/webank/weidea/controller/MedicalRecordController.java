package cn.webank.weidea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.webank.weidea.dto.SaveMedicalRecordReq;
import cn.webank.weidea.dto.SearchMedicalRecordReq;
import cn.webank.weidea.entity.Hospital;
import cn.webank.weidea.entity.MedicalRecord;
import cn.webank.weidea.entity.User;

@Controller
public class MedicalRecordController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordController.class);
	
	@RequestMapping(value="api/record",method=RequestMethod.POST)
	public @ResponseBody Gson searchMedicalRecord(
			@RequestBody String requestBody,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		Gson response = new Gson();
		//获取前端提交的信息
		Gson request = new Gson();
		SearchMedicalRecordReq searchMedicalRecordReq = new SearchMedicalRecordReq();
		searchMedicalRecordReq = request.fromJson(requestBody,SearchMedicalRecordReq.class);
		
		return response;
	}
	
	@RequestMapping(value="api/saveRecord",method=RequestMethod.POST)
	public @ResponseBody Gson saveMedicalRecord(
			@RequestBody String requestBody,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		Gson response = new Gson();
		//获取前端提交的信息
		Gson request = new Gson();
		SaveMedicalRecordReq saveMedicalRecordReq = new SaveMedicalRecordReq();
		saveMedicalRecordReq = request.fromJson(requestBody,SaveMedicalRecordReq.class);
		
		
		Hospital hospital = new Hospital();
		hospital.setOrganizationCodeNumber(saveMedicalRecordReq.getHospital());
		User user = new User();
		user.setIdCard(saveMedicalRecordReq.getIdCard());
		
		return response;
	}
	
	public static void main(String[] args) {
		String requestBody = "{'category':'530421199612070260','item':'HX99665780'}";
		Gson testInfo = new Gson();
		MedicalRecord test = testInfo.fromJson(requestBody, MedicalRecord.class);
		System.out.println(test.getCategory()+test.getItem());
	}
	
}
