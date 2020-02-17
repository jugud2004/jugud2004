package com.communication.stock.usersInfo;

import java.io.Serializable;

public class UsersInfoVO implements Serializable{
	private String id;
	private String name;
	private String rankName;
	private String positionName;
	private long mtCode;
	private int command;
	private int corps;
	private int division;
	private int regiment;
	private int battalion;
	private int company;
	private int platoon;
	
	public UsersInfoVO() {}

	public UsersInfoVO(String id, String name, String rankName, String positionName, long mtCode, int command,
			int corps, int division, int regiment, int battalion, int company, int platoon) {
		super();
		this.id = id;
		this.name = name;
		this.rankName = rankName;
		this.positionName = positionName;
		this.mtCode = mtCode;
		this.command = command;
		this.corps = corps;
		this.division = division;
		this.regiment = regiment;
		this.battalion = battalion;
		this.company = company;
		this.platoon = platoon;
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

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public long getMtCode() {
		return mtCode;
	}

	public void setMtCode(long mtCode) {
		this.mtCode = mtCode;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public int getCorps() {
		return corps;
	}

	public void setCorps(int corps) {
		this.corps = corps;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public int getRegiment() {
		return regiment;
	}

	public void setRegiment(int regiment) {
		this.regiment = regiment;
	}

	public int getBattalion() {
		return battalion;
	}

	public void setBattalion(int battalion) {
		this.battalion = battalion;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getPlatoon() {
		return platoon;
	}

	public void setPlatoon(int platoon) {
		this.platoon = platoon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + battalion;
		result = prime * result + command;
		result = prime * result + company;
		result = prime * result + corps;
		result = prime * result + division;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (mtCode ^ (mtCode >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + platoon;
		result = prime * result + ((positionName == null) ? 0 : positionName.hashCode());
		result = prime * result + ((rankName == null) ? 0 : rankName.hashCode());
		result = prime * result + regiment;
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
		UsersInfoVO other = (UsersInfoVO) obj;
		if (battalion != other.battalion)
			return false;
		if (command != other.command)
			return false;
		if (company != other.company)
			return false;
		if (corps != other.corps)
			return false;
		if (division != other.division)
			return false;
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
		if (platoon != other.platoon)
			return false;
		if (positionName == null) {
			if (other.positionName != null)
				return false;
		} else if (!positionName.equals(other.positionName))
			return false;
		if (rankName == null) {
			if (other.rankName != null)
				return false;
		} else if (!rankName.equals(other.rankName))
			return false;
		if (regiment != other.regiment)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsersInfoVO [id=" + id + ", name=" + name + ", rankName=" + rankName + ", positionName=" + positionName
				+ ", mtCode=" + mtCode + ", command=" + command + ", corps=" + corps + ", division=" + division
				+ ", regiment=" + regiment + ", battalion=" + battalion + ", company=" + company + ", platoon="
				+ platoon + "]";
	}

	
	
}
