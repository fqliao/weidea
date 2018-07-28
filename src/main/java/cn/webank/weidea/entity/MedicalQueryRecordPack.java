package cn.webank.weidea.entity;

import java.util.List;

public class MedicalQueryRecordPack {
	
	private MedicalQueryRecord medicalQueryRecord;
	
	private List<Integer> indexs;

	public MedicalQueryRecord getMedicalQueryRecord() {
		return medicalQueryRecord;
	}

	public void setMedicalQueryRecord(MedicalQueryRecord medicalQueryRecord) {
		this.medicalQueryRecord = medicalQueryRecord;
	}

	public List<Integer> getIndexs() {
		return indexs;
	}

	public void setIndexs(List<Integer> indexs) {
		this.indexs = indexs;
	}
	
	
}
