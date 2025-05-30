import Pageobject.Ourwork;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Ourworkpage extends base {

    public WebDriver driver;
    public WebDriver drive;
    @BeforeTest
    public void browserope() throws IOException {
        driver = initializationdriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1)
    public void ourportfolipage() throws InterruptedException {

        Ourwork op = new Ourwork(driver);
        op.getourpagelink().click();
        Thread.sleep(2000);

        String actual = op.verifypagelink().getText();
        String expected = "Work Portfolio";

        Assert.assertEquals(actual,expected);

        List<WebElement> alltab = op.alltabclick();
        System.out.println(alltab.size());

        for(int i=0; i<alltab.size(); i++) {
            alltab = op.alltabclick();
            WebElement all = alltab.get(i);
            String text = all.getText();
            String tab = all.getAttribute("role");

            if(tab !=null && !tab.trim().isEmpty()) {
                System.out.println("Clicking link: " + text + " (" + tab + ")");
                all.click();
                Thread.sleep(3000);
            }else {
                System.out.println("Skipped empty link at index " + i);
            }

        }

        Thread.sleep(5000);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000);


        JavascriptExecutor js1 =(JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");

        List<WebElement> countportfoliimages = op.countportfolio();
        System.out.println(countportfoliimages.size());
        if (countportfoliimages.size() == 4) {
            System.out.println("4 portfolio project match");
        }else {
            System.out.println("Expected 4 portfolio, but found" + countportfoliimages.size());
        }
        Thread.sleep(2000);

        op.gotoportfoliodetailpage().click();
        Thread.sleep(3000);
        driver.navigate().back();







    }
}
