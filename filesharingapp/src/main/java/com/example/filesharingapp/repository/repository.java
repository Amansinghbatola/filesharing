package com.example.filesharingapp.repository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.filesharingapp.entity.entity;

public interface repository extends JpaRepository<entity, Integer> {
    List<entity>searchbyexpiriy(LocalDateTime expiryDate);
    // Additional query methods can be defined here if needed

}
