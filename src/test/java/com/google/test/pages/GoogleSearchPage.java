package com.google.test.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends PageObject {
    @FindBy(name = "q")
    //in case of search with multiple search engines there will be @FindBy (xpath="google xpath|yahoo xpath|yandex xpath")
    WebElementFacade searchInput;

    @FindBy(xpath = "//*[@id='pnnext']")
    WebElementFacade nextPaginationButton;

    public WebElementFacade searchInput(String searchQuery) {
        return searchInput.waitUntilClickable().type(searchQuery);
    }

    public WebElementFacade searchResult(int resultNumber) {
        return findBy(String.format("(//*[@class='LC20lb'])[" + resultNumber + "]")).waitUntilClickable();
    }

    public WebElementFacade nextPaginationButton() {
        return nextPaginationButton;
    }

    public List<WebElement> urlsOnSearchResultPage() {
        return getDriver().findElements(By.xpath("//*[@class='iUh30']"));
    }


}
