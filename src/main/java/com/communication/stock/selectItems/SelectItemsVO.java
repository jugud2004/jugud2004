package com.communication.stock.selectItems;

import java.io.Serializable;

public class SelectItemsVO implements Serializable{
	private String itemSortation;
	private int itemQuentity;
	private String ownerShip;
	public SelectItemsVO() {}
	public SelectItemsVO(String itemSortation, int itemQuentity, String ownerShip) {
		this.itemSortation = itemSortation;
		this.itemQuentity = itemQuentity;
		this.ownerShip = ownerShip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemQuentity;
		result = prime * result + ((itemSortation == null) ? 0 : itemSortation.hashCode());
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
		SelectItemsVO other = (SelectItemsVO) obj;
		if (itemQuentity != other.itemQuentity)
			return false;
		if (itemSortation == null) {
			if (other.itemSortation != null)
				return false;
		} else if (!itemSortation.equals(other.itemSortation))
			return false;
		if (ownerShip == null) {
			if (other.ownerShip != null)
				return false;
		} else if (!ownerShip.equals(other.ownerShip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SelectItemsVO [itemSortation=" + itemSortation + ", itemQuentity=" + itemQuentity + ", ownerShip="
				+ ownerShip + "]";
	}
	public String getItemSortation() {
		return itemSortation;
	}
	public void setItemSortation(String itemSortation) {
		this.itemSortation = itemSortation;
	}
	public int getItemQuentity() {
		return itemQuentity;
	}
	public void setItemQuentity(int itemQuentity) {
		this.itemQuentity = itemQuentity;
	}
	public String getOwnerShip() {
		return ownerShip;
	}
	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}
	
	
	
	
	
	
	
}
