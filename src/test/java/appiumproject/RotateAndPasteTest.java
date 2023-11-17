package appiumproject;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ComplexTest extends BaseTest{

    @Test
    public void RotateAndPasteTest() throws MalformedURLException {


        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);

        driver.setClipboardText("Test WiFi");
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(AppiumBy.id("android:id/button1")).click();


    }
}
