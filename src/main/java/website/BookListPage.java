package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BookListPage extends MainPage {


    public BookListPage(WebDriver driver) {
        super(driver, true);
        PageFactory.initElements(driver, this);
    }

    public List<String> getAllBookTitles() {
        List<String> titles = new ArrayList<>();
        List<WebElement> bookA = driver.findElements(By.xpath("//div[@id='left_less']/div/a[@class='bigger odright_pet']"));
        for (WebElement we : bookA) {
            titles.add(we.getText());
        }
        return titles;
    }

    public BookPage goToBookNumber(int num) {
        List<WebElement> bookA = driver.findElements(By.xpath("//div[@id='left_less']/div/a[@class]"));
        MyUtils.jsClick(bookA.get(num), driver);
        return new BookPage(driver);
    }

    public BookListPage removeFromList(String bookName) {
        List<String> allBooks = getAllBookTitles();
        List<WebElement> allDeletes = driver.findElements(By.xpath("//a[@class='bigger odright_pet']/preceding-sibling::div//ul/a[@class='deleteFromCases']"));
        MyUtils.jsClick(allDeletes.get(allBooks.indexOf(bookName)),driver);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new BookListPage(driver);
    }
}
