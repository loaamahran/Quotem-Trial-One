package BusinessTests;

import DriverFactory.DriverFactory;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.browserSetup;
import static DriverFactory.DriverFactory.getDriver;

public class BaseTest {
    @BeforeMethod
    public void setup() throws IOException {
        browserSetup(DataUtils.getPropertyData("environments", "Browser"));
        LogsUtils.info("Open Chrome Browser");
        getDriver().get(DataUtils.getPropertyData("environments", "BUSINESS_STAGING_URL"));
        LogsUtils.info("Open Business Account");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

        DriverFactory.teardown();
    }
}
