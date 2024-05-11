package com.tekup.EduLearnapi.repository;

import com.tekup.EduLearnapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
