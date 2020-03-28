package ru.open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageOpen {
    public WebDriver chromeDriver;

    public PageOpen(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
    }

    public Float getBuyDollar() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(
                By.xpath("//div[@class='main-page-exchange main-page-info__card']"))));
        return Float.parseFloat(chromeDriver.findElement(By.xpath(
                "(//span[contains(@class, 'main-page-exchange__rate')])[1]")).getText().replace(',', '.'));
    }

    public Float getSellDollar() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(
                By.xpath("//div[@class='main-page-exchange main-page-info__card']"))));
        return Float.parseFloat(chromeDriver.findElement(By.xpath(
                "(//span[contains(@class, 'main-page-exchange__rate')])[2]")).getText().replace(',', '.'));
    }
}
