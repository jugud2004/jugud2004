package com.communication.stock.militaryInfo;

import java.util.List;

public interface MilitaryInfoService {
	MilitaryInfoVO getMtInfo(MilitaryInfoVO vo);
	
	List<MilitaryInfoVO> getMtInfoAll();
}
