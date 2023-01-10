package com.example.seouldream.cocheline.exceptions;

public class NoFoundActivityError extends RuntimeException {
  public NoFoundActivityError() {
    super("존재하지 않거나 삭제된 활동입니다.");
  }
}
