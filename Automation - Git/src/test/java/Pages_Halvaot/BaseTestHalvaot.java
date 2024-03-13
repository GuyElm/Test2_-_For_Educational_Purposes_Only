package Pages_Halvaot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTestHalvaot {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageLoaderHalvaot pageLoaderHalvaot;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://danel-mazagot:1018/?Ticket=ffbd2705-1f86-418d-bc3b-881618229729");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageLoaderHalvaot = PageFactory.initElements(driver,PageLoaderHalvaot.class);
        pageLoaderHalvaot =new PageLoaderHalvaot(driver);
    }

    @Test
    public void Open_Web_Browser() {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.setItem('apiUrl', 'http://danel-mazagot:1017/api/');" ); }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
