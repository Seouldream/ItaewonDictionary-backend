package com.example.seouldream.cocheline.exceptions;

public class ExistedAccount extends RuntimeException {
  public ExistedAccount() {
    super("이미 존재하는 계정입니다.");
  }
}
