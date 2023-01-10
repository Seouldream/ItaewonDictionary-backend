package com.example.seouldream.cocheline.exceptions;

public class NoExistingUser extends RuntimeException{
  public NoExistingUser() {
    super("존재하지않거나 삭제된 유저입니다.");
  }
}
