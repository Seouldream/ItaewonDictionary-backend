package com.example.seouldream.cocheline.utils;

import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@Component
public class S3Uploader {
  private final AmazonS3Client amazonS3Client;

  @Value("${cloud.aws.s3.bucket}")
  private String bucket;

  public S3Uploader(AmazonS3Client amazonS3Client) {
    this.amazonS3Client = amazonS3Client;
  }

  public String uploadFiles(
      MultipartFile multipartFile, String dirName) throws IOException {
    File uploadFile = convert(multipartFile).orElseThrow(() ->
        new IllegalArgumentException("error: MultipartFile -> File convert fail"));
    return upload(uploadFile, dirName);
  }

  public String upload(File uploadFile, String filePath) {

    String fileName = filePath + "/" + UUID.randomUUID() + uploadFile.getName();
    String uploadRecordUrl = putS3(uploadFile, fileName);
    removeNewFile(uploadFile);
    return uploadRecordUrl;
  }

  private String putS3(File uploadFile, String fileName) {
    amazonS3Client.putObject(
        new PutObjectRequest(bucket, fileName, uploadFile)
            .withCannedAcl(CannedAccessControlList.PublicRead));
    return amazonS3Client.getUrl(bucket, fileName).toString();
  }

  private void removeNewFile(File targetFile) {
    if (targetFile.delete()) {
      System.out.println("File delete success");
      return;
    }
    System.out.println("File delete fail");
  }

  private Optional<File> convert(MultipartFile file) throws IOException {
    File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
    // 확장자가 .m4a로 끝나면 mp3파일로 변환
    if (file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4).equals(
        ".m4a")
    ) {
      convertFile = new File(file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - 4)
          + ".mp3");
    }

    if (convertFile.createNewFile()) {
      try (FileOutputStream fileOutputStream = new FileOutputStream(convertFile)) {
        fileOutputStream.write(file.getBytes());
      }
      return Optional.of(convertFile);
    }
    return Optional.empty();
  }
}
