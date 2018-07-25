package cn.webank.weidea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {
	private int id;
	private String date;
	private User user;
	private Hospital hospital;
	private String diagnosis;
	private String proposal;
	private String category;
	private String item;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "date")
	public String getDate() {
		return date;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	@ManyToOne
	@JoinColumn(name = "hospital_id")
	public Hospital getHospital() {
		return hospital;
	}

	@Column(name = "diagnosis", length = 8192)
	public String getDiagnosis() {
		return diagnosis;
	}

	@Column(name = "proposal", length = 8192)
	public String getProposal() {
		return proposal;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	@Column(name = "item")
	public String getItem() {
		return item;
	}

	public void setId(int id) {
		this.id = id;
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

}
