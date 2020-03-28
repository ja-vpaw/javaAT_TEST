package ru.market_yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class MarketAppleTest extends ru.WebDriverSettings {

    @Test
    public void marketAppleFilter(){
        System.out.println(this.getClass().getName());
        PageFactoryMarket marketPage = PageFactory.initElements(chromeDriver,PageFactoryMarket.class);

        marketPage.goElectronicsSection();
        marketPage.goCellSection();
        marketPage.setAppleFilter();

        boolean check = true;
        for(WebElement we : marketPage.getListOfItemsBrand()) {
            System.out.println(we.getText());
            if(we.getText().equals("Автоматизация"))
                check = false;
        }
        Assertions.assertTrue(check);
    }
}
