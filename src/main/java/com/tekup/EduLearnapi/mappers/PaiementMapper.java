package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.model.Paiement;

public class PaiementMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static PaiementDTO convertToDto(Paiement paiement)
	{
		return modelMapper.map(paiement, PaiementDTO.class);
	}
	public static Paiement convertToEntity(PaiementDTO paiementDTO)
	{
		return modelMapper.map(paiementDTO, Paiement.class);
	}
}
