package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.LoginPage;
import pageObjects.NewCustomerPage;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;

public class BackgroundSteps {
    LoginPage loginPage;
    NewCustomerPage newCustomerPage;
    @Given("user should be on demo Guru site")
    public void user_should_be_on_demo_guru_site() throws IOException {
       String myUrl = CommonUtility.readPropertiesFile("url");
       BaseClass.getDriver().get(myUrl);

       // BaseClass.getDriver().get("https://demo.guru99.com/V1/");

    }

    @Given("user log in with valid username and password")
    public void user_log_in_with_valid_username_and_password() throws IOException, InterruptedException {
        loginPage = new LoginPage(BaseClass.getDriver());
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.clickOnLogin();
        Thread.sleep(1000);
        newCustomerPage.clickOnNewCustomerModule();
        Thread.sleep(2000);




    }


}
