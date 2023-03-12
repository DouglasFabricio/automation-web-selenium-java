package com.company.base.runners.regressivo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features"
}, tags="@teste and not @wip", glue = {"com.company.base"}, dryRun = false)
public class DefinitionTestSuiteRegressivo {
}

