package cn.webank.weidea.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchMedicalRecordReq {
	/*
	 * idCard: String,
	 * startTime: Date,
	 * endTime: Date,
	 * category: String,
	 * password: String
	 * */
	@JsonProperty(value = "idCard")
	private String idCard;
	
	@JsonProperty(value = "startTime")
	private Date startTime;
	
	@JsonProperty(value = "endTime")
	private Date endTime;
	
	@JsonProperty(value = "category")
	private String category;
	
	@JsonProperty(value = "password")
	private String password;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SaveMedicalRecordReq [idCard=" + idCard + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", category=" + category + ", password=" + password + "]";
	}
	
	
}
