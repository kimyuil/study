package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import service.WorshipList;

public interface MakeFile {

    public void download(String fileName, List<WorshipList> content);

    default boolean validateContent(List<WorshipList> content) {
        return (content == null) ? false : true;
    }

    default String makeFileName(String fileName, String extension) {
        if (fileName == null || fileName.equals("")) {
            fileName = "default." + extension;
            System.out.println("파일 이름이 설정되지 않아 default.xlsx로 저장됩니다.");
        } else {
            if (fileName.indexOf("." + extension) == -1) {
                fileName = fileName + ".xlsx";
            }
        }
        return fileName;
    }

    default List<String> makeHeader(WorshipList item) {
        List<String> header = new ArrayList<>();
        List<Field> headerList = ReflectionUtil.getAllFields(new LinkedList<Field>(), item.getClass());

        for (Field h : headerList) {
            h.setAccessible(true);
            header.add(h.getName());
        }
        return header;
    }

    default Method[] getSortedMethodPerItem(List<String> header, WorshipList item) {
        List<Method> allmethods = ReflectionUtil.getAllMethods(new LinkedList<Method>(), item.getClass());
        Method[] sortedMethods = new Method[header.size()];

        // find getter methods and set to sortedMethods
        for (Method m : allmethods) {
            if (m.getName().indexOf("get") == 0 && m.getParameterTypes().length == 0
                    && !m.getName().equals("getClass")) {

                sortedMethods[header.indexOf(m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4))] = m;
            }
        }
        return sortedMethods;
    }
}
