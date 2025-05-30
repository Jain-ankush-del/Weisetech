package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Softwaresevicepage {

    public WebDriver driver;
    By servicedropdown = By.cssSelector("a[role='button']");
    By serivcelink = By.cssSelector("ul[id='menu-main-menu'] li ul li:nth-child(2)");
    By PageTitle = By.cssSelector(".mb-3");
    By Webandapptitle = By.cssSelector("div[class='content-box'] h2");
    By WWT = By.cssSelector("div[class='why-left-text'] h2");
    By OurText = By.cssSelector("h4[class='fw-bold']");
    By BSB = By.cssSelector("div[class='subhead mb-50'] h2");
    By plusicon = By.cssSelector("div[class='faq-question collapsed'] span[class='faq-icon']");
    By minusicon = By.cssSelector("body > section:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");
    By image = By.tagName("img");

    public Softwaresevicepage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getservicedropdown() {
        return this.driver.findElement(servicedropdown);
    }

    public List<WebElement> getimage() {
        return this.driver.findElements(image);
    }
    public WebElement getserivcelink() {
        return this.driver.findElement(serivcelink);
    }
    public WebElement getPageTitle() {
        return this.driver.findElement(PageTitle);
    }
    public WebElement getWebandapptitle() {
        return this.driver.findElement(Webandapptitle);
    }
    public WebElement getWWT() {
        return this.driver.findElement(WWT);
    }

    public WebElement getOurText() {
        return this.driver.findElement(OurText);
    }
    public WebElement getBSB() {
        return this.driver.findElement(BSB);
    }
    public WebElement getplusicon() {
        return this.driver.findElement(plusicon);
    }
    public WebElement getminusicon() {
        return this.driver.findElement(minusicon);


    }
}
