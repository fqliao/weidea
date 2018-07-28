package cn.webank.weidea.entity;

import java.util.List;

public class MedicalQueryRecord {
	private String idCard;
	private String hospitalAndDoctor;
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

	@Override
	public String toString() {
		return "MedicalQueryRecord [idCard=" + idCard + ", hospitalAndDoctor=" + hospitalAndDoctor + ", date=" + date
				+ ", index=" + index + "]";
	}
}
