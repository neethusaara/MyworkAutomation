package StepDef;

import Utils.BrowserClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    BrowserClass browserClass;
    public Hooks(BrowserClass browserClass)
    {
        this.browserClass = browserClass;
    }


    @After
    public void CloseBrowser() throws IOException {

        browserClass.testBaseClass.BrowserManger().quit();

    }

    @AfterStep
    public void TakeScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File path = ((TakesScreenshot)browserClass.testBaseClass.BrowserManger()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(path);
            scenario.attach(fileContent,"image/png","image");

        }

    }

}
