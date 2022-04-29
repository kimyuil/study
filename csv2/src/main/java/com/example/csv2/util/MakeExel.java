package com.example.csv2.util;

import com.example.csv2.service.WorshipList;
import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MakeExel implements MakeFile {

    @Override
    public void download(String fileName, List<WorshipList> content) {

        // validation
        if (isNotValidateContent(content)) {
            return;
        }
        fileName = makeFileName(fileName, "xlsx");

        List<String> header = makeHeader(content.get(0));

        // file write (try with resource)
        try (XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream fileoutputstream = new FileOutputStream(fileName)) {

            XSSFSheet sheet = workbook.createSheet("명단");

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
            for (WorshipList item : content) {
                rowContent = sheet.createRow(idxRow);

                idxCell = 0;
                rowContent.createCell(idxCell).setCellValue(String.valueOf(idxRow));
                idxCell++;

                for (Method m : getSortedMethodPerItem(header, item)) {
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
