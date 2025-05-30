import Pageobject.Aboutpage;
import Pageobject.Servicepage;
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

public class Websitedevelopment extends base {



        public WebDriver driver;

        @BeforeTest
        public void browserope() throws IOException {
            driver = initializationdriver();
            driver.get(prop.getProperty("url"));
        }

        @Test
        public void innerpageservice() throws InterruptedException {
            Servicepage Sp = new Servicepage(driver);
            Sp.getservicedropdown().click();
            Thread.sleep(3000);
            Sp.getwebsitelink().click();

            String actual = Sp.getwebsitedevelopmenttext().getText();
            String expected = "Web Development";

            Assert.assertEquals(actual,expected);

            WebElement image = Sp.getLImage();
            String actualimage = image.getAttribute("src");
            String Expected  = "https://dev.weisetechdev.com/weisetech/wp-content/uploads/2025/05/Laravel-Development.webp";
            Assert.assertEquals(actualimage,Expected);

            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,700)");
            Thread.sleep(3000);
            String actual1 = Sp.getLD().getText();
            System.out.println(actual1);
            String expected1 = "Laravel Development";

            Assert.assertEquals(actual1,expected1);

            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0,500)");
            Thread.sleep(3000);
            String actual12 = Sp.getRJD().getText();
            System.out.println(actual12);
            String expected12 = "React JS Development";

            Assert.assertEquals(actual12,expected12);

            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0,500)");
            Thread.sleep(3000);
            String actual123 = Sp.getNJD().getText();
            System.out.println(actual123);
            String expected123 = "Node.js Development";
            Assert.assertEquals(actual123,expected123);

            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0,500)");
            Thread.sleep(3000);
            String actual1234 = Sp.getAJD().getText();
            System.out.println(actual1234);
            String expected1234 = "AngularJS Development";
            Assert.assertEquals(actual1234,expected1234);

            JavascriptExecutor js4 = (JavascriptExecutor) driver;
            js4.executeScript("window.scrollBy(0,500)");
            Thread.sleep(3000);
            String actual5 = Sp.getPHD().getText();
            System.out.println(actual5);
            String expected5 = "PHP Development";
            Assert.assertEquals(actual5,expected5);

        }

    @Test(priority = 2)
    public void Images() throws InterruptedException {
        Servicepage Sp = new Servicepage(driver);


        List<WebElement> img = Sp.getimage();
        System.out.println(img.size());

        for (int i = 0; i < img.size(); i++) {
            img = Sp.getimage();
            WebElement Imagename1 = img.get(i);
            String text = Imagename1.getText();
            String imagepath = Imagename1.getAttribute("src");

            if (imagepath != null && !imagepath.trim().isEmpty()) {
                System.out.println(  text + " (" + imagepath + ")");

            } else {
                System.out.println("Skipped any attribute not available" + i);
            }
        }
    }
        @AfterTest
        public void teardown() {
            driver.close();

        }
    }

