package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DetailedSearchPage extends BasePage {
    WebDriver driver;

    public DetailedSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='SumoSelect sumo_brand']//span[text()=' Marka']")
    WebElement brand;

    @FindBy(xpath = "//div[@class='SumoSelect sumo_model']//span[text()=' Svi modeli']")
    WebElement model;
    @FindBy(css = "[name='price_from']")
    WebElement  priceFrom;



    public void selectBrandByText(String text){
        clickElement(brand,"Brand is selected");
        clickElement(driver.findElement(By.xpath("//div[@class='SumoSelect sumo_brand open']//li/label[text()='"+text+"']")), "Brand: "+text);
    }
    public void selectModelByText(String text){
        clickElement(model, "Model");
        clickElement(driver.findElement(By.xpath("//div[@class='SumoSelect sumo_model open']//li//label[contains(text(),'"+text+"')]")), "Model "+text);
    }

    public void checkOption(String text){
        clickElement(driver.findElement(By.xpath("//label[text()='"+text+"']")),"Cekirano"+text);
    }

    public void enterPriceFrom(String price){
        typeText(priceFrom, price, "Price from" );
    }
 }

 ////div[@class='SumoSelect sumo_model open']//li//label[contains(text(),'"+text+"')]