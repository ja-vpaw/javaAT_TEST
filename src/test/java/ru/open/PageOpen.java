package ru.open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageOpen {

    private String selectorExchangeRates = "//*[@class='main-page-exchange main-page-info__card']";
    private String selectorBuyUSD = "(.//tr[@class=\"main-page-exchange__row main-page-exchange__row--with-border\"" +
                                    " and .//span/text()='USD']//span)[2]";
    private String selectorSellUSD = "(.//tr[@class=\"main-page-exchange__row main-page-exchange__row--with-border\"" +
                                    " and .//span/text()='USD']//span)[3]";


    public WebDriver chromeDriver;

    public PageOpen(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
    }

    public WebElement getExchangeBlock() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(
                By.xpath(selectorExchangeRates))));
        return chromeDriver.findElement(By.xpath(selectorExchangeRates));
    }

    public Float getBuyUSD(WebElement webElement) {
        // Здесь решил оставить селектор со списком, т.к. всего два варианта
        return Float.parseFloat(webElement.findElement
                (By.xpath(selectorBuyUSD)).getText().replace(',', '.'));
    }

    public Float getSellUSD(WebElement webElement) {
        return Float.parseFloat(webElement.findElement
                (By.xpath(selectorSellUSD)).getText().replace(',', '.'));
    }
}
