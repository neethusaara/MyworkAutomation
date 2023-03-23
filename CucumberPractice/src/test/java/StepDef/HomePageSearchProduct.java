package StepDef;

import PageObject.HomePageSearchPO;
import Utils.BrowserClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageSearchProduct {


    public BrowserClass BrowserDriver;
    public HomePageSearchPO searchHome;

    public HomePageSearchProduct(BrowserClass BrowserDriver)
    {
        this.BrowserDriver = BrowserDriver;

    }
    @Given("user is in green cart home page")
    public void user_is_in_green_cart_home_page() {
        System.out.println("Launching browser");
    }


    @When("^user search for product with short name(.+)and extracted the actual code")
    public void user_search_for_product_with_short_name_and_extracted_the_actual_code(String product) throws InterruptedException {
        searchHome= BrowserDriver.PageObjectManager.HomePage();
        BrowserDriver.productName= searchHome.searchAndVerifyProductName(product);

    }

}
