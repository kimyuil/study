package util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import service.WorshipList;

public class MakeCsv implements MakeFile {

    @Override
    public void download(String fileName, List<WorshipList> content) {

        // validation
        if (!validateContent(content)) {
            return;
        }
        fileName = makeFileName(fileName, "csv");

        List<String> header = makeHeader(content.get(0));

        // file write (try with resource)
        File file = new File(System.getProperty("user.dir") + "\\" + fileName);

        try (BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {

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
            Integer idx = 1;
            for (WorshipList item : content) {

                fw.write(idx.toString());
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
