package appiumproject;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SwipeTest extends BaseTest{

    @Test
    public void ScrollMenu() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]"))
                .getAttribute("focusable"),"true");
        swipeAction(firstImage,"left");
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]"))
                .getAttribute("focusable"),"false");

    }
}
