import org.junit.Test;
//import sun.font.TrueTypeFont;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.assertTrue;

public class FirstFirefoxTest {

    @Test
    public void firefoxIsSupportedByWebDriver()
    {
        //System.setProperty("webdriver.gecko.driver",)
        WebDriver driver = new FirefoxDriver();

        //WebDriver driver = new MarionetteDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium");
        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
        driver.close();
        //driver.quit();

    }


}
