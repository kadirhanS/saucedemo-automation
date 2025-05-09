package Test;

import Utilities.BaseTest;
import Utilities.ConfigReader;
import Utilities.ReUseableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn_Tests extends BaseTest {



    @Test
    void TC01_ValidLogIn_Test(){
            reUseableMethods.check_SiteURL_LoginHeader();
            reUseableMethods.validLogIn();

            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                    "Url is not contains inventory.html");

    }

    @Test
    void TC02_InvalidLogIn_Test(){
//        reUseableMethods.navigateToSite();
        reUseableMethods.check_SiteURL_LoginHeader();
        reUseableMethods.invalidLogIn();
        Assert.assertEquals(saucedDemo.saucedDemo_Invalid_Username_Password_Message.getText(),
                ConfigReader.get("invalidLogIn_Message"),
                "No error message appeared");

    }

    @Test
    void TC03_LoginWithEmptyFields_Test(){

        reUseableMethods.check_SiteURL_LoginHeader();
        actions.click(saucedDemo.saucedDemo_UserNameField)
                .sendKeys("",Keys.TAB)
                .sendKeys("")
                .click(saucedDemo.saucedDemo_LoginButton)
                .perform();
        Assert.assertEquals(saucedDemo.saucedDemo_Invalid_Username_Password_Message.getText(),
                ConfigReader.get("invalidEmptyField_Message"),
                "Login successfully with empty fields");
    }

    @Test
    void TC04_LockedOutUserLogIn_Test(){


        reUseableMethods.check_SiteURL_LoginHeader();
        reUseableMethods.lockedOutUserLogIn();
        Assert.assertEquals(saucedDemo.saucedDemo_Invalid_Username_Password_Message.getText(),
                ConfigReader.get("lockedOutUser_Message"),
                "Successfully logged in ");
    }


}
