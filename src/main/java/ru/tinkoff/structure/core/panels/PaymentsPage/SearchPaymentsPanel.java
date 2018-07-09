package ru.tinkoff.structure.core.panels.PaymentsPage;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tinkoff.structure.core.pages.JkuMoscowPage;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import ru.tinkoff.structure.core.webdriver.AbstractPanel;

import java.util.concurrent.TimeUnit;

public class SearchPaymentsPanel extends AbstractPanel {

    public SearchPaymentsPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    private static final String SEARCH_INPUT = "//input[@data-qa-file=\"SearchInput\"]";
    private static final String SEARCH_ICON = "//dIv[@data-svg-id=\"8932e2e566143b9b72bf2f2ae20a9891.svg\" and @class=\"Icon__icon_3VmKb\"]";
    private static final String POP_UP_RESULT_MENU = "//div[@data-qa-file=\"SearchSuggested\" and @class=\"SearchSuggested__suggestContainer_Z6mjO\"]";
    private static final String FIRST_ELLEMENT_FROM_LIST = "//div[@class=\"SearchSuggest__entry_2vlxq SearchSuggest__entry_pickable_2Vfxf SearchSuggest__entry_highlighted_1SPg3 SearchSuggest__entry_withIcon_FH3k1\"]";
    private static final String PAY_JKU_IN_MOSCOW_TAB = "//a[@href=\"/zhku-moskva/oplata/\"]/span";
    private static final String MAIN_PAGE_BLOCK = "//div[@class=\"MainPageBlockStyles__container_3vY9h\"]";

    public void searchByText(String search){
        findBy(SEARCH_INPUT).then().clear();
        findBy(SEARCH_INPUT).then().click();
        findBy(SEARCH_INPUT).then().sendKeys(search);
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(SEARCH_ICON),"display","inline-block"));
    }



    public String textFirstElemetn(){
        return findBy(FIRST_ELLEMENT_FROM_LIST).getText();
    }

    public JkuMoscowPage chooseFirst(){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.attributeToBe(By.xpath(MAIN_PAGE_BLOCK),"overflow","visible"));
        findBy(FIRST_ELLEMENT_FROM_LIST).then().click();
        wait.until(ExpectedConditions.attributeToBe(By.xpath(PAY_JKU_IN_MOSCOW_TAB),"display","inline-flex"));
        return new JkuMoscowPage(getDriver());
    }


}
