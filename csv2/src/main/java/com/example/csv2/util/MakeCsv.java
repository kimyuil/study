package com.example.csv2.util;

import com.example.csv2.service.WorshipList;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class MakeCsv implements MakeFile {

    @Override
    public void download(String fileName, List<WorshipList> content) {

        // validation
        if (isNotValidateContent(content)) {
            return;
        }
        fileName = makeFileName(fileName, "csv");

        List<String> header = makeHeader(content.get(0));

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
            for (WorshipList item : content) {

                fw.write(Integer.toString(idx));
                fw.write(",");

                for (Method m : getSortedMethodPerItem(header, item)) {
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
