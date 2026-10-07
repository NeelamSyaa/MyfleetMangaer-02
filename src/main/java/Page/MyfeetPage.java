package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class MyfeetPage {

	  private final Page page;
	    private final Locator searchtext; 

	    
	    
	public MyfeetPage(Page page) {
		this.page =page;
		this.searchtext = page.getByPlaceholder("Search by Vehicle Details");
		
	   
	}
	
	
	public void serachVehcile(String  vehiclenumber) {
		searchtext.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		page.waitForLoadState(LoadState.NETWORKIDLE); 
		searchtext.fill(vehiclenumber);
	}	
		
}
