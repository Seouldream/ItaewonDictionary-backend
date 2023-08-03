package com.example.seouldream.cocheline.backdoor;

import org.hibernate.annotations.*;
import org.springframework.jdbc.core.*;
import org.springframework.security.crypto.password.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

@RestController
@RequestMapping("backdoor")
@Transactional
public class BackDoorController {
  private JdbcTemplate jdbcTemplate;
  private PasswordEncoder passwordEncoder;

  public BackDoorController(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
    this.jdbcTemplate = jdbcTemplate;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping("delete-all")
  public String deleteAllData() {
    jdbcTemplate.execute("DELETE FROM activity");
    jdbcTemplate.execute("DELETE FROM activity_comment");
    jdbcTemplate.execute("DELETE FROM basic_template");
    jdbcTemplate.execute("DELETE FROM category");
    jdbcTemplate.execute("DELETE FROM grammar");
    jdbcTemplate.execute("DELETE FROM person");
    jdbcTemplate.execute("DELETE FROM practical_template");
    jdbcTemplate.execute("DELETE FROM practice");
    jdbcTemplate.execute("DELETE FROM practice_comment");

    return "delete all data complete";
  }

  @GetMapping("setup-database")
  public String setupDataBase() {

    jdbcTemplate.execute("DELETE FROM practice");

    jdbcTemplate.update("INSERT INTO practice(" +
        "id, user_id, title, situation, korean_script," +
        " english_script, record_url, state, created_at)" +
        "VALUES" +
        "(1,1,'카페에서 지갑 잃어버렸을때'," +
        "'커피숍에서 5년만에 국제 중학교 동창 Jake를 만났다. Jake는 나를 못알아보는 듯 하다. 하지만 그는 분명히 Jake야! 어떻게 말을 걸 수 있을까??'," +
        "'어..저기 제이크니? 나 **이야 기억해? 우리 같은 **국제중학교 출신이잖아! 같이 농구도 하곤 했었는데.꽤 오랜만인데 어떻게 지냈어? 잘 지냈어?'," +
        "'you…Jake..? Hi! I am Mike from GIT middle school. we used to play basketball together. Don’t you remember me? How have you been?'," +
        "'https://itaewondictionary.s3.ap-northeast-2.amazonaws.com/temporary/08511827-c9d9-4c85-8d4a-24d84cb60dc9audioExample.mp3'," +
        "'미답변'," +
        "'2021-02-25T16:10:45.8306309'),\n"

        + "(2,1,'친구와 싸웠을때'," +
        " '10년만에 만난 친구와 사상 차이로 다투었다. 어떻게 화해할 수 있을까?'," +
        "'어..저기 제이크니? 나 **이야 기억해? 우리 같은 **국제중학교 출신이잖아! 같이 농구도 하곤 했었는데.꽤 오랜만인데 어떻게 지냈어? 잘 지냈어?'," +
        "'you…Jake..? Hi! I am Mike from GIT middle school. we used to play basketball together. Don’t you remember me? How have you been?'," +
        "'https://itaewondictionary.s3.ap-northeast-2.amazonaws.com/temporary/08511827-c9d9-4c85-8d4a-24d84cb60dc9audioExample.mp3'," +
        "'미답변'," +
        "'2021-02-25T16:10:45.8306309'),\n"

        + "(3,1,'바에서 외국인 친구를 사귈때'," +
        " '바에 가서 혼자 맥주를 마시다 옆에서 외국인무리와 말을 섞게 됬다. 어떻게 말을 이어가야할까?'," +
        "'어..저기 제이크니? 나 **이야 기억해? 우리 같은 **국제중학교 출신이잖아! 같이 농구도 하곤 했었는데.꽤 오랜만인데 어떻게 지냈어? 잘 지냈어?'," +
        "'you…Jake..? Hi! I am Mike from GIT middle school. we used to play basketball together. Don’t you remember me? How have you been?'," +
        "'https://itaewondictionary.s3.ap-northeast-2.amazonaws.com/temporary/08511827-c9d9-4c85-8d4a-24d84cb60dc9audioExample.mp3'," +
        "'답변완료'," +
        "'2021-02-25T16:10:45.8306309'),\n"

        + "(4,1,'바에서 외국인 친구를 사귈때'," +
        "'바에 가서 혼자 맥주를 마시다 옆에서 외국인무리와 말을 섞게 됬다. 어떻게 말을 이어가야할까?'," +
        "'어..저기 제이크니? 나 **이야 기억해? 우리 같은 **국제중학교 출신이잖아! 같이 농구도 하곤 했었는데.꽤 오랜만인데 어떻게 지냈어? 잘 지냈어?'," +
        "'you…Jake..? Hi! I am Mike from GIT middle school. we used to play basketball together. Don’t you remember me? How have you been?'," +
        "'https://itaewondictionary.s3.ap-northeast-2.amazonaws.com/temporary/08511827-c9d9-4c85-8d4a-24d84cb60dc9audioExample.mp3'," +
        "'답변완료'," +
        "'2021-02-25T16:10:45.8306309')\n");


    return "setup database completed";
  }

  @GetMapping("setup-admin")
  public String adminSetup() {

    jdbcTemplate.execute("DELETE FROM person\n" +
        "WHERE id = 1000;");

    jdbcTemplate.execute("DELETE FROM person\n" +
        "WHERE id = 1001;");

    jdbcTemplate.update("INSERT INTO person(" +
            "id,name, password, user_name, role)" +
            "VALUES" +
            "(1000,'관리자1🦕', ?,'admin123','admin')",
        passwordEncoder.encode("Admin@1234"));

    jdbcTemplate.update("INSERT INTO person(" +
            "id,name, password, user_name, role)" +
            "VALUES" +
            "(1001,'관리자2🐥', ?,'admin456','admin')",
        passwordEncoder.encode("Admin@4567"));

    return "setup admin accounts complete";
  }
}
