package cn.webank.weidea.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.dao.QueryRecordRepository;
import cn.webank.weidea.dto.SearchQueryRecordReq;
import cn.webank.weidea.entity.MedicalQueryRecord;
import cn.webank.weidea.entity.MedicalRecord;
import cn.webank.weidea.model.QueryRecordResponse;

@Service
public class QueryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(QueryService.class);

	@Autowired
	QueryRecordRepository queryRecordRepository;

	private List<MedicalQueryRecord> getqueryRecordList(SearchQueryRecordReq searchQueryRecordReq) {

		int count = queryRecordRepository.count();
		LOGGER.info("=====获取到的医生查询记录有：" + count + "条");
		List<MedicalQueryRecord> result = new ArrayList();
		for (int i = 0; i < count; i++) {
			MedicalQueryRecord mqr = queryRecordRepository.findByIndex(i);
			LOGGER.info("处理查询记录：" + mqr.toString());
			if (filterByCondition(searchQueryRecordReq, mqr)) {
				result.add(mqr);
			}
		}
		return result;
	}

	public List<QueryRecordResponse> getqueryRecord(SearchQueryRecordReq searchQueryRecordReq) {

		List<MedicalQueryRecord> medicalQueryRecords = getqueryRecordList(searchQueryRecordReq);
		Map<String, QueryRecordResponse> queryRecordResponsesMap = new HashMap<>();

		for (MedicalQueryRecord medicalQueryRecord : medicalQueryRecords) {
			String key = medicalQueryRecord.getHospitalAndDoctor() + medicalQueryRecord.getDate();
			if (!queryRecordResponsesMap.containsKey(key)) {
				queryRecordResponsesMap.put(key, new QueryRecordResponse(medicalQueryRecord.getIdCard(),
						medicalQueryRecord.getHospitalAndDoctor(), medicalQueryRecord.getDate(), ""));

			}
			QueryRecordResponse queryRecordResponse = queryRecordResponsesMap.get(key);
			queryRecordResponse.getNumberSet().add(String.valueOf(medicalQueryRecord.getIndex()));
			// queryRecordResponse
			// .setNumberRecord(queryRecordResponse.getNumberRecord() + "," +
			// medicalQueryRecord.getIndex());
		}
		for (QueryRecordResponse queryRecordResponse : queryRecordResponsesMap.values()) {
			StringBuilder stringBuilder = new StringBuilder();
			for (String number : queryRecordResponse.getNumberSet()) {
				stringBuilder.append(number + ",");
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			queryRecordResponse.setNumberRecord(stringBuilder.toString());
			queryRecordResponse.setNumberSet(null);
		}
		List<QueryRecordResponse> recordResponsesList = new ArrayList<>();
		recordResponsesList.addAll(queryRecordResponsesMap.values());
		return recordResponsesList;
	}
	// public convertTo() {
	//
	// }

	void verifyParam() {

	}

	boolean filterByCondition(SearchQueryRecordReq searchQueryRecordReq, MedicalQueryRecord mqr) {

		return true;
	}

}
