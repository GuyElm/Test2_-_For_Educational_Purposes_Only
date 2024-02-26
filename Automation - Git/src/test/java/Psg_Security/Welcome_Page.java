package Psg_Security;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome_Page {
    @FindBy(xpath = "//div[@data-fieldId='7481']//input")
    WebElement TZ_Number;

    @FindBy(xpath = "//div[@data-fieldId='7483']//input")
    WebElement Phone_Number;

    @FindBy(xpath = "//span[contains(@class, 'recaptcha-checkbox')]//div")
    WebElement Capcha;
}
