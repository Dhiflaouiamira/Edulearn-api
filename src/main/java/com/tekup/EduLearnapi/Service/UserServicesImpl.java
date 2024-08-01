package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.mappers.CommentaireMapper;
import com.tekup.EduLearnapi.mappers.CoursMapper;
import com.tekup.EduLearnapi.mappers.PaiementMapper;
import com.tekup.EduLearnapi.mappers.ReclamationMapper;
import com.tekup.EduLearnapi.mappers.UserMapper;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.Reclamation;
import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.CommentaireRepository;
import com.tekup.EduLearnapi.repository.PaiementRepository;
import com.tekup.EduLearnapi.repository.ReclamationRepository;
import com.tekup.EduLearnapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final CommentaireRepository  commentaireRepository ;
	@Autowired
	private final ReclamationRepository reclamationRepository ;
	@Autowired
	private final PaiementRepository paiementRepository ;

	
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public Page<UserDTO> getAllUsers(Pageable pageable) {
		Page<User> users=userRepository.findAll(pageable);
		return users.map(UserMapper::convertToDto);
		
	}


	@Override
	public UserDTO addOneUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
		return UserMapper.convertToDto(userRepository.save(UserMapper.convertToEntity(user)));

	}

	@Override
	public void deleteOneUser(long id) {
		userRepository.deleteById(id);		
	}



	@Override
	public Optional<UserDTO> findOneUser(long id) {
		return userRepository.findById(id).map(UserMapper::convertToDto);

	}



	@Override
	public UserDTO assignCommentaireToUser(long id, CommentaireDTO commentaire) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			Commentaire cmt=CommentaireMapper.convertToEntity(commentaire);
			cmt.setUser(user);
			commentaireRepository.save(cmt);
			return UserMapper.convertToDto(user);
		}
		
		return null;
	}
	



	@Override
	public UserDTO assignReclamationToUser(long id, ReclamationDTO reclamation) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			Reclamation rec=ReclamationMapper.convertToEntity(reclamation);
			rec.setUser(user);
			reclamationRepository.save(rec);
			return UserMapper.convertToDto(user);
		}
		return null;
	}
	



	@Override
	public UserDTO assignPaiementToUser(long id, PaiementDTO paiement) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			Paiement pai=PaiementMapper.convertToEntity(paiement);
			pai.setUser(user);
			paiementRepository.save(pai);
			return UserMapper.convertToDto(user);
		}
		return null;
	}



	@Override
	public UserDTO assignCoursToUser(long id, CoursDTO cours) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			Set<Cours> courss=user.getCours();
			courss.add(CoursMapper.convertToEntity(cours));
			return UserMapper.convertToDto(userRepository.save(user));
		}
		
		return null;
	}

	public Optional<UserDTO> updateOneUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id).map(user -> {
            user.setNom(userDTO.getNom());
            user.setRole(userDTO.getRole());
            user.setPrenom(userDTO.getPrenom());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setDateDeNaissance(userDTO.getDateDeNaissance());
            user.setTelephone(userDTO.getTelephone());
            user.setCin(userDTO.getCin());
            user.setPhoto(userDTO.getPhoto());
            user.setGenre(userDTO.getGenre());
            userRepository.save(user);
            return new UserDTO();
        });
    }

}
