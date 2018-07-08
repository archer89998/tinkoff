package ru.tinkoff.structure.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tinkoff.structure.core.panels.JkuMoscowPage.JkuPaymentContentPanel;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class JkuMoscowPage extends AbstractPage {
    public JkuMoscowPage(final WebDriver driver) {
        super(driver);
    }

    private static final String JKU_FORM_CONTENT_PANEL = "//div[@data-qa-file=\"UIPageFrame\" and @class=\"ui-page-frame__content\"]";
    private static final String JKU_IN_MOSCOW_TAB_HEADER = "//div[text()='Оплатите ЖКУ в Москве без комиссии']";
    private static final String PAY_JKU_IN_MOSCOW_TAB = "//span[@data-qa-file=\"Tab\" and text()='Оплатить ЖКУ в Москве']";

    public void clickJkuInMoscowTab(){
        findBy(PAY_JKU_IN_MOSCOW_TAB).then().click();
    }

    public JkuPaymentContentPanel getJkuPaymentContentPanel(){
        clickJkuInMoscowTab();
        //withTimeoutOf(30, TimeUnit.SECONDS).waitFor(JKU_IN_MOSCOW_TAB_HEADER);
        return  new JkuPaymentContentPanel(findBy(JKU_FORM_CONTENT_PANEL),this);
    }

}
