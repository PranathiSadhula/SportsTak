package pages;

import base.WebDriverImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HomePage extends WebDriverImpl {
    public String langToToggle;
    @FindBy(xpath = "//*[text()='Home']")
    WebElement homePageWebEle;
    public HomePage(){
        PageFactory.initElements(getDriver(), this);
        click(homePageWebEle);
        this.langToToggle =  prop.getProperty("langToToggle");
    }


  // @FindBy(xpath = "//*[contains(@class,'btnLangToggle')]//*[text()='"+langToToggle+"']")
  @FindBy(xpath = "//*[contains(@class,'btnLangToggle')]//*[text()='Eng']")
   WebElement webEleLangToToggle;

    public void toggleLang(String langToToggle){
        try {
            //select language
            click(webEleLangToToggle);
         //   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@class,'btnLangToggle')]//*[text()='" + langToToggle + "']")))).click();
            System.out.println("langToToggle expected " + langToToggle + " and found .." + langToToggle);
        } catch (WebDriverException e) {
            System.out.println("langToToggle expected " + langToToggle + " but is already toggled!!");
        }

    }

    @FindBy(xpath = "//div[@clicktoplay]")
    List<WebElement> thumbNails;

    public boolean verifyThumbnailLinkNotBroken(){
        for (WebElement eachThumbNail : thumbNails) {
            eachThumbNail.click();

            String url =  getDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@clicktoplay]//iframe"))).getAttribute("src");
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
        return false;
    }

    @FindBy(xpath = "//*[@class='webstorieshome-title']//parent::a")
    List<WebElement> webStories;


    public WebStoriesPage clickFirstWebStory(){
        click(webStories.get(0));
        switchWindows();
        return new WebStoriesPage();
    }

    @FindBy(xpath = "//*[contains(@class,'btnThemeToggle')]")
    WebElement themeWebElt;
    public HomePage toggleTheme(){
        click(themeWebElt);
        return this;
    }

    @FindBy(xpath = "//*[text()='Cricket']")
    WebElement cricketPageWebElt;
    public CricketPage gotToCricketPage(){
        click(cricketPageWebElt);
        return new CricketPage();
    }

}
