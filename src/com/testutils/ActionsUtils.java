package com.testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Util class for Actions method.
 */
public class ActionsUtils {

    public static void moveTo(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }
}
