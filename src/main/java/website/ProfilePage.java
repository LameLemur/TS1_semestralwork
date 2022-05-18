package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends MainPage {

    @FindBy(xpath = "//div[@id='right_more']//ul[@id='profil']/li[11]/a")
    private WebElement ratedBooks;


    public ProfilePage(WebDriver driver) {
        super(driver, true);
        PageFactory.initElements(driver, this);
    }

    public BookListPage goToBookList(int index) {
        WebElement element = driver.findElements(By.xpath("//div[@id='right_more']//ul[@id='profil']/li/a")).get(index);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new BookListPage(driver);
    }

    public RatedBooksPage goToRatedBooks() {
        MyUtils.jsClick(ratedBooks, driver);
        return new RatedBooksPage(driver);
    }
}
