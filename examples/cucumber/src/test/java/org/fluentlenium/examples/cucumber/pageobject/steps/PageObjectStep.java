package org.fluentlenium.examples.cucumber.pageobject.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.examples.cucumber.PropertiesReader;
import org.fluentlenium.examples.cucumber.pageobject.page.HomePage;
import org.junit.BeforeClass;

import static org.assertj.core.api.Assertions.assertThat;

@FluentConfiguration(webDriver = "chrome")
public class PageObjectStep extends FluentCucumberTest {

    @Page
    private HomePage page;

    public PageObjectStep(){
        System.setProperty("webdriver.chrome.driver", new PropertiesReader().readProperty("webdriver.path"));
    }

    @Given(value = "Visit duckduckgo search page")
    public void step1() {
        goTo(page);
    }

    @When(value = "I search FluentLenium term")
    public void step2() {
        page.find("FluentLenium");
    }

    @Then(value = "Title contains FluentLenium term")
    public void step3() {
        assertThat(page.window().title()).contains("FluentLenium");
    }


    @Before
    public void beforeScenario(Scenario scenario) {
        this.before(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
        this.after(scenario);
    }
}
