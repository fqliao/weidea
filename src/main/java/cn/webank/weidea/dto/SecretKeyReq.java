package cn.webank.weidea.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecretKeyReq {
	@JsonProperty(value = "idCard")
	private String idCard;
	
	
	@JsonProperty(value = "token")
	private String token;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "KeyManagementReq [idCard=" + idCard + ", token=" + token + "]";
	}

	
	
	
}
