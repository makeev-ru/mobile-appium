package android;

import org.example.pageObjects.android.CartPage;
import org.example.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_TC_2 extends androidConfig {

    @Test(dataProvider = "getData")
    public void AddToCart(String name, String gender, String country) throws InterruptedException {

        formPage.setNameField(name);
        formPage.setGender(gender);
        formPage.setCountry(country);
        ProductCatalogue productCatalogue = formPage.pressShopButton();

        CartPage cartPage = productCatalogue.addProductToCart("Jordan 6 Rings");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        String productNameInCart = cartPage.getProductNameInCart();
        Assert.assertEquals(productNameInCart, "Jordan 6 Rings");
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {{"TestName1", "female", "Argentina"}};
    }
}
