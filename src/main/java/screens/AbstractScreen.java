package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by olena.kolesnyk on 14/10/2017.
 */
class AbstractScreen {
    protected AppiumDriver driver;
    WebDriverWait wait;


    public AbstractScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
        wait = new WebDriverWait(driver, 30);
    }

}
