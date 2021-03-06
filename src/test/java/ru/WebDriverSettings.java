package ru;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    protected WebDriver chromeDriver;

    public static void son(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }

    @BeforeEach
    public void setupBellTest(){
        String osName = System.getProperty("os.name");
        System.out.println(osName);


        if (osName != null && osName.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        }
        else if (osName != null && osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");

        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterEach
    public void closeBellTest(){
        chromeDriver.quit();
    }

}
