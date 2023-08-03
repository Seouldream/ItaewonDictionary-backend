package com.example.seouldream.cocheline.dtos;

public class LoginResultDto {
  private String accessToken;
  private String name;
  private String role;


  public LoginResultDto(String accessToken, String name, String role) {
    this.accessToken = accessToken;
    this.name = name;
    this.role=role;
  }

  public LoginResultDto(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getName() {
    return name;
  }

  public String getRole() {
    return role;
  }
}
