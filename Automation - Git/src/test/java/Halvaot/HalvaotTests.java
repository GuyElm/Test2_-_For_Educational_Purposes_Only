package Halvaot;


import Pages_Halvaot.BaseTestHalvaot;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HalvaotTests extends BaseTestHalvaot {


    List<String> names = (List<String>) DealPage.readNamesFromCSV("\\\\win2019ex\\share\\Winword\\פריוריטי\\Guy Elmakias - QA\\Automation_Proj\\Halvaot\\NameList.csv");
    String randomName = DealPage.generateFullName(names);
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    String currentDateTime = DealPage.getCurrentDateTimeAsString();
    String currentShortDateTime = DealPage.getCurrentShortDateTimeAsString();
     public HalvaotTests() throws IOException {
    }

    @Test
    public void ClickNewDealButton() throws InterruptedException {
        DealPage.ClickCreateNewDeal();
    }
    @Test
    public void Fill_Deal_Name() {
        DealPage.Deal_Name.sendKeys(randomName + " - " +  currentDateTime/*+ MSSQLConnection()*/);
    }

    @Test
    public void Fill_Request_Deal_Date(){
         DealPage.DealRequestDate.sendKeys(currentShortDateTime);
    }

}
