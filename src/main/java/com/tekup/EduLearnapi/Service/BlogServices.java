package com.tekup.EduLearnapi.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekup.EduLearnapi.dto.BlogDTO;

public interface BlogServices {

	
	public Page<BlogDTO> getAllBlogs(Pageable pageable) ;
	public BlogDTO addOneBlog(BlogDTO blog);
	public void deleteOneBlog(long id);
	public Optional<BlogDTO> findOneBlog(long id);
}
