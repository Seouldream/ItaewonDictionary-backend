package com.example.seouldream.cocheline.exceptions;

public class AuthenticationError extends RuntimeException {
  public AuthenticationError() {
    super("Authentication error");
  }
}
