package Test;

import Utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOut_Tests extends BaseTest {
    @Test
    void TC13_LogOutFromMenu(){
        reUseableMethods.navigateToSite();
        reUseableMethods.check_SiteURL_LoginHeader();
        reUseableMethods.validLogIn();
        saucedDemo.saucedDemo_HamburgerButton.click(); //click burger menu
        //wait until log out button is clickable.
        reUseableMethods.elementToBeClickAble(saucedDemo.saucedDemo_LogOutButtonInHamburgerMenu);
        saucedDemo.saucedDemo_LogOutButtonInHamburgerMenu.click(); //click log out button

        Assert.assertEquals(reUseableMethods.getCurrentUrl(),"https://www.saucedemo.com/"); //assert curent url is https://www.saucedemo.com/


    }
}
