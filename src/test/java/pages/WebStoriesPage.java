package pages;

import base.WebDriverImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebStoriesPage extends WebDriverImpl {


    public WebStoriesPage(){
        PageFactory.initElements(getDriver(), this);

    }

    @FindBy(xpath="//div[@class='letterbox']//*[text()]")
    private List<WebElement> webStoriesList;

    public WebStoriesPage captureWebStoryTexts(){
        //List<WebElement> webStoriesText = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='letterbox']//*[text()]")));
        for (WebElement eachWebStoryText : webStoriesList){
            System.out.println("text on each WebStory :"+eachWebStoryText.getText());
        }
        return this;
    }


    public HomePage switchBackToHome(){
        switchToWindow(getHomeWindow());
        return new HomePage();
    }
}
