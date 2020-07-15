package com.ladbrokers.test;

import com.ladbrokers.page.NewsPage;
import com.testutils.Bot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Parent test with common test setup.
 */
public class ParentTest {

    protected WebDriver driver;
    protected Bot bot;
    protected WebDriverWait wait;
    protected NewsPage newsPage;
    private static final String URL = "https://news.ladbrokes.com";

    @Parameters("browser")

    @BeforeClass
    public void prepare(String browser) {

        if (browser.equalsIgnoreCase("chrome")){
            // 83.0.4103.39
            System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")){
            // 0.26.0 win64
            System.setProperty(
                "webdriver.gecko.driver",
                "webdriver/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headless")){
            // experimental, webdriver exe not included
            // TODO fix config, adjust tests
            System.setProperty(
                "phantomjs.binary.path",
                "webdriver/phantomjs");
            driver = new PhantomJSDriver();
        }

        bot = new Bot(driver);
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        newsPage = new NewsPage(driver);
        driver.get(URL);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
