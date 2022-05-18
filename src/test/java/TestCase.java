import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void clean() {
        driver.quit();
    }
}
