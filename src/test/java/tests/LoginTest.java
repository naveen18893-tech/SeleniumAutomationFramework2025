package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Chrome options for Jenkins (headless execution)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");        // Run without UI
        options.addArguments("--no-sandbox");          // Required for Jenkins/Linux
        options.addArguments("--disable-dev-shm-usage"); // Fix memory issues
        options.addArguments("--disable-gpu");

        // Initialize driver
        driver = new ChromeDriver(options);

        // Common settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open your application URL
        driver.get("https://admin-demo.nopcommerce.com/login");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
