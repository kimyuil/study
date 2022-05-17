package com.example.excel.util;

import com.example.excel.data.Fish;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ExcelService {

  public void download(String fileName, List<Fish> content) {

    // validation
    if (content == null) {
      return;
    }

    fileName = fileName + ".xlsx";

    // todo 리플렉션으로 리팩토링
    List<String> header = List.of("최소ph","최대ph","길이","색깔","요구포만도","현재포만도","질병여부");

    // file write (try with resource)
    try (XSSFWorkbook workbook = new XSSFWorkbook();
         FileOutputStream fileoutputstream = new FileOutputStream(fileName)) {

      XSSFSheet sheet = workbook.createSheet("물고기");

      // header
      int idx = 1;
      XSSFRow rowHeader = sheet.createRow(0);
      rowHeader.createCell(0).setCellValue("no");
      for (String head : header) {
        rowHeader.createCell(idx).setCellValue(head);
        idx++;
      }

      // content
      int idxRow = 1;
      int idxCell;
      XSSFRow rowContent;
      for (var item : content) {
        rowContent = sheet.createRow(idxRow);

        idxCell = 0;
        rowContent.createCell(idxCell).setCellValue(String.valueOf(idxRow));
        idxCell++;

        // todo 리플랙션 리팩토링
        rowContent.createCell(idxCell).setCellValue(item.get최소ph());
        idxCell++;
        rowContent.createCell(idxCell).setCellValue(item.get최대ph());
        idxCell++;
        rowContent.createCell(idxCell).setCellValue(item.get길이());
        idxCell++;
        rowContent.createCell(idxCell).setCellValue(item.get색깔());
        idxCell++;
        rowContent.createCell(idxCell).setCellValue(item.get요구포만도());
        idxCell++;
        rowContent.createCell(idxCell).setCellValue(item.get현재포만도());
        idxCell++;
        rowContent.createCell(idxCell).setCellValue(item.get질병여부());


        idxRow++;
      }

      workbook.write(fileoutputstream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
