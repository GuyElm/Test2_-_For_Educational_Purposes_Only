package Psg_Security;
import Pages.BaseTest;
import Pages.PageLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends BaseTest {

    @Test
    public void Fill_Fields(){
        PageLoader pageLoader = new PageLoader(driver);
        pageLoader.welcome_page.enterTZNumber(pageLoader.welcome_page.Wrong_Tz_Number);
        pageLoader.welcome_page.enterPhoneNumber(pageLoader.welcome_page.Wrong_Phone_Number);
        Pattern pattern = Pattern.compile(pageLoader.welcome_page.Special_Characters);  //Define the regular expression pattern to match special characters
        Matcher matcher = pattern.matcher(pageLoader.welcome_page.Wrong_Tz_Number); //Create a Matcher object
        StringBuilder specialCharacters = new StringBuilder(); //Create a StringBuilder to store extracted special characters

        while (matcher.find()){
            specialCharacters.append(matcher.group());
        } //Find and append all special characters to the StringBuilder

        Assert.assertEquals(specialCharacters.length(), 1, "Special Characters In The TZ_Number: " + specialCharacters.toString());
    }
}
