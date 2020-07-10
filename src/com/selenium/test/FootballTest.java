package com.selenium.test;

import com.selenium.page.NewsPage;
import com.selenium.testutils.ActionsUtils;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Football page test.
 */
public class FootballTest extends ParentTest {

    /**
     * Validate Premier League button from menu.
     */
    @Test
    public void validatePremierLeagueButton() {

        String newsTitle = "Online Betting News at Ladbrokes.com";
        String premierLeagueTitle = "Premier League Betting Tips, lastest News and Predictions | Ladbrokes.com";

        NewsPage newsPage = new NewsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOf(newsPage.getFootballButton()));

        assertEquals("The news page title is incorrect",
            newsTitle, driver.getTitle());
        assertTrue("Football button is not displayed",
            newsPage.getFootballButton().isDisplayed());
        ActionsUtils.moveTo(driver, newsPage.getFootballButton());
        assertTrue("Football menu is not visible",
            newsPage.isFootballMenuActive());

        wait.until(ExpectedConditions.visibilityOf(newsPage.getPremierLeagueButton()));
        newsPage.getPremierLeagueButton().click();
        wait.until(ExpectedConditions.titleIs(premierLeagueTitle));

        assertEquals("The page title should be Premier League",
            premierLeagueTitle, driver.getTitle());
    }
}