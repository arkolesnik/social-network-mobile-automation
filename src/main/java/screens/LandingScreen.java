package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by olena.kolesnyk on 14/10/2017.
 */
public class LandingScreen extends AbstractScreen {

    @AndroidFindBy(id = "com.mewe:id/btnSignUp")
    private AndroidElement signUpBtn;

    public LandingScreen(AppiumDriver driver) {
        super(driver);
    }

    public void clickSignUpButton() {
        signUpBtn.click();
    }

}
