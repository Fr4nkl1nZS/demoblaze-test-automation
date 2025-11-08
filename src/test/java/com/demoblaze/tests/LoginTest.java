package com.demoblaze.tests;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.utils.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfullLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        //Execute login
        loginPage.login("admin", "admin");

        //Add a little wait for loading
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Verified that log in is success
        assertTrue(loginPage.isLogginSuccessfull(),
                "Log in should be successful with valid credentials");
    }

    @Test
    public void testFailedLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        //Execute log in with invalid credentials
        assertFalse(loginPage.isLogginSuccessfull(),
                "Login should fail with invalid credentials");
    }
}
