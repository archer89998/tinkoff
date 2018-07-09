package jbehave.steps.SearchInputeAndCheckListOfSupliersTest;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ru.tinkoff.structure.core.pages.JkhPaymentPage;
import ru.tinkoff.structure.core.pages.JkuMoscowPage;
import ru.tinkoff.structure.core.pages.PaymentsPage;
import ru.tinkoff.structure.core.pages.StartPage;
import ru.tinkoff.structure.core.panels.JkhPaymentPage.JkhPaymentContentPanel;

public class SearchInputeAndCheckListOfSupliersTestSteps extends ScenarioSteps {

    private StartPage startPage;
    private PaymentsPage paymentsPage;
    private JkuMoscowPage jkuMoscowPage;
    private final static String saveFind = "ЖКУ-Москва";

    public SearchInputeAndCheckListOfSupliersTestSteps(final Pages pages) {
        super(pages);
        startPage = getPages().getPage(StartPage.class);
    }

    @Step
    public void openPage() {
        startPage.open();
    }

    @Step
    public void clickPaymentsButton() {
        paymentsPage = startPage.getSecondMenuPanel().getPaymentsPage();
    }

    @Step
    public boolean searchFindingSavePayment() {
        paymentsPage.getSearchPaymentsPanel().searchByText(saveFind);
        return paymentsPage.getSearchPaymentsPanel().textFirstElemetn().equals(saveFind);

    }

    @Step
    public void chooseFindingDataFromList() {
        jkuMoscowPage = paymentsPage.getSearchPaymentsPanel().chooseFirstElementFromListAndGetJkuMoscowPage();
    }

    @Step
    public void userCheckThatPageIsSame() {
        jkuMoscowPage.getJkuPaymentContentPanel().pageIsSame();
    }


}
