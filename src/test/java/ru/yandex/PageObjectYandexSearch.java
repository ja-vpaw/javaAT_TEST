package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectYandexSearch extends  PageObjectYandex{

    private String selectorPagerItems = "//*[@class=\"pager__items\"]";

    public PageObjectYandexSearch(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    // Получение списка с навигацией по страницам
    public boolean waitPagerItems() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath(selectorPagerItems))));
        return true;
    }
}
