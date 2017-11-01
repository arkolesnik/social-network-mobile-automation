package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Created by olena.kolesnyk on 17/10/2017.
 */
public class BasicUtils {

    private static final double SWIPE_START_POINT = 0.50;
    private static final double SWIPE_END_POINT = 0.80;
    private static final double SWIPE_ANCHOR = 0.50;
    private static final double SCROLL_START_POINT = 0.90;
    private static final double SCROLL_END_POINT = 0.10;
    private static final double SCROLL_ANCHOR = 0.10;

    public enum ActionType {
        SWIPE,
        SCROLL
    }

    public static void performAction(ActionType type, AppiumDriver driver) {
        Dimension size = getWindowSize(driver);
        int startPoint = 0;
        int endPoint = 0;
        int anchor = 0;
        switch (type) {
            case SWIPE:
                startPoint = (int) (size.height * SWIPE_START_POINT);
                endPoint = (int) (size.height * SWIPE_END_POINT);
                anchor = (int) (size.width * SWIPE_ANCHOR);
                break;
            case SCROLL:
                startPoint = (int) (size.height * SCROLL_START_POINT);
                endPoint = (int) (size.height * SCROLL_END_POINT);
                anchor = (int) (size.width * SCROLL_ANCHOR);
                break;
        }
        Duration duration = Duration.of(1, SECONDS);
        new TouchAction(driver)
                .press(anchor, startPoint)
                .waitAction(duration)
                .moveTo(anchor, endPoint)
                .release()
                .perform();
    }

    private static Dimension getWindowSize(AppiumDriver driver) {
        return driver.manage().window().getSize();
    }

}
