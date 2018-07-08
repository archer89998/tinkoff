package ru.tinkoff.util;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class JbehaveUtil {

    private JbehaveUtil() {
    }

    public static <T> List<T> populate(final ExamplesTable table, final Class<T> returnType) {
        return populate(table, returnType, true);
    }

    public static <T> List<T> populate(final ExamplesTable table, final Class<T> returnType,
            final boolean replaceNamedParameters) {
        return table.getRowsAsParameters(replaceNamedParameters).stream()
            .map(row -> populate(row, returnType))
            .collect(toList());
    }

    public static <T> T populate(final Parameters row, final Class<T> returnType) {
        return BeanUtil.populateNew(returnType, row.values());
    }
}