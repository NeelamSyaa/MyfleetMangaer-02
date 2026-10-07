package Page;

import java.nio.file.Paths;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InstitutesPage {

    private final Page page;
    private final Locator addInstitutes; 
    private final Locator BulkUploadbtn; 
    public InstitutesPage(Page page) {
        this.page = page;
       
        this.addInstitutes = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Institutes"));
      this.  BulkUploadbtn  =  page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Bulk Upload"));
        
    }
    
    public void addbulkupload(String filePath) {
        
    	BulkUploadbtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    	BulkUploadbtn.click();
        
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);

      
        page.waitForFileChooser(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose File")).click();
        }).setFiles(Paths.get(filePath)); 
    }
}
