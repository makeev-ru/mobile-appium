package iOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iOSSwipePhotoTest extends iOSBaseForInstalledApp {
    @Test
    public void iOSSwipePhotoTest() {
        Map<String, String> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp", params);

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        int photosSize = allPhotos.size();

        driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
        Map<String, String> params1 = new HashMap<>();
        params1.put("direction", "left");

        for (int i = 0; i < photosSize; i++) {
            driver.executeScript("mobile:swipe", params1);
        }

        String lastPhotoTimestamp = driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name");
        System.out.println(lastPhotoTimestamp);
        Assert.assertEquals(lastPhotoTimestamp, "30 March 2018, 12:14");

        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();
    }
}
