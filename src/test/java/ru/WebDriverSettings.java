package ru;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public WebDriver chromeDriver;
    public Logger logger;

    public static void son(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void createLogFile() {
        try {
            File file = new File(".\\log\\chromedriver.log");
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (java.io.IOException e) {
        }
    }

    @BeforeEach
    public void setupBellTest(){
        String osName = System.getProperty("os.name");
        System.out.println(osName);

        logger=Logger.getLogger("BellTests");
        // configure log4j properties file
        PropertyConfigurator.configure("log4j.properties");



        if (osName != null && osName.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        }
        else if (osName != null && osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
            System.setProperty("webdriver.chrome.logfile", ".\\log\\chromedriver.log");
            //System.setProperty("webdriver.chrome.verboseLogging", "true");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");

        chromeDriver = new ChromeDriver(options);
        // Open browser
        logger.info("Browser Opened");
        // Set implicit wait
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("Implicit wait given");

    }

    @AfterEach
    public void closeBellTest(){
        logger.info("Test finished");
        chromeDriver.quit();
    }

}
