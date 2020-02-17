package com.communication.stock.militaryInfo;

import java.io.Serializable;

public class MilitaryInfoVO implements Serializable{
	private long mtCode;
	private int command;
	private int corps;
	private int division;
	private int regiment;
	private int battalion;
	private int company;
	private int platoon;
	
	public MilitaryInfoVO() {}

	public MilitaryInfoVO(long mtCode, int command, int corps, int division, int regiment, int battalion, int company,
			int platoon) {
		this.mtCode = mtCode;
		this.command = command;
		this.corps = corps;
		this.division = division;
		this.regiment = regiment;
		this.battalion = battalion;
		this.company = company;
		this.platoon = platoon;
	}

	@Override
	public String toString() {
		return "MilitaryInfoVO [mtCode=" + mtCode + ", command=" + command + ", corps=" + corps + ", division="
				+ division + ", regiment=" + regiment + ", battalion=" + battalion + ", company=" + company
				+ ", platoon=" + platoon + "]";
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
		result = prime * result + (int) (mtCode ^ (mtCode >>> 32));
		result = prime * result + platoon;
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
		MilitaryInfoVO other = (MilitaryInfoVO) obj;
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
		if (mtCode != other.mtCode)
			return false;
		if (platoon != other.platoon)
			return false;
		if (regiment != other.regiment)
			return false;
		return true;
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

	
	
	
}
