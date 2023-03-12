package com.parallelTNG.TNG;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserManager {
	 
	   public static WebDriver doBrowserSetup(String browserName){

	        WebDriver driver = null;
	        if (browserName.equalsIgnoreCase("chromium"))
	        {
	            //steup chromium browser
	        	String pathOfExecutable = "/home/testCode/TNG/src/test/resources/msedgedriver";
	        	System.out.println("Driver Exists : " + new File(pathOfExecutable).exists());
	        	WebDriverManager.chromiumdriver().setup();
	        	System.setProperty("webdriver.edge.driver",pathOfExecutable);
	        	
	        	//Add options for --headed or --headless browser launch
	        	
	            EdgeOptions edgeOptions = new EdgeOptions();
	           // edgeOptions.addArguments("-headed");
	            edgeOptions.addArguments("--headless");
	            edgeOptions.addArguments("--no-sandbox");
	            edgeOptions.addArguments("--disable-dev-shm-usage");
	            edgeOptions.addArguments("--disable-gpu");
	            edgeOptions.addArguments("--window-size=1920,1080");
	         	            
	            //initialize driver for chrome
	            driver = new EdgeDriver(edgeOptions);

	            //maximize window
	            driver.manage().window().maximize();

	            //add implicit timeout
	            driver.manage()
	           .timeouts()
	           .implicitlyWait(Duration.ofSeconds(30));

	        }
	   return driver;
	}
}