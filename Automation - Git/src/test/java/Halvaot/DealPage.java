package Halvaot;

import BaseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DealPage extends BasePage {
    public DealPage(WebDriver driver) throws IOException {
        super(driver);
    }

    static List<String> readNamesFromCSV(String filePath) throws IOException {
        List<String> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            names.add(parts[0].trim());
        }
        reader.close();
        return names;
    }

    static String getRandomName(List<String> names) {
        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        return names.get(randomIndex);
    }


    @FindBy(xpath = "//a[@class='btn btn-primary ml-2 p-2 px-4 pull-right font-weight-bold']")
    public static WebElement Create_New_Deal_Button;

    @FindBy(xpath = "//input[@placeholder='שם העסקה']")
    public static WebElement Deal_Name;

    public static void ClickCreateNewDeal() throws InterruptedException {
        Thread.sleep(9000);
        Create_New_Deal_Button.click();
        Thread.sleep(3000);
    }
}
