package ru.market_yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageFactoryMarket {
    private WebDriver chromeDriver;
    private String url = "https://market.yandex.ru/";
    WebDriverWait wait;


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Электроника')]")
    WebElement electronicsSection;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Мобильные телефоны')]")
    WebElement cellPhoneSection;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Apple')]")
    WebElement appleFilterCheckbox;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "n-snippet-cell2__brand-name"))
    List<WebElement> listOfItemsBrand;


    public PageFactoryMarket(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        wait = new WebDriverWait(chromeDriver, 30);
        chromeDriver.get(url);
    }

    public void clickAndWaitPageLoad(WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we));
        we.click();
    }

    public void goElectronicsSection() {
        clickAndWaitPageLoad(electronicsSection);
    }

    public void goCellSection() {
        clickAndWaitPageLoad(cellPhoneSection);
    }

    public void setAppleFilter() {
        clickAndWaitPageLoad(appleFilterCheckbox);
        ru.WebDriverSettings.son(5000);
    }

    public List<WebElement> getListOfItemsBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(listOfItemsBrand.get(0)));
        return listOfItemsBrand;
    }

}
