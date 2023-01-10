package com.example.seouldream.cocheline.dtos;

public class LoginRequestDto {
  private String userName;
  private String password;

  public LoginRequestDto() {
  }

  public LoginRequestDto(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}
