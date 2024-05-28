package com.tekup.EduLearnapi.Service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tekup.EduLearnapi.dto.SupportDTO;
import com.tekup.EduLearnapi.mappers.SupportMapper;
import com.tekup.EduLearnapi.model.Support;
import com.tekup.EduLearnapi.repository.SupportRepository;

@Service
public class SupportServicesImpl implements SupportServices {

	
	SupportRepository supportRepository;

	@Override
	public Page<SupportDTO> getAllSupports(Pageable pageable) {
		Page<Support> supports=supportRepository.findAll(pageable);
		return supports.map(SupportMapper::convertToDto);
		
	}


	@Override
	public SupportDTO addOneSupport(SupportDTO support) {
		return SupportMapper.convertToDto(supportRepository.save(SupportMapper.convertToEntity(support)));

	}

	@Override
	public void deleteOneSupport(long id) {
		supportRepository.deleteById(id);		
	}



	@Override
	public Optional<SupportDTO> findOneSupport(long id) {
		return supportRepository.findById(id).map(SupportMapper::convertToDto);

	}

}
