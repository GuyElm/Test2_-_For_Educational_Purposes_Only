package Pages_Halvaot;

import Halvaot.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageLoaderHalvaot {
    public MainPage mainPage;

    public PageLoaderHalvaot(WebDriver driver){ mainPage = PageFactory.initElements(driver, MainPage.class); }
}
