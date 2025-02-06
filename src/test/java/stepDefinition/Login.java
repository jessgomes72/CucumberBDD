package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.BaseClass;

import java.io.IOException;

public class Login {

  /*  @Given("user should be on demo Guru site")
    public void user_should_be_on_demo_guru_site() {
  } */
    LoginPage loginPage;

    @When("user enters valid userName")
    public void user_enters_valid_user_name() throws IOException {
    loginPage =new LoginPage(BaseClass.getDriver());
    loginPage.enterValidUserName();
    }

    @When("user enters valid password")
    public void user_enters_valid_password()throws IOException {

      loginPage.enterValidUserPassword();

    }

    @When("user click on login button")
    public void user_click_on_login_button()throws IOException {

      loginPage.clickOnLogin();

    }

    @Then("user successfully logged in")
    public void user_successfully_logged_in() throws IOException {

      loginPage.userOnManagersPage();

    }

    @When("user enters {string}")
    public void user_enters(String userName) {
      loginPage = new LoginPage(BaseClass.getDriver());
      loginPage.enterUserName(userName);

    }

    @When("user enter {string}")
    public void user_enter(String password) {

      loginPage.enterPassword(password);

    }

    @Then("user fails to log in")
    public void user_fails_to_log_in() {
      loginPage.userNotValid();

    }
}