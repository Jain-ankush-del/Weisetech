package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Aboutpage {

    public WebDriver driver;

    By aboutus = By.cssSelector("body[class*='page-template'] header div div nav div  ul li:nth-child(2)");
    By text = By.cssSelector("h1[class='mb-3']");
    By mathvalue = By.cssSelector("section[class*='about-section'] div div:nth-child(2) div span");
    By OWR = By.cssSelector("section[class*='sub-gray-light-bg'] div div div div:nth-child(2) h2");
    By WCS = By.cssSelector("div[class='about-sub-serv-sp pr-110'] h2");
    By image = By.tagName("img");

    public Aboutpage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getimage() {
        return this.driver.findElements(image);
    }

    public WebElement getaboutlink() {
        return this.driver.findElement(aboutus);
    }
    public WebElement verifyaboutuspage() {
        return this.driver.findElement(text);
    }
    public WebElement verifymathisvalue() {
        return this.driver.findElement(mathvalue);
    }
    public WebElement getOWR() {
        return this.driver.findElement(OWR);
    }
    public WebElement getWCR() {
        return this.driver.findElement(WCS);
    }
}
