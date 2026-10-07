package TestCases;

import org.testng.annotations.Test;

import Base.BasetTest;
import Page.loginPage;

public class loginTest extends BasetTest {

	@Test
	public void testSuccessfulLogin() {
		loginPage loginPage = new loginPage(page);
		loginPage.login("9180000019", "9180000019");
		
	}
}
