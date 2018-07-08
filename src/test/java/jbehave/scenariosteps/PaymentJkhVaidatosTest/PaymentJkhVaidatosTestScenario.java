package jbehave.scenariosteps.PaymentJkhVaidatosTest;

import jbehave.steps.PaymentJkhVaidatosTest.PaymentJkhVaidatosTestSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class PaymentJkhVaidatosTestScenario {

    @Steps
    private PaymentJkhVaidatosTestSteps paymentJkhVaidatosTestStepsSteps;

    @Given("user has opened 'tinkoff.ru' site")
    public void userOpenedSite() {
        paymentJkhVaidatosTestStepsSteps.openPage();
    }

    @When("user click on SecondMenu 'Платежи' button")
    public void clickPaymentsButton() {
        paymentJkhVaidatosTestStepsSteps.clickPaymentsButton();
    }

    @When("user check 'city' if not Moscow choosen '$city'")
    public void checkCityIsMoslov(final String city) {
        paymentJkhVaidatosTestStepsSteps.checkCityIsMosKov(city);
    }

    @When("user choose 'Коммунальные платежи'")
    public void chooseJkhPayments() {
        paymentJkhVaidatosTestStepsSteps.chooseJkhPayments();
    }

    @When("user check that first list element 'ЖКУ-Москва' and save as 'искомый'")
    public void chooseJkuMosowAndSaveFinding() {
        paymentJkhVaidatosTestStepsSteps.chooseJkuMosowAndSaveFinding();
    }

    @Then("cause all errors requred fields and check error messages")
    public void chechResult() {
        Assert.assertTrue("Validate messege uncorrect", paymentJkhVaidatosTestStepsSteps.checkInvalidDataErrorsequiredFillInFields());
    }

}
