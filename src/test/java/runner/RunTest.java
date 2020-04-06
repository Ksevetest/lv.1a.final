package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
//@CucumberOptions(plugin = {"pretty",},
 features = {"/Users/vulros/Documents/FinalProject/src/test/resources/features"},
        glue = {"steps", "hooks"},
        tags = {"@Shoptest"}
)

public class RunTest {

}
