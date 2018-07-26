package cn.webank.weidea.entity;

public class MedicalRecord {
	private String date;
	private User user;
	private Hospital hospital;
	private String diagnosis;
	private String proposal;
	private String category;
	private String item;

	public String getDate() {
		return date;
	}

	public User getUser() {
		return user;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getProposal() {
		return proposal;
	}

	public String getCategory() {
		return category;
	}

	public String getItem() {
		return item;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "MedicalRecord [date=" + date + ", user=" + user + ", hospital=" + hospital + ", diagnosis=" + diagnosis
				+ ", proposal=" + proposal + ", category=" + category + ", item=" + item + "]";
	}

}
