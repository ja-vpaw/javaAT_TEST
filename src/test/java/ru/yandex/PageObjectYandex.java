package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectYandex {
    public WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;

    public PageObjectYandex(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        searchField = chromeDriver.findElement(By.name("text"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@type='submit']"));
    }

    public void find(String stringFind){
        searchField.click();
        searchField.sendKeys(stringFind);
        searchButton.click();
    }

    public List<WebElement> getListOfAllLinks() {
        return chromeDriver.findElements(By.xpath("//*[@href]"));
    }
}
