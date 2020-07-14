package com.ladbrokers.testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Util class for driver common methods.
 */
public class Bot {
    private WebDriver driver;

    public Bot(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAndClick(WebElement element, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
