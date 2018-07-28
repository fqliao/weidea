package cn.webank.weidea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.webank.weidea.dto.SaveMedicalRecordReq;
import cn.webank.weidea.dto.SearchMedicalRecordReq;
import cn.webank.weidea.dto.SearchQueryRecordReq;
import cn.webank.weidea.entity.Hospital;
import cn.webank.weidea.entity.MedicalQueryRecord;
import cn.webank.weidea.entity.MedicalRecord;
import cn.webank.weidea.entity.User;
import cn.webank.weidea.model.RecordRequest;
import cn.webank.weidea.model.QueryRecordResponse;
import cn.webank.weidea.service.QueryService;
import cn.webank.weidea.service.RecordService;

@Controller
public class MedicalRecordController {

	@Autowired
	RecordService recordService;

	@Autowired
	QueryService queryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordController.class);

	@RequestMapping(value = "api/record", method = RequestMethod.POST)

	public @ResponseBody Map<String, List<MedicalRecord>> searchMedicalRecord(@RequestBody String requestBody,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			List<MedicalRecord> mrs = recordService.searchRecord(user.getIdCard(), user.getToken());
			Map<String, List<MedicalRecord>> result = new HashMap();
			result.put("medicalRecords", mrs);
			return result;
		} else {
			// 获取前端提交的信息
			Gson request = new Gson();
			SearchMedicalRecordReq searchMedicalRecordReq = new SearchMedicalRecordReq();
			searchMedicalRecordReq = request.fromJson(requestBody, SearchMedicalRecordReq.class);

			LOGGER.info("========获取到查询条件：" + searchMedicalRecordReq.toString() + "========");

			LOGGER.info("==========开始搜索就诊记录===========");
			List<MedicalRecord> mrs = recordService.searchRecord(searchMedicalRecordReq);

			for (MedicalRecord mr : mrs) {
				LOGGER.info("===========查询到就诊记录： " + mr.toString() + "==============");
			}

			Map<String, List<MedicalRecord>> result = new HashMap();
			result.put("medicalRecords", mrs);
			return result;
		}
	}

	@ResponseBody
	@RequestMapping(value = "api/saveRecord", method = RequestMethod.POST)
	public boolean saveMedicalRecord(@RequestBody String requestBody, HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		Gson response = new Gson();
		// 获取前端提交的信息
		Gson request = new Gson();
		SaveMedicalRecordReq saveMedicalRecordReq = new SaveMedicalRecordReq();
		saveMedicalRecordReq = request.fromJson(requestBody, SaveMedicalRecordReq.class);
		LOGGER.info("========获取到录入信息：" + saveMedicalRecordReq.toString() + "========");
		//
		// Hospital hospital = new Hospital();
		// hospital.setOrganizationCodeNumber(saveMedicalRecordReq.getHospital());
		// User user = new User();
		// user.setIdCard(saveMedicalRecordReq.getIdCard());

		return recordService.savaRecord(saveMedicalRecordReq);
	}

	@RequestMapping(value = "api/searchRecord", method = RequestMethod.POST)
	public @ResponseBody Map<String, List<QueryRecordResponse>> searchQueryRecord(@RequestBody String requestBody) {

		Gson requestJson = new Gson();
		SearchQueryRecordReq searchQueryRecordReq = new SearchQueryRecordReq();
		searchQueryRecordReq = requestJson.fromJson(requestBody, SearchQueryRecordReq.class);
		LOGGER.info("========获取到查询条件：" + searchQueryRecordReq.toString() + "========");

		LOGGER.info("==========开始查询医生记录===========");
		List<QueryRecordResponse> mrs = queryService.getqueryRecord(searchQueryRecordReq);

		LOGGER.info("医生查询记录为：");
		for (QueryRecordResponse re : mrs) {
			LOGGER.info("======获取到医生查询记录：" + re.toString());
		}

		Map<String, List<QueryRecordResponse>> result = new HashMap();
		result.put("infos", mrs);
		return result;
	}

	@RequestMapping(value = "api/onerecord", method = RequestMethod.POST)
	@ResponseBody
	public String getByIndex(@RequestBody String requestBody, HttpSession session) {
		RecordRequest recordRequest = new Gson().fromJson(requestBody, RecordRequest.class);
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			recordRequest.setIdCard(user.getIdCard());
			recordRequest.setPassword(user.getToken());
		}
		return new Gson().toJson(recordService.getRecord(recordRequest));
	}

}
