package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

public class DriversPAge {

    private final Page page;

    // Form Navigation and Action Locators
    private final Locator driversTab;
    private final Locator addDriversButton;
    private final Locator driverName;
    private final Locator mobileNumber;
    private final Locator licenseNumber;
    private final Locator fetchDetailsButton;
    private final Locator addDriverSubmit;

    // Material UI Calendar Component Locators
    private final Locator calendarButton;
    private final Locator switchToCalendar;
    private final Locator targetYearButton;
    private final Locator previousMonthButton;
    private final Locator dayInMonth;
    private final Locator okButton;

    public DriversPAge(Page page) {
        this.page = page;

        // Core Form Fields and Actions
        this.driversTab = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Drivers"));
        this.addDriversButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Driver").setExact(true));
        this.driverName = page.getByPlaceholder("Enter Driver Name");
        this.mobileNumber = page.getByPlaceholder("Enter Phone Number");
        this.licenseNumber = page.getByPlaceholder("Enter Driving License Number");
        this.fetchDetailsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fetch Details"));
        this.addDriverSubmit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Driver").setExact(true));

        // Date Picker Sub-Components
        this.calendarButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose date"));
        this.switchToCalendar = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("year view is open, switch to calendar view"));
        this.targetYearButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("1996"));
        this.previousMonthButton = page.locator("button[title='Previous month']");
        this.dayInMonth = page.locator("//div[@class='MuiDayCalendar-weekContainer css-cy45vv'][2]/button[6]");
        this.okButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK"));
    }

    public void openAddDriverForm() {
        driversTab.click();
        addDriversButton.click();
    }

    public void enterDriverDetails(String name, String phone, String license) {
        driverName.fill(name);
        mobileNumber.fill(phone);
        licenseNumber.fill(license);
    }

    /**
     * Handles navigating back into the picker widget tree.
     * Selects year 1996, clicks previous month 5 times, selects the day, and confirms.
     */
    public void enterDateOfBirth(String targetYear, String targetMonth, String targetDay) {
        // 1. Open the widget view layout
        calendarButton.click();
        switchToCalendar.click();
        
        // 2. Select the year node row 
        targetYearButton.scrollIntoViewIfNeeded();
        targetYearButton.click();

        // 3. Step back sequentially across 5 months
        for (int i = 0; i < 5; i++) {
            previousMonthButton.click();
            page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        }
        
        // 4. Highlight the target day grid coordinates and save modal changes
        dayInMonth.click();
        okButton.click();
    }

    public void fetchDriverDetails() {
        fetchDetailsButton.click();
    }

    public void submitDriverDetails() {
        addDriverSubmit.click();
    }
}
