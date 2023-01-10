package com.example.seouldream.cocheline.services;


import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.models.*;
import com.example.seouldream.cocheline.repositories.*;
import com.example.seouldream.cocheline.utils.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class LoginService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;


  public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
  }

  public LoginResultDto login(String userName, String password) throws LoginFailed {
    User user = userRepository.findByUserName(userName)
        .orElseThrow(LoginFailed::new);

    if(!user.authenticate(passwordEncoder,password)) {
      throw new LoginFailed();
    }

    String accessToken = jwtUtil.encode(user.getId());

    return new LoginResultDto(
        accessToken,
        user.getName(),
        user.getRole()
    );
  }
}
