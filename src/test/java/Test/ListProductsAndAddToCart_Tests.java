package Test;

import Utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListProductsAndAddToCart_Tests extends BaseTest {

    @Test
    void TC05_ProductCountVerification(){
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        Assert.assertEquals(items.size(),6,
                "6 products are not visible");

    }

    @Test
    void TC06_AddToCard(){
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        WebElement sauceBackpack = driver.findElement(By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item\"][1]//div[@class=\"pricebar\"]//button"));
        sauceBackpack.click();
        Assert.assertEquals(saucedDemo.saucedDemo_ShoppingCartBadge.getText(),"1",
                        "Add to cart operation failed");
    }

    @Test
    void TC07_RemoveItemsFromCart(){
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        WebElement saucedBackPack_addToCartButton = driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-backpack'])[1]"));

        saucedBackPack_addToCartButton.click();

        Assert.assertEquals(saucedDemo.saucedDemo_ShoppingCartBadge.getText(),"1",
                "Add to cart operation failed");
        System.out.println("after add: "+saucedDemo.saucedDemo_ShoppingCartBadge.getText());

        try {
            saucedBackPack_addToCartButton.click();
        } catch (StaleElementReferenceException e) {
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        }

        Assert.assertTrue(saucedDemo.saucedDemo_ShoppingCartBadge.getText().isEmpty(),
                    "still shows as 1");
        System.out.println("After remove: "+saucedDemo.saucedDemo_ShoppingCartBadge.getText());




    }
}
