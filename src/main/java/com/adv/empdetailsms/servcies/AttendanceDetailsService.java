package com.adv.empdetailsms.servcies;

import java.util.List;

import com.adv.empdetailsms.dto.ApprovalDto;
import com.adv.empdetailsms.dto.AttendanceDetailsDto;

public interface AttendanceDetailsService {

	public AttendanceDetailsDto createAttendanceDetails(AttendanceDetailsDto attendanceDetailsDto, String empId);

	public List<AttendanceDetailsDto> getAttendanceDetailsForMonth(String empId, String startDate, String endDate);

	public List<ApprovalDto> getAttendanceDetailsForApproval(String approverId);

	public void updateAttendanceDetails(List<AttendanceDetailsDto> attendanceDetailsDtos, String empId);

	public boolean updateAttendanceDetails(AttendanceDetailsDto attendanceDetailsDto, String empId, String attendId);

	public List<AttendanceDetailsDto> getPreviousApplies(String empId);
}
