package stepdefinitions;

import factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;


import pages.UserPortal;


public class UserPortalSteps {
    UserPortal UserPortal = new UserPortal(DriverFactory.getPage());

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
        UserPortal.navigateToLandingPage(string);
    }
    @Then("verify that {string} landing page appears")
    public void verify_that_landing_page_appears(String string) {
        assertTrue(UserPortal.verifyLandingPageTitle(string));
    }

}
