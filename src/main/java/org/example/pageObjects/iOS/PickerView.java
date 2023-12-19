package org.example.pageObjects.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.example.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PickerView extends IOSActions {

    IOSDriver driver;

    public PickerView(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Red color component value")
    private WebElement leftPicker;

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private WebElement middlePicker;

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private WebElement rightPicker;

    public void setPicker(String pickerPosition_left_middle_right, String value){
        switch (pickerPosition_left_middle_right){
            case "left":
                leftPicker.sendKeys(value);
                break;
            case "middle":
                middlePicker.sendKeys(value);
                break;
            case "right":
                rightPicker.sendKeys(value);
                break;
            default:
                System.out.println("Wrong value");
        }
    }
}
