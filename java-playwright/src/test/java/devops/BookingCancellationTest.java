package devops;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BookingCancellationTest extends TestCase {
	
	  // Shared between all tests in this class.
	  static Playwright playwright;
	  static Browser browser;
	  static String TargetURL;
	  //static String Browser;
	  static String username;
	  static String password;	  

	  // New instance for each test method.
	  BrowserContext context;
	  Page page;

	  static void launchBrowser() {
	    playwright = Playwright.create();
	    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
	    
    	TargetURL = System.getProperty("TargetURL");    
        //Browser = System.getProperty("browser");
        username = System.getProperty("username");
        password = System.getProperty("password");
        
        System.out.println("TargetURL ="+TargetURL);
        System.out.println("Username ="+username);
        System.out.println("Password ="+password);    
	  }

	  static void closeBrowser() {
	    playwright.close();
	  }

	  void createContextAndPage() {
	    context = browser.newContext();
	    page = context.newPage();
	  }

	  void closeContext() {
	    context.close();
	  }
	  
    public static Test suite()
    {
        return new TestSuite( BookingCancellationTest.class );
    }


	  public void testApp() {
		  
		  launchBrowser();
		  createContextAndPage();
		  
		  page.navigate(TargetURL);

		  // Login
		  page.getByPlaceholder("User name").fill(username);
		  page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill(password);
		  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
		  
		  // Create BookingCancellation 
		  page.locator("[data-test-id=\"\\32 01812201359010458611\"] a").first().hover();
		  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create")).click();
		  page.locator("[data-test-id=\"\\32 01812201359010337524\"] a").hover();
		  page.locator("[data-test-id=\"\\32 01812201359010337524\"] a").click();

		  // Booking Cancellation submission
		  page.locator("[data-test-id=\"\\32 02212270943270446807\"]").fill("DEVOPS");
		  page.locator("[data-test-id=\"\\32 0161017110917023176385\"]").click();
		  page.locator("[data-test-id=\"\\32 02212271110320348301\"]").fill("devops@pega.com");
		  page.locator("[data-test-id=\"\\32 0161017110917023277518\"]").click();
		  
		  assertEquals("Pending-Approval",page.locator("[data-test-id='2016083016191602341167946']").textContent());
		  
		  String caseID = page.locator("[data-test-id='20190510022618055338234']").textContent();
		  System.out.println("Case ID "+caseID+" created");
		  
		  page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("bookingcancellation.png")));
		  
		  closeContext();
		  closeBrowser();
	  }

}

