package cn.webank.weidea.entity;

import java.util.Date;

public class User {
	private String idCard;
	private String username;
	private Date birth;
	private String password;
	private String phone;
	private int sex;
	private String token;

	public String getIdCard() {
		return idCard;
	}

	public String getUsername() {
		return username;
	}

	public Date getBirth() {
		return birth;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public int getSex() {
		return sex;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + sex;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex != other.sex)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idCard=" + idCard + ", username=" + username + ", birth=" + birth + ", password=" + password
				+ ", phone=" + phone + ", sex=" + sex + "]";
	}

}
