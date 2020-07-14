package com.ladbrokers.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * News page object.
 */
public class NewsPage {

    private final static String LATEST_BETTING_NEWS_PARENT_DIV_PARENT_DIV_XPATH =
        "//h1[contains(text(), 'Latest Betting news')]//parent::div//parent::div";
    private final static String LATEST_BETTING_NEWS_SEE_MORE_XPATH =
        LATEST_BETTING_NEWS_PARENT_DIV_PARENT_DIV_XPATH
        + "//div[contains(@class, 'see-more')]/div[contains(@class, 'h3')]";
    private final static String LATEST_BETTING_NEWS_XPATH =
        LATEST_BETTING_NEWS_PARENT_DIV_PARENT_DIV_XPATH
        + "//div[contains(@class, 'post-list-frame') and not(contains(@class, 'desktop-hidden'))]"
        + "//div[contains(@class, 'post-content')]";
    private final static String HERO_CAROUSEL_XPATH =
        "//*[@id='hero-carousel']//*[@class='featured-panel']";

    @FindBy(className = "entry-title")
    private WebElement entryTitle;

    @FindBy(id = "menu-item-217550")
    private WebElement footballButton;

    @FindBy(id = "menu-item-222079")
    private WebElement premierLeagueButton;

    @FindBy(xpath = LATEST_BETTING_NEWS_PARENT_DIV_PARENT_DIV_XPATH)
    private WebElement latestBettingNewsContainer;

    @FindBy(xpath = LATEST_BETTING_NEWS_SEE_MORE_XPATH)
    private WebElement latestBettingNewsContainerSeeMore;

    @FindBy(xpath = LATEST_BETTING_NEWS_XPATH)
    private List<WebElement> latestBettingNews;

    @FindBy(xpath = HERO_CAROUSEL_XPATH)
    private List<WebElement> heroCarouselArticles;

    private WebDriver driver;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEntryTitle()
    {
        return entryTitle;
    }

    public WebElement getFootballButton(){
        return footballButton;
    }

    public WebElement getPremierLeagueButton()
    {
        return premierLeagueButton;
    }

    public WebElement getLatestBettingNewsContainer() {
        return latestBettingNewsContainer;
    }

    public WebElement getLatestBettingNewsSeeMoreButton() {
        return latestBettingNewsContainerSeeMore;
    }

    public List<WebElement> getLatestBettingNews() {
        return latestBettingNews;
    }

    public List<WebElement> getHeroCarouselArticles() {
        return heroCarouselArticles;
    }

    public boolean isFootballMenuActive(){
        return getFootballButton().getAttribute("class").contains("ubermenu-active");
    }

    public String getHeroCarouselArticleHeader(int articleIndex)
    {
        return getHeroCarouselArticles().get(articleIndex).findElement(By.className("hero-panel-text")).getText();
    }

    public void clickHeroCarouselArticle(int articleIndex)
    {
        getHeroCarouselArticles().get(articleIndex).click();
    }

}
