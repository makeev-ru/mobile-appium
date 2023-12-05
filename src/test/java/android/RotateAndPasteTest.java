package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class RotateAndPasteTest extends BaseTest{

    @Test
    public void RotateAndPaste() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);

        driver.setClipboardText("Test WiFi");
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
