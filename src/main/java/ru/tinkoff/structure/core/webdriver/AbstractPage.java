package ru.tinkoff.structure.core.webdriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public abstract class AbstractPage extends PageObject {

    public AbstractPage(final WebDriver driver) {
        super(driver);
        getDriver().manage().window().maximize();
    }

    public AbstractPage(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
    }

    public boolean isElementPresent(final String xpathLocator) {
        setImplicitTimeout(500, MILLISECONDS);
        final boolean isElementsPresent = isNotEmpty(getDriver().findElements(org.openqa.selenium.By.xpath(xpathLocator)));
        resetImplicitTimeout();
        return isElementsPresent;
    }

    public void waitForAjaxToComplete() {
        final String script = "return window.jQuery != undefined && jQuery.active == 0;";
        final Object result = getJavascriptExecutorFacade().executeScript(script);
        waitFor(condition -> result);
    }

    public void waitForReadyStateToComplete() {
        final String script = "return document.readyState";
        final Object result = getJavascriptExecutorFacade().executeScript(script);
        waitFor(condition -> result.equals("complete"));
    }
}