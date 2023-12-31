package org.example.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSUtils extends AppiumUtils {

    IOSDriver driver;

    public IOSUtils(IOSDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", 5);

        driver.executeScript("mobile:touchAndHold", params);
    }

    public void scrollToElement(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)ele).getId());

        driver.executeScript("mobile:scroll", params);
    }


    public void swipeToEnd(int swipes, String direction) {
        Map<String, String> params1 = new HashMap<>();
        params1.put("direction", direction);

        for (int i = 0; i < swipes; i++) {
            driver.executeScript("mobile:swipe", params1);
        }
    }
}
