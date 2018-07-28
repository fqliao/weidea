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
import cn.webank.weidea.dao.QueryRecordRepository;
import cn.webank.weidea.dao.UserRepository;
import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.dto.SaveMedicalRecordReq;
import cn.webank.weidea.dto.SearchMedicalRecordReq;
import cn.webank.weidea.entity.MedicalQueryRecord;
import cn.webank.weidea.entity.MedicalRecord;
import cn.webank.weidea.util.EncryptUtils;
import cn.webank.weidea.util.HttpUtil;

@Service
public class RecordService {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	QueryRecordRepository queryRecordRepository;
	@Autowired
	private SecretKeyService secretKeyService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RecordService.class);

	public boolean savaRecord(SaveMedicalRecordReq record) {

		try {
			MedicalRecord mr = convertToMedicalRecord(record);
			if (varifyRecord(mr)) {
				String publicKey = userRepository.findPublishKey(record.getIdCard());
				if (publicKey == null || publicKey.length() == 0) {
					throw new CheckException("该身份证未注册");
				}
				MedicalRecord decryptMeicalRecord = new MedicalRecord();
				EncryptUtils encryptUtils = new EncryptUtils();
				// encryptUtils.Encrypt(publicKey, text)
				decryptMeicalRecord.setCategory(encryptUtils.Encrypt(publicKey, mr.getCategory()));
				decryptMeicalRecord.setDate(encryptUtils.Encrypt(publicKey, mr.getDate()));
				decryptMeicalRecord.setDiagnosis(encryptUtils.Encrypt(publicKey, mr.getDiagnosis()));
				decryptMeicalRecord.setProposal(encryptUtils.Encrypt(publicKey, mr.getProposal()));
				decryptMeicalRecord.setHospitalAndDoctor(encryptUtils.Encrypt(publicKey, mr.getHospitalAndDoctor()));
				decryptMeicalRecord.setItem(encryptUtils.Encrypt(publicKey, mr.getItem()));
				decryptMeicalRecord.setIdCard(mr.getIdCard());
				medicalRecordRepository.save(decryptMeicalRecord);
				LOGGER.info("==========成功写入就诊记录：" + mr.toString() + "=======");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public List<MedicalRecord> searchRecord(String idCard, String token) {
		List<MedicalRecord> records = new ArrayList();
		int count = medicalRecordRepository.count();
		LOGGER.info("===========从链上查询到就诊记录共有：" + count + "条");
		for (int i = 0; i < count; i++) {
			MedicalRecord encryptMedicalRecord = medicalRecordRepository.findByIndex(i);
			MedicalRecord mr = new MedicalRecord();
			mr.setCategory(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getCategory()));
			mr.setDiagnosis(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getDiagnosis()));
			mr.setHospitalAndDoctor(
					secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getHospitalAndDoctor()));
			mr.setItem(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getItem()));
			mr.setProposal(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getProposal()));
			mr.setDate(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getDate()));
			mr.setIdCard(idCard);

			records.add(mr);
		}

		return records;

	}

	public List<MedicalRecord> searchRecord(SearchMedicalRecordReq searchMedicalRecordReq) {
		String idCard = searchMedicalRecordReq.getIdCard();
		String token = searchMedicalRecordReq.getPassword();
		String publicKey = userRepository.findPublishKey(idCard);
		if (publicKey == null || publicKey.length() == 0) {
			throw new CheckException("该身份证未注册");
		}
		List<MedicalRecord> records = new ArrayList();
		int count = medicalRecordRepository.count();
		LOGGER.info("===========从链上查询到就诊记录共有：" + count + "条");
		for (int i = 0; i < count; i++) {
			MedicalRecord encryptMedicalRecord = medicalRecordRepository.findByIndex(i);
			MedicalRecord mr = new MedicalRecord();
			mr.setCategory(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getCategory()));
			mr.setDiagnosis(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getDiagnosis()));
			mr.setHospitalAndDoctor(
					secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getHospitalAndDoctor()));
			mr.setItem(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getItem()));
			mr.setProposal(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getProposal()));
			mr.setDate(secretKeyService.getPlaintext(idCard, token, encryptMedicalRecord.getDate()));
			mr.setIdCard(idCard);

			LOGGER.info("处理就诊记录：" + mr.toString());
			if (filterRecordByCondition(searchMedicalRecordReq, mr)) {
				records.add(mr);
				addQueryRecord(searchMedicalRecordReq, i);
			}
		}

		return records;
	}

	private void addQueryRecord(SearchMedicalRecordReq searchMedicalRecordReq, int index) {
		MedicalQueryRecord mqr = new MedicalQueryRecord();
		mqr.setIdCard(searchMedicalRecordReq.getIdCard());
		// mqr.setHospitalAndDoctor(searchMedicalRecordReq.getHospital());
		mqr.setHospitalAndDoctor("hospitalAndDoctor");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		mqr.setDate(date);
		mqr.setIndex(index);
		queryRecordRepository.save(mqr);
		LOGGER.info("=====写入医生查询记录：" + mqr.toString() + "=====");
	}

	boolean filterRecordByCondition(SearchMedicalRecordReq smr, MedicalRecord record) {
		if (!record.getIdCard().equals(smr.getIdCard())) {
			System.out.println("record.IdCard======================" + record.getIdCard() + "=================");
			System.out.println("smr.IdCard======================" + smr.getIdCard() + "=================");
			return false;
		}
		// 校验token--LULU

		/*
		 * if(smr.getStartTime()!=null&&smr.getEndTime()!=null) { SimpleDateFormat sdf =
		 * new SimpleDateFormat("yyyy-MM-dd"); String startdate =
		 * sdf.format(smr.getStartTime()); String enddate=sdf.format(smr.getEndTime());
		 * if(!(compare_date(record.getDate(),startdate)!=1&&
		 * compare_date(record.getDate(),enddate)!=-1)) return false; }
		 * if(record.getCategory()!=null &&
		 * !record.getCategory().equals(smr.getCategory())) return false;
		 */
		if (record.getCategory() != null && !record.getCategory().equals(smr.getCategory())) {
			System.out.println(
					"record.getCategory()==============================" + record.getCategory() + "==================");
			System.out.println(
					"smr.getCategory()==============================" + smr.getCategory() + "==================");

			return false;
		}
		return true;
	}

	private MedicalRecord convertToMedicalRecord(SaveMedicalRecordReq record) {
		MedicalRecord mr = new MedicalRecord();
		mr.setIdCard(record.getIdCard());
		mr.setHospitalAndDoctor(record.getHospital());
		mr.setCategory(record.getCategory());
		mr.setItem(record.getItem());
		mr.setProposal(record.getProposal());
		mr.setDiagnosis(record.getDiagnosis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(record.getDate());
		mr.setDate(date);
		return mr;
	}

	private boolean varifyRecord(MedicalRecord record) {

		// 验证

		return true;
	}

	private int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() < dt2.getTime()) {
				System.out.println(dt1 + "在" + dt2 + "前");
				return 1;
			} else if (dt1.getTime() > dt2.getTime()) {
				System.out.println(dt1 + "在" + dt2 + "后");
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
