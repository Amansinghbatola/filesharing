package com.example.filesharingapp.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.filesharingapp.dto.filedto;
import com.example.filesharingapp.entity.entity;
import com.example.filesharingapp.repository.repository;

@Service
public class serviceimpl implements service {
    private  repository fileRepository;
    private ModelMapper modelmapper;


    // Implement the methods defined in the sevice interface
    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedby) throws IOException {
        entity fileEntity = new entity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setUploadedBy(uploadedby);
        fileEntity.setUploadTime(LocalDateTime.now());
        fileEntity.setExpiryTime(LocalDateTime.now().plusDays(1)); // 24 hours expiry
        fileEntity.setFileData(file.getBytes());
        fileRepository.save(fileEntity);
        filedto fileDto = new filedto();
        
        return ResponseEntity.ok().body(fileDto);
    }
        // Implementation logic for file upload
        

    @Override
    public ResponseEntity<byte[]> downloadFile(int id) throws IOException {
        // Implementation logic for file download
        return null; // Replace with actual implementation
    }

    @Override
    public List<filedto> getAllFiles() {

        List<entity> files = fileRepository.findAll();
       
        return files.stream()
            .map(file -> modelmapper.map(file, filedto.class))
            .toList();
    }

    @Override
    public ResponseEntity<?> deletefile(int id) {
        // Implementation logic to delete a file
        return null; // Replace with actual implementation
    }

    @Override
    public ResponseEntity<?> sharfile(int id) {
       Optional <entity> fileEntity = fileRepository.findById(id);
        if(fileEntity.isPresent()){
            entity file = fileEntity.get();
            filedto fileModel = new filedto();
            modelmapper.map(file, fileModel);
            return ResponseEntity.ok().body(fileModel);
      
            }
       
        else{
             throw new com.example.filesharingapp.exceptions.FileNotFoundException("File not found");
     }
    }
    @Override
    public void deleteFile(int id) {
        Optional<entity> fileEntity = fileRepository.findById(id);
        if (fileEntity.isPresent()) {   
            fileRepository.delete(fileEntity.get());
        } else {
            throw new com.example.filesharingapp.exceptions.FileNotFoundException("File not found with ID: " + id);
        }           
        
        // Implementation logic to delete a file by ID
    }


}
