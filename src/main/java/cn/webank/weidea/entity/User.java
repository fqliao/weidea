package cn.webank.weidea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	private int id;
	private String idCard;
	private String username;
	private Date birth;
	private String password;
	private String phone;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "id_card")
	public String getIdCard() {
		return idCard;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "birth")
	public Date getBirth() {
		return birth;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
