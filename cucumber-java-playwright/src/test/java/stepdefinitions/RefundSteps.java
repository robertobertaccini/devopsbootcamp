package stepdefinitions;

import static org.junit.Assert.assertEquals;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.RefundCaseType;
import pages.UserPortal;

public class RefundSteps {
	LoginPage loginPage = new LoginPage(DriverFactory.getPage());
	UserPortal UserPortal = new UserPortal(DriverFactory.getPage());
	RefundCaseType refundCT = new RefundCaseType(DriverFactory.getPage());
    
    @Given("I login as user")
    public void i_login_as_user() {
		loginPage.navigateToUrl("TargetURL");
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
    }
    @When("I create a new refund request")
    public void i_create_a_new_refund_request() {
    	UserPortal.createCase("BookingCancellationDemo");
    }
    @When("I select PNR {string}")
    public void i_select_pnr(String string) {
        refundCT.collectBookingID(string);
    }
    @Then("The loyalty is {string}")
    public void the_loyalty_is(String string) {
    }
    @When("i provide refunder email {string}")
    public void i_provide_refunder_email(String string) {
    	refundCT.checkBooking(string);
    }
    @Then("the case is sent for approval")
    public void the_case_is_sent_for_approval() {
    	assertEquals("Pending-Approval",refundCT.getCaseStatus());
    }

}
