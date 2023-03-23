package PageObject;

import Utils.BrowserClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class TopDealsSearchPO {

    WebDriver driver;
    public TopDealsSearchPO(WebDriver driver){
        this.driver =driver;
    }

    public String prodName1;

    By TopDealsLink = By.linkText("Top Deals");
    By SearchTopDeals = By.xpath("//input[@type=\"search\"]");
    By ProductDisplayed = By.cssSelector("tr td:nth-child(1)");


    public void MoveToTopDealsPage() throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Thread.sleep(2000);

    }


    public String searchForProductInTopDeals(String product) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(product);
        Thread.sleep(2000);
        prodName1 = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        return prodName1;
    }


}
