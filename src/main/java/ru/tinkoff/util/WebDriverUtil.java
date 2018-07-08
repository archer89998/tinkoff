package ru.tinkoff.util;



import ru.tinkoff.structure.core.webdriver.AbstractPage;

import java.util.Objects;

public class WebDriverUtil {

    private WebDriverUtil() {
    }

    public static <T extends AbstractPage> void openPage(final T page) {
        Objects.requireNonNull(page, "Cannot open page from null reference!");
        page.open();
    }
}
