package iOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iOSSliderTest extends iOSConfig {
    @Test
    public void iOSSliderTest() throws InterruptedException {
        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
        slider.sendKeys("1%"); // 1% == 100%

        String value = slider.getAttribute("value");
        Assert.assertEquals(value, "100%");
    }
}
