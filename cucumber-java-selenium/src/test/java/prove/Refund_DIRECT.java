package prove;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cbt.cucumber.Refund;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author CBT
 */

public class Refund_DIRECT {
    public static void main(String[] args) throws Exception{

    System.setProperty("TargetURL","https://10.60.213.235:8443/prweb/PRServlet/app/FlightManagementSolTest/");    
        System.setProperty("SeleniumGridURL","http://10.250.65.77:5555/wd/hub");  
        System.setProperty("browser","chrome");
        
      Refund ref = new Refund();

      try {
    	  	 ref.setUp();
    	 	 //ref.i_login_with_and("AUTUser@flightmgmt_react.com", "Ziofa2023!");
    	  	 ref.i_login_with_and("AUTUser@flightmgmt.com", "Ziofa2023!");
    	 	 ref.i_create_a_new_refund_request();
    	 	 ref.i_select_pnr("UP4231");
    	 	 ref.the_loyalty_is("Platinum");
    	 	 ref.i_provide_refunder_email("Selenium@flightmanagement.com");
    	 	 ref.the_case_is_sent_for_approval();
	 	     	 	     	 	 
      } catch (Exception e) {
		e.printStackTrace();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    
    
}