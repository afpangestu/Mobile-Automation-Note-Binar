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
    By homeTxt = By.xpath("//android.widget.TextView[@text='Home']");
    By logoutBtn = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/btn_logout");
    By addNoteBtn = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/fab_add");
    By listNote = By.xpath("//androidx.cardview.widget.CardView/android.view.ViewGroup");
    // locator add note
    By tambahCatatanTxt = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/title_dialog");
    By judulEt = By.xpath("//android.widget.EditText[@hint='Judul']");
    By catatanEt = By.xpath("//android.widget.EditText[@hint='Catatan']");
    By simpanBtn = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/btn_add_update");
    By editBtn = By.xpath("(//android.widget.ImageView[@resource-id='com.kazakimaru.ch04_ajifauzipangestu:id/btn_edit'])[1]");
    By deleteBtn = By.xpath("(//android.widget.ImageView[@resource-id='com.kazakimaru.ch04_ajifauzipangestu:id/btn_delete'])[1]");
    // locator edit note
    By editCatatanTxt = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/title_dialog");
    By editJudulEt = By.xpath("//android.widget.EditText[@hint='Judul']");
    By editCatatanEt = By.xpath("//android.widget.EditText[@hint='Catatan']");
    By perbaruiBtn = By.id("com.kazakimaru.ch04_ajifauzipangestu:id/btn_add_update");

    // methods
    public boolean welcomeTxt() {
        return driver.findElement(welcomeTxt).isDisplayed();
    }
}
