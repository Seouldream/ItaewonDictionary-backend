package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
                     PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User create(UserRegistrationDto userRegistrationDto) {
    String userName = userRegistrationDto.getUserName();

    if(!((userRepository.getByUserName(userName)) == null)) {
      throw new ExistedAccount();
    }

    User user = new User(null,
        userRegistrationDto.getName(),
        userRegistrationDto.getUserName());

    user.changePassword(passwordEncoder, userRegistrationDto.getPassword());

    userRepository.save(user);

    return user;
  }
}