package com.example.seouldream.cocheline.interceptors;

import com.auth0.jwt.exceptions.*;
import com.example.seouldream.cocheline.exceptions.*;
import com.example.seouldream.cocheline.utils.*;
import org.springframework.web.servlet.*;

import javax.servlet.http.*;

public class AuthenticationInterceptor implements HandlerInterceptor {
  private final JwtUtil jwtUtil;

  public AuthenticationInterceptor(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) {
    String authorization = request.getHeader(("Authorization"));

    if( authorization == null || !authorization.startsWith("Bearer ")) {
      return true;
    }

    String accessToken = authorization.substring("Bearer ".length());
    try {

      Long userId = jwtUtil.decode(accessToken);

      request.setAttribute("userId", userId);

      return true;
    } catch (JWTCreationException exception) {
      throw new AuthenticationError();
    }
  }
}
