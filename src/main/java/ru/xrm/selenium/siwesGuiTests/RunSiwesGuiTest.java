package ru.xrm.selenium.siwesGuiTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ru/xrm/selenium/SiwesGuiFeatures",
        plugin = { "pretty", "html:target/cucumber-reports"}
)
public class RunSiwesGuiTest {

}
