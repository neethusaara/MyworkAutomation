package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class Genericutils {
    WebDriver driver;
    public Genericutils(WebDriver driver)
    {
     this.driver=driver;
    }

    public void SwitchWindowToChild(){
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow =i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }
}
