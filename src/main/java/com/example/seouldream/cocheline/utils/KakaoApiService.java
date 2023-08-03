package com.example.seouldream.cocheline.utils;

import com.example.seouldream.cocheline.dtos.KakaoAccountDto;
import com.example.seouldream.cocheline.dtos.KakaoOAuthTokenDto;
import com.example.seouldream.cocheline.dtos.KakaoUserDto;
import com.example.seouldream.cocheline.models.KakaoAccount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoApiService {
    private final String appKey;

    private final String redirectUri;

    private final RestTemplate restTemplate;



    public KakaoApiService(
            @Value("${kakao.api-key}") String appKey,
            @Value("${kakao.redirectUrl}") String redirectUri,
            RestTemplate restTemplate) {
        this.appKey = appKey;
        this.redirectUri = redirectUri;
        this.restTemplate = restTemplate;
    }

    public String requestAccessToken(String code) {
        if (code.startsWith("TEST-CODE-")) {
            return "TEST-ACCESS-TOKEN-" + code.substring("TEST-CODE-".length());
        }

        String url = "https://kauth.kakao.com/oauth/token";

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("client_id", appKey);
        formData.add("redirect_uri", redirectUri);
        formData.add("code", code);

        KakaoOAuthTokenDto data = restTemplate.postForObject(
                url, formData, KakaoOAuthTokenDto.class);

        if (data == null) {
            return null;
        }

        return data.getAccessToken();
    }

    public KakaoAccountDto fetchUser(String accessToken) {
        if (accessToken.startsWith("TEST-ACCESS-TOKEN-")) {
            return null;
        }

        String url = "https://kapi.kakao.com/v2/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<KakaoUserDto> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, KakaoUserDto.class);

        KakaoUserDto body = response.getBody();

        return body.getKakao_account();

    }
}
