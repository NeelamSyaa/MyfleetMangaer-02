package TestCases;

import org.testng.annotations.Test;
import Base.BasetTest;
import Page.DriversPAge;
import Page.loginPage;

public class addDriverTest extends BasetTest {

    @Test
    public void addDriverTest() {
        loginPage loginPage = new loginPage(page);
        loginPage.login("9180000019", "9180000019");
        
        DriversPAge driversPage = new DriversPAge(page);
        driversPage.openAddDriverForm();

        driversPage.enterDriverDetails(
                "Rahul Kumar",
                "9876543210",
                "KA5320240029259"
        );

        // This will now dynamically click the year 1996 and select the 12th day!
        driversPage.enterDateOfBirth("1996", "April", "12");
        
        driversPage.fetchDriverDetails();
        driversPage.submitDriverDetails();
    }
}
