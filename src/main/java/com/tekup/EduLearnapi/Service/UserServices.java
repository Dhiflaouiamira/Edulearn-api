package com.tekup.EduLearnapi.Service;


import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.Reclamation;

public interface UserServices {
	
	public Page<UserDTO> getAllUsers(Pageable pageable) ;
	public UserDTO addOneUser(UserDTO user);
	public void deleteOneUser(long id);
	public Optional<UserDTO> findOneUser(long id);
	public UserDTO assignCommentaireToUser(long id,Commentaire commentaire);
	public UserDTO assignReclamationToUser(long id,Reclamation reclamation);
	public UserDTO assignPaiementToUser(long id,Paiement paiement);
	public UserDTO assignCoursToUser(long id,CoursDTO cours);

}
