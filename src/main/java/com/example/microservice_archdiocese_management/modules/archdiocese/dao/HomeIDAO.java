package com.example.microservice_archdiocese_management.modules.archdiocese.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice_archdiocese_management.modules.archdiocese.entity.ParishEntity;

@Repository
public interface HomeIDAO extends JpaRepository<ParishEntity, Integer> {

	/*
	 * Por si se llega a necesitar
	 * @Query(value = "Query SQL quí", nativeQuery = true)
	public LoginDAOEntity searchByUserFirst();*/
	
}
