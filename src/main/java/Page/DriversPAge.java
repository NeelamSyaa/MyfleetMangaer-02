package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;

public class DriversPAge  {

		   private final Page page;
		    private final Locator Drivers;
		    private final Locator passwordField;
		    private final Locator loginButton;
		public DriversPAge(Page page) {
			this.page =page;
			this.Drivers =  page.getByRole(AriaRole.TAB, new GetByRoleOptions().setName("Drivers"));
			this.passwordField = page.locator("[name=\"password\"]"); 
			            this.loginButton =      page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Login"));
		}
		
		
		public void login(String user, String Pws) {
			
		}
		
	
		
}
