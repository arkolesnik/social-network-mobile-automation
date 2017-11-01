package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by olena.kolesnyk on 14/10/2017.
 */
public class SignUpScreen extends AbstractScreen {

    @AndroidFindBy(id = "com.mewe:id/firstName")
    private AndroidElement fistNameInput;

    @AndroidFindBy(id = "com.mewe:id/lastName")
    private AndroidElement lastNameInput;

    @AndroidFindBy(id = "com.mewe:id/password")
    private AndroidElement passwordInput;

    @AndroidFindBy(id = "com.mewe:id/btnNext")
    private AndroidElement nextBtn;

    @AndroidFindBy(id = "com.mewe:id/etAge")
    private AndroidElement ageInput;

    @AndroidFindBy(id = "com.mewe:id/useEmailPhone")
    private AndroidElement useEmailLink;

    @AndroidFindBy(id = "com.mewe:id/email")
    private AndroidElement emailInput;

    @AndroidFindBy(id = "com.mewe:id/btnVerify")
    private AndroidElement verifyEmailBtn;

    @AndroidFindBy(id = "com.mewe:id/btnGoToEmail")
    private AndroidElement goToEmailBtn;

    public SignUpScreen(AppiumDriver driver) {
        super(driver);
    }

    public void fillInSignUpFields(String email, String password) {
        fistNameInput.setValue(RandomStringUtils.randomAlphabetic(7));
        lastNameInput.setValue(RandomStringUtils.randomAlphabetic(10));
        nextBtn.click();

        passwordInput.setValue(password);
        nextBtn.click();

        Integer age = ThreadLocalRandom.current().nextInt(18, 60);
        ageInput.setValue(age.toString());
        nextBtn.click();

        useEmailLink.click();
        emailInput.setValue(email);
        verifyEmailBtn.click();

        wait.until(ExpectedConditions.visibilityOf(goToEmailBtn));
        goToEmailBtn.click();
    }

}
