package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of feature file
        features = "src/test/resources/SportsTak.feature",
        //path of step definition file
        glue = "src/test/java/steps/StepDefinations"
)
public class TestRunner {


}
