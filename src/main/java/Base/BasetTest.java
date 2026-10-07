package Base;

import java.util.List;

import javax.naming.Context;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasetTest {
	Playwright playwright;
	Browser Browser;
	 BrowserContext Context;
	    protected Page page ;
	@BeforeMethod
	public void  setup() {
		 playwright = Playwright.create();
	   Browser = playwright.chromium().launch (new BrowserType.LaunchOptions().setHeadless(false) );
       Context = Browser.newContext();
       BrowserContext context = Browser.newContext(new Browser.NewContextOptions()
    		    .setViewportSize(1920, 1080)); // Forces standard Desktop resolution

     page = Context.newPage();
    page.navigate("https://school-dev.syaa.xyz/login");
  

    
		
	}
	
	
	
	@AfterTest
	public void  teardwon() {
		//Browser.close();
		//playwright.close();
	}
}
