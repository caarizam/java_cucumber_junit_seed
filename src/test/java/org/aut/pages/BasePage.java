package org.aut.pages;

import org.aut.common.Browser;
import org.aut.common.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class BasePage {

    WebDriver driver;
    Browser browser;
    Actions actions;
    JavascriptExecutor js;

    final int SHORT_TIMEOUT = 5;
    final int MID_TIMEOUT = 15;
    final int LONG_TIMEOUT = 30;
    final int DEFAULT_POLLING_TIME = 1;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.browser = Constants.getInstance().getBrowser();
    }

    public boolean waitForElement(WebDriver driver, int time, WebElement element){

        try{
            WebElement tmpElement = (new WebDriverWait(driver, time)).until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception ex){
            return false;
        }

    }

    public void addBrowserScreenshot(){
        this.browser.addScreenShootScenario();
    }

    public boolean isElementDisplayed(WebDriver driver, WebElement element, int timeout, int pollingTime){
        Wait wait = getWait(driver, timeout, pollingTime);

        return (boolean) wait.until((Function<Boolean, Boolean>) x -> element.isDisplayed());
    }

    public void moveToElement(WebElement element){
        browser = Constants.getInstance().getBrowser();
        actions = browser.getActions();
        actions.moveToElement(element).perform();
    }

    public static Wait getWait(WebDriver driver, int timeout, int pollingTimme){
        Duration duTimeout = Duration.ofSeconds(timeout);
        Duration duPollingTime = Duration.ofSeconds(pollingTimme);

        Wait wait = new FluentWait(driver)
                .withTimeout(duTimeout)
                .pollingEvery(duPollingTime)
                .ignoring(NoSuchElementException.class);

        return wait;
    }

    public void scrollToView(WebElement element) {

        JavascriptExecutor js = this.browser.getJs();
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void jsSingleQuerySelector(String selector, String action) {

        JavascriptExecutor js = this.browser.getJs();

        try{
            switch (action){
                case "click":
                    js.executeScript("document.querySelector('" + selector + "').click()");
                    break;
                default:
                    System.out.println("jsSingleQuerySelector:" + action + ":Not implemented yet");
                    break;
            }
        }catch (Exception ex){
            System.out.println("jsSingleQuerySelector:" + action + ": Exception message: " + ex.getMessage());
        }



    }

}
