package com.tekup.EduLearnapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.EduLearnapi.model.Blog;
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
