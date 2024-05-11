package com.tekup.EduLearnapi.model;

import java.time.LocalDateTime;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@PrePersist
	public void Oninit()
	{
		this.createdAt=this.updatedAt=LocalDateTime.now();
	}
	@PreUpdate
	public void OnUpdate()
	{
		this.updatedAt=LocalDateTime.now();
	}
	
}