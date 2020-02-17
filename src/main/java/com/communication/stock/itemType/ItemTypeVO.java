package com.communication.stock.itemType;

import java.io.Serializable;

public class ItemTypeVO implements Serializable{
	private int itemType;
	private String itemTypeName;
	
	public ItemTypeVO() {}

	public ItemTypeVO(int itemType, String itemTypeName) {
		super();
		this.itemType = itemType;
		this.itemTypeName = itemTypeName;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemType;
		result = prime * result + ((itemTypeName == null) ? 0 : itemTypeName.hashCode());
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
		ItemTypeVO other = (ItemTypeVO) obj;
		if (itemType != other.itemType)
			return false;
		if (itemTypeName == null) {
			if (other.itemTypeName != null)
				return false;
		} else if (!itemTypeName.equals(other.itemTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemTypeVO [itemType=" + itemType + ", itemTypeName=" + itemTypeName + "]";
	}
	
	
}
