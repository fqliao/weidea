package cn.webank.weidea.entity;

public class MedicalRecord {
	private String date;
	private String idCard;
	private String hospitalAndDoctor;
	private String hospital;
	private String diagnosis;
	private String proposal;
	private String category;
	private String item;

	public MedicalRecord() {
	}

	public MedicalRecord(String date, String idCard, String hospitalAndDoctor, String diagnosis, String proposal,
			String category, String item) {
		super();
		this.date = date;
		this.idCard = idCard;
		this.hospitalAndDoctor = hospitalAndDoctor;
		this.diagnosis = diagnosis;
		this.proposal = proposal;
		this.category = category;
		this.item = item;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIdCard() {
		return idCard;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospitalAndDoctor = hospital;
		this.hospital = hospital;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getHospitalAndDoctor() {
		return hospitalAndDoctor;
	}

	public void setHospitalAndDoctor(String hospitalAndDoctor) {
		this.hospital = hospitalAndDoctor;
		this.hospitalAndDoctor = hospitalAndDoctor;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((hospitalAndDoctor == null) ? 0 : hospitalAndDoctor.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((proposal == null) ? 0 : proposal.hashCode());
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
		MedicalRecord other = (MedicalRecord) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (hospitalAndDoctor == null) {
			if (other.hospitalAndDoctor != null)
				return false;
		} else if (!hospitalAndDoctor.equals(other.hospitalAndDoctor))
			return false;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (proposal == null) {
			if (other.proposal != null)
				return false;
		} else if (!proposal.equals(other.proposal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalRecord [date=" + date + ", idCard=" + idCard + ", hospitalAndDoctor=" + hospitalAndDoctor
				+ ", diagnosis=" + diagnosis + ", proposal=" + proposal + ", category=" + category + ", item=" + item
				+ "]";
	}

}
