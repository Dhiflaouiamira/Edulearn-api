package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.SupportDTO;
import com.tekup.EduLearnapi.model.Support;

public class SupportMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    // Convert Support entity to SupportDTO
    public static SupportDTO convertToDto(Support support) {
        return modelMapper.map(support, SupportDTO.class);
    }

    // Convert SupportDTO to Support entity
    public static Support convertToEntity(SupportDTO supportDTO) {
        return modelMapper.map(supportDTO, Support.class);
    }
}
