package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtil {

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
