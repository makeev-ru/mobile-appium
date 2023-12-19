package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class commonActions {

    AppiumDriver driver;

    public commonActions(AppiumDriver driver) {
        this.driver = driver;
    }

      public void waitForElementToAppear(WebElement element){
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
          wait.until(ExpectedConditions.attributeContains((element), "text", "Cart"));
      }
}
