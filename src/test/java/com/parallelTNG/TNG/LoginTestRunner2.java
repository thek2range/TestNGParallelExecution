package com.parallelTNG.TNG;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner2 extends BaseTest {

    @Test (dataProvider = "test2dp")
    public void test2( String expectedTitle, String url  ) throws IOException, Exception {
    	 WebDriver wd2 =  getDriver();
         wd2.get( url );
         String title = wd2.getTitle();
       //  System.out.println("title : " + title);
         Assert.assertEquals(title, expectedTitle);
		
		  try { System.out.println("Wait Start : for LoginTestRunner1 : 10s  For : " + url);
		  Thread.sleep(10000);
		  System.out.println("Wait End : for LoginTestRunner1 : 10s  For : " + url);
		  
		  } catch (Exception e) { // TODO: handle exception 
			  
		  }
		 
    }
    
    @DataProvider
    public Object[][] test2dp() {
      return new Object[][] {
        new Object[] { "News - Latest News, Breaking News, Bollywood, Sports, Business and Political News | Times of India", "https://timesofindia.indiatimes.com/" },
        new Object[] { "National Geographic", "https://www.nationalgeographic.com/" },
        new Object[] { "Home | motherdairy.com", "https://www.motherdairy.com/" },

      };
    }
    
    
}