package com.communication.stock.positions;

import java.io.Serializable;

public class PositionsVO implements Serializable{
	private int positionCode;
	private String positionName;
	
	public PositionsVO() {}

	public PositionsVO(int positionCode, String positionName) {
		super();
		this.positionCode = positionCode;
		this.positionName = positionName;
	}

	public int getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(int positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionCode;
		result = prime * result + ((positionName == null) ? 0 : positionName.hashCode());
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
		PositionsVO other = (PositionsVO) obj;
		if (positionCode != other.positionCode)
			return false;
		if (positionName == null) {
			if (other.positionName != null)
				return false;
		} else if (!positionName.equals(other.positionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PositionsVO [positionCode=" + positionCode + ", positionName=" + positionName + "]";
	}
	
	
}
