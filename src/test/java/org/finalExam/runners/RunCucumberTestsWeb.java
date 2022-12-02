package org.finalExam.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Web automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/finalExam/tests/features",
        glue = {"org.finalExam.tests.stepsDefinitions.web"},
        tags = "@webAutomation")
public class RunCucumberTestsWeb extends AbstractTestNGCucumberTests {

}
