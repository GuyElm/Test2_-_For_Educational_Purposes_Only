package Psg_Security;
import Pages.BasePage;
import Pages.PageLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Welcome_Page extends BasePage {
    @FindBy(xpath = "//div[@data-fieldId='7481']//input")
    public WebElement TZ_Number_Input;

    @FindBy(xpath = "//div[@data-fieldId='7483']//input")
    public WebElement Phone_Number_Input;

    @FindBy(xpath = "//span[contains(@class, 'recaptcha-checkbox')]//div")
    WebElement Capcha;

    static String Wrong_Tz_Number = "999491798'";
    static String Right_Tz_Number = "999491798";
    String Wrong_Phone_Number = "111111111";
    String Right_Phone_Number = "0508103433";
    static String Special_Characters = "[\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]";
    public Welcome_Page(WebDriver driver){
        super(driver);
    }

    static StringBuilder Finding_Special_Characters(PageLoader pageLoader, String Tz_Number) {
        Pattern pattern = Pattern.compile(Special_Characters);  //Define the regular expression pattern to match special characters
        Matcher matcher = pattern.matcher(Tz_Number); //Create a Matcher object
        StringBuilder specialCharacters = new StringBuilder(); //Create a StringBuilder to store extracted special characters

        while (matcher.find()){
            specialCharacters.append(matcher.group());
        } //Find and append all special characters to the StringBuilder
        return specialCharacters;
    }

    public void enterTZNumber(String TZ_Number) {
        TZ_Number_Input.sendKeys(TZ_Number);
    }
    public void enterPhoneNumber(String Phone_Number) {
        Phone_Number_Input.sendKeys(Phone_Number);
    }
}
