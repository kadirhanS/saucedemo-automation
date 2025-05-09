package Test;

import Utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Link_Control_Tests extends BaseTest {
    @Test
    void TC14_AboutLink_isBlank(){
        reUseableMethods.navigateToSite();
        reUseableMethods.validLogIn();
        saucedDemo.saucedDemo_HamburgerButton.click();
        String actualTab_URL = reUseableMethods.getCurrentUrl();;
        String expectedNewTab_URL ="https://saucelabs.com/";
        reUseableMethods.elementToBeClickAble(saucedDemo.saucedDemo_AboutLink);
        saucedDemo.saucedDemo_AboutLink.click();
        String newTab_URL = reUseableMethods.getCurrentUrl();
        System.out.println("New tab url is: "+newTab_URL);
//        Assert.assertNotEquals(actualTab_URL,newTab_URL,
//                "Links are same");
        //or
        Assert.assertEquals(newTab_URL,expectedNewTab_URL,
                "Link is not working");
    }
}
