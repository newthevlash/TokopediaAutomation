package Cucumber.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Cucumber",glue="Cucumber.StepDefinitions")
public class TestRunner {

}
