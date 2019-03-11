package com.google.test.steps.serenity;

import com.google.test.pages.GoogleSearchPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CommonSteps {
    GoogleSearchPage searchPage;

    @Step
    public void navigateToUrl(String url) {
        searchPage.getDriver().get(url);
    }

    @Step
    public void checkTitle(String title) {
        Assert.assertTrue("Currently displayed title is: " + searchPage.getTitle() + ", it doesn't contains:" + " " + title,
                searchPage.getTitle().toLowerCase().contains(title.toLowerCase()));
    }
}
