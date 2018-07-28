package cn.webank.weidea.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchQueryRecordReq {
	
	@JsonProperty(value = "idCard")
	private String idCard;
	
	@JsonProperty(value = "hospital")
	private String hospital;
	
	@JsonProperty(value = "password")
	private String password;
	
	@JsonProperty(value = "startTime")
	private Date startTime;
	
	@JsonProperty(value = "endTime")
	private Date endTime;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "SearchQueryRecordReq [idCard=" + idCard + ", hospital=" + hospital + ", password=" + password
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}	

}
