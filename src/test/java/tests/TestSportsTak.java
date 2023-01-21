package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class TestSportsTak {
    @Test
    public void testSportsTak() {
        String langToToggle = "Eng";
        //step 1 : Open the website https://thesportstak.com/ & select the language
        //create driver instance
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        //launch url
        driver.get("https://thesportstak.com/");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        try {
            //select language
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@class,'btnLangToggle')]//*[text()='" + langToToggle + "']")))).click();
            System.out.println("langToToggle expected " + langToToggle + " and found .." + langToToggle);
        } catch (WebDriverException e) {
            System.out.println("langToToggle expected " + langToToggle + " but is already toggled!!");
        }
        //Step 2 :Click on each thumbnail and verify that links are not broken on Home-->All.
        //retrive all thumnail links on HomePage
        List<WebElement> thumbNails = driver.findElements(By.xpath("//div[@clicktoplay]"));

        //iterate all thumbnails to verify each of them are not broken!!
        for (WebElement eachThumbNail : thumbNails) {
            eachThumbNail.click();
            String url = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@clicktoplay]//iframe"))).getAttribute("src");
            try {
                HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
                int respCode = 200;
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (MalformedURLException e) {
                System.out.println(" URL is malformed");
            } catch (IOException e) {
                System.out.println("Connection error");
            }

        }

        //Step 3 :Click on "Cricket" and scroll to the 3rd page and click on the links and verify the links are not broken.
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Cricket']")))).click();
        //here scrolling to 3rd page ??? no clarity!!!

        //4. Change the theme from "Light" to "Dark" or vice versa.

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@class,'btnThemeToggle')]")))).click();

        //Step 5 : Click on any Web Stories displayed.

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Home']")))).click();

        List<WebElement> webStories = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='webstorieshome-title']//parent::a"))));
        System.out.println("webStories found :" + webStories.size());
        //clicking on webStory
        wait.until(ExpectedConditions.elementToBeClickable(webStories.get(0))).click();
        //Switch windows to navigate to webStory webpage

        String homeWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String curWindow : windowHandles){
            driver.switchTo().window(curWindow);
        }
        // Step 6 : Capture the text on each Web Stories and each page of webstories.
        List<WebElement> webStoriesText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='letterbox']//*[text()]")));
        for (WebElement eachWebStoryText : webStoriesText){
            System.out.println(eachWebStoryText.getText());
        }


        //Step 7 : Then click on the next webstory and return to the homepage.
        driver.switchTo().window(homeWindow);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Home']")))).click();


        driver.close();





    }


}
