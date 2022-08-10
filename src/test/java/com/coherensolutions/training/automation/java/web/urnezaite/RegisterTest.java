package com.coherensolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends BaseTest {

    @Test
    @Description("Verify the ability to create an account")
    public void testRegistration() {

        LogInPage logInPage = new LogInPage(driver);
        logInPage.load(LOGIN_PAGE_LINK);
        RegistrationPage registrationPage = logInPage.createAccount(USERNAME);
        MyAccountPage myAccountPage = registrationPage.register();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(USERNAME.equalsIgnoreCase(myAccountPage.getDisplayedAccountName()), "account name is not correct");
        softAssert.assertTrue(myAccountPage.isTitleCorrect(), "title is not correct");
        softAssert.assertTrue(myAccountPage.isCartButtonDisplayed(), "cart button is not displayed");
        softAssert.assertTrue(myAccountPage.isWishListButtonDisplayed(), "wishlist button is not displayed");
        softAssert.assertAll();
    }
}