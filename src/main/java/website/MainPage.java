package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    protected final WebDriver driver;

    @FindBy(xpath = "//div[@id='header']/div[@class='logoub']/div/a[1]")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@id='hledani']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@name='hledat']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[text()='Knihy']")
    private WebElement knihy;
    @FindBy(xpath = "//div[@id='top_setup']/img")
    private WebElement profileDropDown;
    @FindBy(xpath = "//li[text()='Odhlásit']//ancestor::a[@href='logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//div[@class='logoub']/a[1]")
    private WebElement profileButton;
    @FindBy(xpath = "//button[@id='didomi-notice-agree-button']")
    private WebElement cookiesButton;

    protected WebDriverWait webDriverWait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        driver.get("https://www.databazeknih.cz");
    }

    public MainPage(WebDriver driver, boolean openNew) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLogin() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage(driver);
    }

    public BooksPage goToBooks() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(knihy));
        MyUtils.jsClick(knihy, driver);
        return new BooksPage(driver);
    }

    public MainPage logOut() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(profileDropDown));
        MyUtils.jsClick(profileDropDown, driver);
        MyUtils.jsClick(logoutButton, driver);
        return this;
    }

    public ProfilePage goToProfile() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
        return new ProfilePage(driver);
    }

    public MainPage clickAgreeCookies() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cookiesButton));
        MyUtils.jsClick(cookiesButton, driver);
        return this;
    }

    public boolean loggedIn() {
        List<WebElement> upperPanel = driver.findElements(By.xpath("//div[@class='logoub']/*"));
        return upperPanel.size() > 1;
    }
}
