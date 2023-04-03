package restassured;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/scenarios",
        glue = {"restassured"},
        tags = "@test",
        publish = true
)
public class TestRunner {


}
