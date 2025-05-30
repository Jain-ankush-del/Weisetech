package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class homepage {
    public  WebDriver driver;

    By navigationmenu = By.cssSelector("#mainNav");
    By allnavigationlinks = By.tagName("a");
    By dropdownicon = By.cssSelector("a[role='button']");
    By Aboutusimage = By.cssSelector("img[alt='About']");
    By Abouttitele = By.cssSelector(".text-capitalize");
    By Whatsection = By.cssSelector(".mb-0");
    By firstimage = By.cssSelector("div[class='col-12 col-md-6 col-lg-4 mspb-30 aos-init aos-animate'] img[alt='app-development']");
    By developtitele = By.cssSelector("h2[class='mb-30']");
    By developimage = By.cssSelector("img[alt='app-development-case']");
    By clienttitele = By.cssSelector("body[class*='wp-singular'] section:nth-child(6) div div div h2");
    By clientimage = By.cssSelector(".business-chat");
    By preview = By.cssSelector("section[class='study-section gray-bg'] div[class='owl-nav'] button:nth-child(1)");
    By next = By.cssSelector("section[class='study-section gray-bg'] div[class='owl-nav'] button:nth-child(2)");
    By image = By.tagName("img");
    By Sociallinka = By.cssSelector(".social-links");

    public homepage(WebDriver driver) {
        this.driver = driver;

    }
    public List<WebElement> getSociallinka() {
        return this.driver.findElements(Sociallinka);
    }
    public List<WebElement> getimage() {
        return this.driver.findElements(image);
    }

    public WebElement getpreviewbutton() {
        return this.driver.findElement(preview);
    }
    public WebElement getnextbutton() {
        return this.driver.findElement(next);
    }

    public WebElement getnavigationbar() {
        return this.driver.findElement(navigationmenu);
    }
    public WebElement getaboutimage() {
        return this.driver.findElement(Aboutusimage);
    }
    public WebElement getabouttitele() {
        return this.driver.findElement(Abouttitele);
    }
    public WebElement whattitele() {
        return this.driver.findElement(Whatsection);
    }
    public WebElement verifyimage() {
        return this.driver.findElement(firstimage);
    }
    public WebElement developtitele() {
        return this.driver.findElement(developtitele);
    }
    public WebElement developverifyimage() {
        return this.driver.findElement(developimage);
    }
    public WebElement clienttitele() {
        return this.driver.findElement(clienttitele);
    }
    public WebElement clientverifyimage() {
        return this.driver.findElement(clientimage);
    }

    public List<WebElement> getallnavigationlinks() {
        return this.driver.findElements(allnavigationlinks);
    }
    public WebElement gedropdownarrow() {
        return this.driver.findElement(dropdownicon);
    }

}
