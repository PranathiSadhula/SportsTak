package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import testExecutionEngine.ExecutionEngine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ValidateSportsTakTest  extends ExecutionEngine {
    @BeforeMethod
    public void luanchSportsTakWebPage(){
        ////step 1 : Open the website https://thesportstak.com/
        driverImpl.loadURL("https://thesportstak.com/");
    }



    @Test
    public void testSportsTak() {
        HomePage homePage = new HomePage();
        //step 1:  select the language
        homePage.toggleLang(homePage.langToToggle);

        //Step 2 :Click on each thumbnail and verify that links are not broken on Home-->All.
        //retrive all thumnail links on HomePage
        homePage.verifyThumbnailLinkNotBroken();

        //Step 3 :Click on "Cricket" and scroll to the 3rd page and click on the links and verify the links are not broken.
        homePage.gotToCricketPage();

        //go back to Home to 4. Change the theme from "Light" to "Dark" or vice versa.
        new HomePage()
                .toggleTheme()
                .clickFirstWebStory() //Step 5 : Click on any Web Stories displayed.
                .captureWebStoryTexts()// Step 6 : Capture the text on each Web Stories and each page of webstories.
                .switchBackToHome()   //Step 7 : Then click on the next webstory and return to the homepage.

        ;

    }

}
