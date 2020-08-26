package org.aut.common;

import cucumber.api.Scenario;

public class Constants {
    private static Constants instance;

    private Constants() {
    }

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    private Browser browser = null;
    private Scenario currentScenario;

    public Browser getBrowser() {
        if(browser == null){
            browser = new Browser();
        }
        return browser;
    }

    public Scenario getCurrentScenario() {
        return currentScenario;
    }

    public void setCurrentScenario(Scenario currentScenario) {
        this.currentScenario = currentScenario;
    }
}
