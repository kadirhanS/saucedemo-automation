package Utilities;

import Driver.Driver;
import Locators.SaucedDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected ReUseableMethods reUseableMethods;
    protected Actions actions;
    protected WebDriverWait wait;
    protected SaucedDemo saucedDemo;


    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = Driver.getDriver(browser);
        reUseableMethods = new ReUseableMethods(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        saucedDemo = new SaucedDemo(driver);

        reUseableMethods.navigateToSite();

    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();

    }
}
