package com.softwarequalitycourse.lab7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

/**
 * Created by sasha on 12/3/15.
 */
public class LoginTest {

    private HtmlUnitDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        driver.get("http://nodejsoauth-umap.rhcloud.com/#/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

//    @Test
//    public void testLogin() throws Exception {
//        driver.get("http://nodejsoauth-umap.rhcloud.com/#/login");
//    }

    @Test
    public void testMain() throws Exception {
        driver.get("http://nodejsoauth-umap.rhcloud.com/#");
       assertEquals(driver.getTitle(),"Title");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
