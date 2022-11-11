package com.example.seouldream.cocheline.dtos;

public class RequestedEventDto {
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
  private String hashTags;
  private String content;

  public RequestedEventDto(String title,
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
                           String hashTags,
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

  public String getTitle() {
    return title;
  }

  public String getDate() {
    return date;
  }

  public String getHost() {
    return host;
  }

  public String getPrice() {
    return price;
  }

  public String getHostEmail() {
    return hostEmail;
  }

  public String getHostContact() {
    return hostContact;
  }

  public String getOnOrOffline() {
    return onOrOffline;
  }

  public String getEventType() {
    return eventType;
  }

  public String getCategory() {
    return category;
  }

  public String getHomepageAddress() {
    return homepageAddress;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public String getHashTags() {
    return hashTags;
  }

  public String getContent() {
    return content;
  }
}
