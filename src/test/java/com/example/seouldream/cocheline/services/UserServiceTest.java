package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
  @Test
  void create() {
    UserRepository userRepository = mock(UserRepository.class);
    PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();

    UserService userService = new UserService(
        userRepository,
        passwordEncoder
    );

    UserRegistrationDto userRegistrationDto = new UserRegistrationDto(
        "김명훈", "11112222", "Qwe1234!", "Qwe1234!"
    );

    User user = userService.create(userRegistrationDto);

    assertThat(user).isNotNull();

    verify(userRepository).save(user);
  }
}
