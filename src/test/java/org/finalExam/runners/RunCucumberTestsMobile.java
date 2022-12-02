package org.finalExam.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Mobile automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/finalExam/tests/features",
        glue = {"org.finalExam.tests.stepsDefinitions"},
        tags = "@mobileAutomation")
public class RunCucumberTestsMobile extends AbstractTestNGCucumberTests {
}
