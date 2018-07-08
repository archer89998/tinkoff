package jbehave.scenariosteps.SearchInputeAndCheckListOfSupliersTest;


import jbehave.steps.SearchInputeAndCheckListOfSupliersTest.SearchInputeAndCheckListOfSupliersTestSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class SearchInputeAndCheckListOfSupliersTestStcenario {

    @Steps
    private SearchInputeAndCheckListOfSupliersTestSteps searchInputeAndCheckListOfSupliersTestSteps;
    private boolean result;

    @Given("user has opened 'tinkoff.ru' site")
    public void userOpenedSite() {
        searchInputeAndCheckListOfSupliersTestSteps.openPage();
    }

    @When("user click on SecondMenu 'Платежи' button")
    public void clickPaymentsButton() {
        searchInputeAndCheckListOfSupliersTestSteps.clickPaymentsButton();
    }


    @When("user enter saved finding data and check that first list element 'ЖКУ-Москва' is 'искомый'")
    public void searchFindingSavePayment() {
        searchInputeAndCheckListOfSupliersTestSteps.searchFindingSavePayment();
    }

    @When("user choose 'Коммунальные платежи' from list")
    public void chooseFindingDataFromList() {
        searchInputeAndCheckListOfSupliersTestSteps.chooseFindingDataFromList();
    }

    @Then("user check that page is same when he click by icon")
    public void userCheckThatPageIsSame() {
//        Assert.assertTrue("Search page and page click icon hava different content", searchInputeAndCheckListOfSupliersTestSteps.userCheckThatPageIsSame());
        searchInputeAndCheckListOfSupliersTestSteps.userCheckThatPageIsSame();
    }
}
