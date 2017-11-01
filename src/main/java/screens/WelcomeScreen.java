package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by olena.kolesnyk on 16/10/2017.
 */
public class WelcomeScreen extends AbstractScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome!']")
    private AndroidElement welcomeTxt;

    @AndroidFindBy(id = "com.mewe:id/ivDismiss")
    private AndroidElement dismissBtn;

    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isWelcomeTextDisplayed() {
        return welcomeTxt.isDisplayed();
    }

    public void closeScreen() {
        dismissBtn.click();
    }
}
