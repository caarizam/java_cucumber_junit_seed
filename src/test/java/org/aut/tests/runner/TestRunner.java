package org.aut.tests.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-json-report.json", "html:target/cucumber-html" },
        features = {"src/test/resources/features/" },
        glue = { "classpath:org.aut.steps" },
        tags = { "@e2e" })
public class TestRunner {
}
