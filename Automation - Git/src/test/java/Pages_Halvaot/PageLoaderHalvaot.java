package Pages_Halvaot;

import Halvaot.DealPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageLoaderHalvaot {
    public DealPage mainPage;

    public PageLoaderHalvaot(WebDriver driver){ mainPage = PageFactory.initElements(driver, DealPage.class); }
}
