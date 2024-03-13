package Halvaot;

import Pages_Psagot.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) { super(driver); }
    @FindBy (xpath = "//a[@class='btn btn-primary ml-2 p-2 px-4 pull-right font-weight-bold']")
    public static WebElement Create_New_Deal_Button;

    @FindBy (xpath = "//input[@placeholder='שם העסקה']")
    public static WebElement Deal_Name;
    public static void ClickCreateNewDeal() throws InterruptedException {
        Thread.sleep(9000);
        Create_New_Deal_Button.click();
        Thread.sleep(3000);
    }
}
