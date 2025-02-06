package stepDefinition;

import com.beust.ah.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.interactions.Actions;
import pageObjects.LoginPage;
import pageObjects.NewCustomerPage;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;

public class NewCustomer {

   // object of the class
   NewCustomerPage newCustomerPage;

    @When("user does not enter a value in NAME Field")
    public void user_does_not_enter_a_value_in_name_field() throws InterruptedException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.clickOnCustomerNameField();
       Thread.sleep(2000);

    }

    @When("user press TAB and move to next Field")
    public void user_press_tab_and_move_to_next_field() throws InterruptedException {
        Thread.sleep(2000);
        newCustomerPage.noValueInNameField();

    }

    @Then("An error message Customer name must not be blank must appear")
    public void an_error_message_customer_name_must_not_be_blank_must_appear() throws IOException, InterruptedException {
        newCustomerPage.validateNameIsBlankErrorMessage();
        Thread.sleep(2000);

    }

    @When("user enters numeric {string} in NAME Field")//value
    public void user_enters_numeric_in_name_field(String value)throws IOException, InterruptedException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.nameField(value);
        Thread.sleep(2000);
    }

    @Then("An error message Numbers are not allowed must appear")
    public void an_error_message_numbers_are_not_allowed_must_appear()throws IOException {
        newCustomerPage.validateNumbersErrorMessage();


    }

    @When("user enters special {string} in NAME Field")//characters
    public void user_enters_special_in_name_field(String characters) throws IOException, InterruptedException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.nameField1(characters);
        Thread.sleep(2000);
    }

    @Then("An error message Special characters are not allowed must appear")
    public void an_error_message_special_characters_are_not_allowed_must_appear()throws IOException {

        newCustomerPage.validateSpecialCharactersErrorMessage();
    }

    @When("user enters first character Blank Space in NAME Field")
    public void user_enters_first_character_blank_space_in_name_field() throws InterruptedException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.clickOnCustomerNameField();
        newCustomerPage.nameField2();
        Thread.sleep(2000);
    }

    @Then("An error message First characters cannot be space must appear beside Name field")
    public void an_error_message_first_characters_cannot_be_space_must_appear_beside_name_field() throws IOException, InterruptedException {
        newCustomerPage.validateNameBlankSpaceErrorMessage();
        Thread.sleep(2000);
    }

    @When("user does not enter a value in ADDRESS Field")
    public void user_does_not_enter_a_value_in_address_field()throws InterruptedException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.addressField();
        Thread.sleep(2000);

    }


    @Then("An error message Address can not be empty must appear")
    public void an_error_message_address_can_not_be_empty_must_appear() throws InterruptedException {

        newCustomerPage.noValueInAddressField();
        Thread.sleep(2000);
        newCustomerPage.noValueAddressFieldErrorMessage();
        Thread.sleep(2000);
    }

    @When("user enters first character Blank Space in ADDRESS Field")
    public void user_enters_first_character_blank_space_in_address_field()throws InterruptedException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.addressField();
        newCustomerPage.addressFieldSpace();
        Thread.sleep(2000);

        }

        @Then("An error message First characters cannot be space must appear beside Address field")
    public void an_error_message_first_characters_cannot_be_space_must_appear_beside_address_field()throws InterruptedException{

        newCustomerPage.validateAddressFieldBlankSpaceErrorMessage();
        Thread.sleep(2000);

    }

    @When("user does not enter a value in CITY Field")
    public void user_does_not_enter_a_value_in_city_field()throws InterruptedException{
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.cityField();
        Thread.sleep(2000);
        newCustomerPage.noValueInCityField();
        Thread.sleep(2000);
    }

    @Then("An error message City must not be blank must appear")
    public void an_error_message_city_must_not_be_blank_must_appear() throws InterruptedException, IOException {

        newCustomerPage.noValueCityFieldErrorMessage();
        Thread.sleep(2000);

    }

    @When("user enters numeric {string} in CITY Field")
    public void user_enters_numeric_in_city_field(String value) throws InterruptedException, IOException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.cityFieldValue(value);
        Thread.sleep(2000);
    }

    @Then("An error message Numbers are not allowed must appear beside City field")
    public void an_error_message_numbers_are_not_allowed_must_appear_beside_city_field() throws InterruptedException, IOException {

        newCustomerPage.validateCityNumberErrorMessage();
        Thread.sleep(2000);
    }

    @When("user enters special {string} in CITY Field")
    public void user_enters_special_in_city_field(String characters) throws InterruptedException, IOException {
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.cityFieldCharacter(characters);
        Thread.sleep(2000);
    }

    @Then("An error message Special characters are not allowed must appear for City Field")
    public void an_error_message_special_characters_are_not_allowed_must_appear_for_city_field()throws IOException, InterruptedException{

       newCustomerPage.validateCitySpecialCharactersErrorMessage();
       Thread.sleep(2000);
    }

    @When("user enters first character Blank Space in CITY Field")
    public void user_enters_first_character_blank_space_in_city_field() throws InterruptedException{
        newCustomerPage =new NewCustomerPage(BaseClass.getDriver());
        newCustomerPage.cityField();;
        Thread.sleep(2000);
        newCustomerPage.cityFieldSpace();
        Thread.sleep(2000);

    }

    @Then("An error message First characters cannot be space must appear beside City field")
    public void an_error_message_first_characters_cannot_be_space_must_appear_beside_city_field()throws InterruptedException {

        newCustomerPage.validateCityFieldBlankSpaceErrorMessage();
        Thread.sleep(2000);
    }

}
