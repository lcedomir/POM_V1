package tests;


import org.testng.annotations.*;
import pages.*;

import java.io.IOException;

public class SearchTests extends BaseTest {

    @BeforeMethod
    public void setup(){
        init("Chrome",30);
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test
    public void detailedSearch() throws IOException {
        driver.get("https://www.polovniautomobili.com/");

        HomePage homePage = new HomePage(driver);
        homePage.clickDetailedSearchButton();
        reportScreenshots("Test", "Test screenshot");

        DetailedSearchPage detailedSearchPage = new DetailedSearchPage(driver);

        detailedSearchPage.selectBrandByText("Alfa Romeo");
        detailedSearchPage.selectModelByText("Spider");
        detailedSearchPage.checkOption("Multimedija");
        detailedSearchPage.checkOption("ABS");
        detailedSearchPage.enterPriceFrom("1000");

     }
}
