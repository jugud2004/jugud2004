package com.communication.stock.security;

import java.io.Serializable;

public class SecurityVO implements Serializable{
	private int securityLevel;
	private String securityName;
	
	public SecurityVO() {}

	public SecurityVO(int securityLevel, String securityName) {
		super();
		this.securityLevel = securityLevel;
		this.securityName = securityName;
	}

	public int getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + securityLevel;
		result = prime * result + ((securityName == null) ? 0 : securityName.hashCode());
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
		SecurityVO other = (SecurityVO) obj;
		if (securityLevel != other.securityLevel)
			return false;
		if (securityName == null) {
			if (other.securityName != null)
				return false;
		} else if (!securityName.equals(other.securityName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SecurityVO [securityLevel=" + securityLevel + ", securityName=" + securityName + "]";
	}
	
	
}
