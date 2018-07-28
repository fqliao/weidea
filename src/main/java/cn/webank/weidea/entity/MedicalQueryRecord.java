package cn.webank.weidea.entity;

public class MedicalQueryRecord {
	private String idCard;
	private String hospitalAndDoctor;
	private String recordHash;
	private String date;
	private int index;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getHospitalAndDoctor() {
		return hospitalAndDoctor;
	}

	public void setHospitalAndDoctor(String hospitalAndDoctor) {
		this.hospitalAndDoctor = hospitalAndDoctor;
	}

	public String getRecordHash() {
		return recordHash;
	}

	public void setRecordHash(String recordHash) {
		this.recordHash = recordHash;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
