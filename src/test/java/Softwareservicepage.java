import Pageobject.Servicepage;
import Pageobject.Softwaresevicepage;
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

public class Softwareservicepage extends base {

    public WebDriver driver;

    @BeforeTest
    public void browserope() throws IOException {
        driver = initializationdriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void servicepage() throws InterruptedException {
        Softwaresevicepage Sp = new Softwaresevicepage(driver);
        Sp.getservicedropdown().click();
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector(".menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-has-children.nav-item.dropdown")).click();
        Sp.getserivcelink().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        String actual = Sp.getPageTitle().getText();
        String expected = "Software Service";

        Assert.assertEquals(actual,expected);

        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,200)");

        String actual1 = Sp.getWebandapptitle().getText();
        String expected1 = "Web And App Development Company In Toronto";

        Assert.assertEquals(actual1,expected1);
        Thread.sleep(2000);

        Assert.assertEquals(actual,expected);

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,500)");

        String actual2 = Sp.getWWT().getText();
        String expected2 = "Why We Are";

        Assert.assertEquals(actual2,expected2);
        Thread.sleep(2000);

        JavascriptExecutor js3= (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,500)");

        String actual3 = Sp.getOurText().getText();
        String expected3 = "Our Services Web App Development Partner Opens The Door To Exclusive Perks";

        Assert.assertEquals(actual3,expected3);
        Thread.sleep(2000);
        JavascriptExecutor js4= (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,700)");

        String actual4 = Sp.getBSB().getText();
        String expected4 = "Building Strong Bond";

        Assert.assertEquals(actual4,expected4);
        Thread.sleep(2000);
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);


        Sp.getminusicon().click();
        Thread.sleep(5000);

        Sp.getplusicon().click();
    }

    @Test(priority = 2)
    public void allimages() throws InterruptedException {
        Softwaresevicepage Sp = new Softwaresevicepage(driver);
        Thread.sleep(5000);
        List<WebElement> image = Sp.getimage();
        System.out.println(image.size());

        for(int i=0;i< image.size(); i++) {
            WebElement img = image.get(i);
            String text = img.getText();
            String imagepath = img.getAttribute("src");

            if(imagepath != null && !imagepath.trim().isEmpty()) {
                System.out.println(text +"("+imagepath+")");
            }else {
                System.out.println("Skipped any attriubute not avaliable" +i);
            }
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();

    }
}
