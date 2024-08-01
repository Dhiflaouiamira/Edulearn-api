package com.tekup.EduLearnapi.Service;


import java.util.Optional;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.CoursDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.dto.UserDTO;

public interface UserServices {
	
	public Page<UserDTO> getAllUsers(Pageable pageable) ;
	public UserDTO addOneUser(UserDTO user);
	public void deleteOneUser(long id);
	public Optional<UserDTO> findOneUser(long id);
	public UserDTO assignCommentaireToUser(long id,CommentaireDTO commentaire);
	public UserDTO assignReclamationToUser(long id,ReclamationDTO reclamation);
	public UserDTO assignPaiementToUser(long id,PaiementDTO paiement);
	public UserDTO assignCoursToUser(long id,CoursDTO cours);
	public Optional<UserDTO> updateOneUser(Long id, UserDTO userDTO);

}
