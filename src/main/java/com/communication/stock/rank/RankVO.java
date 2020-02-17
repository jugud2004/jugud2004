package com.communication.stock.rank;

import java.io.Serializable;

public class RankVO implements Serializable{
	private int rankCode;
	private String rankName;
	
	public RankVO() {}

	public RankVO(int rankCode, String rankName) {
		super();
		this.rankCode = rankCode;
		this.rankName = rankName;
	}

	public int getRankCode() {
		return rankCode;
	}

	public void setRankCode(int rankCode) {
		this.rankCode = rankCode;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rankCode;
		result = prime * result + ((rankName == null) ? 0 : rankName.hashCode());
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
		RankVO other = (RankVO) obj;
		if (rankCode != other.rankCode)
			return false;
		if (rankName == null) {
			if (other.rankName != null)
				return false;
		} else if (!rankName.equals(other.rankName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RankVO [rankCode=" + rankCode + ", rankName=" + rankName + "]";
	}
	
	
}
