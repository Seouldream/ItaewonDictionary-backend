package com.example.seouldream.cocheline.dtos;

public class IncorrectUserNameErrorDto extends ErrorDto {
  public IncorrectUserNameErrorDto() {
    super(1004, "아이디 혹은 비밀번호가 맞지 않습니다");
  }
}
