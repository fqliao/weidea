package cn.webank.weidea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {
	private int id;
	private String account;
	private String name;
	private String OrganizationCodeNumber;
	private String place;
	private String phone;
	private String token;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "account")
	public String getAccount() {
		return account;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "organization_code_number")
	public String getOrganizationCodeNumber() {
		return OrganizationCodeNumber;
	}

	@Column(name = "place")
	public String getPlace() {
		return place;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	@Column(name = "token")
	public String getToken() {
		return token;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrganizationCodeNumber(String organizationCodeNumber) {
		OrganizationCodeNumber = organizationCodeNumber;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
