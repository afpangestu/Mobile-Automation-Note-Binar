import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class NoteBinarTest {
    public static DesiredCapabilities capabilities;
    public static AppiumDriver driver;
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

    @Test
    public void testLogin() {
        driver.findElement(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys("ajifauzi");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("ajifauzi123");
        driver.findElement(By.id("com.kazakimaru.ch04_ajifauzipangestu:id/btn_login")).click();
    }

    public void testRegister() {

    }

    @AfterTest
    public void endTest() {
       driver.quit();
    }

}
