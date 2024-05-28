package com.tekup.EduLearnapi.Service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.mappers.CoursMapper;
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


	private final UserRepository userRepository;
	
	private final CommentaireRepository  commentaireRepository ;
	
	private final ReclamationRepository reclamationRepository ;
	
	private final PaiementRepository paiementRepository ;

	@Override
	public Page<UserDTO> getAllUsers(Pageable pageable) {
		Page<User> users=userRepository.findAll(pageable);
		return users.map(UserMapper::convertToDto);
		
	}


	@Override
	public UserDTO addOneUser(UserDTO user) {
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
	public UserDTO assignCommentaireToUser(long id, Commentaire commentaire) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			commentaire.setUser(user);
			commentaireRepository.save(commentaire);
			return UserMapper.convertToDto(user);
		}
		
		return null;
	}
	



	@Override
	public UserDTO assignReclamationToUser(long id, Reclamation reclamation) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			reclamation.setUser(user);
			reclamationRepository.save(reclamation);
			return UserMapper.convertToDto(user);
		}
		return null;
	}
	



	@Override
	public UserDTO assignPaiementToUser(long id, Paiement paiement) {
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			paiement.setUser(user);
			paiementRepository.save(paiement);
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
	

}
