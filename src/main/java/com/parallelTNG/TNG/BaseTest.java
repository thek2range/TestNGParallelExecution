package com.parallelTNG.TNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();


    @BeforeTest
    public void Setup(){
        WebDriver driver = BrowserManager.doBrowserSetup("chromium");
        //set driver
        threadLocalDriver.set(driver);
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
    }

    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    @AfterTest
    public void tearDown(){
        getDriver().quit();

        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

        threadLocalDriver.remove();
    }

}