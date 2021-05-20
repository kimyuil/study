package util;

import java.util.List;

import service.WorshipList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class MakeExel implements MakeFile {

    @Override
    public void download(String fileName, List<WorshipList> content) {
        // 1. validation
        if (content == null) {
            System.out.println("입력된 내용이 없습니다.");
            return;
        }
        if (fileName == null || fileName.equals("")) { // TODO : csv -> xls??
            fileName = "default.csv";
            System.out.println("파일 이름이 설정되지 않아 default.csv로 저장됩니다.");
        } else {
            if (!(fileName.substring(fileName.length() - 4, fileName.length())).equals(".csv")) {
                fileName = fileName + ".csv";
            }
        }

    }

}
