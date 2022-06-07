package com.example.excel.util;

import com.example.excel.data.Fish;
import com.example.excel.data.ValueOrder;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

public class ExcelService implements FileService {

  public <T> void download(String fileName, List<T> contents) {

    // validation
    if (contents == null) {
      return;
    }

    fileName = fileName + ".xlsx";

    List<ValueOrder> headers = getHeaders(contents.get(0).getClass());

    // file write (try with resource)
    try (XSSFWorkbook workbook = new XSSFWorkbook();
         FileOutputStream fileoutputstream = new FileOutputStream(fileName)) {

      XSSFSheet sheet = workbook.createSheet("물고기");

      // header
      int idx = 1;
      XSSFRow rowHeader = sheet.createRow(0);
      rowHeader.createCell(0).setCellValue("no");
      for (var head : headers) {
        rowHeader.createCell(idx).setCellValue(head.getDisplayName());
        idx++;
      }

      // content
      int idxRow = 1;
      int idxCell;
      XSSFRow rowContent;
      for (var item : contents) {
        rowContent = sheet.createRow(idxRow);

        idxCell = 0;
        rowContent.createCell(idxCell).setCellValue(String.valueOf(idxRow));
        idxCell++;

        for (Method m : getSortedMethodPerItem(headers, item)) {
          rowContent.createCell(idxCell).setCellValue(m.invoke(item).toString());
          idxCell++;
        }

        idxRow++;
      }

      workbook.write(fileoutputstream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
