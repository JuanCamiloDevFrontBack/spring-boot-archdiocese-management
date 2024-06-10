package com.example.microservice_archdiocese_management.modules.archdiocese.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservice_archdiocese_management.modules.archdiocese.entity.PriestsEntity;

@Repository
public interface PriestsIDAO extends JpaRepository<PriestsEntity, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE priest SET name = :name, age = :age, ordination_date = :ordinationDate, is_parish_priest = :isParishPriest, id_parish = :idParish WHERE id = :id", nativeQuery = true)
	public void updatePriestDb(@Param("id") Integer id,
	                    @Param("name") String name,
	                    @Param("age") Integer age,
	                    @Param("ordinationDate") LocalDate ordinationDate,
	                    @Param("isParishPriest") String isParishPriest,
	                    @Param("idParish") Integer idParish);
	
}
