package Psg_Security;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;



public class Main {

    WebDriver driver;
    Welcome_Page welcome_page;
    @BeforeClass
    public void Start_Session() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Automation_29.06\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://danel-db:5200/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        welcome_page = PageFactory.initElements(driver, Welcome_Page.class);
    }

    @Test
    public void Open_Web_Browser() {
        ((JavascriptExecutor) driver).executeScript(
                "window.localStorage.setItem('apiUrl', 'http://danel-db:5201/api/');"
        );
    }

    @Test
    public void Fill_Fields(){
        driver.navigate().refresh();
        WebElement checkbox = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
        //WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
        welcome_page.TZ_Number.sendKeys("999491798'");
        welcome_page.Phone_Number.sendKeys("111111111");
        //driver.switchTo().frame("recaptcha-accessible-status");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'recaptcha-checkbox')]")));
        //((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('aria-checked', 'true');", welcome_page.Capcha);
    }
}
