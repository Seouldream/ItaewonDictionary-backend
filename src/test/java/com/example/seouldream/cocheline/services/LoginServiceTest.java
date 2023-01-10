package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import com.example.seouldream.cocheline.utils.*;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class LoginServiceTest {
  private LoginService loginService;

  private UserRepository userRepository;

  private PasswordEncoder passwordEncoder;

  private JwtUtil jwtUtil;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);

    passwordEncoder = new Argon2PasswordEncoder();

    jwtUtil = new JwtUtil("secret");

    loginService = new LoginService(userRepository, passwordEncoder, jwtUtil);
  }

  @Test
  void loginSuccess() throws LoginFailed {

    User user = User.fake("tester1234!");

    user.changePassword(passwordEncoder, "password");

    given(userRepository.findByUserName(any()))
        .willReturn(Optional.of(user));

    LoginResultDto loginResultDto = loginService.login(user.getUserName(), "password");

    assertThat(loginResultDto.getName()).isEqualTo("김명훈");
  }

}