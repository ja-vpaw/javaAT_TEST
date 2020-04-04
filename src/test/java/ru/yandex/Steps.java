package ru.yandex;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Steps {

    @Step("Поиск {text} в Яндексе")
    public static void searchTextYandex (PageObjectYandexSearch page, String text) {
        Assert.assertTrue("did not go to the page: '"+text+"'",
                page.find(text)
        );
        Assert.assertTrue("did load find page",
                page.waitPagerItems()
        );
        getScreen(page.chromeDriver);
    }

    @Attachment
    public static byte[] getScreen(WebDriver driver){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources","screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

}
