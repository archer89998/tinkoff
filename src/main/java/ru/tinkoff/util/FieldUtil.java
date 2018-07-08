package ru.tinkoff.util;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.reflect.FieldUtils.readField;
import static org.apache.commons.lang3.reflect.FieldUtils.writeField;

public class FieldUtil {

    private static final String DOT = ".";

    private FieldUtil() {
    }

    public static void initNestedField(final Object bean, final String fieldPath) {
        if (isNestedField(fieldPath)) {
            final String childFieldName = substringBefore(fieldPath, DOT);
            ofNullable(getField(bean, childFieldName)).ifPresent(field -> {
                final Object fieldValue = readFieldValue(bean, childFieldName);
                if (fieldValue == null) {
                    final Object newDefaultBean = BeanUtil.createNewInstance(field.getType());
                    writeFieldIfApplicable(bean, childFieldName, newDefaultBean);
                }
                final String nestedFieldPath = substringAfter(fieldPath, DOT);
                initNestedField(readFieldValue(bean, childFieldName), nestedFieldPath);
            });
        }
    }

    public static boolean isNestedField(final String fieldPath) {
        return contains(fieldPath, DOT);
    }

    public static Object readFieldValue(final Object bean, final String fieldName) {
        final Object value = null;
        if (getField(bean, fieldName) != null) {
            try {
                return readField(bean, fieldName, true);
            } catch (final IllegalAccessException e) {
                throw new IllegalStateException("Failed to read bean field.", e);
            }
        }
        return value;
    }

    private static void writeFieldIfApplicable(final Object target, final String fieldName, final Object value) {
        if (getField(target, fieldName) != null) {
            try {
                writeField(target, fieldName, value, true);
            } catch (final IllegalAccessException e) {
                throw new IllegalStateException("Failed to write bean field.", e);
            }
        }
    }

    public static Field getField(final Object bean, final String fieldName) {
        final Field field = Optional.ofNullable(bean)
            .map(b -> FieldUtils.getField(b.getClass(), fieldName, true))
            .orElse(null);
        return field;
    }
}