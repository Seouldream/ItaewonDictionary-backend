package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public UserCreatedDto register(
      @RequestBody UserRegistrationDto userRegistrationDto
  ) {
    User user = userService.create(userRegistrationDto);
    return user.toCreatedDto();
  }

  @ExceptionHandler(ExistedAccount.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto existedAccountNumber() {
    return new ExistedAccountErrorDto();
  }
}
