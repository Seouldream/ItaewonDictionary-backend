package com.example.seouldream.cocheline.config;

import org.springframework.context.annotation.*;
import org.springframework.web.filter.*;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Import(EnableMockMvc.Config.class)
public @interface EnableMockMvc {
  class Config {
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
      return new CharacterEncodingFilter("UTF-8", true);
    }
  }
}
