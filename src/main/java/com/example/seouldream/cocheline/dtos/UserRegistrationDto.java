package com.example.seouldream.cocheline.dtos;

public class UserRegistrationDto {
  private String name;

  private String userName;

  private String password;

  private String confirmPassword;

  public UserRegistrationDto() {
  }

  public UserRegistrationDto(String name,
                             String userName,
                             String password,
                             String confirmPassword) {
    this.name = name;
    this.userName = userName;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  public String getName() {
    return name;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }
}
