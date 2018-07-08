package ru.tinkoff.structure.core.panels.PaymentsPage;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tinkoff.structure.core.pages.JkuMoscowPage;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import ru.tinkoff.structure.core.webdriver.AbstractPanel;

public class PopUpPanel extends AbstractPanel {
    public PopUpPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    private static final String FIRST_ELLEMENT_FROM_LIST = "//div[@class=\"SearchSuggest__entry_2vlxq SearchSuggest__entry_pickable_2Vfxf SearchSuggest__entry_highlighted_1SPg3 SearchSuggest__entry_withIcon_FH3k1\"]";
    private static final String PAY_JKU_IN_MOSCOW_TAB = "//a[@href=\"/zhku-moskva/oplata/\"]/span";

    public String textFirstElemetn(){
        return findBy(FIRST_ELLEMENT_FROM_LIST).getText();
    }

    public JkuMoscowPage chooseFirst(){
        findBy(FIRST_ELLEMENT_FROM_LIST).then().click();
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(PAY_JKU_IN_MOSCOW_TAB),"display","inline-flex"));
        return new JkuMoscowPage(getDriver());
    }
}
