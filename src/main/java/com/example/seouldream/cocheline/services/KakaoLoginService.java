package com.example.seouldream.cocheline.services;

import com.example.seouldream.cocheline.dtos.KakaoAccountDto;
import com.example.seouldream.cocheline.dtos.LoginResultDto;
import com.example.seouldream.cocheline.models.KakaoAccount;
import com.example.seouldream.cocheline.models.User;
import com.example.seouldream.cocheline.models.UserId;
import com.example.seouldream.cocheline.repositories.UserRepository;
import com.example.seouldream.cocheline.utils.JwtUtil;
import com.example.seouldream.cocheline.utils.KakaoApiService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KakaoLoginService {
    private final JwtUtil jwtUtil;
    private final KakaoApiService kakaoApiService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public KakaoLoginService(JwtUtil jwtUtil, KakaoApiService kakaoApiService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.kakaoApiService = kakaoApiService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public LoginResultDto login(String code) {
        String kakaoAccessToken = kakaoApiService.requestAccessToken(code);
        KakaoAccountDto kakaoAccountDto = kakaoApiService.fetchUser(kakaoAccessToken);

        String name = kakaoAccountDto.getProfile().getNickname();

        String email = kakaoAccountDto.getEmail();

        Optional<User> foundUser = userRepository.findByUserName("kakao " + email);

        if ( foundUser == null ) {
            User user = new User(null, name, "kakao " + email);

            user.changePassword(passwordEncoder, email);

            userRepository.save(user);

            String accessToken = jwtUtil.encode(user.getId());

            return new LoginResultDto(accessToken, name, user.getRole());
        }

        String accessToken = jwtUtil.encode(foundUser.get().getId());

        String role = foundUser.get().getRole();
        return new LoginResultDto(accessToken, name, role);
    }
}
