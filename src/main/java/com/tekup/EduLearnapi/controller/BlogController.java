package com.tekup.EduLearnapi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.BlogServices;
import com.tekup.EduLearnapi.dto.BlogDTO;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogServices blogServices;

    // Get all blogs with pagination
    @GetMapping
    public ResponseEntity<Page<BlogDTO>> getBlogs(Pageable pageable) {
        Page<BlogDTO> blogs = blogServices.getAllBlogs(pageable);
        return ResponseEntity.ok(blogs);
    }

    // Get a blog by ID
    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable long id) {
        return blogServices.findOneBlog(id)
                .map(blog -> ResponseEntity.ok(blog))
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new blog
    @PostMapping
    public ResponseEntity<BlogDTO> addOneBlog(@RequestBody BlogDTO blogDTO) {
        BlogDTO createdBlog = blogServices.addOneBlog(blogDTO);
        return ResponseEntity.status(201).body(createdBlog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateOneBlog(@PathVariable long id, @RequestBody BlogDTO blogDTO) {
        return blogServices.updateOneBlog(id, blogDTO)
                .map(updatedBlog -> ResponseEntity.ok(updatedBlog))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneBlog(@PathVariable long id) {
        blogServices.deleteOneBlog(id);
        return ResponseEntity.noContent().build();
    }

}
