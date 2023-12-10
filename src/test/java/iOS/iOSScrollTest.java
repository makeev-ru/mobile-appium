package iOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSScrollTest extends iOSBaseTest {
    @Test
    public void iOSBasicTest() throws InterruptedException {
        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)ele).getId());

        driver.executeScript("mobile:scroll", params);

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("50");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("150");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("250");
    }
}
