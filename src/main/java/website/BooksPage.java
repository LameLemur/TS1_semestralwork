package website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksPage extends MainPage {

    @FindBy(xpath = "//input[@id='sugbooks']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@class='searchbut']")
    private WebElement searchButton;

    public BooksPage(WebDriver driver) {
        super(driver, true);
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage searchBook(String name) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(name);
        MyUtils.jsClick(searchButton,driver);
        return new SearchResultPage(driver);
    }

}
