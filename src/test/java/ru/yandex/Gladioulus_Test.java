package ru.yandex;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.WebDriverSettings;


import java.util.List;

public class Gladioulus_Test extends WebDriverSettings {

    private WebDriverWait wait;


    @Test
    public void  checkGladioulusWiki(){
        System.out.println(this.getClass().getName());
        chromeDriver.get("https://yandex.ru");
        WebElement searchField = chromeDriver.findElement(By.name("text"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@type='submit']"));


        searchField.click();
        searchField.sendKeys("Гладиолус");
        searchButton.click();


        // get all links
        WebDriverWait wait = new WebDriverWait(chromeDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//*[@class=\"pager__items\"]"))));

        List<WebElement> ListAllLinks = chromeDriver.findElements(By.xpath("//*[@href]"));

        boolean check = false;
        for(WebElement we : ListAllLinks) {
            // System.out.println(we.getAttribute("href"));

            if (we.getAttribute("href").contains("wikipedia.org"))
                check = true;
        }
        Assertions.assertTrue(check);

//        son(2000);

    }

    @Test
    public void  checkGladioulusWikiPageObject(){
        System.out.println(this.getClass().getName());
        chromeDriver.get("https://yandex.ru");

        PageObjectYandexSearch yandexSearch = new PageObjectYandexSearch(chromeDriver);

        yandexSearch.find("Гладиолус");
        yandexSearch.waitPagerItems();

        boolean check = false;
        for(WebElement we : yandexSearch.getListOfAllLinks()) {
            // System.out.println(we.getAttribute("href"));

            if (we.getAttribute("href").contains("wikipedia.org"))
                check = true;
        }
        Assertions.assertTrue(check);

    }

}
