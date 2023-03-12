package com.company.base;

import com.company.base.pages.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;
import java.util.Map;

public class Hooks extends BasePage {

    @Before
    public void beforeScenarioAllTests() {
        getDriver().manage().deleteAllCookies();
    }


    @After
    public void afterScenarioAllTests() {
        getDriver().close();
    }

}
