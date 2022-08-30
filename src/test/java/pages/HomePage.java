package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.VodicComponent;

public class HomePage extends BasePage{

    WebDriver driver;
    public VodicComponent vodicComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        vodicComponent = new VodicComponent(driver);
    }

   //public WebElement el = driver.findElement(By.cssSelector("[name='isDetailed']"));

    @FindBy(css = "[name='isDetailed']")
    WebElement detailedSearchButton;

    public void clickDetailedSearchButton(){
        clickElement(detailedSearchButton,"Detailed search button");
    }









}
