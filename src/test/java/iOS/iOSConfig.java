package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.example.pageObjects.iOS.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class iOSConfig {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt/homebrew//bin//appium"))
                .usingDriverExecutable(new File("//opt/homebrew//bin//node"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setApp("/Users/rpryimak/mobauto/src/test/java/iOS/resources/UIKitCatalog.app");
//        options.setApp("/Users/rpryimak/mobauto/src/test/java/iOS/resources/TestApp 3.app");
        options.setPlatformName("17.0");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        String service_url = service.getUrl().toString();
        driver = new IOSDriver(new URL(service_url), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
