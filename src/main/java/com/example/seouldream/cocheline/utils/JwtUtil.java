package com.example.seouldream.cocheline.utils;

import com.auth0.jwt.*;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.interfaces.*;

public class JwtUtil {
  private Algorithm algorithm;

  public JwtUtil(String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  public String encode(Long userId) {
    return JWT.create()
        .withClaim("userId", userId)
        .sign(algorithm);
  }

  public Long decode(String token) {
    System.out.println("token: " + token);
    JWTVerifier verifier = JWT.require(algorithm).build();
    DecodedJWT verify = verifier.verify(token);

    return verify.getClaim("userId").asLong();
  }
}
