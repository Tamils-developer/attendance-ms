package com.adv.empdetailsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adv.empdetailsms.entity.LeaveDetailsEntity;

@Repository
public interface LeaveDetailsRepository extends JpaRepository<LeaveDetailsEntity, Integer> {

	LeaveDetailsEntity findByEmpId(String empId);

}
