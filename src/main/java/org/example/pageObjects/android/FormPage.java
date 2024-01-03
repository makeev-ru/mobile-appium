package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.AndroidUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidUtils {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;


    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }

    public void setCountry(String country) {
        countryList.click();
        scrollToText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']")).click();

    }

    public ProductCatalogue pressShopButton() {
        shopButton.click();
        return new ProductCatalogue(driver);
    }
}
