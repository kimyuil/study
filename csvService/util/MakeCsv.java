package util;

import java.io.*;
import java.util.List;

public class MakeCsv {
    List<String> header;
    List<List<String>> content;
    String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public void setContent(List<List<String>> content) {
        this.content = content;
    }

    public void downloadCSV() {
        if (this.header.size() == 0) {
            System.out.println("헤더가 설정되어 있지 않습니다");
            return;
        }
        if (fileName == null || fileName.equals("")) {
            this.fileName = "default.csv";
            System.out.println("파일 이름이 설정되지 않아 default.csv로 저장됩니다.");
        } else {
            if (!(this.fileName.substring(this.fileName.length() - 4, this.fileName.length())).equals(".csv")) {
                this.fileName = this.fileName + ".csv";
            }
        }

        File file = new File(System.getProperty("user.dir") + "\\" + this.fileName);

        try {
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "euc-kr"));
            // FileWriter fw = new FileWriter(file);

            for (String head : this.header) {
                fw.write(head);
                fw.write(",");
            }
            fw.write("\n");

            for (List<String> line : this.content) {
                for (String item : line) {
                    fw.write(item);
                    fw.write(",");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
