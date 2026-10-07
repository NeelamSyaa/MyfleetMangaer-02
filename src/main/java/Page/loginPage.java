package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;

public class loginPage {
	   private final Page page;
	    private final Locator usernameField;
	    private final Locator passwordField;
	    private final Locator loginButton;
	public loginPage(Page page) {
		this.page =page;
		this.usernameField = page.locator("[name=\"username\"]");
		this.passwordField = page.locator("[name=\"password\"]"); 
		            this.loginButton =      page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Login"));
	}
	
	
	public void login(String user, String Pws) {
		usernameField.fill(user);
		passwordField.fill(Pws);
		loginButton.click();
		
	}}