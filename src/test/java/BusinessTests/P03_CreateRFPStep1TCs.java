package BusinessTests;

import Pages.P01_LoginPage;
import Pages.P03_RequistionsListPage;
import Pages.P04_CreateRFPStep1Page;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utils;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import Listeners.InvokeMethodListener;
import Listeners.ITestResultListener;
import static DriverFactory.DriverFactory.getDriver;
@Listeners({InvokeMethodListener.class, ITestResultListener.class})
public class P03_CreateRFPStep1TCs extends BaseTest {


    public P03_CreateRFPStep1TCs() throws FileNotFoundException {
    }



    @Test
    public void invalidTitle() throws IOException, InterruptedException {navigateToList() ;
        new P03_RequistionsListPage(getDriver())
                .createRFP().
                setTitle(DataUtils.getJsonData("RFPData", "InvalidTitle"));
        Assert.assertEquals(new P04_CreateRFPStep1Page(getDriver()).titleText(), "Title cannot exceed 150 characters.");


    }
    @Test
    public void createRFPStep2ValidData() throws IOException, InterruptedException {
        navigateToList() ;
        new P03_RequistionsListPage(getDriver())
                .createRFP().
                RFPStep1(title, description).
                createSection(sectionName);}}



