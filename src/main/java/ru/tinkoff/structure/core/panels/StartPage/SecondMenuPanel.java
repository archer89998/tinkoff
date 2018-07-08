package ru.tinkoff.structure.core.panels.StartPage;


import ru.tinkoff.structure.core.pages.PaymentsPage;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import ru.tinkoff.structure.core.webdriver.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondMenuPanel extends AbstractPanel {

    public SecondMenuPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    private static final String PAYMETS_BUTTON = "//a[@data-qa-file=\"Link\" and text()=\"Платежи\"]";

    public void clickPaymentsButton() {
        findBy(PAYMETS_BUTTON).then().click();
    }

    public PaymentsPage getPaymentsPage() {
        clickPaymentsButton();
        return new PaymentsPage(getDriver());
    }

}
