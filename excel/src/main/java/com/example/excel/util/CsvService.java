package com.example.excel.util;

import com.example.excel.data.Fish;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvService {

  public void download(String fileName, List<Fish> content) {

    // validation
    if (content == null) {
      return;
    }

    fileName = fileName + ".csv";

    // todo 리플렉션으로 리팩토링
    List<String> header = List.of("최소ph","최대ph","길이","색깔","요구포만도","현재포만도","질병여부");

    // file write (try with resource)
    File file = new File(System.getProperty("user.dir") + "\\" + fileName);

    try (BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
        StandardCharsets.UTF_8))) {

      fw.write("\uFEFF"); // utf-8 bom

      // header
      fw.write("no");
      fw.write(",");
      for (String head : header) {
        fw.write(head);
        fw.write(",");
      }
      fw.write("\n");

      // content
      int idx = 1;
      for (var item : content) {

        fw.write(Integer.toString(idx));
        fw.write(",");

        // todo 리플랙션 리팩토링
        fw.write(Double.toString(item.get최소ph()));
        fw.write(",");
        fw.write(Double.toString(item.get최대ph()));
        fw.write(",");
        fw.write(Integer.toString(item.get길이()));
        fw.write(",");
        fw.write(item.get색깔());
        fw.write(",");
        fw.write(Integer.toString(item.get요구포만도()));
        fw.write(",");
        fw.write(Integer.toString(item.get현재포만도()));
        fw.write(",");
        fw.write(Boolean.toString(item.get질병여부()));
        fw.write(",");

        fw.write("\n");
        idx++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
