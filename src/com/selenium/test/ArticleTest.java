package com.selenium.test;

import com.selenium.page.NewsPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

/**
 * Test article page.
 */
public class ArticleTest extends ParentTest {

    /**
     * Validate random article by clicking it from carousel.
     */
    @Test
    public void validateRandomArticleFromCarousel() {

        NewsPage newsPage = new NewsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(p -> newsPage.getHeroCarouselArticles().size() > 0);
        String articleHeader = newsPage.getHeroCarouselArticles().get(0).findElement(By.className("hero-panel-text")).getText();
        newsPage.getHeroCarouselArticles().get(0).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("entry-title")));

        assertThat("The page title should be as clicked article",
            driver.getTitle(), equalToIgnoringCase(articleHeader));
    }
}
