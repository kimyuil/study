package util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import service.WorshipList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MakeExel implements MakeFile {

    @Override
    public void download(String fileName, List<WorshipList> content) {

        // validation
        if (!validateContent(content)) {
            return;
        }
        fileName = makeFileName(fileName, "xlsx");

        List<String> header = makeHeader(content.get(0));

        // file write (try with resource)
        try (XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream fileoutputstream = new FileOutputStream(fileName)) {

            XSSFSheet sheet = workbook.createSheet("명단");

            // header
            Integer idx = 1;
            XSSFRow rowHeader = sheet.createRow(0);
            rowHeader.createCell(0).setCellValue("no");
            for (String head : header) {
                rowHeader.createCell(idx).setCellValue(head);
                idx++;
            }

            // content
            Integer idxRow = 1;
            Integer idxCell;
            XSSFRow rowContent;
            for (WorshipList item : content) {
                rowContent = sheet.createRow(idxRow);

                idxCell = 0;
                rowContent.createCell(idxCell).setCellValue(idxRow.toString());
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
