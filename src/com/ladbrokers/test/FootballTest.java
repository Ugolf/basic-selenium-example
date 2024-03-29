package com.ladbrokers.test;

import com.testutils.ActionsUtils;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

        wait.until(ExpectedConditions.visibilityOf(newsPage.getFootballButton()));

        assertEquals("The news page title is incorrect",
            newsTitle, driver.getTitle());
        assertTrue("Football button is not displayed",
            newsPage.getFootballButton().isDisplayed());
        ActionsUtils.moveTo(driver, newsPage.getFootballButton());
        assertTrue("Football menu is not visible",
            newsPage.isFootballMenuActive());

        bot.waitAndClick(newsPage.getPremierLeagueButton(), 2);
        wait.until(ExpectedConditions.titleIs(premierLeagueTitle));

        assertEquals("The page title should be Premier League",
            premierLeagueTitle, driver.getTitle());
    }
}