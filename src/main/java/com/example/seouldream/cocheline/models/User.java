package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.springframework.security.crypto.password.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String userName;
  private String role = "user";
  private String password;

  public User() {
  }


  public User(Long id, String name, String userName) {
    this.id = id;
    this.name = name;
    this.userName = userName;
  }

  public User(Long id, String name, String userName, String password) {
    this.id = id;
    this.name = name;
    this.userName = userName;
    this.password = password;
  }

  public static User fake(String userName) {
    return new User(1L,"김명훈",userName,"password");
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUserName() {
    return userName;
  }

  public String getRole() {
    return role;
  }

  public String getPassword() {
    return password;
  }


  public void changePassword(PasswordEncoder passwordEncoder, String password) {
    this.password = passwordEncoder.encode(password);
  }

  public boolean authenticate(PasswordEncoder passwordEncoder, String password) {
    return passwordEncoder.matches(password, this.password);
  }

  public UserCreatedDto toCreatedDto() {
    return new UserCreatedDto(id, name, userName);
  }
}
