package activity;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeActivity {
    AppiumDriver driver;

    // contructor
    public HomeActivity(AppiumDriver driver) {
        this.driver = driver;
    }

    // locator
    By welcomeTxt = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/txt_welcome_user");

    // methods
    public boolean welcomeTxt() {
        return driver.findElement(welcomeTxt).isDisplayed();
    }
}
