package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class androidBrowserConfig {

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
        options.setChromedriverExecutable("/opt/homebrew/Caskroom/chromedriver/119.0.6045.105/chromedriver-mac-arm64/chromedriver");
        options.setCapability("browserName", "Chrome");

        String service_url = service.getUrl().toString();
        driver = new AndroidDriver(new URL(service_url), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
