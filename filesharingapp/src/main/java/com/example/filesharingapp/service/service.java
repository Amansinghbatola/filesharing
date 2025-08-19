package com.example.filesharingapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.filesharingapp.dto.filedto;

public interface service {
    
    // Define service methods here, e.g., for file upload, download, etc.
   
    public void deleteFile(int id);
    public ResponseEntity<?> uploadFile(MultipartFile file ,String uploadby) throws IOException;
    public ResponseEntity<byte[]> downloadFile(int id) throws IOException;
    public List<filedto> getAllFiles();
    public ResponseEntity<?> deletefile(int id);
    public ResponseEntity<?> sharfile(int id);

}
