package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = {"C:\\Users\\ajgom\\IdeaProjects\\
// CucumberBDD\\src\\test\\java\\features\\login.feature"},
@CucumberOptions(features = {"C:\\Users\\ajgom\\IdeaProjects\\" +
        "CucumberBDD\\src\\test\\java\\features\\newCustomer.feature"},
        glue={"stepDefinition"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true, publish = true)

public class Runner {


}
