package Psg_Security;
import Pages_Psagot.BaseTest;
import Pages_Psagot.PageLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main extends BaseTest {

    @Test
    public void Fill_Opening_Page_Wrongly(){
        PageLoader pageLoader = new PageLoader(driver);
        pageLoader.welcome_page.enterTZNumber(Welcome_Page.Wrong_Tz_Number);
        pageLoader.welcome_page.enterPhoneNumber(pageLoader.welcome_page.Wrong_Phone_Number);
        StringBuilder specialCharacters = Welcome_Page.Finding_Special_Characters(Welcome_Page.Wrong_Tz_Number);
        Assert.assertEquals(specialCharacters.length(), 1, "Special Characters In The TZ_Number: " + specialCharacters.toString());
    }

    @Test
    public void Fill_Opening_Page_The_Right_Way() throws InterruptedException {
        driver.navigate().refresh();
        PageLoader pageLoader = new PageLoader(driver);
        pageLoader.welcome_page.enterTZNumber(Welcome_Page.Right_Tz_Number);
        pageLoader.welcome_page.enterPhoneNumber(pageLoader.welcome_page.Right_Phone_Number);
        StringBuilder specialCharacters = Welcome_Page.Finding_Special_Characters(Welcome_Page.Right_Tz_Number);
        Assert.assertEquals(specialCharacters.length(), 0, "Special Characters In The TZ_Number: " + specialCharacters.toString());
    }



}
