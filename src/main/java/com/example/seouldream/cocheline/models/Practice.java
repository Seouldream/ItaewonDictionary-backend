package com.example.seouldream.cocheline.models;


import com.example.seouldream.cocheline.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.*;

@Entity
public class Practice {
  @Id
  @GeneratedValue
  private Long id;
  private Long userId;
  private String title;
  private String situation;
  private String koreanScript;

  private String englishScript;

  private String recordUrl;
  private String state;
  @CreationTimestamp
  private LocalDateTime createdAt;

  public Practice() {
  }

  public Practice(Long userId,
                  String title,
                  String situation,
                  String koreanScript,
                  String englishScript,
                  String recordUrl,
                  String state) {
    this.userId = userId;
    this.title = title;
    this.situation = situation;
    this.koreanScript = koreanScript;
    this.englishScript = englishScript;
    this.recordUrl = recordUrl;
    this.state = state;
  }

  public Long getUserId() {
    return userId;
  }



  public Practice(Long id,
                  Long userId,
                  String title,
                  String situation,
                  String koreanScript,
                  String englishScript,
                  String recordUrl,
                  String state) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.situation = situation;
    this.koreanScript = koreanScript;
    this.englishScript = englishScript;
    this.recordUrl = recordUrl;
    this.state = state;
  }

  public static Practice fake() {
    return new Practice(1L,
        1L,
        "카페에서 지갑 잃어버렸을때", "커피숍에서 5년만에 국제 중학교 동창 Jake를 만났다. Jake는 나를 못알아보는 듯 하다. 하지만 그는 분명히 Jake야! 어떻게 말을 걸 수 있을까?",
        "you…Jake..? Hi! I am Mike from GIT middle school. we used to play basketball together.",
        "어..저기 제이크니? 나 **이야 기억해? ",
        "url",
        "미답변"
    );
  }

  public static Practice fake2() {
    return new Practice(1L,
        1L,
        "카페에서 지갑 잃어버렸을때", "커피숍에서 5년만에 국제 중학교 동창 Jake를 만났다. Jake는 나를 못알아보는 듯 하다. 하지만 그는 분명히 Jake야! 어떻게 말을 걸 수 있을까?",
        "you…Jake..? Hi! I am Mike from GIT middle school. we used to play basketball together.",
        "어..저기 제이크니? 나 **이야 기억해? ",
        "url",
        "미답변"
    );
  }
  //ToDo 유저닉네임 수정필요
  public PracticeDto toDto(String userName) {
    return new PracticeDto(id,
        userName,
        title,
        situation,
        koreanScript,
        englishScript,
        recordUrl,
        state,
        createdAt);
  }
}
