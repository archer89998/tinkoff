package ru.tinkoff.structure.core.pages;


import org.openqa.selenium.WebDriver;
import ru.tinkoff.structure.core.panels.JkhPaymentPage.JkhPaymentContentPanel;
import ru.tinkoff.structure.core.webdriver.AbstractPage;

import java.util.concurrent.TimeUnit;

public class JkhPaymentPage extends AbstractPage {

    public JkhPaymentPage(WebDriver driver) {
        super(driver);
    }

    private static final String JKH_PAYMENT_CONTENT_PANEL = "//div[@data-qa-file=\"UIPageFrame\" and @class=\"ui-page-frame\" ]";

    public JkhPaymentContentPanel getMainPageBlock() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(JKH_PAYMENT_CONTENT_PANEL);
        return new JkhPaymentContentPanel(findBy(JKH_PAYMENT_CONTENT_PANEL), this);
    }

}
