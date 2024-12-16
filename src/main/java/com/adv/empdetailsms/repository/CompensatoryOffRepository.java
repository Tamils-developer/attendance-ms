package com.adv.empdetailsms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adv.empdetailsms.entity.CompensatoryOffEntity;

@Repository
public interface CompensatoryOffRepository extends JpaRepository<CompensatoryOffEntity, String> {

	List<CompensatoryOffEntity> findAllByEmpIdAndStatus(String Id,String status  );

}
