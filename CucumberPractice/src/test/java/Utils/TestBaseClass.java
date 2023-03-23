package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBaseClass {

    public WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    public WebDriver BrowserManger() throws IOException {
        Properties prop = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//global.properties");
        prop.load(inputStream);
        String url = prop.getProperty("apllicationURL");
        String browsercommand= System.getProperty("browser");
        System.out.println("browser   "+browsercommand);
        if(driver ==null) {
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C://MyWork//CucumberPractice//src//main//resources//chromedriver.exe");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                System.out.println(url);
                driver.get(url);
            }
        }
        return driver;
        }
}

// to get the browser details or any other parameter from command line use below code

/////String browsercommand= System.getProperty("browser"); // this will return the value
//////String BrowserProperty = prop.getProperty("browser");


//given in the commond line say, -Dbrowser = chrome. And this is controlled in runtime
// So for below code check both case ( from system property and from property file

// result = testcondition ? value1 : value2
// ** if test condition is true then it will return value1 else value2

// browser = browsercommand != nll ? browsercommand : BrowserProperty
