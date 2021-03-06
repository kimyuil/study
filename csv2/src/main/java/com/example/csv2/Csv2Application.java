package com.example.csv2;

import com.example.csv2.service.SundayService;
import com.example.csv2.service.WednesdayService;
import com.example.csv2.service.WorshipList;
import com.example.csv2.util.MakeCsv;
import com.example.csv2.util.MakeExel;
import com.example.csv2.util.MakeFile;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Csv2Application {

  public static void main(String[] args) {
    SpringApplication.run(Csv2Application.class, args);

    List<WorshipList> data = new ArrayList<>();
    data.add(new SundayService("김유일", "청년부", "전도사", 27, "정인태"));
    data.add(new SundayService("홍길동", "가정국", "집사", 30, "정인태"));
    data.add(new SundayService("홍길순", "캠퍼스", "강도사", 24, "정인태"));
    data.add(new SundayService("주별별", "청년부", "", 25, "정인태"));
    data.add(new SundayService("주달달", "가정국", "집사", 37, "정인태"));
    data.add(new SundayService("주해해", "캠퍼스", "", 40, "정인태"));

    MakeFile service = new MakeCsv();
    service.download("test1.csv", data);

    List<WorshipList> data2 = new ArrayList<>();
    data2.add(new WednesdayService("정별별", "캠퍼스", "", 29));
    data2.add(new WednesdayService("정달달", "캠퍼스", "전도사", 27));
    data2.add(new WednesdayService("정해해", "장년부", "집사", 57));

    // service.download("수요예배", data2);
    service = new MakeExel();
    service.download("test2", data2);
  }

}
