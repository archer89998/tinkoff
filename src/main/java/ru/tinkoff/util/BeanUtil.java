package ru.tinkoff.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.lang.String.format;
import static org.mockito.internal.util.Primitives.isPrimitiveOrWrapper;

public class BeanUtil {

    private static BeanUtilsBean beanUtilsBean;

    private BeanUtil() {
    }

    public static BeanUtilsBean getBeanUtilsBeanInstance() {
        if (beanUtilsBean == null) {
            beanUtilsBean = BeanUtilsBean.getInstance();
            beanUtilsBean.getConvertUtils().register(new IntegerConverter(null), Integer.class);
            beanUtilsBean.getConvertUtils().register(new DoubleConverter(null), Double.class);
            beanUtilsBean.getConvertUtils().register(new LongConverter(null), Long.class);
            beanUtilsBean.getConvertUtils().register(new BooleanConverter(null), Boolean.class);
            beanUtilsBean.getConvertUtils().register(new BigIntegerConverter(null), BigInteger.class);
            beanUtilsBean.getConvertUtils().register(new BigDecimalConverter(null), BigDecimal.class);
            beanUtilsBean.getConvertUtils().register(new ArrayConverter(String[].class, new StringConverter()),
                String[].class);
        }
        return beanUtilsBean;
    }

    public static void copyProperties(final Object destination, final Object source) {
        copyProperties(destination, source, format("Failed to copy properties from [%s] to [%s]",
                source.getClass().getSimpleName(), destination.getClass().getSimpleName()));
    }

    public static void copyProperties(final Object destination, final Object source, final String exceptionMessage) {
        try {
            getBeanUtilsBeanInstance().copyProperties(destination, source);
        } catch (final IllegalAccessException | InvocationTargetException e1) {
            throw new IllegalStateException(exceptionMessage, e1);
        }
    }

    public static <T> T populateNew(final Class<T> returnType, final Map<String, String> properties) {
        final T bean = BeanUtil.createNewInstance(returnType);
        properties.keySet().stream()
            .filter(FieldUtil::isNestedField)
            .forEach(header -> FieldUtil.initNestedField(bean, header));
        populateProperties(bean, properties);
        return bean;
    }

    public static void populateProperties(final Object obj, final Map<String, String> properties) {
        Objects.requireNonNull(obj, "Cannot populate properties of null object.");
        try {
            getBeanUtilsBeanInstance().populate(obj, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Failed to populate properties of bean", e);
        }
    }

    public static <T> T createNewInstance(final Class<T> type) {
        Objects.requireNonNull(type, "Cannot invoke method newInstance() from null Class.");
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(format("Failed to create instance of [%s]", type.getName()), e);
        }
    }

    public static <T> boolean isSimpleType(final Class<T> type) {
        Objects.requireNonNull(type, "Class is null, cannot check whether it simple or composite!");
        return Stream.of(String.class, Number.class, Enum.class, XMLGregorianCalendar.class)
                .anyMatch(klass -> (klass.isAssignableFrom(type) || isPrimitiveOrWrapper(type)));
    }
}