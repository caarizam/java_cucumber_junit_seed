package org.aut.steps.definition;

import cucumber.api.java.en.Given;
import org.aut.common.Browser;
import org.aut.common.BrowserType;
import org.aut.common.Constants;
import org.aut.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class GeneralSteps {

    Browser browser;
    HomePage homePage;

    public GeneralSteps(){
        browser = Constants.getInstance().getBrowser();
    }

    @Given("^The user is on the Home Page$")
    public void theUserIsOnTheHomePage() {
        homePage = PageFactory.initElements(browser.getDriver(), HomePage.class);
        browser.launchBrowser("", BrowserType.CHROME);
        browser.addScreenShootScenario();
        boolean isPageLoaded = homePage.isPageLoaded();
        Assert.assertEquals("The page is not loaded", true, isPageLoaded);
    }
}
