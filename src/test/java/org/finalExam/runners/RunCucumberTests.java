package org.finalExam.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/finalExam/tests/features",
        glue = {"org.finalExam.tests.stepsDefinitions"})
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
