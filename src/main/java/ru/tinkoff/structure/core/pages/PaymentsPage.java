package ru.tinkoff.structure.core.pages;

import ru.tinkoff.structure.core.panels.PaymentsPage.MainPageBlockPanel;
import ru.tinkoff.structure.core.panels.PaymentsPage.PopUpPanel;
import ru.tinkoff.structure.core.panels.PaymentsPage.SearchPaymentsPanel;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PaymentsPage extends AbstractPage {

    public PaymentsPage(final WebDriver driver) {
        super(driver);
    }

    private static final String MAIN_PAGE_BLOCK = "//div[@class=\"MainPageBlockStyles__container_3vY9h\"]";
    private static final String SEARCH_PAYMENT_PANEL = "//div[contains(@class, \"SearchInput-theme__layout_XPW_Q\")]";


    public MainPageBlockPanel getMainPageBlock() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(MAIN_PAGE_BLOCK);
        return new MainPageBlockPanel(findBy(MAIN_PAGE_BLOCK), this);
    }

    public SearchPaymentsPanel getSearchPaymentsPanel(){
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(SEARCH_PAYMENT_PANEL);
        return new SearchPaymentsPanel(findBy(SEARCH_PAYMENT_PANEL), this);
    }


}
