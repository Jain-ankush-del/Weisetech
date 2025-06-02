import Pageobject.homepage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Homepagesalllinks extends base
{
    public WebDriver driver;
    //public homepage hm;
    public static Logger log = LogManager.getLogger(base.class.getName());


    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = initializationdriver();
        Thread.sleep(4000);
        driver.get(prop.getProperty("url"));
        Thread.sleep(5000);

    }

    @Test
    public void alllinks() throws InterruptedException {
        homepage hm = new homepage(driver);
        System.out.println(driver.getCurrentUrl());
        driver.getPageSource();
        Thread.sleep(3000);
        String Expected = "Weisetech Developers";
        Assert.assertEquals(driver.getTitle(),Expected);
        Thread.sleep(3000);


        hm.getnavigationbar();

        List<WebElement> nav = hm.getallnavigationlinks();
        System.out.println(nav.size());

        for(int i=0;i< nav.size(); i++) {
            nav = hm.getallnavigationlinks();
            WebElement link = nav.get(i);
            String text = link.getText();
            String url = link.getAttribute("href");

            if(url != null && !url.trim().isEmpty()) {
                log.info("Clicking link: " + text + " (" + url + ")");
                try {
                    Thread.sleep(2000);
                    link.click();
                    Thread.sleep(2000);

                    //WebElement dropdown = hm.gedropdownarrow();
                    //dropdown.click();
                    Thread.sleep(4000);
                    //link.click();
                    driver.navigate().back();
                    driver.get(prop.getProperty("url"));
                    Thread.sleep(2000);
                } catch (Exception e) {
                    log.info("Failed to click link: " + url);
                }
            } else {
                log.info("Skipped empty link at index " + i);
            }


        }



    }
    @AfterTest
    public void teardown() {
        driver.close();

    }
}
