package iOS;

import io.appium.java_client.AppiumBy;
import org.example.pageObjects.iOS.PickerView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSScrollTest extends iOSConfig {
    @Test
    public void iOSScrollTest() {
        homePage.openWebView();

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        PickerView pickerView = homePage.openPickerView();

        pickerView.setPicker("left", "50");
        pickerView.setPicker("middle", "150");
        pickerView.setPicker("right", "250");
    }
}
