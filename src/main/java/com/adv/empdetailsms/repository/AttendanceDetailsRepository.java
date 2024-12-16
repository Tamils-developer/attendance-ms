package com.adv.empdetailsms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adv.empdetailsms.entity.AttendanceDetailsEntity;

@Repository
public interface AttendanceDetailsRepository extends JpaRepository<AttendanceDetailsEntity, String> {

	@Query(value = "select id , att_date, attendance, shift_id, status, approver_id ,emp_id,created_date,created_by, updated_date,updated_by ,is_deleted from attendance_details where emp_id=:empId AND att_date Between :start_date and :end_Date ", nativeQuery = true)
	List<AttendanceDetailsEntity> findByEmpIdAndBetweenDates(@Param("empId") String empId,
			@Param("start_date") String startDate, @Param("end_Date") String endDate);

	List<AttendanceDetailsEntity> findByApproverIdAndStatus(String approverId, String status);

	@Procedure(name = "AttendanceDetailsEntity.updateAttendanceAndCompOffDetails")
	Boolean updateAttendanceAndCompOffDetails(String attendId, String approverId, String empId, String updatedStatus);

	@Query(value = "select id , att_date, attendance, shift_id, status, approver_id ,emp_id,created_date,created_by, updated_date,updated_by ,is_deleted from attendance_details where emp_id=:empId limit :limit ", nativeQuery = true)
	List<AttendanceDetailsEntity> findByEmpIdByLimit(@Param("empId") String empId, @Param("limit") Integer limit);

}
