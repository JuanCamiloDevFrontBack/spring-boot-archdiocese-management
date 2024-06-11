package com.example.microservice_archdiocese_management.modules.archdiocese.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservice_archdiocese_management.modules.archdiocese.entity.ParishEntity;

@Repository
public interface HomeIDAO extends JpaRepository<ParishEntity, Integer> {

	@Query(value = "SELECT id, name FROM parish", nativeQuery = true)
	public List<Object[]> getParishList();
	
	@Modifying
    @Transactional
	@Query(value = "UPDATE parish SET name = :name, address = :address, district = :district WHERE id = :id", nativeQuery = true)
    public void updateParishDb(@Param("id") Integer id,
                      @Param("name") String name,
                      @Param("address") String address,
                      @Param("district") String district);
	
}
