package com.tekup.EduLearnapi.Service;

import java.util.List;

import com.tekup.EduLearnapi.model.User;

public interface UserServices {

	public List<User> findAll();
	public User findOne(long id);
	public User AddOne(User user);
	public void DeleteOne(long id);
}
