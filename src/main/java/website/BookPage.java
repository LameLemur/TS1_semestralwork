package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookPage extends MainPage {

    @FindBy(xpath = "//div[@class='logoub']/a[1]")
    private WebElement profileButton;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement titleName;
    @FindBy(xpath = "//span[@itemprop='author']/a")
    private WebElement authorA;


    public BookPage(WebDriver driver) {
        super(driver,true);
        PageFactory.initElements(driver, this);
    }


    public BookPage addToList(int listIndex) {
        WebElement element = driver.findElements(By.xpath("//div[@class='dropdown oddown_midl']//ul/a")).get(listIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@class='dropbtn']"))).build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        MyUtils.jsClick(element, driver);
        return this;
    }

    public BookPage rate(int numOfStars) {
        WebElement element = driver.findElements(By.xpath("//div[@class='stars']/*[name()='svg']/*")).get(numOfStars);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    public BookPage removeRating() {
        WebElement element = driver.findElement(By.xpath("//a[@title='smazat hodnocení']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    public String getName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(titleName));
        return titleName.getText();
    }

    public String getAuthor() {
        return authorA.getText();
    }
}
