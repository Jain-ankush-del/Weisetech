package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaravelDev {

    public WebDriver driver;
    By servicedropdown = By.cssSelector("a[role='button']");
    By serivcelink = By.cssSelector("ul[id='menu-main-menu'] li ul li:nth-child(3)");
    By PageTitle = By.cssSelector(".mb-3");
    By LaravelDevelopmenttitele = By.cssSelector("div[class='content-box'] h4 strong");
    By ELD = By.cssSelector("body > section:nth-child(5) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1)");
    By Countbox = By.cssSelector("div[class*='aos-animate']");
    By developmentprocesstitle = By.cssSelector("div[class='subhead mb-20'] h2");
    By countportfolio = By.cssSelector("div[class='service-portfolio-card']");
    By countindustries = By.cssSelector("div[class*='p-3']");
    By image = By.tagName("img");

    public LaravelDev(WebDriver driver) {
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
    public WebElement getLaravelDevelopmenttitele() {
        return this.driver.findElement(LaravelDevelopmenttitele);
    }

    public WebElement getELD() {
        return this.driver.findElement(ELD);
    }
    public WebElement getdevelopmentprocesstitle() {
        return this.driver.findElement(developmentprocesstitle);
    }

    public List<WebElement> getCountbox() {
        return this.driver.findElements(Countbox);
    }
    public List<WebElement> getcountportfolio() {
        return this.driver.findElements(countportfolio);
    }
    public List<WebElement> getcountindustries() {
        return this.driver.findElements(countindustries);
    }



}
