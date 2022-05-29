import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {
    //Test case:
    //1. Open page http://www.99-bottles-of-beer.net
    //2. Click menu button Browse languages;
    //3. Click menu button Start
    //4. Confirm that user can see heading "Welcome to 99 Bottles of Beer"
    //5. Close browser

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath ="C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        //Thread.sleep(2000);

        WebElement menuBrowserLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li[@class='sel']/a")
        );
        menuBrowserLanguages.click();
        //Thread.sleep(2000);

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2")
        );
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
;    }
}
