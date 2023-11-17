package appiumproject;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollTest extends BaseTest{

    @Test
    public void ScrollMenu() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        scrollToEndAction();

    }
}
