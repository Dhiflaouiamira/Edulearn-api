package com.tekup.EduLearnapi.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.LangueDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.mappers.ChapitreMapper;
import com.tekup.EduLearnapi.mappers.CommentaireMapper;
import com.tekup.EduLearnapi.mappers.CoursMapper;
import com.tekup.EduLearnapi.mappers.LangueMapper;
import com.tekup.EduLearnapi.mappers.PaiementMapper;
import com.tekup.EduLearnapi.model.Categorie;
import com.tekup.EduLearnapi.model.Chapitre;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.model.Langue;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.CategorieRepository;
import com.tekup.EduLearnapi.repository.ChapitreRepository;
import com.tekup.EduLearnapi.repository.CommentaireRepository;
import com.tekup.EduLearnapi.repository.CoursRepository;
import com.tekup.EduLearnapi.repository.LangueRepository;
import com.tekup.EduLearnapi.repository.PaiementRepository;
import com.tekup.EduLearnapi.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class CoursServicesImpl implements CoursServices {

    @Autowired
    private final CoursRepository coursRepository;
    @Autowired
    private final CommentaireRepository commentaireRepository;
    @Autowired
    private final ChapitreRepository chapitreRepository;

    @Autowired
    private final PaiementRepository paiementRepository;
    
    @Autowired
    private final CategorieRepository categorieRepository;
    
    @Autowired
    private final UserRepository userRepository;
    @Autowired
	private final LangueRepository langueRepository;

    @Override
    public Page<CoursDTO> getAllCours(Pageable pageable) {
        Page<Cours> courss = coursRepository.findAll(pageable);
        return courss.map(CoursMapper::convertToDto);
    }

  

   
    @Override
    public void deleteOneCours(long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public Optional<CoursDTO> findOneCours(long id) {
        return coursRepository.findById(id).map(CoursMapper::convertToDto);
    }

    @Override
    public List<Cours> findCoursesByTitre(String titre) {
        return coursRepository.findByTitre(titre);
    }

    @Override
    public List<Cours> findCoursesByLangue(String langueName) {
        return coursRepository.findByLangueNom(langueName);
    }

    @Override
    public List<Cours> findCoursesBydesc(String description) {
        return coursRepository.findByDescription(description);
    }
    
   

    @Override
    public CoursDTO assignCommentaireToCours(long coursId, CommentaireDTO commentaireDTO) {
        Cours cours = coursRepository.findById(coursId)
            .orElseThrow();
        
        Commentaire commentaire = CommentaireMapper.convertToEntity(commentaireDTO);
        commentaire.setCours(cours);

        User user = userRepository.findById(commentaireDTO.getUserId())
            .orElseThrow();
        
        commentaire.setUser(user);

        commentaireRepository.save(commentaire);
        return CoursMapper.convertToDto(cours);
    }


    @Override
    public CoursDTO assignChapitreToCours(long id, ChapitreDTO chapitreDTO) {
        return coursRepository.findById(id).map(cours -> {
            Chapitre chapitre = ChapitreMapper.convertToEntity(chapitreDTO);
            chapitre.setCours(cours);
            chapitreRepository.save(chapitre);
            return CoursMapper.convertToDto(cours);
        }).orElse(null);
    }

    @Override
    public CoursDTO assignPaiementToCours(long coursId, PaiementDTO paiementDTO) {
    	Cours cours = coursRepository.findById(coursId)
                .orElseThrow();
            
            Paiement paiement = PaiementMapper.convertToEntity(paiementDTO);
            paiement.setCours(cours);

            User user = userRepository.findById(paiementDTO.getUserId())
                .orElseThrow();
            
            paiement.setUser(user);

            paiementRepository.save(paiement);
            return CoursMapper.convertToDto(cours);
    }


    @Override
    public CoursDTO assignCategorieToCours(Long coursId, Long categorieId) {

        Cours cours = coursRepository.findById(coursId)
            .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        Categorie categorie = categorieRepository.findById(categorieId)
            .orElseThrow(() -> new EntityNotFoundException("Categorie not found"));
        Set<Categorie> categorieSet = cours.getAssignedCategorie();
        if (categorieSet == null) {
            categorieSet = new HashSet<>();
        }
        categorieSet.add(categorie);
        cours.setAssignedCategorie(categorieSet);
        Cours updatedCours = coursRepository.save(cours);
        return CoursMapper.convertToDto(updatedCours);
    }

    @Override
    public CoursDTO assignUserToCours(Long coursId, Long userId) {
        Cours cours = coursRepository.findById(coursId)
            .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Set<User> userSet = cours.getAssignedUser();
        if (userSet == null) {
            userSet = new HashSet<>();
        }
        userSet.add(user);
        cours.setAssignedUser(userSet);
        Cours updatedCours = coursRepository.save(cours);
        return CoursMapper.convertToDto(updatedCours);
    }

    
    @Override
    public Optional<CoursDTO> updateOneCours(Long id, CoursDTO coursDTO) {
        return coursRepository.findById(id).map(cours -> {
            cours.setTitre(coursDTO.getTitre());
            cours.setDescription(coursDTO.getDescription());
            cours.setNiveau(coursDTO.getNiveau());
            cours.setDuree(coursDTO.getDuree());
            cours.setDateDebut(coursDTO.getDateDebut());
            cours.setDateFin(coursDTO.getDateFin());
            cours.setPrix(coursDTO.getPrix());
            cours.setSujet(coursDTO.getSujet());
            cours.setCover(coursDTO.getCover());
            cours.setCertification(coursDTO.isCertification());

            coursRepository.save(cours);


            return CoursMapper.convertToDto(coursRepository.save(cours));
        });
    }

    
    @Transactional
    public LangueDTO addCourseAndAssign(CoursDTO coursDTO, long langueId, long userId) {
        Langue langue = langueRepository.findById(langueId)
                .orElseThrow(() -> new EntityNotFoundException("Language not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Cours cours = CoursMapper.convertToEntity(coursDTO);
        cours.setLangue(langue);
        cours = coursRepository.save(cours);
        System.out.println("Course saved: " + cours);
        user.getCours().add(cours);
        user = userRepository.save(user);
        System.out.println("User updated with new course: " + user);
        return LangueMapper.convertToDto(langue);
    }
    
    

    public Set<Cours> getCoursesByCategory(Long categorieId) {
        return coursRepository.findByAssignedCategorieId(categorieId);
    }
    
    public Set<Cours> getCoursesByUser(Long UserId) {
        return coursRepository.findByAssignedUserId(UserId);
    }
}
