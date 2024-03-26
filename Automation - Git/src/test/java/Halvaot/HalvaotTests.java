package Halvaot;


import Pages_Halvaot.BaseTestHalvaot;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HalvaotTests extends BaseTestHalvaot {


    List<String> names = (List<String>) DealPage.readNamesFromCSV("\\\\win2019ex\\share\\Winword\\פריוריטי\\Guy Elmakias - QA\\Automation_Proj\\Halvaot\\NameList.csv");
    String randomName = DealPage.generateFullName(names);
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    public static String getCurrentDateTimeAsString() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return currentDateTime.format(formatter);
    }

    String currentDateTime = getCurrentDateTimeAsString();
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

}
