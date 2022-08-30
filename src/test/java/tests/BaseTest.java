package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    public void init(String browser, int wait) {
        switch (browser) {
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
            break;
            case "Firefox": {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        }
    }

    public void  quit(){
        driver.quit();
    }

    public void takeScreenshot(String name) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/results/screenshots/"+name+".png"));
    }

    public void reportScreenshots(String name, String desc) throws IOException {
        takeScreenshot(name);
        Path content = Paths.get("src/results/screenshots/"+name+".png");
        InputStream is = Files.newInputStream(content);
        Allure.addAttachment(desc,is);
    }
}
