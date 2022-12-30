package GuiTests;

import GuiPages.RegisterUserPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GuiTests.LoginUserTest.LoginUserTestData;

public class VerifySubscriptionTest {
    SHAFT.GUI.WebDriver driver ;
    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }


    @Test(description = "Verify Subscription in home page")
    public void Verify_Subscription_in_home_page(){
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .Enter_email_address_in_input(LoginUserTestData.getTestData("EmailAddress"));


        driver.verifyThat()
                .element(RegisterUserPage.success_subscribe_Message())
                .text()
                .contains("You have been successfully subscribed!")
                .withCustomReportMessage("Verify success message 'You have been successfully subscribed!' contains You have been successfully subscribed! ")
                .perform();

        driver.verifyThat()
                .element(RegisterUserPage.success_subscribe_Message())
                .isVisible()
                .withCustomReportMessage("Verify success message 'You have been successfully subscribed!' is visible")
                .perform();


    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
