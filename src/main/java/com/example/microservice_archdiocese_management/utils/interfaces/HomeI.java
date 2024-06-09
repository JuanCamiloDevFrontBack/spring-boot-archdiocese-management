package com.example.microservice_archdiocese_management.utils.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.microservice_archdiocese_management.modules.archdiocese.dto.DTO;
import com.example.microservice_archdiocese_management.modules.archdiocese.dto.DTO.SuccessResponse;

public interface HomeI {
	
	public List<DTO.ParishedList> allRegisI = new ArrayList<>();// si no es constante(final), no se recomienda mucho.

	public List<DTO.ParishedList> listAllParished();
	
	public List<DTO.PriestsList> listAllPriest();
	
	public SuccessResponse addNewParish(Optional<DTO.AddParished> newParished);
	
	public SuccessResponse addNewPriest(Optional<DTO.AddPriests> newPriest);
	
	public SuccessResponse removeParish(Optional<String> id);
	
	public SuccessResponse removePriest(Optional<String> id);
	
}
