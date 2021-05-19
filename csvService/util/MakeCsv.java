package util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import service.WorshipList;

public class MakeCsv {
    List<WorshipList> content;
    String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // public void setHeader(List<String> header) {
    //     this.header = header;
    // }

    public void setContent(List<WorshipList> content) {
        this.content = content;
    }

    public void downloadCSV() {

        // 1. validation
        if (this.content == null) {
            System.out.println("입력된 내용이 없습니다.");
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

        // 2. get header by reflection
        List<String> header = new ArrayList<>();        
        List<Field> headerList = getAllFields(new LinkedList<Field>(), this.content.get(0).getClass());
        
        for(Field h : headerList){
            h.setAccessible(true); 
            header.add(h.getName());
        }

        // 3. file write (try with resource)
        File file = new File(System.getProperty("user.dir") + "\\" + this.fileName);
        try (BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))){
            
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
            for (WorshipList item : this.content) {

                fw.write(idx.toString());
                fw.write(",");

                List<Method> allmethods = getAllMethods(new LinkedList<Method>(), item.getClass());
                Method[] sortedMethods = new Method[header.size()];

                //find getter methods and set to sortedMethods
                for(Method m : allmethods){                    
                    if(m.getName().indexOf("get") == 0 && 
                    m.getParameterTypes().length == 0 && 
                    !m.getName().equals("getClass")){

                        sortedMethods[header.indexOf(m.getName().substring(3,4).toLowerCase() + m.getName().substring(4))] = m;
                    }                    
                }
                
                for(Method m : sortedMethods){
                    fw.write(m.invoke(item).toString());
                    fw.write(",");
                }                
                fw.write("\n");                
                idx = idx+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get member list (상속포함)
    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
    
        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }
    
        return fields;
    }

    public static List<Method> getAllMethods(List<Method> methods, Class<?> type) {
        methods.addAll(Arrays.asList(type.getDeclaredMethods()));
    
        if (type.getSuperclass() != null) {
            getAllMethods(methods, type.getSuperclass());
        }
    
        return methods;
    }
}


