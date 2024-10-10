package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RefundCaseType {
    private Page page;
    private final Locator AUTOCOMPLETE_PNR;
    private final Locator REFUNDER_EMAIL;
    private final Locator CONTINUE;
    private final Locator CREATE;
    private final Locator CASE_STATUS;

    public RefundCaseType(Page page) {
        this.page = page;
        this.AUTOCOMPLETE_PNR = page.locator("[data-test-id=\"\\32 02212270943270446807\"]");
        this.REFUNDER_EMAIL = page.locator("[data-test-id=\"\\32 02212271110320348301\"]");
        this.CONTINUE = page.locator("[data-test-id=\"\\32 0161017110917023176385\"]");
        this.CREATE = page.locator("[data-test-id=\"\\32 0161017110917023277518\"]");
        this.CASE_STATUS = page.locator("[data-test-id='2016083016191602341167946']");
        
    }

    public void collectBookingID(String PNR) {
        AUTOCOMPLETE_PNR.fill(PNR);
        CONTINUE.click();
        
    }

    public void checkBooking(String refunderEmail) {
    	REFUNDER_EMAIL.fill(refunderEmail);
    	CREATE.click();
    }
    
    public String getCaseStatus() {
    	return CASE_STATUS.textContent();
    }

}
