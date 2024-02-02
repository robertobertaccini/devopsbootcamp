package cbt.cucumber;

import io.cucumber.java.*;
import io.cucumber.java.en.*;


import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class Refund {

    private WebDriver driver;
    private String TargetURL;
    private String SeleniumGridURL;
    private String Browser;
    private String username;
    private String password;

    @Before
    public void setUp() throws Throwable {
        
    	TargetURL = System.getProperty("TargetURL");    
        SeleniumGridURL = System.getProperty("SeleniumGridURL");  
        Browser = System.getProperty("browser");
        username = System.getProperty("username");
        password = System.getProperty("password");
        
        System.out.println("TargetURL ="+TargetURL);
        System.out.println("SeleniumGridURL ="+SeleniumGridURL);
        System.out.println("Browser ="+Browser);
        System.out.println("Username ="+username);
        System.out.println("Password ="+password);        
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        
    	DesiredCapabilities dc = new DesiredCapabilities();
    	dc.setBrowserName(Browser);
    	dc.setPlatform(Platform.WIN11);
    	dc.setCapability(ChromeOptions.CAPABILITY, opt);
    	
        driver = new RemoteWebDriver(new URL(SeleniumGridURL), dc);

    }
    
    @Given("I login as user")
    public void i_login_as_user() {
    	
	 	 driver.get(TargetURL);
	 	 
	 	 if(TargetURL.contains("10.60.213.235")) {
		 	 driver.findElement(By.id("details-button")).click();
		 	 driver.findElement(By.id("proceed-link")).click();
	 	 }
	 	 
   	  	 driver.findElement(By.id("txtUserID")).sendKeys(username); // USERNAME
	 	 driver.findElement(By.id("txtPassword")).sendKeys(password); // PASSWORD
	 	 driver.findElement(By.id("sub")).click(); // LOGIN

    	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    @Given("I login with {string} and {string}")
    public void i_login_with_and(String string, String string2) {
    	
	 	 driver.get(TargetURL);
	 	 
	 	 // Skip 
	 	 driver.findElement(By.id("details-button")).click();
	 	 driver.findElement(By.id("proceed-link")).click();
	 	 
   	  	 driver.findElement(By.id("txtUserID")).sendKeys(string); // USERNAME
	 	 driver.findElement(By.id("txtPassword")).sendKeys(string2); // PASSWORD
	 	 driver.findElement(By.id("sub")).click(); // LOGIN

    	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    @When("I create a new refund request")
    public void i_create_a_new_refund_request() {
    	
    	 driver.findElement(By.xpath("//span[@class = 'menu-item-icon-imageclass pi pi-plus']")).click(); // + CREATE
    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 //new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[(text() = 'BookingCancellationDemo' or . = 'BookingCancellationDemo')]")));
	 	 driver.findElement(By.xpath("//span[(text() = 'BookingCancellationDemo' or . = 'BookingCancellationDemo')]")).click(); // REFUND
	 	 
    }

    @When("I select PNR {string}")
    public void i_select_pnr(String string) {
	 	 new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='20161017110917023176385']")));
	 	 
	 	 driver.findElement(By.xpath("//*[@data-test-id='202212270943270446807']")).sendKeys(string); // PNR
	 	 
    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	 
	 	 driver.findElement(By.xpath("//span[@class='match']")).click();
	 	 
	 	 
    	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @Then("The loyalty is {string}")
    public void the_loyalty_is(String string) {

   	 String loyalty = driver.findElement(By.xpath("//*[@data-test-id='202212270748150344480']")).getText();
   	 System.out.println("Loyalty :"+loyalty);
   	 
 	
	 	 driver.findElement(By.xpath("//*[@data-test-id='20161017110917023176385']")).click(); // CONTINUE	
    }

    @When("i provide refunder email {string}")
    public void i_provide_refunder_email(String string) {

	 	new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='20161017110917023277518']")));
	 	driver.findElement(By.xpath("//*[@data-test-id='202212271110320348301']")).sendKeys(string); // refounder email
	 	driver.findElement(By.xpath("//*[@data-test-id='20161017110917023277518']")).click(); // CONTINUE	
    }

    @Then("the case is sent for approval")
    public void the_case_is_sent_for_approval() {
        
   	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 
   	 assertEquals("PENDING-APPROVAL",driver.findElement(By.xpath("//*[@data-test-id='2016083016191602341167946']")).getText());
        driver.close();
    }
    
    

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
