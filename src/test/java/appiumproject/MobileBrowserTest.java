package appiumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

    @Test
    public void browserTest() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();

//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
//        Thread.sleep(3000);


//        driver.findElement(By.xpath("//android.widget.Button[@resource-id='KByQx']")).click();
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.id("XSqSsc")).sendKeys("weather today");
    }
}
