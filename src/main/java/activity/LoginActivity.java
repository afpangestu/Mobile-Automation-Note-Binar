package activity;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginActivity {
    AppiumDriver driver;

    // contructor
    public LoginActivity(AppiumDriver driver) {
        this.driver = driver;
    }

    // locator
    By registerBtn = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/txt_daftar");
    By loginBtn = By.id("//android.widget.EditText[@text='Password']");
    By usernameEt = By.xpath("//android.widget.EditText[@text='Username']");
    By passwordEt = By.xpath("com.kazakimaru.ch04_ajifauzipangestu:id/btn_login");

    // methods
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    public void setUsername(String username) {
        driver.findElement(usernameEt).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordEt).sendKeys(password);
    }
}
