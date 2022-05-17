package com.example.excel;

import com.example.excel.data.Fish;
import com.example.excel.util.CsvService;
import com.example.excel.util.ExcelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ExcelApplication {

  public static void main(String[] args) {

    SpringApplication.run(ExcelApplication.class, args);
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());

    List<Fish> fishList = new ArrayList<>();
    for(int i = 0 ; i < 1000 ; i ++){
      fishList.add(Fish.builder()
              .최대ph(random.nextDouble()*10)
              .최소ph(random.nextDouble()*10)
              .길이(random.nextInt(20))
              .색깔( // a~z 까지 5개 글자 랜덤 string
                  random.ints(97,122)
                      .limit(5)
                      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                      .toString())
              .현재포만도(0)
              .요구포만도(random.nextInt(30))
              .질병여부(random.nextBoolean())
          .build());
    }

    // 상위 5개 값 확인
    int i = 1;
    for(var f : fishList){
      System.out.println(f);
      i++;
      if(i>5){
        break;
      }
    }

    CsvService csvService = new CsvService();
    csvService.download("test", fishList);
    ExcelService excelService = new ExcelService();
    excelService.download("test",fishList);



  }

}
