package cn.webank.weidea.model;

import java.util.HashSet;
import java.util.Set;

public class QueryRecordResponse {
	private String numberRecord;
	private String idCard;
	private String hospital;
	private String date;
	private Set<String> numberSet;

	public QueryRecordResponse(String idCard, String hospital, String date, String numberRecord) {
		super();
		this.idCard = idCard;
		this.hospital = hospital;
		this.date = date;
		this.numberRecord = numberRecord;
		this.numberSet = new HashSet<>();
	}

	public String getNumberRecord() {
		return numberRecord;
	}

	public Set<String> getNumberSet() {
		return numberSet;
	}

	public void setNumberSet(Set<String> numberSet) {
		this.numberSet = numberSet;
	}

	public void setNumberRecord(String numberRecord) {
		this.numberRecord = numberRecord;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "QueryRecordResponse [numberRecord=" + numberRecord + ", idCard=" + idCard + ", hospital=" + hospital
				+ ", date=" + date + "]";
	}
}
