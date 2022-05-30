package com.example.excel.util;

import com.example.excel.data.Fish;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CsvService {

  public <T> void download(String fileName, List<T> contents) {

    // validation
    if (contents == null) {
      return;
    }

    fileName = fileName + ".csv";

    List<String> headers = ReflectionUtil.getHeaders(contents.get(0).getClass());

    // file write (try with resource)
    File file = new File(System.getProperty("user.dir") + File.separator + fileName);

    try (BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
        StandardCharsets.UTF_8))) {

      fw.write("\uFEFF"); // utf-8 bom

      // header
      fw.write("no");
      fw.write(",");
      for (String head : headers) {
        fw.write(head);
        fw.write(",");
      }
      fw.write("\n");

      // content
      int idx = 1;
      for (var item : contents) {

        fw.write(Integer.toString(idx));
        fw.write(",");
        for (Method m : ReflectionUtil.getSortedMethodPerItem(headers, item)) {
          fw.write(m.invoke(item).toString());
          fw.write(",");
        }

        fw.write("\n");
        idx++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }




}
