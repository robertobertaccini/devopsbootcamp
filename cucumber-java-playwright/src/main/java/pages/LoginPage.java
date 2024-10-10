package pages;

import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import utils.WebActions;

public class LoginPage {
    private Page page;
    private final Locator USERNAME_EDITBOX;
    private final Locator PASSWORD_EDITBOX;
    private final Locator LOGIN_BUTTON;


    public LoginPage(Page page) {
        this.page = page;
        this.USERNAME_EDITBOX = page.getByPlaceholder("User name");
        this.PASSWORD_EDITBOX = page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true));
        this.LOGIN_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
   }

    public void navigateToUrl(String url) {
        this.page.navigate(WebActions.getEnvironmentVariabe(url));
    }

    public void enterUsername(String username) {
        USERNAME_EDITBOX.fill(WebActions.getEnvironmentVariabe(username));
    }

    public void enterPassword(String password) {
        PASSWORD_EDITBOX.fill(WebActions.getEnvironmentVariabe(password));
    }

    public void clickLogin() {
        LOGIN_BUTTON.click();
    }
    
    public void clickOnIcon(String iconName) {
        this.page.getByText(iconName, new Page.GetByTextOptions().setExact(true)).click();  // Clicks on the Exact text
    }

}
