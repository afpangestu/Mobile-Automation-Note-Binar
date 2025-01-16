import activity.LoginActivity;
import activity.RegisterActivity;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class NoteBinarTest {
    private static final Logger log = LoggerFactory.getLogger(NoteBinarTest.class);
    public static AppiumDriver driver;
    public static LoginActivity login;
    public static RegisterActivity register;
    public static UiAutomator2Options options;
    public static String baseUrl = "http://127.0.0.1:4723";

    @BeforeTest
    public  void setup() throws MalformedURLException {
        options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9 Pro")
                .setApp("src/test/java/apk/Note_Binar-debug.apk") // use this if you running appium in Terminal of IDE
                .setPlatformVersion("14")
                .setPlatformName("Android");

        driver = new AppiumDriver(new URL(baseUrl), options);
    }

    @Test(priority = 2)
    public void testLogin() {
        login = new LoginActivity(driver);
        login.setUsername("ajifauzi");
        login.setPassword("ajifauzi123");
        login.clickLogin();
    }

    @Test(priority = 1)
    public void testRegister() {
        login = new LoginActivity(driver);
        register = new RegisterActivity(driver);
        // navigate to register activity
        login.clickRegister();
        // assertion
        Assert.assertTrue(register.registerTitle());

        register.setUsername("ajifauzi");
        register.setEmail("ajifauzi@mail.com");
        register.setPassword("ajifauzi123");
        register.setConfirmPassword("ajifauzi123");
        register.clickRegister();
        // assertion
        Assert.assertTrue(login.loginTitle());
    }

    @AfterTest
    public void endTest() {
       driver.quit();
    }

}
