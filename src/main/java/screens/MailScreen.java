package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasicUtils;

import static utils.BasicUtils.ActionType.SCROLL;
import static utils.BasicUtils.ActionType.SWIPE;

/**
 * Created by olena.kolesnyk on 16/10/2017.
 */
public class MailScreen extends AbstractScreen {

    @AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
    private AndroidElement gotItBtn;

    @AndroidFindBy(id = "com.google.android.gm:id/setup_addresses_add_another")
    private AndroidElement addAddress;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Google']")
    private AndroidElement googleAccountTab;

    @AndroidFindBy(id = "identifierId")
    private AndroidElement emailInput;

    @AndroidFindBy(id = "identifierNext")
    private AndroidElement emailNextBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
    private AndroidElement passwordInput;

    @AndroidFindBy(id = "passwordNext")
    private AndroidElement passwordNextBtn;

    @AndroidFindBy(id = "signinconsentNext")
    private AndroidElement iAgreeBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary']")
    private AndroidElement primaryMailBox;

    @AndroidFindBy(id = "com.google.android.gms:id/suw_items_switch")
    private AndroidElement backUpSwitchBtn;

    @AndroidFindBy(id = "com.google.android.gms:id/next_button")
    private AndroidElement agreeBtn;

    @AndroidFindBy(id = "com.google.android.gm:id/account_address")
    private AndroidElement savedEmailTab;

    @AndroidFindBy(id = "com.google.android.gm:id/action_done")
    private AndroidElement takeMeToGmailBtn;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Unread MeWe, Quick! Confirm your email')]/..")
    private AndroidElement unreadMessage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CONFIRM EMAIL!']")
    private AndroidElement confirmEmailBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MeWe']")
    private AndroidElement meWeTab;

    @AndroidFindBy(id = "android:id/button_always")
    private AndroidElement alwaysBtn;

    private By welcomeTitle = By.id("com.google.android.gm:id/welcome_tour_title");
    private By openWithPopup = By.xpath("//android.widget.TextView[@text='Open with']");

    public MailScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoggedInToEmail() {
        return driver.findElements(welcomeTitle).size() == 0;
    }

    public boolean isOpenWithPopupDisplayed() {
        return driver.findElements(openWithPopup).size() != 0;
    }

    public void signInToEmail(String email, String emailPassword) {
        gotItBtn.click();
        addAddress.click();
        googleAccountTab.click();
        emailInput.setValue(email);
        emailNextBtn.click();
        passwordInput.setValue(emailPassword);
        passwordNextBtn.click();
        iAgreeBtn.click();
        backUpSwitchBtn.click();
        agreeBtn.click();
        wait.until(ExpectedConditions.visibilityOf(savedEmailTab));
        takeMeToGmailBtn.click();
    }

    public void confirmEmail() {
        wait.until(ExpectedConditions.visibilityOf(primaryMailBox));
        try {
            wait.until(ExpectedConditions.visibilityOf(unreadMessage));
        } catch (TimeoutException e) {
            BasicUtils.performAction(SWIPE, driver);
            wait.until(ExpectedConditions.visibilityOf(unreadMessage));
        }
        unreadMessage.click();
        wait.until(ExpectedConditions.visibilityOf(confirmEmailBtn));
/*        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                "scrollIntoView(new UiSelector().descriptionStartsWith(\"CONFIRM EMAIL!\").instance(0))"));*/
        BasicUtils.performAction(SCROLL, driver);
        confirmEmailBtn.click();
        if (isOpenWithPopupDisplayed()) {
            meWeTab.click();
            alwaysBtn.click();
        }
    }

}
