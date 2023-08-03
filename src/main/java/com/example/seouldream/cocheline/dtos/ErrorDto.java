package com.example.seouldream.cocheline.dtos;

public abstract class ErrorDto {
  private final Integer code;
  private final String message;

  protected ErrorDto(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
