package cn.webank.weidea.entity;

public class User {
	private String idCard;
	private String username;
	private String phone;
	private int sex;
	private String token;
	private String publishKey;

	public User(String idCard, String username, String phone, int sex, String token, String publishKey) {
		super();
		this.idCard = idCard;
		this.username = username;
		this.phone = phone;
		this.sex = sex;
		this.token = token;
		this.publishKey = publishKey;
	}

	public User() {
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPublishKey() {
		return publishKey;
	}

	public void setPublishKey(String publishKey) {
		this.publishKey = publishKey;
	}

	@Override
	public String toString() {
		return "User [idCard=" + idCard + ", username=" + username + ", phone=" + phone + ", sex=" + sex + ", token="
				+ token + ", publishKey=" + publishKey + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((publishKey == null) ? 0 : publishKey.hashCode());
		result = prime * result + sex;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (publishKey == null) {
			if (other.publishKey != null)
				return false;
		} else if (!publishKey.equals(other.publishKey))
			return false;
		if (sex != other.sex)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
