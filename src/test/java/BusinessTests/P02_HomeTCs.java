package BusinessTests;

import Pages.P01_LoginPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class P02_HomeTCs extends BaseTest{

 @Test(groups = "valid")
    public void RequisitionNavigate() throws IOException {
     new P01_LoginPage(getDriver()).
            addEmail(DataUtils.getJsonData("LoginData", "email")).
             addPassword(DataUtils.getJsonData("LoginData", "password")).
             rememberME().
             Login().getRequistionsList();
    Assert.assertEquals(getDriver().getCurrentUrl(), DataUtils.getPropertyData("environments", "Requisition_URL"));
     LogsUtils.info("Navigate to requisition tab");
 }
}
