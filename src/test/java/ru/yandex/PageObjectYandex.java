package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectYandex {
    protected WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;

    public PageObjectYandex(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        if(!chromeDriver.getTitle().contains("Яндекс"))
            chromeDriver.get("https://www.yandex.ru/");
        searchField = chromeDriver.findElement(By.name("text"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@type='submit']"));
    }

    public boolean find(String stringFind){
        searchField.click();
        searchField.sendKeys(stringFind);
        searchButton.click();
        return true;
    }

    public List<WebElement> getListOfAllLinks() {
        return chromeDriver.findElements(By.xpath("//*[@href]"));
    }
}
