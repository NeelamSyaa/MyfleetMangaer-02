package Page;

import java.nio.file.Paths;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InstitutesPage {

    private final Page page;
    private final Locator addInstitutes; 
    private final Locator sumbitbtn; 
   // private final Locator dwonlodfile;
    private final Locator DownloadXLSXdulicatedara; 
    private final Locator errortext; 
    private final Locator DownloadTemplate; 
    private final Locator Closewindow; 
    public InstitutesPage(Page page) {
        this.page = page;
        this.addInstitutes = page.getByRole(
        	    AriaRole.TAB,
        	    new Page.GetByRoleOptions().setName("Institutes")
        	);
        
       
        this.sumbitbtn = page.getByRole(
        	    AriaRole.BUTTON,
        	    new Page.GetByRoleOptions().setName("Submit")
        	);

//        this.dwonlodfile = page.getByRole(
//        	    AriaRole.BUTTON,
//        	    new Page.GetByRoleOptions().setName("Download Button")
//        	);
        
        this.DownloadXLSXdulicatedara = page.getByRole(
        	    AriaRole.BUTTON,
        	    new Page.GetByRoleOptions().setName("Download XLSX")
        	);
        
        this.errortext =    page.getByText("Upload Finished with Errors");
        
        this.DownloadTemplate = page.getByRole(
        	    AriaRole.BUTTON,
        	    new Page.GetByRoleOptions().setName("Download Template")
        	);
        this.Closewindow = page.getByRole(
        	    AriaRole.BUTTON,
        	    new Page.GetByRoleOptions().setName("Close").setExact(true)
        	);
        
        
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
        sumbitbtn.click();
      //  dwonlodfile.click();
        DownloadXLSXdulicatedara.click();
     // Print error message if present
        if (errortext.isVisible()) {
            System.out.println("Upload status: " + errortext.innerText());
        }
      DownloadTemplate.click();
      
      Closewindow.click();
     
    }
    
    
    
}
