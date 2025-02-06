package pageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;

public class LoginPage {

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name = 'uid']")
    WebElement userIDPath;

    @FindBy(xpath ="//input[@name = 'password']")
    WebElement passwordPath;

    @FindBy(xpath ="//input[@name = 'btnLogin']")
    WebElement loginButtonPath;

    @FindBy(xpath = "//input[@name = 'btnReset']")
    WebElement resetButtonPath;

    @FindBy(xpath = "//marquee[@class='heading3']")
    WebElement welcomeText;


    public void enterValidUserName() throws IOException {
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,userIDPath);
        String userName= CommonUtility.readPropertiesFile("userName");
        userIDPath.sendKeys(userName);
    }
    public void enterValidUserPassword() throws IOException{
        String password = CommonUtility.readPropertiesFile("password");
        passwordPath.sendKeys(password);
    }
    public void clickOnLogin(){
        loginButtonPath.click();

    }
    public void clickOnReset(){

        resetButtonPath.click();
    }
    public void userOnManagersPage() throws IOException {
        //validation by getting text
     String welcomeMessage = welcomeText.getText();
        System.out.println(welcomeText);
        if (welcomeMessage.equals("Welcome to Manager's page of GTPL bank")){
            System.out.println("User successfully logged in");
        }else{
            System.out.println("Login failed");
        }
        //validation using the URL
        String newPageURL = BaseClass.getDriver().getCurrentUrl();
        if(newPageURL.equals("https://demo.guru99.com/V1/html//managerhomepage.php")){
            System.out.println("User successfully logged in ");
        }else {
            System.out.println("Login failed");
        }
        //validation by screenshot
        CommonUtility.screenshot("Manager'shomepage");

        new SoftAssert().assertEquals(welcomeMessage,"Welcome ToManager's page of GTPL bank");
        new SoftAssert().assertEquals(newPageURL,"https://demo.guru99.com/V1/html//managerhomepage.php");
        new SoftAssert().assertAll();
    }

    public void enterUserName(String userName){
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,userIDPath);
        userIDPath.sendKeys(userName);

    }
    public void enterPassword(String password){
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,userIDPath);
        passwordPath.sendKeys(password);
    }

    public void userNotValid(){
        String alertText = BaseClass.getDriver().switchTo().alert().getText();
        if(alertText.equalsIgnoreCase("User is not valid")){
        System.out.println("Invalid Username or Password");
    } else {
            System.out.println("Invalid user can also login. code error");
        }

        BaseClass.getDriver().switchTo().alert().accept();

    }


}


