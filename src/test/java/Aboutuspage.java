import Pageobject.Aboutpage;
import Pageobject.homepage;
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

public class Aboutuspage extends base {

    public WebDriver driver;

    @BeforeTest
    public void browserope() throws IOException {
        driver = initializationdriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1)
    public void innerpageaboutus() throws InterruptedException {
        Aboutpage ab = new Aboutpage(driver);
        ab.getaboutlink().click();

        String actual = ab.verifyaboutuspage().getText();
        String expected = "About Us";

        Assert.assertEquals(actual,expected);

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        String actual1 = ab.getOWR().getText();
        System.out.println(actual1);
        String expected1 = "Our Working Process";

        Assert.assertEquals(actual1,expected1);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        String actual2 = ab.getWCR().getText();
        String expected2 = "What Clients Say About The Tool";

        Assert.assertEquals(actual2,expected2);




    }

    @Test(priority = 2)
    public void Images() throws InterruptedException {
        Aboutpage ab = new Aboutpage(driver);


        List<WebElement> img = ab.getimage();
        System.out.println(img.size());

        for (int i = 0; i < img.size(); i++) {
            img = ab.getimage();
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


