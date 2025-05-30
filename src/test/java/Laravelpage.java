import Pageobject.LaravelDev;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

public class Laravelpage extends base {


    public WebDriver drive;
    @BeforeTest
    public void browserope() throws IOException {
        driver = initializationdriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void Laravelpage() throws InterruptedException {
        LaravelDev LD = new LaravelDev(driver);

    }

}
