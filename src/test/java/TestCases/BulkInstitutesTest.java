package TestCases;

import org.testng.annotations.Test;

import Base.BasetTest;
import Page.InstitutesPage;
import Page.loginPage;

public class BulkInstitutesTest  extends BasetTest{

	@Test
	public void addInstitutest() {
		loginPage loginPage = new loginPage(page);
		loginPage.login("9180000019", "9180000019");
		InstitutesPage InstitutesPage = new InstitutesPage(page);
		
		String file = "C:\\Users\\Admin\\eclipse-workspace\\MyfleetMangaer-02\\data\\student_invalid_data.xlsx";
		InstitutesPage.addbulkupload(file);
		InstitutesPage.addbulkupload(file);
	}
	
}
