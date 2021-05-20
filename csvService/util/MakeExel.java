package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import service.WorshipList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MakeExel implements MakeFile {

    @Override
    public void download(String fileName, List<WorshipList> content) {
        // 1. validation
        if (content == null) {
            System.out.println("입력된 내용이 없습니다.");
            return;
        }
        if (fileName == null || fileName.equals("")) { // TODO : csv -> xls??
            fileName = "default.xlsx";
            System.out.println("파일 이름이 설정되지 않아 default.xlsx로 저장됩니다.");
        } else {
            if (!(fileName.substring(fileName.length() - 5, fileName.length())).equals(".xlsx")) {
                fileName = fileName + ".xlsx";
            }
        }

        try (XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream fileoutputstream = new FileOutputStream(fileName)) {

            XSSFSheet sheet = workbook.createSheet("시트명"); // 새 시트(Sheet) 생성
            XSSFRow row = sheet.createRow(0); // 엑셀의 행은 0번부터 시작
            XSSFCell cell = row.createCell(0); // 행의 셀은 0번부터 시작
            cell.setCellValue("테스트 데이터"); // 생성한 셀에 데이터 삽입

            workbook.write(fileoutputstream);
            System.out.println("엑셀파일생성성공");
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("엑셀파일생성실패");
        }
    }

}
