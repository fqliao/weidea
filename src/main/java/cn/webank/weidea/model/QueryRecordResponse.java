package cn.webank.weidea.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueryRecordResponse {
	private List<Integer> numRecord = new ArrayList<>();
	private String idCard;
	private String hospital;
	private String date;
	private Set<Integer> numberSet;

	public QueryRecordResponse(String idCard, String hospital, String date) {
		super();
		this.idCard = idCard;
		this.hospital = hospital;
		this.date = date;
		this.numberSet = new HashSet<>();
	}

	public List<Integer> getNumRecord() {
		return numRecord;
	}

	public Set<Integer> getNumberSet() {
		return numberSet;
	}

	public void setNumberSet(Set<Integer> numberSet) {
		this.numberSet = numberSet;
	}

	public void setNumberRecord(List<Integer> numberRecord) {
		this.numRecord = numberRecord;
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
}
