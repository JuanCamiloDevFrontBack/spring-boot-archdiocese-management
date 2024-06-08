package com.example.microservice_archdiocese_management.modules.archdiocese.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice_archdiocese_management.modules.archdiocese.entity.PriestsEntity;

@Repository
public interface PriestsIDAO extends JpaRepository<PriestsEntity, Integer> {

	/*
	 * Por si se llega a necesitar
	 * @Query(value = "Query SQL quí", nativeQuery = truepriest)
	public LoginDAOEntity searchByUserFirst();*/
	
}
