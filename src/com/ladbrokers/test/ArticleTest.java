package com.ladbrokers.test;

import org.junit.Test;

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
        wait.until(p -> newsPage.getHeroCarouselArticles().size() > 0);
        String articleHeader = newsPage.getHeroCarouselArticleHeader(0);
        newsPage.clickHeroCarouselArticle(0);
        wait.until(p -> newsPage.getEntryTitle().isDisplayed());

        assertThat("The page title should be as clicked article",
            driver.getTitle(), equalToIgnoringCase(articleHeader));
    }
}
