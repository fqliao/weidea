package cn.webank.weidea.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DecryptReq {
	@JsonProperty(value = "idCard")
	private String idCard;
	
	@JsonProperty(value = "token")
	private String token;
	
	@JsonProperty(value = "plaintext")
	private String plaintext;

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

	public String getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}

	@Override
	public String toString() {
		return "DecryptReq [idCard=" + idCard + ", token=" + token + ", plaintext=" + plaintext + "]";
	}
	
	
}
