package utilities;

import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseClass {

    private static WebDriver driver;

    public BaseClass()throws IOException { //IO input output

        FileInputStream fis = new FileInputStream("C:\\Users\\ajgom\\IdeaProjects\\" +
                "CucumberBDD\\src\\test\\java\\config\\env.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String myURL = prop.getProperty("url");
        String myBrowser = prop.getProperty("browser");

       // WebDriverManager.chromedriver().setup();
       // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--guest");//Guest mode in a browser allows someone to use
        // a temporary, separate profile to browse the internet without affecting the main user's data1.
        // When you use Guest mode, your browsing activity, cookies, and site data are not saved once you
        // close the guest session1. It's great for letting others use your computer without compromising
        // your personal information.
        //driver = new ChromeDriver(options);

        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);


        /*
        if(myBrowser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            driver = new ChromeDriver(options);
        } else if(myBrowser.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            driver = new EdgeDriver(options);

        } else if(myBrowser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options= new FirefoxOptions();
            options.addArguments("--guest");
            driver = new FirefoxDriver(options);
        } else if(myBrowser.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }


         */

     driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() throws IOException {
        BaseClass obj = new BaseClass();
    }
}