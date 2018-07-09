package jbehave.steps.PaymentJkhVaidatosTest;

import ru.tinkoff.structure.core.pages.JkhPaymentPage;
import ru.tinkoff.structure.core.pages.JkuMoscowPage;
import ru.tinkoff.structure.core.pages.StartPage;
import ru.tinkoff.structure.core.pages.PaymentsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;

public class PaymentJkhVaidatosTestSteps extends ScenarioSteps {

    private StartPage startPage;
    private PaymentsPage paymentsPage;
    private JkhPaymentPage jkhPaymentPage;
    private JkuMoscowPage jkuMoscowPage;

    public PaymentJkhVaidatosTestSteps(final Pages pages) {
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
    public void checkCityIsMosKov(final String city) {
        paymentsPage.getMainPageBlock().checkCity(city);
    }

    @Step
    public void chooseJkhPayments() {
        jkhPaymentPage = paymentsPage.getMainPageBlock().getJkhPaymentPage();
    }

    @Step
    public void chooseJkuMosowAndSaveFinding() {
        jkuMoscowPage = jkhPaymentPage.getMainPageBlock().getJkuMoscowPageAndSaveFinding();
    }

    @Step
    public boolean checkInvalidDataErrorsequiredFillInFields() {

        ArrayList<Boolean> result = new ArrayList<>();
        result.add(jkuMoscowPage.getJkuPaymentContentPanel().emptyRequiredFields());
        result.add(jkuMoscowPage.getJkuPaymentContentPanel().codeValuuFillInError());
        result.add(jkuMoscowPage.getJkuPaymentContentPanel().dateValuuFillInError());
        result.add(jkuMoscowPage.getJkuPaymentContentPanel().biggerMaxLimitValuuFillInError());
        result.add(jkuMoscowPage.getJkuPaymentContentPanel().lesserZeroLimitValuuFillInError());
        result.add(jkuMoscowPage.getJkuPaymentContentPanel().lesserMinLimitValuuFillInError());


        for (Boolean res : result
                ) {
            if (!res)
                return false;
        }
        return true;
    }

}
