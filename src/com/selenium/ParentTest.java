package com.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 */
public class ParentTest {

    protected WebDriver driver;
    private static final String URL = "https://news.ladbrokes.com";

    @Before
    public void prepare() {

        System.setProperty(
            "webdriver.chrome.driver",
            "webdriver/chromedriver");

        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
