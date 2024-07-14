package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.EduLearnapi.Service.BlogServices;
import com.tekup.EduLearnapi.dto.BlogDTO;


	@RestController
	@RequestMapping("/api/blogs")
	public class BlogController {

		 @Autowired
		    private BlogServices blogServices;

		 @GetMapping
		    public Page<BlogDTO> getBlogs(Pageable pageable)
		    {
		    	return blogServices.getAllBlogs(pageable);
		    }

		    @PostMapping
		    public BlogDTO addOneBlog(@RequestBody BlogDTO blog)
		    {
		    return blogServices.addOneBlog(blog);	
		    }

		    @DeleteMapping("/{id}")
		    public void deleteOneBlog(@PathVariable long id)
		    {
		    blogServices.deleteOneBlog(id);	

		    }
		    }
	

	

