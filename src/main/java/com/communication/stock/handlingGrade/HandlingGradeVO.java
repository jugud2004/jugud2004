package com.communication.stock.handlingGrade;

import java.io.Serializable;

public class HandlingGradeVO implements Serializable{
	private int handlingGrade;
	private String handlingGradeName;
	
	public HandlingGradeVO() {}

	public HandlingGradeVO(int handlingGrade, String handlingGradeName) {
		super();
		this.handlingGrade = handlingGrade;
		this.handlingGradeName = handlingGradeName;
	}

	public int getHandlingGrade() {
		return handlingGrade;
	}

	public void setHandlingGrade(int handlingGrade) {
		this.handlingGrade = handlingGrade;
	}

	public String getHandlingGradeName() {
		return handlingGradeName;
	}

	public void setHandlingGradeName(String handlingGradeName) {
		this.handlingGradeName = handlingGradeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + handlingGrade;
		result = prime * result + ((handlingGradeName == null) ? 0 : handlingGradeName.hashCode());
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
		HandlingGradeVO other = (HandlingGradeVO) obj;
		if (handlingGrade != other.handlingGrade)
			return false;
		if (handlingGradeName == null) {
			if (other.handlingGradeName != null)
				return false;
		} else if (!handlingGradeName.equals(other.handlingGradeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HandlingGradeVO [handlingGrade=" + handlingGrade + ", handlingGradeName=" + handlingGradeName + "]";
	}
	
	
}
