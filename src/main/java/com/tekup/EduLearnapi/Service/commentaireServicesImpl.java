package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.CommentaireRepository;
import com.tekup.EduLearnapi.repository.UserRepository;

@Service
public class commentaireServicesImpl implements CommentaireServices{

	@Autowired
	CommentaireRepository commentaireRepository;
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public List<Commentaire> findAll() {
		return commentaireRepository.findAll();
	}

	@Override
	public Commentaire findOne(long id) {
		return commentaireRepository.findById(id).orElse(null);

	}



    @Override
    public Commentaire AddOne(Commentaire commentaire, long idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("User not found"));
        commentaire.setUser(user);
        return commentaireRepository.save(commentaire);
    }

	@Override
	public void DeleteOne(long id) {
		commentaireRepository.deleteById(id);
		
	}

}
