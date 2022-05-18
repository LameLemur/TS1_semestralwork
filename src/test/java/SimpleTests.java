import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import website.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests extends TestCase {

    @Test
    public void loginTest() {
        assertTrue(new MainPage(getDriver())
                .clickAgreeCookies()
                .goToLogin()
                .fillUserName("sellenium")
                .fillPassword("testovani69")
                .clickLogin()
                .loggedIn());
    }

    @Test
    public void LogoutTest() {
        assertFalse(new MainPage(getDriver())
                .clickAgreeCookies()
                .goToLogin()
                .fillUserName("sellenium")
                .fillPassword("testovani69")
                .clickLogin()
                .logOut()
                .loggedIn());
    }

    @ParameterizedTest
    @CsvSource({"Komu zvoní hrana", "Válka s Mloky", "Bílá Voda"})
    public void findBookTest(String bookName) {
        String foundBookName = new MainPage(getDriver())
                .clickAgreeCookies()
                .goToBooks()
                .searchBook(bookName)
                .getBookOnIndex(0)
                .getName();
        assertEquals(bookName, foundBookName);
    }
}
