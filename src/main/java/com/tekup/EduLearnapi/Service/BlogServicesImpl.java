package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekup.EduLearnapi.dto.BlogDTO;
import com.tekup.EduLearnapi.mappers.BlogMapper;
import com.tekup.EduLearnapi.model.Blog;
import com.tekup.EduLearnapi.repository.BlogRepository;

@Service
public class BlogServicesImpl implements BlogServices{
	@Autowired
	BlogRepository blogRepository;

	@Override
	public Page<BlogDTO> getAllBlogs(Pageable pageable) {
		Page<Blog> blogs=blogRepository.findAll(pageable);
		return blogs.map(BlogMapper::convertToDto);
		
	}


	@Override
	public BlogDTO addOneBlog(BlogDTO blog) {
		return BlogMapper.convertToDto(blogRepository.save(BlogMapper.convertToEntity(blog)));

	}

	@Override
	public void deleteOneBlog(long id) {
		blogRepository.deleteById(id);		
	}



	@Override
	public Optional<BlogDTO> findOneBlog(long id) {
		return blogRepository.findById(id).map(BlogMapper::convertToDto);

	}

}

