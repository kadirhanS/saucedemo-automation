package Test;

import Utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sorting_Test extends BaseTest {



    @Test
    void TC11_SortingItems(){
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        //click sorting field
        saucedDemo.saucedDemo_ProductSortContainer.click();

        //Add select options
        Select prdocutSelectOptions = new Select(saucedDemo.saucedDemo_ProductSortContainer);

        //Select low to high:

        prdocutSelectOptions.selectByValue("lohi");
        String firstProductPrice = driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])[1]")).getText();
        System.out.println("first product price is: "+ firstProductPrice);
        //Assert first product pirce is lowest
        Assert.assertEquals(firstProductPrice,"$7.99");


    }

    @Test
    void TC12_Name_Z_To_A(){
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        //click sorting field
        saucedDemo.saucedDemo_ProductSortContainer.click();

        //Add select options
        Select prdocutSelectOptions = new Select(saucedDemo.saucedDemo_ProductSortContainer);

        //Select Z to A;
        prdocutSelectOptions.selectByValue("za");

        String firstProductName = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name \"])[1]")).getText();
        System.out.println("First product name: " + firstProductName);
        Assert.assertEquals(firstProductName,"Test.allTheThings() T-Shirt (Red)");

    }
}
