package com.communication.stock.messages;

import java.io.Serializable;

public class MessagesVO implements Serializable{
	private String contents1;
	private int check1;
	private String ownerShip;
	private int msCount;
	public MessagesVO() {}
	public MessagesVO(String contents1, int check1, String ownerShip, int msCount) {
		this.contents1 = contents1;
		this.check1 = check1;
		this.ownerShip = ownerShip;
		this.msCount = msCount;
	}
	@Override
	public String toString() {
		return "MessagesVO [contents1=" + contents1 + ", check1=" + check1 + ", ownerShip=" + ownerShip + ", msCount="
				+ msCount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + check1;
		result = prime * result + ((contents1 == null) ? 0 : contents1.hashCode());
		result = prime * result + msCount;
		result = prime * result + ((ownerShip == null) ? 0 : ownerShip.hashCode());
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
		MessagesVO other = (MessagesVO) obj;
		if (check1 != other.check1)
			return false;
		if (contents1 == null) {
			if (other.contents1 != null)
				return false;
		} else if (!contents1.equals(other.contents1))
			return false;
		if (msCount != other.msCount)
			return false;
		if (ownerShip == null) {
			if (other.ownerShip != null)
				return false;
		} else if (!ownerShip.equals(other.ownerShip))
			return false;
		return true;
	}
	public String getContents1() {
		return contents1;
	}
	public void setContents1(String contents1) {
		this.contents1 = contents1;
	}
	public int getCheck1() {
		return check1;
	}
	public void setCheck1(int check1) {
		this.check1 = check1;
	}
	public String getOwnerShip() {
		return ownerShip;
	}
	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}
	public int getMsCount() {
		return msCount;
	}
	public void setMsCount(int msCount) {
		this.msCount = msCount;
	}
	
	
}
