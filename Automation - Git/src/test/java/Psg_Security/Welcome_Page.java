package Psg_Security;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome_Page extends BasePage {
    @FindBy(xpath = "//div[@data-fieldId='7481']//input")
    public WebElement TZ_Number_Input;

    @FindBy(xpath = "//div[@data-fieldId='7483']//input")
    public WebElement Phone_Number_Input;

    @FindBy(xpath = "//span[contains(@class, 'recaptcha-checkbox')]//div")
    WebElement Capcha;

    String Wrong_Tz_Number = "999491798'";
    String Wrong_Phone_Number = "111111111";
    String Special_Characters = "[\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]";
    public Welcome_Page(WebDriver driver){
        super(driver);
    }
    public void enterTZNumber(String TZ_Number) {
        TZ_Number_Input.sendKeys(TZ_Number);
    }
    public void enterPhoneNumber(String Phone_Number) {
        Phone_Number_Input.sendKeys(Phone_Number);
    }
}
