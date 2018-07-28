package cn.webank.weidea.entity;

import java.util.List;

public class MedicalQueryRecord {
	private String idCard;
	private String hospitalAndDoctor;
	private String date;
	private int index;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getHospitalAndDoctor() {
		if (!this.hospitalAndDoctor.contains(",")) {
			this.hospitalAndDoctor = this.hospitalAndDoctor.replace("And", ",");
		}
		return hospitalAndDoctor;
	}

	public void setHospitalAndDoctor(String hospitalAndDoctor) {
		if (!hospitalAndDoctor.contains(",")) {
			hospitalAndDoctor = hospitalAndDoctor.replace("And", ",");
		}
		this.hospitalAndDoctor = hospitalAndDoctor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "MedicalQueryRecord [idCard=" + idCard + ", hospitalAndDoctor=" + hospitalAndDoctor + ", date=" + date
				+ ", index=" + index + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hospitalAndDoctor == null) ? 0 : hospitalAndDoctor.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + index;
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
		MedicalQueryRecord other = (MedicalQueryRecord) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		if (index != other.index)
			return false;
		return true;
	}
}
