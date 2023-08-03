package com.example.seouldream.cocheline.dtos;

public class GrammarNotFoundErrorDto extends ErrorDto {
  public GrammarNotFoundErrorDto() {
    super(1001, "그래마가 아직 존재하지 않아요! 업데이트를 기다려주세요!");
  }
}
