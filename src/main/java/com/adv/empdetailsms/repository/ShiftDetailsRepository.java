package com.adv.empdetailsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adv.empdetailsms.entity.ShiftDetailsEntity;
@Repository
public interface ShiftDetailsRepository  extends JpaRepository<ShiftDetailsEntity, Integer> {

}
