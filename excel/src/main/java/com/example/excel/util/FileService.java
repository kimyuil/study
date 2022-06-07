package com.example.excel.util;

import com.example.excel.data.FileColumns;
import com.example.excel.data.ValueOrder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public interface FileService {

  <T> void download(String fileName, List<T> contents);

  default <T> Method[] getSortedMethodPerItem(List<ValueOrder> columns, T item) {
    List<Method> allMethods = ReflectionUtil.getAllMethods(new LinkedList<>(), item.getClass());
    Method[] sortedMethods = new Method[columns.size()];

    List<String> headers = new ArrayList<>();
    columns.forEach(e -> headers.add(e.getFieldName()));

    // get메소드를 찾고, sortedMethods에 세팅
    for (Method m : allMethods) {
      if (m.getName().indexOf("get") == 0 && m.getParameterTypes().length == 0
          && !m.getName().equals("getClass")) {

        var a = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
        int b = headers.indexOf(a);
        sortedMethods[b] = m;
      }
    }
    return sortedMethods;
  }

  default List<ValueOrder> getHeaders(Class<?> type){

    List<Field> fields = ReflectionUtil.getAllFields(new LinkedList<>(), type);

    List<ValueOrder> values = new ArrayList<>();
    for (var f : fields) {
      f.setAccessible(true);
      FileColumns anno = f.getAnnotation(FileColumns.class);
      values.add(ValueOrder.builder().displayName(anno.fieldName()).fieldName(f.getName()).order(anno.order()).build());
    }

    values.sort(Comparator.comparingInt(ValueOrder::getOrder));

    return values;
  }

}
