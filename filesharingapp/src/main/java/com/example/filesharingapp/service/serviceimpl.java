package com.example.filesharingapp.service;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.filesharingapp.entity.entity;
import com.example.filesharingapp.repository.repository;

public class serviceimpl implements service {
    private  repository fileRepository;
    private ModelMapper modelmapper;


    // Implement the methods defined in the sevice interface
    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file, String uploadby) throws IOException {
        // Implementation logic for file upload
        return null; // Replace with actual implementation
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(int id) throws IOException {
        // Implementation logic for file download
        return null; // Replace with actual implementation
    }

    @Override
    public List<entity> getAllFiles() {
        // Implementation logic to get all files
        return null; // Replace with actual implementation
    }

    @Override
    public ResponseEntity<?> deletefile(int id) {
        // Implementation logic to delete a file
        return null; // Replace with actual implementation
    }

    @Override
    public ResponseEntity<?> sharfile(int id) {
        // Implementation logic to share a file
        return null; // Replace with actual implementation
    }

    @Override
    public void deleteFile(int id) {
        // Implementation logic to delete a file by ID
    }


}
