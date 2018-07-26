package cn.webank.weidea.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveMedicalRecordReq {
	/*
	 * idCard: String,
	 * hospital: String,
	 * item: String,
	 * category: String,
	 * proposal: String,
	 * date: date,
	 * password: String
	 * */
	@JsonProperty(value = "idCard")
	private String idCard;
	
	@JsonProperty(value = "hospital")
	private String hospital;
	
	@JsonProperty(value = "item")
	private String item;
	
	@JsonProperty(value = "category")
	private String category;
	
	@JsonProperty(value = "proposal")
	private String proposal;
	
	@JsonProperty(value = "date")
	private Date date;
	
	@JsonProperty(value = "password")
	private String password;

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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SaveMedicalRecordReq [idCard=" + idCard + ", hospital=" + hospital + ", item=" + item + ", category="
				+ category + ", proposal=" + proposal + ", date=" + date + ", password=" + password + "]";
	}
	
	
}
