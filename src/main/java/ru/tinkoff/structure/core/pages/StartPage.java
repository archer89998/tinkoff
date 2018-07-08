package ru.tinkoff.structure.core.pages;

import ru.tinkoff.structure.core.panels.StartPage.SecondMenuPanel;
import ru.tinkoff.structure.core.webdriver.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.tinkoff.ru/")
public class StartPage extends AbstractPage {

    public StartPage(final WebDriver driver) {
        super(driver);
    }


    private static final String SECOND_MENU_PANEL = "//div[@class=\"Tabs__wrap_318Kl\"]";

    public SecondMenuPanel getSecondMenuPanel() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(SECOND_MENU_PANEL);
        return new SecondMenuPanel(findBy(SECOND_MENU_PANEL), this);
    }

}
