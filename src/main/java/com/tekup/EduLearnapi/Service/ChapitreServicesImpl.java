package com.tekup.EduLearnapi.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.SupportDTO;
import com.tekup.EduLearnapi.mappers.ChapitreMapper;
import com.tekup.EduLearnapi.mappers.SupportMapper;
import com.tekup.EduLearnapi.model.Chapitre;
import com.tekup.EduLearnapi.model.Support;
import com.tekup.EduLearnapi.repository.ChapitreRepository;
import com.tekup.EduLearnapi.repository.SupportRepository;

@Service
public class ChapitreServicesImpl implements ChapitreServices {

    @Autowired
    private ChapitreRepository chapitreRepository;

    @Autowired
    private SupportRepository supportRepository;

    @Override
    public Page<ChapitreDTO> getAllChapitres(Pageable pageable) {
        Page<Chapitre> chapitres = chapitreRepository.findAll(pageable);
        return chapitres.map(ChapitreMapper::convertToDto);
    }

    @Override
    public ChapitreDTO addOneChapitre(ChapitreDTO chapitre) {
        Chapitre chapitreEntity = ChapitreMapper.convertToEntity(chapitre);
        Chapitre savedChapitre = chapitreRepository.save(chapitreEntity);
        return ChapitreMapper.convertToDto(savedChapitre);
    }

    @Override
    public void deleteOneChapitre(long id) {
        chapitreRepository.deleteById(id);
    }

    @Override
    public Optional<ChapitreDTO> findOneChapitre(long id) {
        return chapitreRepository.findById(id).map(ChapitreMapper::convertToDto);
    }

    @Override
    public Optional<ChapitreDTO> updateOneChapitre(Long id, ChapitreDTO chapitreDTO) {
        return chapitreRepository.findById(id).map(chapitre -> {
            chapitre.setTitre(chapitreDTO.getTitre());
            chapitre.setDescription(chapitreDTO.getDescription());
            chapitre.setOrdre(chapitreDTO.getOrdre());
            Chapitre updatedChapitre = chapitreRepository.save(chapitre);
            return ChapitreMapper.convertToDto(updatedChapitre);
        });
    }


    public ChapitreDTO assignSupportToChapitre(long chapitreId, SupportDTO supportDTO) {
        Optional<Chapitre> chapitreOptional = chapitreRepository.findById(chapitreId);
        if (chapitreOptional.isPresent()) {
            Chapitre chapitre = chapitreOptional.get();
            Support support = SupportMapper.convertToEntity(supportDTO);
            support.setChapitre(chapitre);
            supportRepository.save(support);
            return ChapitreMapper.convertToDto(chapitre);
        } else {
            // Handle chapitre not found scenario
            return null;
        }
    }

    @Override
    public List<ChapitreDTO> findChapitresByCoursTitre(String titre) {
        List<Chapitre> chapitres = chapitreRepository.findByCoursTitre(titre);
        return chapitres.stream()
                        .map(ChapitreMapper::convertToDto)
                        .collect(Collectors.toList());
    }
}
