import Pageobject.homepage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Homepage extends base {

public WebDriver driver;
    //public homepage hm;
    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = initializationdriver();
        log.info("Driver is open");
        Thread.sleep(4000);
        driver.get(prop.getProperty("url"));
        Thread.sleep(5000);
        log.info("Navigate to url");




    }

    @Test
  public void Aboutus() throws InterruptedException {


        homepage hm = new homepage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement image = hm.getaboutimage(); // Get the image WebElement

        String actualImageSrc = image.getAttribute("src"); // Get the src attribute

        if (actualImageSrc.equals("https://dev.weisetechdev.com/weisetech/wp-content/uploads/2025/05/home-about.webp")) {
            log.info("Image is displayed and src matches");
        } else {
            log.info("Image is either not displayed or src does not match");
        }
         Thread.sleep(4000);


        Assert.assertEquals(hm.getabouttitele().getText(), "Mobile App Design & Web Development Company In Canada");

        Assert.assertEquals(hm.whattitele().getText(),"What We Do Best");
        log.info("verify the  title");

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,800)");

        WebElement image1 = hm.verifyimage();
        String actualimage = image1.getAttribute("src");

        if (actualimage.equals("https://dev.weisetechdev.com/weisetech/wp-content/uploads/2025/05/app-development.svg")) {
            log.info("Image is displayed and src matches");
        } else {
            log.info("Image is either not displayed or src does not match");
        }
    }
    @Test
    public void developmentsection() throws InterruptedException {

        homepage hm = new homepage(driver);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,800)");
        Thread.sleep(4000);

       // String actual = hm.developtitele().getText();
      //  Assert.assertEquals();
        Assert.assertEquals(hm.developtitele().getText(), "Banking Application – Enhanced User Experience");
        log.info("verify the  title");

        WebElement image2 = hm.developverifyimage();
        String actualimage = image2.getAttribute("src");
        String expected = "https://dev.weisetechdev.com/weisetech/wp-content/uploads/2025/05/app-development-case.webp";

        Assert.assertEquals(actualimage,expected,"Image is not matched");
        log.info("verify the  title");

    }

    @Test
    public void clientsection() throws InterruptedException {

        homepage hm = new homepage(driver);
        Thread.sleep(6000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,800)");
        Thread.sleep(4000);

        String actual = hm.clienttitele().getText();
        String expected12 = "highly experienced team";
        //Assert.assertTrue(actual.contains(expected12), "Text does not contain the substring ");
        if(actual.contains(expected12)){
            log.info("substring is matched");

        }else {
            log.info("substring is not matched");
        }
        /* Assert.assertEquals(hm.clienttitele().getText(), "InA highly experienced team" +
                 "with 10+ years of average" +
                 "industry expertise.");*/
        WebElement image2 = hm.clientverifyimage();
        String actualimage = image2.getAttribute("class");
        String expected = "business-chat";

        Assert.assertEquals(actualimage,expected,"Image is not matched");
        log.info("verify the  title");
    }






    @AfterTest
    public void teardown() {
        driver.close();

    }
}
