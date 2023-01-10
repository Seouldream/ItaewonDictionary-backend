package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.utils.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@RestController
public class S3FileController {
  private final S3Uploader s3Uploader;

  public S3FileController(S3Uploader s3Uploader) {
    this.s3Uploader = s3Uploader;
  }

  @PostMapping("/upload")
  @ResponseStatus(HttpStatus.CREATED)
  public String upload(MultipartFile multipartFile) throws IOException {
    String fileUrl = s3Uploader.uploadFiles(multipartFile, "temporary");


    return fileUrl;
  }
}
