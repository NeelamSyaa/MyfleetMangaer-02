package TestCases;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import Base.BasetTest;
import Page.MyfeetPage;
import Page.loginPage;

public class MyfeetTest  extends BasetTest{
	loginPage  loginPage;
	MyfeetPage  MyfeetPage;
	@Test
	public void Myfeet() {
		
		  loginPage = new loginPage(page);
		loginPage.login("9180000019", "9180000019");
	
		  MyfeetPage = new MyfeetPage(page);
		MyfeetPage.serachVehcile("PB65BH7019");
	}
}
