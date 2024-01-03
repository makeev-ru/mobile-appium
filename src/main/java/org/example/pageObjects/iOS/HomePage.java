package org.example.pageObjects.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.example.utils.IOSUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends IOSUtils {

    IOSDriver driver;

    public HomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility="Alert Views")
    private WebElement alertViews;

    @iOSXCUITFindBy(accessibility="Web View")
    private WebElement webView;

    @iOSXCUITFindBy(accessibility="Picker View")
    private WebElement pickerView;

    public void openWebView(){
        scrollToElement(webView);
        webView.click();
    }

    public PickerView openPickerView(){
        pickerView.click();
        return new PickerView(driver);
    }

    public AlertViews selectAlertViews(){
        alertViews.click();
        return new AlertViews(driver);
    }
}
