package cn.webank.weidea.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.dao.MedicalRecordRepository;
import cn.webank.weidea.dto.SaveMedicalRecordReq;
import cn.webank.weidea.dto.SearchMedicalRecordReq;
import cn.webank.weidea.entity.MedicalRecord;

@Service
public class RecordService {
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RecordService.class);
	
	public boolean savaRecord(SaveMedicalRecordReq record) {
		
		MedicalRecord mr=convertToMedicalRecord(record);
		if(varifyRecord(mr)) {
			medicalRecordRepository.save(mr);
			return true;
		}
		return false;
	}
	
	public List<MedicalRecord> searchRecord(SearchMedicalRecordReq searchMedicalRecordReq) {
		
		List<MedicalRecord> records=new ArrayList();
		int count=medicalRecordRepository.count();
		for(int i=0;i<count;i++) {
			MedicalRecord mr=medicalRecordRepository.findByIndex(i);
			if(filterRecordByCondition(searchMedicalRecordReq,mr)) {
				records.add(mr);
				
				//增加查询记录
				
			}
		}
		return records;
		
	}
	
	boolean filterRecordByCondition(SearchMedicalRecordReq smr,MedicalRecord record){
		if(record.getIdCard().equals(smr.getIdCard())) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startdate = sdf.format(smr.getStartTime());
			String enddate=sdf.format(smr.getEndTime());
			if(compare_date(record.getDate(),startdate)!=1&&
					compare_date(record.getDate(),enddate)!=-1){
					if(record.getCategory().equals(smr.getCategory()))
						return true;
			}
		}
		return false;
	}
	
	private MedicalRecord convertToMedicalRecord(SaveMedicalRecordReq record) {
		MedicalRecord mr=new MedicalRecord();
		mr.setIdCard(record.getIdCard());
		mr.setHospitalAndDoctor(record.getHospital());
		mr.setCategory(record.getCategory());
		mr.setItem(record.getItem());		
		mr.setProposal(record.getProposal());
		//测试LULU
		mr.setDiagnosis("xxxxxx");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(record.getDate());
		mr.setDate(date);
		return mr;
	} 
	
	
	private boolean varifyRecord(MedicalRecord record) {
		
		//验证
		
		return true;
	}
	
	private int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

	
	
	
	
}
