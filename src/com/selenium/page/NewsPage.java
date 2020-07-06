package com.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * News page object.
 */
public class NewsPage {

    private WebDriver driver;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFootballButton(){
        return driver.findElement(By.id("menu-item-217550"));
    }

    public boolean isFootballMenuActive(){
        return getFootballButton().getAttribute("class").contains("ubermenu-active");
    }

    public WebElement getPremierLeagueButton() {
        return driver.findElement(By.id("menu-item-222079"));
    }

    public WebElement getLatestBettingNewsContainer() {
        return driver.findElement(By.xpath("//h1[contains(text(), 'Latest Betting news')]//parent::div//parent::div"));
    }

    public WebElement getLatestBettingNewsSeeMoreButton() {
        return getLatestBettingNewsContainer().findElement(
            By.xpath("//div[contains(@class, 'see-more')]/div[contains(@class, 'h3')]"));
    }

    public List<WebElement> getLatestBettingNews() {
        return getLatestBettingNewsContainer().findElements(By.xpath(
            ".//div[contains(@class, 'post-list-frame') and not(contains(@class, 'desktop-hidden'))]" +
            "//div[contains(@class, 'post-content')]"));
    }

    public List<WebElement> getHeroCarouselArticles() {
        return driver.findElement(By.id("hero-carousel")).findElements(By.className("featured-panel"));
    }

}
