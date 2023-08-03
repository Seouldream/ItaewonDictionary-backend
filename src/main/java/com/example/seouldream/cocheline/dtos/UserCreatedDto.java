package com.example.seouldream.cocheline.dtos;

public class UserCreatedDto {
  private Long id;

  private String name;

  private String account;

  public UserCreatedDto() {
  }

  public UserCreatedDto(Long id, String name,String account) {
    this.id = id;
    this.name = name;
    this.account = account;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAccount() {
    return account;
  }
}
