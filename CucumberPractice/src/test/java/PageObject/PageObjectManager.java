package PageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public TopDealsSearchPO topDealsSearchPO;
    public HomePageSearchPO homePageSearchPO;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public TopDealsSearchPO LandingPage()
    {
        topDealsSearchPO = new TopDealsSearchPO(driver);
        return topDealsSearchPO;
    }

    public HomePageSearchPO HomePage()
    {
        homePageSearchPO = new HomePageSearchPO(driver);
        return  homePageSearchPO;
    }
}
