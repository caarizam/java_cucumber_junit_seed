package org.aut.steps.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aut.common.Browser;
import org.aut.common.Constants;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        Constants.getInstance().setCurrentScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario){

        Browser browser = Constants.getInstance().getBrowser();

        if(scenario.isFailed()){
            byte[] screenshot = browser.takeScreenShot();
            scenario.embed(screenshot, "image/png");

        }
        browser.quitBrowser();

    }

}
