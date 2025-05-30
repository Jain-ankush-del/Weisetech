package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Servicepage {


public  WebDriver driver;

    By servicedropdown = By.cssSelector("a[role='button']");
    By Webistelink = By.cssSelector(".nav-link[href='https://dev.weisetechdev.com/weisetech/web-development/']");
    By webdevelopmenttext = By.cssSelector("h1[class='mb-3']");
    By LD = By.cssSelector("body div[class='container py-5'] div[class='row align-items-center'] div:nth-child(1) h2:nth-child(1)");
    By Limage = By.cssSelector("img[alt='Laravel-Development']");
    By RJD = By.cssSelector("div:nth-child(4) h2:nth-child(1)");
    By NJD = By.cssSelector("div:nth-child(5) h2:nth-child(1)");
    By AJD = By.cssSelector("div:nth-child(8) h2:nth-child(1)");
    By PHD = By.cssSelector("div:nth-child(9) h2:nth-child(1)");
    By image = By.tagName("img");

    public Servicepage(WebDriver driver) {
        this.driver=driver;

    }
    public WebElement getRJD() {
        return this.driver.findElement(RJD);

    }
    public List<WebElement> getimage() {
        return this.driver.findElements(image);
    }
    public WebElement getAJD() {
        return this.driver.findElement(AJD);
    }
    public WebElement getPHD() {
        return this.driver.findElement(PHD);
    }
    public WebElement getNJD() {
        return this.driver.findElement(NJD);
    }

    public WebElement getservicedropdown() {
        return this.driver.findElement(servicedropdown);
    }
    public WebElement getwebsitelink() {
        return this.driver.findElement(Webistelink);
    }
    public WebElement getwebsitedevelopmenttext() {
        return this.driver.findElement(webdevelopmenttext);
    }
    public WebElement getLD() {
        return this.driver.findElement(LD);
}
    public WebElement getLImage() {
        return this.driver.findElement(Limage);
    }
}