package com.parallelTNG.TNG;

import org.openqa.selenium.WebDriver;
/*import Base.BaseTest;
import Pages.Login;
import Utils.BrowserManager;
import Utils.JsonReader;
import org.json.simple.parser.ParseException;*/
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner1 extends BaseTest {
    @Test (dataProvider = "test1dp")
    public void test1( String expectedTitle, String url ) throws IOException, Exception {
         WebDriver wd2 =  getDriver();
         wd2.get( url );
         String title = wd2.getTitle();       
         Assert.assertEquals(title, expectedTitle);
         try {
         	System.out.println("Wait Start : for LoginTestRunner1 : 20s For : " + url);
 			Thread.sleep(20000);
         	System.out.println("Wait End : for LoginTestRunner1 : 20s  For : " + url);

 		} catch (Exception e) {
 			// TODO: handle exception
 		}

    }

    @DataProvider
    public Object[][] test1dp() {
      return new Object[][] {
        new Object[] { "Britannia Industries Limited - Official Website", "http://britannia.co.in/" },
        new Object[] { "Unilever HUL Homepage | Unilever", "https://www.hul.co.in/" },
        new Object[] { "World's Leading Best Ayurvedic Company in India | Ayurvedic Products | Dabur", "https://www.dabur.com/" },

      };
    }

}