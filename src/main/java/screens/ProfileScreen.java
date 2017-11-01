package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by olena.kolesnyk on 16/10/2017.
 */
public class ProfileScreen extends AbstractScreen {

    @AndroidFindBy(xpath = "//android.support.v7.app.ActionBar.Tab[@index='4']")
    private AndroidElement profileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    private AndroidElement myAccountTab;

    @AndroidFindBy(id = "com.mewe:id/deleteMyAccount")
    private AndroidElement deleteMyAccountMenu;

    @AndroidFindBy(id = "com.mewe:id/password")
    private AndroidElement passwordToDeleteInput;

    @AndroidFindBy(id = "com.mewe:id/delete")
    private AndroidElement confirmDeleteBtn;

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    public void deleteAccountSuccess(String password) {
        profileIcon.click();
        myAccountTab.click();
        deleteMyAccountMenu.click();
        passwordToDeleteInput.setValue(password);
        confirmDeleteBtn.click();
    }

}
