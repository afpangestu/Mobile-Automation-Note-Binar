import activity.HomeActivity;
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
    public static HomeActivity home;
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
    public void testLogin() throws InterruptedException {
        home = new HomeActivity(driver);
        login = new LoginActivity(driver);
        login.setUsername("ajifauzi");
        login.setPassword("ajifauzi123");
        login.clickLogin();
        Thread.sleep(2000);
        // assertion
        Assert.assertTrue(home.welcomeTxt());
        Assert.assertTrue(home.homeTxt());
        System.out.println("== TEST LOGIN SUCCESS ==");
    }

    @Test(priority = 1)
    public void testRegister() throws InterruptedException {
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
        Thread.sleep(2000);
        Assert.assertTrue(login.loginTitle());
        System.out.println("== TEST REGISTER SUCCESS ==");
    }

    @Test(priority = 3)
    public void testAddNote() throws InterruptedException {
        home = new HomeActivity(driver);
        // open dialog
        home.clickAddNote();
        Thread.sleep(1000);
        // assert the dialog
        Assert.assertTrue(home.tambahCatatanTxtDisplayed());
        // fill the EditText
        home.setJudulEt("this is title note");
        home.setCatatanEt("this is content of note");
        home.clickSimpan();
        Thread.sleep(1000);
        // assert list note after adding
        Assert.assertTrue(home.listNoteDisplayed());
        System.out.println("== TEST ADD NOTE SUCCESS ==");
    }

    @Test(priority = 4)
    public void testEditNote() throws InterruptedException {
        home = new HomeActivity(driver);
        home.clickEdit(); // edit on the first item
        Thread.sleep(1000);
        // assert the edit dialog
        Assert.assertTrue(home.editCatatanTxtDisplayed());
        // fill the EditText
        home.setJudulEt("this is after edit");
        home.setCatatanEt("this is after edit");
        home.clickPerbarui();
        Thread.sleep(1000);
        // assert list note after edit
        Assert.assertTrue(home.listNoteDisplayed());
        System.out.println("== TEST EDIT NOTE SUCCESS ==");
    }

    @Test(priority = 5)
    public void testDeleteNote() throws InterruptedException {
        home = new HomeActivity(driver);
        home.clickDelete(); // delete on the first item
        Thread.sleep(1000);
        // assert the delete dialog
        Assert.assertTrue(home.deleteAlertDisplayed());
        // click cancel
        home.clickDeleteCancelBtn();
        Thread.sleep(1000);
        home.clickDelete();
        Thread.sleep(1000);
        // assert again the delete dialog
        Assert.assertTrue(home.deleteAlertDisplayed());
        home.clickDeleteYesBtn();
        // assert note is empty after deleting
//        Assert.assertFalse(home.listNoteDisplayed());
        System.out.println("== TEST DELETE NOTE SUCCESS ==");
    }

    @Test(priority = 6)
    public void testLogout() throws InterruptedException {
        login = new LoginActivity(driver);
        home = new HomeActivity(driver);
        home.clickLogout();
        Thread.sleep(1000);
        // assert after press logout
        Assert.assertTrue(login.loginTitle());
        System.out.println("== TEST LOGOUT SUCCESS ==");
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}
