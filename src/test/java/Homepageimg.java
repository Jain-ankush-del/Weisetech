import Pageobject.homepage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Homepageimg extends base
{

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());
    //public homepage hm;

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = initializationdriver();

        Thread.sleep(4000);
        driver.get(prop.getProperty("url"));
        Thread.sleep(5000);




    }

    @Test
    public void allimg() throws InterruptedException {
        homepage hm = new homepage(driver);


        List<WebElement> img = hm.getimage();
        System.out.println(img.size());

        for (int i = 0; i < img.size(); i++) {
            img = hm.getimage();
            WebElement Imagename = img.get(i);
            String text = Imagename.getText();
            String imagepath = Imagename.getAttribute("src");

            if (imagepath != null && !imagepath.trim().isEmpty()) {
                log.info(  text + " (" + imagepath + ")");

            } else {
                log.info("Skipped any attribute not available" + i);
            }
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();

    }
}
