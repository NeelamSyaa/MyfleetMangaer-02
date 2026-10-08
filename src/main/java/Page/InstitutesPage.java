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
    
    public InstitutesPage(Page page) {
        this.page = page;
        this.addInstitutes = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Institutes"));
    }
    
    public void addbulkupload(String filePath) {
    	addInstitutes.click();
       
        page.waitForLoadState(LoadState.NETWORKIDLE);
        
     
      //  Locator bulkUploadBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bulk Upload"));
        Locator bulkUploadBtn   =  page.locator("//button[text()='Bulk Upload']");
       
    	//bulkUploadBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    	bulkUploadBtn.click();
        
        page.waitForLoadState(LoadState.NETWORKIDLE);

        page.waitForFileChooser(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose File")).click();
        }).setFiles(Paths.get(filePath)); 
    }
}
