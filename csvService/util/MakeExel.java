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
        // 1. validation
        if (content == null) {
            System.out.println("입력된 내용이 없습니다.");
            return;
        }
        if (fileName == null || fileName.equals("")) {
            fileName = "default.xlsx";
            System.out.println("파일 이름이 설정되지 않아 default.xlsx로 저장됩니다.");
        } else {
            if (fileName.length() > 5
                    && !(fileName.substring(fileName.length() - 5, fileName.length())).equals(".xlsx")) {
                fileName = fileName + ".xlsx";
            } else {
                fileName = fileName + ".xlsx";
            }
        }

        // 2. get header by reflection
        List<String> header = new ArrayList<>();
        List<Field> headerList = ReflectionUtil.getAllFields(new LinkedList<Field>(), content.get(0).getClass());

        for (Field h : headerList) {
            h.setAccessible(true);
            header.add(h.getName());
        }

        // 3. file write (try with resource)
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

                List<Method> allmethods = ReflectionUtil.getAllMethods(new LinkedList<Method>(), item.getClass());
                Method[] sortedMethods = new Method[header.size()];

                // find getter methods and set to sortedMethods
                for (Method m : allmethods) {
                    if (m.getName().indexOf("get") == 0 && m.getParameterTypes().length == 0
                            && !m.getName().equals("getClass")) {

                        sortedMethods[header
                                .indexOf(m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4))] = m;
                    }
                }

                for (Method m : sortedMethods) {
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
