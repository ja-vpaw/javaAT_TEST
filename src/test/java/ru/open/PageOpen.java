package ru.open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageOpen {
    public WebDriver chromeDriver;

    public PageOpen(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
    }

    public WebElement getExchangeBlock() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(
                By.xpath("//div[@class='main-page-exchange main-page-info__card']"))));
        return chromeDriver.findElement(By.xpath("//div[@class='main-page-exchange main-page-info__card']"));
    }

    public Float getBuyDollar(WebElement webElement) {
        // Здесь решил оставить селектор со списком, т.к. всего два варианта
        return Float.parseFloat(webElement.findElement
                (By.xpath("(.//tr[@class=\"main-page-exchange__row main-page-exchange__row--with-border\" and .//span/text()='USD']//span)[2]"))
                .getText().replace(',', '.'));
    }

    public Float getSellDollar(WebElement webElement) {
        return Float.parseFloat(webElement.findElement
                (By.xpath("(.//tr[@class=\"main-page-exchange__row main-page-exchange__row--with-border\" and .//span/text()='USD']//span)[3]"))
                .getText().replace(',', '.'));
    }
}
