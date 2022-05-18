package website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MainPage{



    @FindBy(xpath = "//input[@name='nick']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@name='log_heslo']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@value='Přihlásit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver, true);
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillUserName(String userName) {
        inputUserName.sendKeys(userName);
        return this;
    }

    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage clickLogin() {
        MyUtils.jsClick(loginButton, driver);
        return new MainPage(driver,true);
    }
}
