package com.google.test.steps.serenity.stepDefs;

import com.google.test.steps.serenity.CommonSteps;
import com.google.test.steps.serenity.steps.GoogleSearchSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class GoogleSearchStepDefs {
    @Steps
    GoogleSearchSteps searchSteps;

    @Steps
    CommonSteps commonSteps;

    @Given("^user navigate to (.*)$")
    public void userNavigateToUrl(String url) {
        commonSteps.navigateToUrl(url);
    }

    @When("^user type (.*) into search input$")
    public void userTypeSearchQuery(String searchQuery) throws AWTException {
        searchSteps.searchForQuery(searchQuery);
    }

    @Then("^user click on first search (.*)$")
    public void userClickOnGivenSearchResult(int searchResultNumber) {
        searchSteps.clickOnGivenSearchResult(searchResultNumber);
    }

    @And("^user verify that title contains (.*)$")
    public void userVerifyThatTitleContainsSearchQuery(String searchQuery) {
        commonSteps.checkTitle(searchQuery);
    }

    @Then("user search (.*) until pagination page number (.*)")
    public void userSearchExpectedDomainUntilPaginationNumber(String expectedDomain, int paginationNumber) {
        searchSteps.checkUrlOnPagination(expectedDomain, paginationNumber);
    }
}
