package StepDef;

import PageObject.HomePageSearchPO;
import PageObject.TopDealsSearchPO;
import Utils.BrowserClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TopDealsSeachProduct {

    String prodName1;
    public BrowserClass BrowserDriver;
    public TopDealsSearchPO topDealsSearch;

    public TopDealsSeachProduct(BrowserClass BrowserDriver) {
        this.BrowserDriver = BrowserDriver;
    }


    @Then("^user searches the same shortname(.+)in offers page")
    public void user_searches_the_same_shortname_in_offers_page_and_check_if_the_product_exist(String product) throws InterruptedException {
        topDealsSearch = BrowserDriver.PageObjectManager.LandingPage();
        topDealsSearch.MoveToTopDealsPage();
        BrowserDriver.genericutils.SwitchWindowToChild();
        prodName1 = topDealsSearch.searchForProductInTopDeals(product);
    }

    @And("user validate search results in home page and topDeal matches")
    public void user_validate_search_results_in_home_and_topDeal_match() {
        Assert.assertEquals(BrowserDriver.productName, prodName1);
    }

}
