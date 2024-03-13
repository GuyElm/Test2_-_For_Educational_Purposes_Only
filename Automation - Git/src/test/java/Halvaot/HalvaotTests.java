package Halvaot;

import Pages_Halvaot.BaseTestHalvaot;
import org.testng.annotations.Test;

public class HalvaotTests extends BaseTestHalvaot {


    @Test
    public void ClickNewDealButton() throws InterruptedException { MainPage.ClickCreateNewDeal(); }
    @Test
    public void Fill_Deal_Name(){
        MainPage.Deal_Name.sendKeys("Something");
    }

}
