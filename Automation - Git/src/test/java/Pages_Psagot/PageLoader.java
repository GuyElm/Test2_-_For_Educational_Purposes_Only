package Pages_Psagot;

import Psg_Security.Welcome_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageLoader {

    public Welcome_Page welcome_page;

    public PageLoader(WebDriver driver){
        welcome_page = PageFactory.initElements(driver, Welcome_Page.class);
    }
}
