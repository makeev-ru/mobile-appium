package iOS;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iOSBasicsTest extends iOSConfig {
    @Test
    public void iOSBasicsTest() {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();

        String actualText = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name BEGINSWITH[c] 'A message'")).getText();
        String expectedText = "A message should be a short, complete sentence.";
        Assert.assertEquals(actualText, expectedText);

        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'"));
    }
}
