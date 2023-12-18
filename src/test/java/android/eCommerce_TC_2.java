package android;

import org.example.pageObjects.android.CartPage;
import org.example.pageObjects.android.FormPage;
import org.example.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_TC_2 extends androidConfig {

    @Test
    public void AddToCart() throws InterruptedException {

        FormPage formPage = new FormPage(driver);
        formPage.setNameField("TestName");
        formPage.setGender("female");
        formPage.setCountry("Belarus");
        ProductCatalogue productCatalogue = formPage.pressShopButton();

        CartPage cartPage = productCatalogue.addProductToCart("Jordan 6 Rings");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        String productNameInCart = cartPage.getProductNameInCart();
        Assert.assertEquals(productNameInCart, "Jordan 6 Rings");
    }
}
