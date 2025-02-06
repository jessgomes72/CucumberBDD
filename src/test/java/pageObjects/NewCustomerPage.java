package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;
import java.time.Duration;

public class NewCustomerPage {

    public NewCustomerPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    String errorOnBlankName = "Customer name must not be blank";//expected message
    String errorOnNumericValue = "Numbers are not allowed";
    String errorOnSpecialCharacter = "Special characters are not allowed";
    String errorOnFirstCharacterSpace = "First character can not have space";
    String errorOnAddressFieldBlank = "Address Field must not be blank";
    String errorOnAddressSpace = "First character can not have space";
    String errorOnBlankCityField = "City Field must not be blank";
    String errorOnValueCity = "Numbers are not allowed";
    String errorOnSpecialCharacterCity ="Special characters are not allowed";
    String errorOnSpaceCity ="First character can not have space";

    @FindBy(xpath = "//input[@name = 'uid']")
    WebElement userId;
    @FindBy(xpath ="//input[@name = 'password']")
    WebElement userPassword;
    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement loginButton;
    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    WebElement newCustomerLink;
    @FindBy(xpath="//label[@id='message']")
    WebElement nameErrorText;
    @FindBy(xpath = "//input[@name='name']")
    WebElement newCustomerName;
    @FindBy(xpath = "//label[@id='message']")
    WebElement numbersNotAllowed;
    @FindBy(xpath = "//label[@id='message']")
    WebElement specialCharactersNotAllowed;

    @FindBy(xpath = "//label[@id='message']")
    WebElement firstCharacterCannotBeBlankSpace;

    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement addressField;
    @FindBy(xpath = "//label[@id='message3']")
    WebElement addressFieldBlank;
    @FindBy(xpath = "//label[@id='message3']")
    WebElement addressFirstCharacterSpace;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityField;
    @FindBy(xpath = "//label[@id='message4']")//blank space
    WebElement cityFieldFirstCharacterCannotBeBlankSpace ;
    @FindBy(xpath = "//label[@id='message4']")//value
    WebElement cityFieldValue;
    @FindBy(xpath = "//label[@id='message4']")//character
    WebElement cityFieldCharacter;
    @FindBy(xpath = "//label[@id='message4']")//space
    WebElement citySpaceNotAllowed;

    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//input[@value='Reset']")
    WebElement resetButton;

    public void clickOnNewCustomerModule(){
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),3,newCustomerLink);
        newCustomerLink.click();
    }
    public void clickOnCustomerNameField() {
        newCustomerName.click();
    }


    public void noValueInNameField() {
        new Actions(BaseClass.getDriver()).sendKeys(Keys.TAB).perform();
        // Actions action = new Actions(BaseClass.getDriver());
        //action.sendKeys(keys.TAB).perform();
    }
    public void validateNameIsBlankErrorMessage() throws IOException {

        if(!nameErrorText.isDisplayed()){
            System.out.println("Error text is not displayed");
        }

        String nameErrorStr= nameErrorText.getText();//actual message
        try {
            Assert.assertEquals(nameErrorStr, errorOnBlankName);

        }catch (AssertionError e){
           throw e;
        }
       /* try {
            Assert.assertEquals(nameErrorStr, errorOnBlankName);
            System.out.println("Correct Message: " + nameErrorStr);
        } catch (AssertionError e) {
            System.out.println("Expected Message: " + errorOnBlankName);
            System.out.println("Actual Message: " + nameErrorStr);
            CommonUtility.screenshot("Name_is_blank");
            throw e;
        }

        */

      /*  if (nameErrorStr.equals(errorOnBlankName)) {
            System.out.println("Name is Blank error text is correct");
        } else {
            System.out.println("Wrong error text");
        } */
        //CommonUtility.screenshot("Name_is_Blank");


    }

    public void nameField(String value) throws IOException {
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,newCustomerName);
        newCustomerName.sendKeys(value);

    }
    public void validateNumbersErrorMessage() throws IOException {

        if(!numbersNotAllowed.isDisplayed()){
            System.out.println("Error text is not displayed");
        }

        String valueErrorStr=numbersNotAllowed.getText();
        try {
            Assert.assertEquals(valueErrorStr,errorOnNumericValue);

        }catch (AssertionError e){
            throw e;
        }
       /* if (valueErrorStr.equals(errorOnNumericValue)) {
            System.out.println("Numbers are not allowed, error text is correct");
        } else {
            System.out.println("Wrong error text");
        }
        */
        //CommonUtility.screenshot("Value_is_Numeric");

    }

    public void nameField1(String characters) throws IOException {
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,newCustomerName);
        newCustomerName.sendKeys(characters);
    }
    public void validateSpecialCharactersErrorMessage() throws IOException {

        if(!specialCharactersNotAllowed.isDisplayed()){
            System.out.println("Error text is not displayed");
        }

        String specialCharactersErrorStr=specialCharactersNotAllowed.getText();
        try {
            Assert.assertEquals(specialCharactersErrorStr,errorOnSpecialCharacter);

        }catch (AssertionError e){
            throw e;
        }

      /*  String specialCharactersErrorStr=specialCharactersNotAllowed.getText();
        if (specialCharactersErrorStr.equals(errorOnSpecialCharacter)) {
            System.out.println("Special Characters are not allowed, error text is correct");
        } else {
            System.out.println("Wrong error text");
        }
       */
       // CommonUtility.screenshot("Value_is_special_characters");

    }

    public void nameField2() {
        new Actions(BaseClass.getDriver()).sendKeys(Keys.SPACE).perform();

    }
    public void validateNameBlankSpaceErrorMessage() throws IOException {
        if (!firstCharacterCannotBeBlankSpace.isDisplayed()) {
            System.out.println("First character cannot be blank space");
        }
        String blankSpaceErrorStr = firstCharacterCannotBeBlankSpace.getText();
        try {
            Assert.assertEquals(blankSpaceErrorStr,errorOnFirstCharacterSpace);

        }catch (AssertionError e){
            throw e;
        }
        /*
        if (blankSpaceErrorStr.equals(errorOnFirstCharacterSpace )){
            System.out.println("Name cannot have first characters as blank space");

        } else {
            System.out.println("Wrong error text");
        }
        */
       // CommonUtility.screenshot("First_characters_cannot_be_blank_space");
    }

    public void addressField() {
       // CommonUtility.elementToBeClickable(BaseClass.getDriver(), 2, addressField);
        addressField.click();
    }
    public void noValueInAddressField() {
        new Actions(BaseClass.getDriver()).sendKeys(Keys.TAB).perform();
        //System.out.println("No error message");
    }
    public void noValueAddressFieldErrorMessage(){
        if(!addressFieldBlank.isDisplayed()){
            System.out.println("Error text is not displayed");
        }

        String addressErrorStr = addressFieldBlank.getText();//actual message
        try {
            Assert.assertEquals(addressErrorStr,errorOnAddressFieldBlank);

        }catch (AssertionError e){
            throw e;
        }
    }
    public void addressFieldSpace() {
        new Actions(BaseClass.getDriver()).sendKeys(Keys.SPACE).perform();
        //System.out.println("No error message");
    }
    public void validateAddressFieldBlankSpaceErrorMessage(){
            if (!addressFirstCharacterSpace.isDisplayed()) {
                System.out.println("First character cannot be blank space");
            }
            String addressBlankSpaceErrorStr = addressFirstCharacterSpace.getText();
            try {
                Assert.assertEquals(addressBlankSpaceErrorStr,errorOnAddressSpace);

            }catch (AssertionError e){
                throw e;
            }
    }

        public void cityField() {
       // CommonUtility.elementToBeClickable(BaseClass.getDriver(), 2, cityField);
        cityField.click();
    }
    public void noValueInCityField() {
        new Actions(BaseClass.getDriver()).sendKeys(Keys.TAB).perform();
    }

    public void noValueCityFieldErrorMessage(){
        if (!cityFieldFirstCharacterCannotBeBlankSpace.isDisplayed()) {
            System.out.println("City Field must be not blank");
        }
        String errorOnBlankCityStr = cityFieldFirstCharacterCannotBeBlankSpace.getText();
        try {
            Assert.assertEquals(errorOnBlankCityStr, errorOnBlankCityField);

        }catch (AssertionError e){
            throw e;
        }
       /* if (errorOnBlankCityStr.equals(errorOnBlankCityField)) {
            System.out.println("error message, City can not be empty must appear");
        } else {
            System.out.println("Wrong error text");
        }*/
        // CommonUtility.screenshot("CityFirst_characters_cannot_be_blank_space");
    }

    public void cityFieldValue(String value) throws IOException {
        CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,cityField);
       cityField.sendKeys(value);
    }
    public void validateCityNumberErrorMessage() throws IOException {

        if(!cityFieldValue.isDisplayed()){
            System.out.println("Numbers are not allowed");
        }

        String cityFieldValueErrorStr = cityFieldValue.getText();
        try {
            Assert.assertEquals(cityFieldValueErrorStr,errorOnValueCity);

        }catch (AssertionError e){
            throw e;

        }
       /* if (cityFieldValueErrorStr.equals(errorOnValueCity)) {
            System.out.println("Numbers are not allowed, error text is correct");
        } else {
            System.out.println("Wrong error text");
        }*/
        //CommonUtility.screenshot("Value_is_Numeric");

    }
    public void cityFieldCharacter(String characters) throws IOException {
        //CommonUtility.elementToBeClickable(BaseClass.getDriver(),2,cityField);
        cityField.sendKeys(characters);
    }
    public void validateCitySpecialCharactersErrorMessage() throws IOException {

        if(!cityFieldCharacter.isDisplayed()){
            System.out.println("Special characters are not allowed");
        }

        String citySpecialCharactersErrorStr=cityFieldCharacter.getText();
        try {
            Assert.assertEquals(citySpecialCharactersErrorStr, errorOnSpecialCharacterCity);

        }catch (AssertionError e){
            throw e;
        }
      /*  if (citySpecialCharactersErrorStr.equals(errorOnSpecialCharacterCity)) {
            System.out.println("Special Characters are not allowed, error text is correct");
        } else {
            System.out.println("Wrong error text");
        }*/
        // CommonUtility.screenshot("CityField_Special_Character_NotAllowed");

    }
    public void cityFieldSpace() {
        new Actions(BaseClass.getDriver()).sendKeys(Keys.SPACE).perform();
    }
    public void validateCityFieldBlankSpaceErrorMessage(){
        if(!citySpaceNotAllowed.isDisplayed()){
            System.out.println("First characters cannot be space");
        }
        String citySpaceErrorStr = citySpaceNotAllowed.getText();
        try {
            Assert.assertEquals(citySpaceErrorStr, errorOnSpaceCity);

        }catch (AssertionError e){
            throw e;
        }
       /* if (citySpaceErrorStr.equals(errorOnSpaceCity)) {
            System.out.println("First characters cannot be space must appear beside City field");
        } else {
            System.out.println("Wrong error text");
        }*/

       // CommonUtility.screenshot("CityField_Space_is_NotAllowed");
    }
}