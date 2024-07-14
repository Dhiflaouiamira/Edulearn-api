package com.tekup.EduLearnapi.mappers;

import org.modelmapper.ModelMapper;

import com.tekup.EduLearnapi.dto.BlogDTO;
import com.tekup.EduLearnapi.model.Blog;

public class BlogMapper {
	private static final ModelMapper modelMapper= new ModelMapper();

	public static BlogDTO convertToDto(Blog blog)
	{
		return modelMapper.map(blog, BlogDTO.class);
	}
	public static Blog convertToEntity(BlogDTO blogDTO)
	{
		return modelMapper.map(blogDTO, Blog.class);
	}
}
