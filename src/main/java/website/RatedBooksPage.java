package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RatedBooksPage extends BookListPage {

    public RatedBooksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public List<String> getAllBookTitles() {
        List<String> titles = new ArrayList<>();
        List<WebElement> bookA = driver.findElements(By.xpath("//p[@class='new']/a"));
        for (WebElement we : bookA) {
            titles.add(we.getText());
        }
        return titles;
    }

    @Override
    public BookPage goToBookNumber(int num) {
        List<WebElement> bookA = driver.findElements(By.xpath("//p[@class='new']/a"));
        MyUtils.jsClick(bookA.get(num), driver);
        return new BookPage(driver);
    }

    public BookPage goToBook(String bookName) {
        List<String> allBooks = getAllBookTitles();
        int index = allBooks.indexOf(bookName);
        return goToBookNumber(index);

    }
}
