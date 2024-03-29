package Halvaot;

import BaseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            names.add(parts[0].trim() + " " + parts[1].trim()); // Append both parts to the list
        }
        reader.close();
        return names;
    }

    static String generateFullName(List<String> names) {
        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        return names.get(randomIndex);
    }


    @FindBy(xpath = "//a[@class='btn btn-primary ml-2 p-2 px-4 pull-right font-weight-bold']")
    public static WebElement Create_New_Deal_Button;

    @FindBy(xpath = "//input[@placeholder='שם העסקה']")
    public static WebElement Deal_Name;
    @FindBy(xpath = "//*[@data-fieldid='6352']//input")
    public static WebElement DealRequestDate;

    public static void ClickCreateNewDeal() throws InterruptedException {
        Thread.sleep(9000);
        Create_New_Deal_Button.click();
        Thread.sleep(3000);
    }

    public static String getCurrentDateTimeAsString() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return currentDateTime.format(formatter);
    }

    public static String getCurrentShortDateTimeAsString() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return currentDateTime.format(formatter);
    }
}
