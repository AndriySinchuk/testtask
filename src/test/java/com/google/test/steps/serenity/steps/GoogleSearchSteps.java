package com.google.test.steps.serenity.steps;

import com.google.test.pages.GoogleSearchPage;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchSteps {
    GoogleSearchPage searchPage;

    @Step
    public void searchForQuery(String searchQuery) throws AWTException {
        Robot robot = new Robot();
        searchPage.searchInput(searchQuery);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Step
    public void clickOnGivenSearchResult(int searchResultNumber) {
        searchPage.searchResult(searchResultNumber).click();
    }

    @Step
    public void checkUrlOnPagination(String textToFind, int paginationNumber) {
        List<WebElement> foundMatches = new ArrayList<>();
        for (int i = 0; i < paginationNumber; i++) {
            searchPage.nextPaginationButton().click();
            searchPage.urlsOnSearchResultPage();
            for (WebElement webElement : searchPage.urlsOnSearchResultPage()) {
                if (webElement.getText().contains(textToFind)) {
                    foundMatches.add(webElement);
                }
            }
        }
        Assert.assertTrue(foundMatches.size() >= 1);
    }
}

