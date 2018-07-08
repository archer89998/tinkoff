package ru.tinkoff.structure.core.panels.PaymentsPage;

import ru.tinkoff.structure.core.pages.JkhPaymentPage;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import ru.tinkoff.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageBlockPanel extends AbstractPanel {

    public MainPageBlockPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    private static final String PAYMENT_CITY = "//span[@data-qa-file=\"Link\"]";
    private static final String CHOOSEN_REGION_CONTAINER = "//div[@data-qa-file=\"UIFadingSlideMotion\"]";
    private static final String CHOOSE_MOSKOW = "//div[@data-qa-file=\"Text\" and text()=\"г. Москва\"]";
    private static final String MAIN_PAGE_BLOCK = "//div[@data-qa-file=\"MainPageBlock\"]";
    private static final String JKH_PAYMENTS_BUTTON = "//span[@data-qa-file=\"UILink\" and text()=\"ЖКХ\"]";
    private static final String JKH_PAYMENTS_PAGE = "//div[@data-qa-file=\"UILayoutPage\" and @class=\"UILayoutPage__page_19-Kp\" ]";


    public void checkCity(String city){
        if(!findBy(PAYMENT_CITY).getText().equals(city)){
            findBy(PAYMENT_CITY).then().click();
            WebDriverWait wait = new WebDriverWait(getDriver(),10);
            wait.until(ExpectedConditions.attributeToBe(By.xpath(CHOOSEN_REGION_CONTAINER),"display","block"));
            findBy(CHOOSE_MOSKOW).then().click();
            wait.until(ExpectedConditions.attributeToBe(By.xpath(MAIN_PAGE_BLOCK),"display","block"));
        }
    }

    public void clickJkhPayment(){
        findBy(JKH_PAYMENTS_BUTTON).then().click();
    }

    public JkhPaymentPage getJkhPaymentPage(){
        clickJkhPayment();
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(JKH_PAYMENTS_PAGE),"display","flex"));
        return new JkhPaymentPage(getDriver());
    }




}
