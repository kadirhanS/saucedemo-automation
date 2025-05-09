package Test;

import Utilities.BaseTest;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOut_Tests extends BaseTest {



    @Test
    void TC08_AddProductToCart_StartCheckout() {
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        driver.findElement(By.xpath("(//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"])")).click();

        reUseableMethods.textToBePresentInElement(saucedDemo.saucedDemo_ShoppingCartBadge,"1");
        saucedDemo.saucedDemo_ShoppingCartBadge.click();

        String productName = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])")).getText();
        Assert.assertEquals(productName, "Sauce Labs Bolt T-Shirt",
                "Product is not match");

        saucedDemo.saucedDemo_CheckOutButton.click();

        reUseableMethods.check_CheckOutHederAndTextMatching();

        System.out.println("Actual header value: " + saucedDemo.saucedDemo_CheckOut_Header.getText());

        actions.click(saucedDemo.saucedDemo_Form_FirstName)
                .sendKeys("RandomName")
                .click(saucedDemo.saucedDemo_Form_LastName)
                .sendKeys("RandomLastName")
                .click(saucedDemo.saucedDemo_Form_PostalCode)
                .sendKeys("02056")
                .click(saucedDemo.saucedDemo_Form_ContinueButton)
                .perform();

        reUseableMethods.textToBePresentInElement(saucedDemo.saucedDemo_CheckOut_Header,"Checkout: Overview");

        Assert.assertEquals(saucedDemo.saucedDemo_CheckOut_Header.getText(),
                "Checkout: Overview",
                "CheckOut header not match ");
        System.out.println("Actual header value: " + saucedDemo.saucedDemo_CheckOut_Header.getText());

    }

    @Test
    void TC09_CheckOutEmptyFields() throws InterruptedException {
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        driver.findElement(By.xpath("(//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"])")).click();

        reUseableMethods.textToBePresentInElement(saucedDemo.saucedDemo_ShoppingCartBadge,"1");

        saucedDemo.saucedDemo_ShoppingCartBadge.click();

        String productName = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])")).getText();

        Assert.assertEquals(productName, "Sauce Labs Bolt T-Shirt",
                "Product is not match");
        saucedDemo.saucedDemo_CheckOutButton.click();

        reUseableMethods.check_CheckOutHederAndTextMatching();

        actions.click(saucedDemo.saucedDemo_Form_FirstName)
                .sendKeys("")
                .click(saucedDemo.saucedDemo_Form_LastName)
                .sendKeys("RandomLastName")
                .click(saucedDemo.saucedDemo_Form_PostalCode)
                .sendKeys("02056")
                .click(saucedDemo.saucedDemo_Form_ContinueButton)
                .perform();

        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"error-message-container error\"])")).getText(),
                "Error: First Name is required");

        // clear all inputs
        WebElement firstName = saucedDemo.saucedDemo_Form_FirstName;
        WebElement lastName = saucedDemo.saucedDemo_Form_LastName;
        WebElement postalCode = saucedDemo.saucedDemo_Form_PostalCode;

        // First name ,clear
        firstName.click();
        firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        firstName.sendKeys(Keys.DELETE);
        wait.until(d -> firstName.getAttribute("value").isEmpty());

        // Last name ,clear
        lastName.click();
        lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        lastName.sendKeys(Keys.DELETE);
        wait.until(d -> lastName.getAttribute("value").isEmpty());

        // Postal code ,clear
        postalCode.click();
        postalCode.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        postalCode.sendKeys(Keys.DELETE);
        wait.until(d -> postalCode.getAttribute("value").isEmpty());

        // One more: empty firstname
        actions.click(firstName)
                .sendKeys("RandomName")
                .click(lastName)
                .sendKeys("")
                .click(postalCode)
                .sendKeys("02056")
                .click(saucedDemo.saucedDemo_Form_ContinueButton)
                .perform();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("(//div[@class=\"error-message-container error\"])"),
                "Error: Last Name is required"));

        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class=\"error-message-container error\"])")).getText(),
                "Error: Last Name is required");
    }

    @Test
    void TC10_ComplateOrder() {
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        driver.findElement(By.xpath("(//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"])")).click();

        reUseableMethods.textToBePresentInElement(saucedDemo.saucedDemo_ShoppingCartBadge,"1");
        saucedDemo.saucedDemo_ShoppingCartBadge.click();

        String productName = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])")).getText();
        Assert.assertEquals(productName, "Sauce Labs Bolt T-Shirt",
                "Product is not match");

        saucedDemo.saucedDemo_CheckOutButton.click();

        reUseableMethods.check_CheckOutHederAndTextMatching();

        actions.click(saucedDemo.saucedDemo_Form_FirstName)
                .sendKeys("RandomName")
                .click(saucedDemo.saucedDemo_Form_LastName)
                .sendKeys("RandomLastName")
                .click(saucedDemo.saucedDemo_Form_PostalCode)
                .sendKeys("02056")
                .click(saucedDemo.saucedDemo_Form_ContinueButton)
                .perform();

        reUseableMethods.textToBePresentInElement(saucedDemo.saucedDemo_CheckOut_Header,"Checkout: Overview");
        Assert.assertEquals(saucedDemo.saucedDemo_CheckOut_Header.getText(),
                "Checkout: Overview",
                "CheckOut header not match ");

        saucedDemo.saucedDemo_Form_FinishButton.click();

        Assert.assertEquals(saucedDemo.saucedDemo_ThankYouForYourOrder.getText(),
                "Thank you for your order!",
                "Order message not showing");

        saucedDemo.saucedDemo_Form_BackHome_Button.click();

    }

}
