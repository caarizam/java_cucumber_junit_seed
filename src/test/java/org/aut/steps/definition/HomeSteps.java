package org.aut.steps.definition;

import org.aut.common.Browser;
import org.aut.common.BrowserType;
import org.aut.common.Constants;
import org.aut.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class HomeSteps {

    Browser browser;
    HomePage homePage;

    public HomeSteps() {
        browser = Constants.getInstance().getBrowser();
    }

    @When("^The user enters the credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserEntersTheCredentialsAnd(String userName, String password) {
        homePage = PageFactory.initElements(browser.getDriver(), HomePage.class);
        System.out.println("username: " + userName + ", password: " + password);
    }

    @Then("^The user should see the Welcome Page$")
    public void theUserShouldSeeTheWelcomePage() {
    }
}
