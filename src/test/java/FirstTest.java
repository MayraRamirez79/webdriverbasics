import org.junit.Test;
//import sun.font.TrueTypeFont;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    @Test
    public void driverIsTheKing()
    {
        //esta es la instancia del driver:
        WebDriver driver = new HtmlUnitDriver();
        //abre la pagina:
        driver.get ("https://www.marthadebayle.com/category/v2/radio/podcast/");
        //hace una comparacion
        assertTrue(driver.getTitle().startsWith("Podcast Archives"));
    }
}
