import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import website.MainPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RatedBooksTest extends TestCase {

    @ParameterizedTest
    @Order(1)
    @CsvSource({"Komu zvoní hrana, 1", "Válka s Mloky, 2", "Bílá Voda, 3"})
    public void rateBook(String bookName, int rating) {
        List<String> allBooksInList = new MainPage(getDriver())
                .clickAgreeCookies()
                .goToLogin()
                .fillUserName("sellenium")
                .fillPassword("testovani69")
                .clickLogin()
                .goToBooks()
                .searchBook(bookName)
                .getBookOnIndex(0)
                .rate(rating)
                .goToProfile()
                .goToRatedBooks()
                .getAllBookTitles();
        assertTrue(allBooksInList.contains(bookName));
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource({"Komu zvoní hrana", "Válka s Mloky", "Bílá Voda"})
    public void removeBookRating(String bookName) {
        List<String> allBooksInList = new MainPage(getDriver())
                .clickAgreeCookies()
                .goToLogin()
                .fillUserName("sellenium")
                .fillPassword("testovani69")
                .clickLogin()
                .goToProfile()
                .goToRatedBooks()
                .goToBook(bookName)
                .removeRating()
                .goToProfile()
                .goToRatedBooks()
                .getAllBookTitles();
        assertFalse(allBooksInList.contains(bookName));
    }
}
