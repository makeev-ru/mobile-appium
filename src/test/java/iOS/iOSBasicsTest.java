package iOS;

import org.example.pageObjects.iOS.AlertViews;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iOSBasicsTest extends iOSConfig {
    @Test
    public void iOSBasicsTest() {
        AlertViews alertViews = homePage.selectAlertViews();

        alertViews.fillTextLabel("Hello");
        String actualMessage = alertViews.getConfirmMessage();
        String expectedText = "A message should be a short, complete sentence.";

        Assert.assertEquals(actualMessage, expectedText);
        alertViews.submitForm();
    }
}
