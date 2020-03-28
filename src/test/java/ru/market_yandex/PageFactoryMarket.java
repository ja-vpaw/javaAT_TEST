package ru.market_yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public String nextPageButtonLocator = "//*[contains(@class, 'n-pager__button-next')]";
    WebDriverWait wait;


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Электроника')]")
    WebElement electronicsSection;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Мобильные телефоны')]")
    WebElement cellPhoneSection;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Apple')]")
    WebElement appleFilterCheckbox;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "n-snippet-cell2__brand-name"))
    List<WebElement> listOfItemsBrand;

    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'n-pager__button-next')]")
    WebElement nextPageButton;


    public PageFactoryMarket(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        wait = new WebDriverWait(chromeDriver, 20);
        chromeDriver.get(url);
    }

    public void clickAndWaitPageLoad(WebElement we) {
        System.out.println(we);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(we));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(chromeDriver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".spin2_progress_yes")));
    }

    public List<WebElement> getListOfItemsBrand() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".spin2_progress_yes"), 0));
        return listOfItemsBrand;
    }

    public boolean isElementPresent(By locator) {
        try {
            chromeDriver.findElement(locator);
            System.out.println(chromeDriver.findElement(locator));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean goNextPage() {
        if (isElementPresent(By.xpath(nextPageButtonLocator))) {
            clickAndWaitPageLoad(nextPageButton);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".spin2_progress_yes")));
            return true;
        } else {
            return false;
        }
    }

}
