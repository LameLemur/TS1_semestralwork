import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import website.MainPage;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ListsOperationsTests extends TestCase {

    private HashMap<Integer, Integer> getIndexMap() {
        HashMap<Integer, Integer> bookToProfileListIndex = new HashMap<>();
        bookToProfileListIndex.put(0,2);
        bookToProfileListIndex.put(1,1);
        bookToProfileListIndex.put(2,5);
        bookToProfileListIndex.put(3,4);
        bookToProfileListIndex.put(4,6);
        bookToProfileListIndex.put(5,7);
        bookToProfileListIndex.put(6,8);
        bookToProfileListIndex.put(7,3);
        return bookToProfileListIndex;
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource({"Komu zvoní hrana, 4", "Válka s Mloky, 2", "Bílá Voda, 3"})
    public void addBookToAList(String bookName, int index) {
        List<String> allBooksInList = new MainPage(getDriver())
                .clickAgreeCookies()
                .goToLogin()
                .fillUserName("sellenium")
                .fillPassword("testovani69")
                .clickLogin()
                .goToBooks()
                .searchBook(bookName)
                .getBookOnIndex(0)
                .addToList(index)
                .goToProfile()
                .goToBookList(getIndexMap().get(index))
                .getAllBookTitles();
        assertTrue(allBooksInList.contains(bookName));
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource({"Komu zvoní hrana, 4", "Válka s Mloky, 2", "Bílá Voda, 3"})
    public void removeBookFromAList(String bookName, int index) {
        List<String> allBooksInList = new MainPage(getDriver())
                .clickAgreeCookies()
                .goToLogin()
                .fillUserName("sellenium")
                .fillPassword("testovani69")
                .clickLogin()
                .goToProfile()
                .goToBookList(getIndexMap().get(index))
                .removeFromList(bookName)
                .getAllBookTitles();
        assertFalse(allBooksInList.contains(bookName));
    }
}
