package com.communication.stock.users;

import java.io.Serializable;

public class UsersVO implements Serializable{
	private String id;
	private String name;
	private String password;
	private int rankCode;
	private int positionCode;
	private long mtCode;
	
	public UsersVO() {}

	public UsersVO(String id, String name, String password, int rankCode, int positionCode, long mtCode) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.rankCode = rankCode;
		this.positionCode = positionCode;
		this.mtCode = mtCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (mtCode ^ (mtCode >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + positionCode;
		result = prime * result + rankCode;
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
		UsersVO other = (UsersVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mtCode != other.mtCode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (positionCode != other.positionCode)
			return false;
		if (rankCode != other.rankCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsersVO [id=" + id + ", name=" + name + ", password=" + password + ", rankCode=" + rankCode
				+ ", positionCode=" + positionCode + ", mtCode=" + mtCode + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRankCode() {
		return rankCode;
	}

	public void setRankCode(int rankCode) {
		this.rankCode = rankCode;
	}

	public int getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(int positionCode) {
		this.positionCode = positionCode;
	}

	public long getMtCode() {
		return mtCode;
	}

	public void setMtCode(long mtCode) {
		this.mtCode = mtCode;
	}
	
	
	
	
	
	
}
