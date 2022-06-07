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



}
