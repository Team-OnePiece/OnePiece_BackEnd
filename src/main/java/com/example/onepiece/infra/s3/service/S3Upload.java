package com.example.onepiece.infra.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.onepiece.infra.s3.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Upload {

    private String bucket = "onepiece"; // TODO: 2023-07-19  

    private final AmazonS3 amazonS3;

    public String uploadImage(MultipartFile multipartFile) {
        return upload(multipartFile);
    }

    private String getImageUrl(String s3FileName) {
        return amazonS3.getUrl(bucket, s3FileName).toString();
    }

    public String upload(MultipartFile multipartFile) {

        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        ObjectMetadata objMeta = new ObjectMetadata();

        try {
            objMeta.setContentLength(multipartFile.getInputStream().available());
            amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        } catch (IOException e) {
            throw ImageNotFoundException.EXCEPTION;
        }

        return getImageUrl(s3FileName);
    }
}