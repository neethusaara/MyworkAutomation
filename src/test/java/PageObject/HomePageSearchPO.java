package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageSearchPO {

    WebDriver driver;
    String StringSplit;
    public HomePageSearchPO(WebDriver driver)
    {
        this.driver = driver;
    }
    String productName;

    By SearchProductField = By.xpath("//input[@type=\"search\"]");
    By SearchButton = By.xpath("//button[@class=\"search-button\"]");
    By ProductName = By.cssSelector("h4.product-name");

    public String searchAndVerifyProductName(String product) throws InterruptedException {
        driver.findElement(SearchProductField).sendKeys(product);
        driver.findElement(SearchButton).click();
        Thread.sleep(2000);
        productName = driver.findElement(ProductName).getText();
        System.out.println("ProductBeforeSplit "+productName);
        //productName = productName.split("-")[0].trim();
        productName = SplitAString(productName,"-","left");
        System.out.println("ProductAfterSplit "+productName);
        return productName;
    }


    public String SplitAString(String StringToSplit, String character, String LeftOrRight)
    {
        if(LeftOrRight.contains("left"))
        {
            StringSplit = StringToSplit.split(character)[0].trim();
        }
        else if(LeftOrRight.contains("right"))
        {
            StringSplit = StringToSplit.split(character)[1].trim();
        }
        return StringSplit;
    }

}


