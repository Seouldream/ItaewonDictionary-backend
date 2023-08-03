package com.example.seouldream.cocheline.controllers;
import com.example.seouldream.cocheline.dtos.LoginResultDto;
import com.example.seouldream.cocheline.dtos.OAuthTokenRequestDto;
import com.example.seouldream.cocheline.services.KakaoLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    private KakaoLoginService kakaoLoginService;

    public OAuthController(KakaoLoginService kakaoLoginService) {
        this.kakaoLoginService = kakaoLoginService;
    }

    @PostMapping("oauth/kakao")
    LoginResultDto token(
            @RequestBody OAuthTokenRequestDto oAuthTokenRequestDto
    ) {

        System.out.println("IN!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String code = oAuthTokenRequestDto.getCode();
        return kakaoLoginService.login(code);
//        return kakaoLoginService.login(code);
    }
}
