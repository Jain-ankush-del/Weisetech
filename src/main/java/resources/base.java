package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {

    public WebDriver driver;
    public  Properties prop;
public WebDriver initializationdriver() throws IOException {

    prop = new Properties();
    FileInputStream fi  = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
    prop.load(fi);

    //String browserName =  System.getProperty("browser");
    String browserName = prop.getProperty("browser");

    if(browserName.equals("chrome")) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//java//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions() ;
        if(browserName.equals("headless")) {
           options.addArguments("headless");
        }
        driver = new ChromeDriver(options);
    }  else if(browserName.equals("firefox")) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\aparp\\Downloads\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    else if(browserName.equals("Edge")){
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;

}

    public String getScrrenshotpath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationfile));
        return destinationfile;
    }

}

