package cn.webank.weidea.entity;

public class MedicalRecord {
	private String date;
	private String idCard;
	private String hospital;
	private String diagnosis;
	private String proposal;
	private String category;
	private String item;

	public String getDate() {
		return date;
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
		return "MedicalRecord [date=" + date + ", idCard=" + idCard + ", hospital=" + hospital + ", diagnosis="
				+ diagnosis + ", proposal=" + proposal + ", category=" + category + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((hospital == null) ? 0 : hospital.hashCode());
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
		if (hospital == null) {
			if (other.hospital != null)
				return false;
		} else if (!hospital.equals(other.hospital))
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

}
