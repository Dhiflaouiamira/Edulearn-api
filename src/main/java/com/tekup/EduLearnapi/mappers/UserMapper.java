package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.model.User;

public class UserMapper {

	private static final ModelMapper modelMapper= new ModelMapper();

	public static UserDTO convertToDto(User user)
	{
		return modelMapper.map(user, UserDTO.class);
	}
	public static User convertToEntity(UserDTO userDTO)
	{
		return modelMapper.map(userDTO, User.class);
	}
}
