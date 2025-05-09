package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedDemo {

    public SaucedDemo(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"login_logo\"]")
    public WebElement saucedDemo_LoginHeader;

    @FindBy(id = "user-name")
    public WebElement saucedDemo_UserNameField;
    @FindBy(id = "password")
    public WebElement saucedDemo_UserPasswordField;
    @FindBy(id = "login-button")
    public WebElement saucedDemo_LoginButton;

    @FindBy(xpath = "//div[@class=\"error-message-container error\"]")
    public WebElement saucedDemo_Invalid_Username_Password_Message;

//    List items:
    @FindBy(xpath = "//div[@class=\"inventory_list\"]//div[@class=\"inventory_item\"]")
    public WebElement saucedDemo_Products;
    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    public WebElement saucedDemo_ShoppingCartBadge;

//    Checkout Section:
    @FindBy(id = "checkout")
    public WebElement saucedDemo_CheckOutButton;

    @FindBy(xpath = "(//span[@class=\"title\"])")
    public WebElement saucedDemo_CheckOut_Header;

    @FindBy(id = "first-name")
    public WebElement saucedDemo_Form_FirstName;

    @FindBy(id = "last-name")
    public WebElement saucedDemo_Form_LastName;

    @FindBy(id = "postal-code")
    public WebElement saucedDemo_Form_PostalCode;

    @FindBy(id = "continue")
    public WebElement saucedDemo_Form_ContinueButton;

    @FindBy(id = "finish")
    public WebElement saucedDemo_Form_FinishButton;

    @FindBy(xpath = "(//h2[@class=\"complete-header\"])")
    public WebElement saucedDemo_ThankYouForYourOrder;

    @FindBy(id = "back-to-products")
    public WebElement saucedDemo_Form_BackHome_Button;

//    Item sorting field
    @FindBy(xpath = "(//select[@class=\"product_sort_container\"])")
    public WebElement saucedDemo_ProductSortContainer;


//    Hamburger menu button
    @FindBy(xpath = "(//button[@id=\"react-burger-menu-btn\"])")
    public WebElement saucedDemo_HamburgerButton;
    @FindBy(xpath = "(//a[@id=\"logout_sidebar_link\"])")
    public WebElement saucedDemo_LogOutButtonInHamburgerMenu;
    @FindBy(id = "about_sidebar_link")
    public WebElement saucedDemo_AboutLink;





}
