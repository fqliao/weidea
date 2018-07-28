package cn.webank.weidea.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.dao.QueryRecordRepository;
import cn.webank.weidea.dto.SearchQueryRecordReq;
import cn.webank.weidea.entity.MedicalQueryRecord;
import cn.webank.weidea.entity.MedicalRecord;

@Service
public class QueryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryService.class);

	@Autowired
	QueryRecordRepository queryRecordRepository;
	
	 public List<MedicalQueryRecord> getqueryRecord(SearchQueryRecordReq searchQueryRecordReq){
		
		 int count=queryRecordRepository.count();	
		 LOGGER.info("=====获取到的医生查询记录有："+count+"条");
		 List<MedicalQueryRecord> result=new ArrayList();
		 for(int i=0;i<count;i++) {
			 MedicalQueryRecord mqr=queryRecordRepository.findByIndex(i);
			LOGGER.info("处理查询记录："+mqr.toString());
			if(filterByCondition(searchQueryRecordReq,mqr)) {
					result.add(mqr);			
			}
		 }
		 return result;
	 }
	 
	 void verifyParam() {
		 
	 }
	 
	 boolean filterByCondition(SearchQueryRecordReq searchQueryRecordReq,MedicalQueryRecord mqr) {
		 
		 
		 return true;
	 }
	
}
