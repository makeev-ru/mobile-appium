package appiumproject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MobileBrowserTest extends BrowserBaseTest {

    @Test
    public void browserTest() throws InterruptedException {
        driver.get("http://google.com");

        driver.findElement(By.xpath("//div[text()='Read more']")).click();
        driver.findElement(By.xpath("//div[text()='Read more']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Accept all']")).click();
        driver.findElement(By.name("q")).sendKeys("Weather today");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(3000);
    }
}
