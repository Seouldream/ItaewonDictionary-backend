package com.example.seouldream.cocheline.dtos;

public class PracticeRegistrationDto {
  private String title;
  private String situation;
  private String koreanScript;

  public PracticeRegistrationDto(String title, String situation, String koreanScript, String englishScript) {
    this.title = title;
    this.situation = situation;
    this.koreanScript = koreanScript;
    this.englishScript = englishScript;
  }

  private String englishScript;

  public static PracticeRegistrationDto fake() {
   return new PracticeRegistrationDto("바에서 외국인 친구를 사귈때",
        "바에 가서 혼자 맥주를 마시다 옆에서 외국인무리와 말을 섞게 됬다. 어떻게 말을 이어가야할까?",
        "어디서 왔어요?",
        "hey, where are you from?");
  }

  public String getTitle() {
    return title;
  }

  public String getSituation() {
    return situation;
  }

  public String getKoreanScript() {
    return koreanScript;
  }

  public String getEnglishScript() {
    return englishScript;
  }
}
