package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReport;

public class CucumberHooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        if (!ExtentReport.isReportInitialized()) {
            ExtentReport.initReports();
        }
        ExtentReport.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReport.logTestStep("Scenario failed: " + scenario.getName(), "fail");
        } else {
            ExtentReport.logTestStep("Scenario passed: " + scenario.getName(), "pass");
        }
    }

    @After
    public void afterAllScenarios() {
        ExtentReport.flushReports();
    }
}
