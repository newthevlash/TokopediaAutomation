package Cucumber.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Tokopedia",glue="Tokopedia.cucumber_StepDefinitions")
public class TestRunner {

}
