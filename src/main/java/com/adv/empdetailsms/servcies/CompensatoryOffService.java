package com.adv.empdetailsms.servcies;

import java.util.List;

import com.adv.empdetailsms.dto.CompensatoryOffDto;

public interface CompensatoryOffService {

	public List<CompensatoryOffDto> getCompOffDetails(String empId);
}
