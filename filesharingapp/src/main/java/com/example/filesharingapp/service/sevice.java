package com.example.filesharingapp.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.filesharingapp.entity.entity;

public interface sevice {
    // Define service methods here, e.g., for file upload, download, etc.
    public ResponseEntity<?> uploadFile(MultipartFile file ,String uploadby) throws IOException;
    public ResponseEntity<byte[]> downloadFile(int id) throws IOException;
    public List<entity> getAllFiles();
    public ResponseEntity<?> deletefile(int id);
    public ResponseEntity<?> sharfile(int id);
      void deleteFile(int id);

}
