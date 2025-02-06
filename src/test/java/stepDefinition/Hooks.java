package stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;

public class Hooks {
    @Before
   public void driverInitialization(){
       try {
           BaseClass.setDriver();
       } catch (Exception e){
           System.out.println(e);
       }
   }
   @After
   public  void tearDown(){
        BaseClass.getDriver().quit();
   }
}
