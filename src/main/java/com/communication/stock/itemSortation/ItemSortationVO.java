package com.communication.stock.itemSortation;

import java.io.Serializable;

public class ItemSortationVO implements Serializable{
	private String itemSortation;
	private String itemSortationName;
	
	public ItemSortationVO() {}

	public ItemSortationVO(String itemSortation, String itemSortationName) {
		super();
		this.itemSortation = itemSortation;
		this.itemSortationName = itemSortationName;
	}

	public String getItemSortation() {
		return itemSortation;
	}

	public void setItemSortation(String itemSortation) {
		this.itemSortation = itemSortation;
	}

	public String getItemSortationName() {
		return itemSortationName;
	}

	public void setItemSortationName(String itemSortationName) {
		this.itemSortationName = itemSortationName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemSortation == null) ? 0 : itemSortation.hashCode());
		result = prime * result + ((itemSortationName == null) ? 0 : itemSortationName.hashCode());
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
		ItemSortationVO other = (ItemSortationVO) obj;
		if (itemSortation == null) {
			if (other.itemSortation != null)
				return false;
		} else if (!itemSortation.equals(other.itemSortation))
			return false;
		if (itemSortationName == null) {
			if (other.itemSortationName != null)
				return false;
		} else if (!itemSortationName.equals(other.itemSortationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemSortationVO [itemSortation=" + itemSortation + ", itemSortationName=" + itemSortationName + "]";
	}
	
	
}
