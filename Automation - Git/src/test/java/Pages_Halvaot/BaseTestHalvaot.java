package Pages_Halvaot;

import Halvaot.DealPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;


import java.util.concurrent.TimeUnit;

public class BaseTestHalvaot {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageLoaderHalvaot pageLoaderHalvaot;
    protected DealPage dealPage;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://danel-mazagot:1018/?Ticket=d75312f2-33a9-4c29-aa42-a0cf07c047b2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageLoaderHalvaot = PageFactory.initElements(driver, PageLoaderHalvaot.class);
        pageLoaderHalvaot = new PageLoaderHalvaot(driver);
        dealPage = PageFactory.initElements(driver, DealPage.class);
    }

    /*@Test
    public ResultSet MSSQLConnection()
    {
        String url = "jdbc:sqlserver://danel-mazagot\\S19;databaseName=Danel_HB_022023;integratedSecurity=true";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            return statement.executeQuery("DECLARE @Result NVARCHAR(MAX);\nSELECT @Result = CONCAT(MajorVersion,'.',MinorVersion,'.',SubVersion,'.',BuildNumber) FROM DatabaseVersions where VersionID = (select top(1) VersionID from DatabaseVersions order by VersionID desc)\nselect @Result");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }*/

        @Test
    public void Open_Web_Browser() {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.setItem('apiUrl', 'http://danel-mazagot:1017/api/');");
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
