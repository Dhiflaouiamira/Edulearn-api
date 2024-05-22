package com.tekup.EduLearnapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {


	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();

	}

	@Override
	public User findOne(long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User AddOne(User user) {
		return userRepository.save(user);

	}

	@Override
	public void DeleteOne(long id) {
		userRepository.deleteById(id);
		
	}

	
	
	

}
