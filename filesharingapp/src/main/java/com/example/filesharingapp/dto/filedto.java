package com.example.filesharingapp.dto;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class filedto {
    private int id;

    private String name;
    private String description;
    private String filePath;
    private LocalDateTime createdAt;
    

    private byte[] fileData;

}


