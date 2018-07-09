package ru.tinkoff.structure.core.panels.JkuMoscowPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import ru.tinkoff.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class JkuPaymentContentPanel extends AbstractPanel {

    public JkuPaymentContentPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    private static final String requredFieldsEmptyError="Поле обязательное";
    private static final String codeValueError = "Поле неправильно заполнено";
    private static final String dateValuError = "Поле заполнено некорректно";
    private static final String maxLimitValueFieldError = "Максимум — 15 000 \u20BD";
    private static final String minLimitValueFieldError = "Минимум — 10 \u20BD";
    private static final String lesserNullLimitValueError = "Поле заполнено неверно";
    private static final String SUBMIT_BUTTON = "//button[@data-qa-file=\"UIButton\"]";
    private static final String JKU_CODE_PAYER_INPUT = "//input[@data-qa-file=\"UIInput\" and @id=\"payerCode\"]";
    private static final String JKU_PERIOD_INPUT = "//input[@data-qa-file=\"UIInput\" and @id=\"period\"]";
    private static final String JKU_VALUE_INPUT = "//input[@data-qa-node=\"ValueComponent\" and @value!='0']";
    private static final String JKU_CODE_ERRORS_MASSEGE = "//div[4]/div[1]/form/div[1]/div/div[2]";
    private static final String JKU_PERIOD_ERRORS_MASSEGE = "//div[4]/div[1]/form/div[2]/div/div[2]";
    private static final String JKU_VALUE_ERRORS_MASSEGE = "//form/div[4]/div/div/div/div/div/div/div/div[2]";
    private static final String PAY_JKU_IN_MOSCOW_TAB = "//span[@data-qa-file=\"Tab\" and text()='Оплатить ЖКУ в Москве']";

    public boolean emptyRequiredFields(){
        findBy(JKU_CODE_PAYER_INPUT).then().clear();
        findBy(JKU_CODE_PAYER_INPUT).then().click();
        findBy(JKU_CODE_PAYER_INPUT).then().sendKeys("");
        findBy(JKU_PERIOD_INPUT).then().clear();
        findBy(JKU_PERIOD_INPUT).then().click();
        findBy(JKU_PERIOD_INPUT).then().sendKeys("");
        findBy(JKU_VALUE_INPUT).then().clear();
        findBy(JKU_VALUE_INPUT).then().click();
        findBy(JKU_VALUE_INPUT).then().sendKeys("");
        findBy(SUBMIT_BUTTON).then().click();
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(findBy(JKU_VALUE_ERRORS_MASSEGE),"display","block"));
        if(findBy(JKU_CODE_ERRORS_MASSEGE).getText().equals(requredFieldsEmptyError) && findBy(JKU_PERIOD_ERRORS_MASSEGE).getText().equals(requredFieldsEmptyError) && findBy(JKU_VALUE_ERRORS_MASSEGE).getText().equals(requredFieldsEmptyError)){
            return true;
        }
        return false;
    }

    public boolean codeValuuFillInError(){
        findBy(JKU_CODE_PAYER_INPUT).then().clear();
        findBy(JKU_CODE_PAYER_INPUT).then().click();
        findBy(JKU_CODE_PAYER_INPUT).then().sendKeys("111111");
        findBy(SUBMIT_BUTTON).then().click();
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(findBy(JKU_CODE_ERRORS_MASSEGE),"display","block"));
        if(findBy(JKU_CODE_ERRORS_MASSEGE).getText().equals(codeValueError)){
            return true;
        }
        return false;
    }

    public boolean dateValuuFillInError(){
        findBy(JKU_PERIOD_INPUT).then().clear();
        findBy(JKU_PERIOD_INPUT).then().click();
        findBy(JKU_PERIOD_INPUT).then().sendKeys("12");
        findBy(SUBMIT_BUTTON).then().click();
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(findBy(JKU_PERIOD_ERRORS_MASSEGE),"display","block"));
        if(findBy(JKU_PERIOD_ERRORS_MASSEGE).getText().equals(dateValuError)){
            return true;
        }
        return false;
    }

    public boolean lesserMinLimitValuuFillInError(){
        findBy(JKU_VALUE_INPUT).then().clear();
        findBy(JKU_VALUE_INPUT).then().click();
        findBy(JKU_VALUE_INPUT).then().sendKeys("4");
        findBy(SUBMIT_BUTTON).then().click();
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(findBy(JKU_VALUE_ERRORS_MASSEGE),"display","block"));
        if(findBy(JKU_VALUE_ERRORS_MASSEGE).getText().equals(minLimitValueFieldError)){
            return true;
        }
        return false;
    }

    public boolean biggerMaxLimitValuuFillInError(){
        findBy(JKU_VALUE_INPUT).then().clear();
        findBy(JKU_VALUE_INPUT).then().click();
        findBy(JKU_VALUE_INPUT).then().sendKeys("20000");
        findBy(SUBMIT_BUTTON).then().click();
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(findBy(JKU_VALUE_ERRORS_MASSEGE),"display","block"));
        if(findBy(JKU_VALUE_ERRORS_MASSEGE).getText().equals(maxLimitValueFieldError)){
            return true;
        }
        return false;
    }

    public boolean lesserZeroLimitValuuFillInError(){
        findBy(JKU_VALUE_INPUT).then().clear();
        findBy(JKU_VALUE_INPUT).then().click();
        findBy(JKU_VALUE_INPUT).then().sendKeys("-10");
        findBy(SUBMIT_BUTTON).then().click();
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(findBy(JKU_VALUE_ERRORS_MASSEGE),"display","block"));
        if(findBy(JKU_VALUE_ERRORS_MASSEGE).getText().equals(lesserNullLimitValueError)){
            return true;
        }
        return false;
    }

    public void pageIsSame(){
        findBy(PAY_JKU_IN_MOSCOW_TAB).getText();
    }
}
