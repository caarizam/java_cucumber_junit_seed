package org.aut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "logo")
    private WebElement logoImg;

    @FindBy(how = How.CLASS_NAME, using = "menu_ppal")
    private List<WebElement> menuList;

    public boolean isPageLoaded(){
        return waitForElement(this.driver, 30, this.logoImg);
    }

    public List<String> getListMenu(){

        List<String> list = new ArrayList<>();

        for(WebElement tmp : this.menuList){
            list.add(tmp.getText());
        }

        return list;

    }

}
