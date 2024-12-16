package com.adv.empdetailsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adv.empdetailsms.entity.RoosterEntity;

@Repository
public interface RoosterRepository extends JpaRepository<RoosterEntity, Integer>{

}
