package com.ladbrokers.test;

import com.ladbrokers.page.NewsPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 */
public class ParentTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected NewsPage newsPage;
    private static final String URL = "https://news.ladbrokes.com";

    @Before
    public void prepare() {

        System.setProperty(
            "webdriver.chrome.driver",
            "webdriver/chromedriver");

        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        newsPage = new NewsPage(driver);
        driver.get(URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
