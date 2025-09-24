package BusinessTests;

import Pages.P01_LoginPage;
import Pages.P03_RequistionsListPage;
import Pages.P04_CreateRFPStep1Page;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import static DriverFactory.DriverFactory.getDriver;

public class P03_CreateRFPStep1TCs extends BaseTest {
String title=DataUtils.getJsonData("RFPData", "title")+ Utils.timeStamp();
String description=DataUtils.getJsonData("RFPData", "description")+ Utils.timeStamp();
//String sectionName = String.valueOf(new Faker().name());
double quantity=new Random().nextDouble(99999);
double roundedQuantity=Math.round(quantity);
    public P03_CreateRFPStep1TCs() throws FileNotFoundException {
    }


        @Test(groups = "valid")
        public void navigateToList() throws IOException, InterruptedException {
            new P01_LoginPage(getDriver()).
                    addEmail(DataUtils.getJsonData("LoginData", "email")).
                    addPassword(DataUtils.getJsonData("LoginData", "password")).
                    rememberME().
                    Login().
                    getRequistionsList().
            clickOnCreateButton();}
            @Test()
             public void createRFPStep1ValidData() throws IOException, InterruptedException {
           navigateToList() ;
           new P03_RequistionsListPage(getDriver())
                   .createRFP().
                   RFPStep1(title, description);

                LogsUtils.info("Step 1 Pass");}

           // RFPStep2(sectionName,roundedQuantity,"custom").
                    //RFPStep3(DataUtils.getJsonData("RFPData", "Notes"), DataUtils.getJsonData("RFPData", "file"));
            //Assert.assertEquals(getDriver().getCurrentUrl(), DataUtils.getPropertyData("environments", "RFPStep1_URL"));
            //LogsUtils.info("Navigate to RFP tab");
        }


