package com.communication.stock.items;

import java.io.Serializable;

public class ItemsVO implements Serializable{
	private String itemID;
	private String itemName;
	private String itemSortation;
	private int itemType;
	private int handlingGrade;
	private int securityLevel;
	private String Ownership;
	public ItemsVO() {}
	public ItemsVO(String itemID, String itemName, String itemSortation, int itemType, int handlingGrade,
			int securityLevel, String ownership) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemSortation = itemSortation;
		this.itemType = itemType;
		this.handlingGrade = handlingGrade;
		this.securityLevel = securityLevel;
		Ownership = ownership;
	}
	@Override
	public String toString() {
		return "ItemsVO [itemID=" + itemID + ", itemName=" + itemName + ", itemSortation=" + itemSortation
				+ ", itemType=" + itemType + ", handlingGrade=" + handlingGrade + ", securityLevel=" + securityLevel
				+ ", Ownership=" + Ownership + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ownership == null) ? 0 : Ownership.hashCode());
		result = prime * result + handlingGrade;
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemSortation == null) ? 0 : itemSortation.hashCode());
		result = prime * result + itemType;
		result = prime * result + securityLevel;
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
		ItemsVO other = (ItemsVO) obj;
		if (Ownership == null) {
			if (other.Ownership != null)
				return false;
		} else if (!Ownership.equals(other.Ownership))
			return false;
		if (handlingGrade != other.handlingGrade)
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemSortation == null) {
			if (other.itemSortation != null)
				return false;
		} else if (!itemSortation.equals(other.itemSortation))
			return false;
		if (itemType != other.itemType)
			return false;
		if (securityLevel != other.securityLevel)
			return false;
		return true;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSortation() {
		return itemSortation;
	}
	public void setItemSortation(String itemSortation) {
		this.itemSortation = itemSortation;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public int getHandlingGrade() {
		return handlingGrade;
	}
	public void setHandlingGrade(int handlingGrade) {
		this.handlingGrade = handlingGrade;
	}
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
	public String getOwnership() {
		return Ownership;
	}
	public void setOwnership(String ownership) {
		Ownership = ownership;
	}
	
	
	
	
	
	
	
}
