package com.example.excel.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ReflectionUtil {

  public static List<Field> getAllFields(List<Field> fields, Class<?> type) {

    Collections.addAll(fields, type.getDeclaredFields());

    //재귀호출
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

  public static <T> Method[] getSortedMethodPerItem(List<String> header, T item) {
    List<Method> allMethods = ReflectionUtil.getAllMethods(new LinkedList<>(), item.getClass());
    Method[] sortedMethods = new Method[header.size()];

    // get메소드를 찾고, sortedMethods에 세팅
    for (Method m : allMethods) {
      if (m.getName().indexOf("get") == 0 && m.getParameterTypes().length == 0
          && !m.getName().equals("getClass")) {

        sortedMethods[header.indexOf(m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4))] = m;
      }
    }
    return sortedMethods;
  }

  public static List<String> getHeaders(Class<?> type){
    List<Field> fields = ReflectionUtil.getAllFields(new LinkedList<>(), type);
    List<String> headers = new ArrayList<>();
    for (var f : fields) {
      f.setAccessible(true);
      headers.add(f.getName());
    }
    return headers;
  }

}
