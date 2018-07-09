package ru.tinkoff.structure.core.panels.JkhPaymentPage;

import org.openqa.selenium.By;
import ru.tinkoff.structure.core.pages.JkuMoscowPage;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import ru.tinkoff.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JkhPaymentContentPanel extends AbstractPanel {

    public JkhPaymentContentPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    private static final String JKU_PAYMENTS_BUTTON = "//li[@data-qa-file=\"UIMenuItemProvider\"][1]";
    private static final String JKU_PAYMENT_FORM = "//div[@data-qa-file=\"SubscriptionProvider\"]";


    public void clickJkuPaymentButton(){
        findBy(JKU_PAYMENTS_BUTTON).then().click();
    }

    public JkuMoscowPage getJkuMoscowPageAndSaveFinding(){
        clickJkuPaymentButton();
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(JKU_PAYMENT_FORM),"display","block"));
        return new JkuMoscowPage(getDriver());
    }


}
