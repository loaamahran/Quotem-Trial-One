package BusinessTests;

import Pages.P01_LoginPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utils;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static DriverFactory.DriverFactory.*;

public class P03_RequisitionListTCs {
String title=DataUtils.getJsonData("RFPData", "title")+ Utils.timeStamp();
String description=DataUtils.getJsonData("RFPData", "description")+ Utils.timeStamp();
String sectionName = String.valueOf(new Faker().name());
double quantity=new Random().nextDouble(99999);
double roundedQuantity=Math.round(quantity);
    public P03_RequisitionListTCs() throws FileNotFoundException {
    }

    @BeforeClass
        public void setup() throws IOException {
            browserSetup(DataUtils.getPropertyData("environments", "Browser"));
            LogsUtils.info("Open Chrome Browser");
            getDriver().get(DataUtils.getPropertyData("environments", "BUSINESS_STAGING_URL"));
            LogsUtils.info("Open Business Account");
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        @Test(groups = "valid")
        public void navigateToCreateRFP() throws IOException, InterruptedException {
            new P01_LoginPage(getDriver()).
                    addEmail(DataUtils.getJsonData("LoginData", "email")).
                    addPassword(DataUtils.getJsonData("LoginData", "password")).
                    rememberME().
                    Login().
                    getRequistionsList()
                    .clickOnCreateButton().
                    createRFP().
                    RFPStep1(title, description).
            RFPStep2(sectionName,roundedQuantity);

            //Assert.assertEquals(getDriver().getCurrentUrl(), DataUtils.getPropertyData("environments", "RFPStep1_URL"));
            //LogsUtils.info("Navigate to RFP tab");
        }
      /* @AfterMethod
   public void tearDown(){
         teardown();
       }
*/
        }
