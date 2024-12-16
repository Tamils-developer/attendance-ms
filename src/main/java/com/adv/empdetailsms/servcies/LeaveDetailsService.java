package com.adv.empdetailsms.servcies;

import com.adv.empdetailsms.dto.LeaveDetailsDto;

public interface LeaveDetailsService {

	public LeaveDetailsDto getLeaveDetails(String empId);
}
