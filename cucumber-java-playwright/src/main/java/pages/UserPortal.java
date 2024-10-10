package pages;

import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import utils.WebActions;

public class UserPortal {
    private Page page;
    private final Locator CREATE_CASE;
    private final Locator PLUS_LINK;
    private final Locator CREATE_LINK;
    private final Locator HOME;
    private final Locator DASHBOARD;
    private final Locator SPACES;
    private final Locator REPORTS;
    private final Locator EXPLORE_DATA;

    public UserPortal(Page page) {
        this.page = page;
        
        this.CREATE_LINK = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create")); 
        this.PLUS_LINK =page.locator("[data-test-id=\"\\32 01812201359010458611\"] a").first();
        this.CREATE_CASE = page.locator("[data-test-id=\"\\32 01812201359010337524\"] a");
        this.HOME = page.locator("[data-test-id=\"dynamic-nav-menu_1\"] a");
        this.DASHBOARD = page.locator("[data-test-id=\"dynamic-nav-menu_2\"] a");
        this.SPACES = page.locator("[data-test-id=\"dynamic-nav-menu_3\"] a");
        this.REPORTS = page.locator("[data-test-id=\"dynamic-nav-menu_4\"] a");
        this.EXPLORE_DATA = page.locator("[data-test-id=\"dynamic-nav-menu_6\"] a");
       
   }

    public void createCase(String caseName) {
    	PLUS_LINK.hover();
        CREATE_LINK.click();
        CREATE_CASE.hover();
        CREATE_CASE.click();
    }

    public void navigateToLandingPage(String landingPageName) {
    	switch (landingPageName) {
		case "Home" : 
			HOME.click();
			break;
		case "Dashboard" : 
			DASHBOARD.click();
			break;
		case "Spaces" : 
			SPACES.click();
			break;
		case "Reports" : 
			REPORTS.click();
			break;
		case "Explore Data" : 
			EXPLORE_DATA.click();
			break;
		default:
			break;
		}
    }

    public boolean verifyLandingPageTitle(String title) {
        Locator ltitle = page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName(title));
        return true;
    }
}
