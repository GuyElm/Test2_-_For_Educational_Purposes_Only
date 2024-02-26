package Psg_Security;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    WebDriver driver;
    Welcome_Page welcome_page;
    @BeforeClass
    public void Start_Session() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Automation_29.06\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://danel-db:7676/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        welcome_page = PageFactory.initElements(driver, Welcome_Page.class);
    }

    @Test
    public void Open_Web_Browser() {
        ((JavascriptExecutor) driver).executeScript(
                "window.localStorage.setItem('apiUrl', 'http://danel-db:7575/api/');"
        );
    }

    @Test
    public void Fill_Fields(){
        driver.navigate().refresh();
        String TZ_Number="999491798'";
        welcome_page.TZ_Number.sendKeys(TZ_Number);
        welcome_page.Phone_Number.sendKeys("111111111");
        Pattern pattern = Pattern.compile("[\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]");  //Define the regular expression pattern to match special characters
        Matcher matcher = pattern.matcher(TZ_Number); //Create a Matcher object
        StringBuilder specialCharacters = new StringBuilder(); //Create a StringBuilder to store extracted special characters

        while (matcher.find()){
            specialCharacters.append(matcher.group());
        } //Find and append all special characters to the StringBuilder

        Assert.assertEquals(specialCharacters.length(), 0, "Special Characters In The TZ_Number: " + specialCharacters.toString());
    }
}
