package com.example.seouldream.cocheline.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoOAuthTokenDto {

    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    private String accessToken;
}