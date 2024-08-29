package com.tekup.EduLearnapi.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BlogDTO {

	@Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
   
    
    @Column(nullable = false)
    
    @Lob
    private String cover1;
    @Column(nullable = false)
    
    @Lob
    private  String cover;
    @Column(nullable = false)
    
    
    @Lob
    private  String cover2;
    @Column(nullable = false)
    
    
    
    private LocalDateTime createdAt;
    
    @JsonIgnoreProperties("blogs")
    private UserDTO user;
    
  
}
