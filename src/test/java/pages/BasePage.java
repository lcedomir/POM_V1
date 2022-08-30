package pages;

import helpers.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends CommonActions {
    WebDriver driver;

    public BasePage(WebDriver driver)  {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-label='MP - Prijavi se']")
    WebElement prijaviSeMenu;
    @FindBy(css = "[title='Prijavi se']")
    WebElement prijaviSe;

    public void prijaviSe(){


        Actions actions = new Actions(driver);
        actions.moveToElement(prijaviSeMenu)
                .moveToElement(prijaviSe)
                .click()
                .build()
                .perform();
    }
}
