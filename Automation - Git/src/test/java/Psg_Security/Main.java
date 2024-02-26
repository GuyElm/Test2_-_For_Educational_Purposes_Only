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
        String TZ_Number="999491798'";
        pageLoader.welcome_page.TZ_Number.sendKeys(TZ_Number);
        pageLoader.welcome_page.Phone_Number.sendKeys("111111111");
        Pattern pattern = Pattern.compile("[\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]");  //Define the regular expression pattern to match special characters
        Matcher matcher = pattern.matcher(TZ_Number); //Create a Matcher object
        StringBuilder specialCharacters = new StringBuilder(); //Create a StringBuilder to store extracted special characters

        while (matcher.find()){
            specialCharacters.append(matcher.group());
        } //Find and append all special characters to the StringBuilder

        Assert.assertEquals(specialCharacters.length(), 0, "Special Characters In The TZ_Number: " + specialCharacters.toString());
    }
}
