package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by olena.kolesnyk on 16/10/2017.
 */
public class WhatToDoNextScreen extends AbstractScreen {

    @AndroidFindBy(id = "com.mewe:id/ivDismiss")
    private AndroidElement dismissBtn;

    public WhatToDoNextScreen(AppiumDriver driver) {
        super(driver);
    }

    public void closeScreen() {
        dismissBtn.click();
    }

}
