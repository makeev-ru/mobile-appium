package appiumproject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt/homebrew//bin//appium"))
                .usingDriverExecutable(new File("//opt/homebrew//bin//node"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("mobauto");
        options.setApp("//Users//rpryimak//mobauto//src//test//java//appiumproject//resources//ApiDemos-debug.apk");

        String service_url = service.getUrl().toString();
        driver = new AndroidDriver(new URL(service_url), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void LongPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                        "duration", 2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }


    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }


    public Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
