package scenarios;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import screens.*;

/**
 * Created by olena.kolesnyk on 14/10/2017.
 */
public class ExampleMobileTest extends AndroidFixture {

    private LandingScreen landingScreen;
    private SignUpScreen signUpScreen;
    private MailScreen mailScreen;
    private WelcomeScreen welcomeScreen;
    private WhatToDoNextScreen whatToDoNextScreen;
    private ProfileScreen profileScreen;

    @BeforeClass
    public void initializePages() {
        landingScreen = new LandingScreen(driver);
        signUpScreen = new SignUpScreen(driver);
        mailScreen = new MailScreen(driver);
        welcomeScreen = new WelcomeScreen(driver);
        whatToDoNextScreen = new WhatToDoNextScreen(driver);
        profileScreen = new ProfileScreen(driver);
    }

    @Test
    @Parameters({"email", "appPassword", "emailPassword"})
    public void signUpSuccess(String email, String password, String emailPassword) {
        landingScreen.clickSignUpButton();
        signUpScreen.fillInSignUpFields(email, password);
        if (!mailScreen.isLoggedInToEmail()) {
            mailScreen.signInToEmail(email, emailPassword);
        }
        mailScreen.confirmEmail();
        Assert.assertTrue(welcomeScreen.isWelcomeTextDisplayed(), "Registration was not properly completed");
        welcomeScreen.closeScreen();
        whatToDoNextScreen.closeScreen();
    }

    @AfterMethod
    @Parameters("appPassword")
    public void deleteAccount(ITestResult result, String appPassword) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            profileScreen.deleteAccountSuccess(appPassword);
        }
    }
}
