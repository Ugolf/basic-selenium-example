package com.selenium;

import com.selenium.page.NewsPage;
import com.selenium.testutils.ActionsUtils;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Test news page.
 */
public class NewsTest extends ParentTest {

    /**
     * Validate loading more latest betting news.
     */
    @Test
    public void validateLatestBettingNews() {

        NewsPage newsPage = new NewsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOf(newsPage.getLatestBettingNewsContainer()));
        assertEquals("Default number of latest betting news is wrong", 6,
            newsPage.getLatestBettingNews().size());

        ActionsUtils.moveTo(driver, newsPage.getLatestBettingNewsSeeMoreButton());
        newsPage.getLatestBettingNewsSeeMoreButton().click();
        wait.until(p -> newsPage.getLatestBettingNews().size() > 6);

        assertEquals("Number of latest betting news is wrong", 12,
            newsPage.getLatestBettingNews().size());

    }
}
