package Psg_Security;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome_Page extends BasePage {
    @FindBy(xpath = "//div[@data-fieldId='7481']//input")
    WebElement TZ_Number;

    @FindBy(xpath = "//div[@data-fieldId='7483']//input")
    WebElement Phone_Number;

    @FindBy(xpath = "//span[contains(@class, 'recaptcha-checkbox')]//div")
    WebElement Capcha;

    public Welcome_Page(WebDriver driver){
        super(driver);
    }
}
