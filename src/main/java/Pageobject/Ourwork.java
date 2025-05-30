package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ourwork {

    public WebDriver driver;

    By Ourworklinkclick = By.cssSelector(".nav-link[href='https://dev.weisetechdev.com/weisetech/portfolio/']");
    By Ourworkpagetitle = By.cssSelector(".mb-3");
    By Alltab = By.cssSelector("button[role='tab']");
    By nextarrow = By.cssSelector("div[id='all'] span[aria-label='Next']");
    By prevarrow = By.cssSelector("div[id='all'] span[aria-label='Previous']");
    By projectcards = By.cssSelector("div[class*='col-lg-6']");
    By secondpagination = By.cssSelector("div[class='container py-5'] li:nth-child(2) a:nth-child(1)");
    By previewportfolio = By.cssSelector(".page-link.ajax-page");
    By portfoliodetaillink = By.cssSelector("body > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > a:nth-child(1) > img:nth-child(1)");
    By image = By.tagName("img");

    public Ourwork(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getourpagelink() {
        return driver.findElement(Ourworklinkclick);
    }

    public WebElement verifypagelink() {
        return driver.findElement(Ourworkpagetitle);
    }

    public List<WebElement> alltabclick() {

        return driver.findElements(Alltab);
    }
    public WebElement clickonnextarrow() {
        return driver.findElement(nextarrow);
    }
    public WebElement clickonpreviewarrow() {
        return driver.findElement(prevarrow);
    }
    public List<WebElement> countportfolio() {

        return driver.findElements(projectcards);
    }
    public WebElement clicksecondpagination() {
        return driver.findElement(secondpagination);
    }
    public WebElement gotopreviewpage() {
        return driver.findElement(previewportfolio);
    }

    public WebElement gotoportfoliodetailpage() {
        return driver.findElement(portfoliodetaillink);
    }

    public List<WebElement> getimage() {
        return this.driver.findElements(image);
    }
}
