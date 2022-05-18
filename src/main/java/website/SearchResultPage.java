package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends MainPage {


    @FindBy(xpath = "//input[@id='sugbooks']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@class='searchbut']")
    private WebElement searchButton;

    public SearchResultPage(WebDriver driver) {
        super(driver,true);
        PageFactory.initElements(driver, this);
    }

    public List<String> getAllBookNames() {
        List<String> res = new ArrayList<>();
        List<WebElement> bookA = driver.findElements(By.xpath("//p[@class='new']/a[@class]"));
        for (WebElement we : bookA) {
            res.add(we.getText());
        }
        return res;
    }

    public BookPage getBookOnIndex(int index) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElements(By.xpath("//p[@class='new']/a[@class]")).get(index);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new BookPage(driver);
    }
}
