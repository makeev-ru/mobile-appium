package android;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class AppiumBasics extends androidConfig {

    @Test
    public void WiFiSettingsName() throws MalformedURLException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Test WiFi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }
}
