package com.example.seouldream.cocheline.dtos;

import lombok.Getter;

public class OAuthTokenRequestDto {
    private String code;

    public String getCode() {
        return code;
    }
}
