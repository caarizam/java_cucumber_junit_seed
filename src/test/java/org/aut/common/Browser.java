package org.aut.common;

import org.aut.helpers.PropertiesReaderHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

public class Browser {

    private WebDriver driver;
    private JavascriptExecutor js;
    private Actions actions;

    public void launchBrowser(String url, BrowserType browserType){
        PropertiesReaderHelper readHelper;
        readHelper = new PropertiesReaderHelper();

        if(url == null || url == ""){
            url = readHelper.getProperty("default-url");
        }

        if(browserType == null){
            browserType = BrowserType.CHROME;
        }

        driver = initDriver(browserType);
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.MINUTES);
        driver.get(url);
        driver.manage().window().maximize();
        //When we are working with Jenkins, with need to assign a screen size
        Dimension dimension = new Dimension(1024,768);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public WebDriver initDriver(BrowserType browserType){
        WebDriver tmpDriver = null;
        String path = System.getProperty("user.dir");

        switch (browserType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chrome/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-plugins");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--lang=en");
                //chromeOptions.addArguments("--headless");
                //chromeOptions.addArguments("--incognito");

                tmpDriver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/firefox/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--incognito");
                tmpDriver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                System.err.println("The browser " + browserType + " is not implemented yet");
                return null;
        }

        return tmpDriver;

    }

    public void addScreenShootScenario(){
        byte[] screenshot = takeScreenShot(); //takeFullScreenShot();
        Constants.getInstance().getCurrentScenario().embed(screenshot, "image/png");
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public byte[] takeScreenShot(){
        return ((TakesScreenshot) this.driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    public byte[] takeFullScreenShot() {
        try{
            BufferedImage screenshot=new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                    .takeScreenshot(driver)
                    .getImage();

            ByteArrayOutputStream babs = new ByteArrayOutputStream();
            ImageIO.write( screenshot, "jpg", babs );
            babs.flush();
            byte[] imageInByte = babs.toByteArray();
            babs.close();
            return imageInByte;

        }catch(Exception ex){
            return null;
        }
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }
}
