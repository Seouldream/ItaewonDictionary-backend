package com.example.seouldream.cocheline.models;

import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "events")
public class Event {
  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String date;
  private String host;
  private String price;
  private String hostEmail;
  private String hostContact;
  private String onOrOffline;
  private String eventType;
  private String category;
  private String homepageAddress;
  private String imgUrl;
  @ElementCollection
  private List<String> hashTags;
  private String content;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Event(Long id,
               String title,
               String date,
               String host,
               String price,
               String hostEmail,
               String hostContact,
               String onOrOffline,
               String eventType,
               String category,
               String homepageAddress,
               String imgUrl,
               List<String> hashTags,
               String content) {
    this.id = id;
    this.title = title;
    this.date = date;
    this.host = host;
    this.price = price;
    this.hostEmail = hostEmail;
    this.hostContact = hostContact;
    this.onOrOffline = onOrOffline;
    this.eventType = eventType;
    this.category = category;
    this.homepageAddress = homepageAddress;
    this.imgUrl = imgUrl;
    this.hashTags = hashTags;
    this.content = content;
  }

  public Event(String title,
               String date,
               String host,
               String price,
               String hostEmail,
               String hostContact,
               String onOrOffline,
               String eventType,
               String category,
               String homepageAddress,
               String imgUrl,
               List<String> hashTags,
               String content) {
    this.title = title;
    this.date = date;
    this.host = host;
    this.price = price;
    this.hostEmail = hostEmail;
    this.hostContact = hostContact;
    this.onOrOffline = onOrOffline;
    this.eventType = eventType;
    this.category = category;
    this.homepageAddress = homepageAddress;
    this.imgUrl = imgUrl;
    this.hashTags = hashTags;
    this.content = content;
  }

  public Event() {
  }

  public static Event fake() {
    Long id = 1L;
    String title = "seedWhale Web seminar";
    String date = "on 12th Nov";
    String host = "seedWhale";
    String price = "free";
    String hostEmail = "seedWhale@google.com";
    String hostContact = "1234";
    String onOrOffline = "online";
    String eventType = "seminar";
    String category = "conference";
    String homepageAddress = "http://megapTera.kr";
    String imgUrl = "https://cdn.pixabay.com/photo/2022/11/03/15/24/coffee-7567749__480.jpg";
    List<String> hashTags = List.of("conference", "seminar");
    String content = "this post is about a new upcoming Event.";

    return new Event(
        id, title, date, host, price, hostEmail, hostContact, onOrOffline,
        eventType, category, homepageAddress, imgUrl, hashTags, content
    );
  }

  public Long getId() {
    return id;
  }

  public EventDto toDto() {
    String registrationDate = createdAt == null ? "" : createdAt.toLocalDate().toString();
    return new EventDto(
        id,
        title,
        date,
        host,
        price,
        hostEmail,
        hostContact,
        onOrOffline,
        eventType,
        category,
        homepageAddress,
        imgUrl,
        content,
        registrationDate,
        hashTags
    );
  }
}












