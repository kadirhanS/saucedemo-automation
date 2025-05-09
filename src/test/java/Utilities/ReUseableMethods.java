package Utilities;

import Driver.Driver;
import Locators.SaucedDemo;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ReUseableMethods {

    protected WebDriver driver;
    protected Actions actions;
    protected SaucedDemo saucedDemo;
    protected WebDriverWait wait;

    public ReUseableMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.saucedDemo = new SaucedDemo(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }
    public void navigateToSite(){
        driver.get(ConfigReader.get("siteUrl"));

    }

    public void validLogIn(){

        actions.click(saucedDemo.saucedDemo_UserNameField)
                .sendKeys(ConfigReader.get("valid_UserName"), Keys.TAB)
                .sendKeys(ConfigReader.get("valid_UserPassword"))
                .click(saucedDemo.saucedDemo_LoginButton)
                .perform();
    }

    public void invalidLogIn(){

        actions.click(saucedDemo.saucedDemo_UserNameField)
                .sendKeys(ConfigReader.get("valid_UserName"),Keys.TAB)
                .sendKeys(ConfigReader.get("invalid_UserPassword"))
                .click(saucedDemo.saucedDemo_LoginButton)
                .perform();
    }

    public void lockedOutUserLogIn() {

        actions.click(saucedDemo.saucedDemo_UserNameField)
                .sendKeys(ConfigReader.get("lockedOutUserName"),Keys.TAB)
                .sendKeys(ConfigReader.get("valid_UserPassword"))
                .click(saucedDemo.saucedDemo_LoginButton)
                .perform();
    }

    public void check_SiteURL_LoginHeader(){
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.get("siteUrl"));
        Assert.assertEquals(saucedDemo.saucedDemo_LoginHeader.getText(),ConfigReader.get("loginHeader"),
                "Login header is not match");
    }
    public void elementToBeClickAble(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void textToBePresentInElement(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void check_CheckOutHederAndTextMatching(){
        Assert.assertTrue(saucedDemo.saucedDemo_CheckOut_Header.isDisplayed(),
                "CheckOut header is not displayed");
        Assert.assertEquals(saucedDemo.saucedDemo_CheckOut_Header.getText(),
                "Checkout: Your Information",
                "CheckOut header not match ");
    }






}
