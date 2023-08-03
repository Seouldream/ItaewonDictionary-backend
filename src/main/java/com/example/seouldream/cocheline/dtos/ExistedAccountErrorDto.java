package com.example.seouldream.cocheline.dtos;

public class ExistedAccountErrorDto extends ErrorDto {
  public ExistedAccountErrorDto() {
    super(1006, "이미 존재하는 계정입니다.");
  }
}
