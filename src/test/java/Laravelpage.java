import Pageobject.LaravelDev;
import Pageobject.Softwaresevicepage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class Laravelpage extends base {


    public WebDriver drive;
    public static Logger log = LogManager.getLogger(base.class.getName());
    @BeforeTest
    public void browserope() throws IOException {
        driver = initializationdriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1)
    public void Laravelpage() throws InterruptedException {
        LaravelDev ld = new LaravelDev(driver);
        ld.getservicedropdown().click();
        Thread.sleep(3000);
        ld.getLaravallink().click();
        Thread.sleep(3000);

        String actual = ld.getPageTitle().getText();
        String expected = "Laravel Development";

        Assert.assertEquals(actual,expected);
        log.info("Verify the page title");

        Thread.sleep(2000);

        String actual1 = ld.getLaravelDevelopmenttitele().getText();
        String expected1 = "Laravel Development";


        Assert.assertEquals(actual1,expected1);
        log.info("Verify the title");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        String actual2 = ld.getELD().getText();
        String expected2 = "Expert Laravel Development for Scalable, Secure Web Solutions";

        Assert.assertEquals(actual2,expected2);
        log.info("Verify the title");

        Thread.sleep(4000);

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0,800)");

        Thread.sleep(4000);

        List<WebElement> cards =  ld.getCountELDcards();
        System.out.println(cards.size());

        if(cards.size() == 4) {
            log.info("4 cards exact match");
        }else  {
            log.info("Expected 4 cards, but found"  + cards.size());
        }

        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("window.scrollBy(0,700)");

        String actual3 = ld.getdevelopmentprocesstitle().getText();
        String expected4 ="Development Process";

        Assert.assertEquals(actual3,expected4);

        Thread.sleep(4000);

        JavascriptExecutor js3 = (JavascriptExecutor)driver;
        js3.executeScript("window.scrollBy(0,1500)");

        List<WebElement> Portfolio = ld.getcountportfolio();
        log.info(Portfolio.size());

        if(Portfolio.size() == 4) {
            log.info("4 portfolio exact match");
        }else {
            log.info("Expected 4 portfolio, but found" + Portfolio.size());
        }

        JavascriptExecutor js4 = (JavascriptExecutor)driver;
        js4.executeScript("window.scrollBy(0,3000)");

        List<WebElement> industries = ld.getcountindustries();
        log.info(industries.size());

        if(industries.size() == 10) {
            log.info("10 industries exact match");
        }else {
            log.info("Expected 10 industries, but found" + industries.size());
        }
    }
    @Test(priority = 2)
    public void allimages() throws InterruptedException {
        LaravelDev ld = new LaravelDev(driver);
        Thread.sleep(5000);
        List<WebElement> image = ld.getimage();
        log.info(image.size());

        for(int i=0;i< image.size(); i++) {
            WebElement img = image.get(i);
            String text = img.getText();
            String imagepath = img.getAttribute("src");

            if(imagepath != null && !imagepath.trim().isEmpty()) {
                log.info(text +"("+imagepath+")");
            }else {
                log.info("Skipped any attriubute not avaliable" +i);
            }
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();

    }

}
