package BusinessTests;
import DriverFactory.DriverFactory;
import Pages.P01_LoginPage;
import Utilities.DataUtils;
import Utilities.Utils;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class P01_LoginTCs extends BaseTest {

// LoginTCs loginTcs=new LoginTCs();

String invalidEmail=new Faker().name()+"@teml.net";
    @Test(groups = "valid")
    public void validLogin() throws FileNotFoundException {
        new P01_LoginPage(DriverFactory.getDriver()).addEmail(DataUtils.getJsonData("LoginData", "email")).
                addPassword(DataUtils.getJsonData("LoginData", "password")).
                rememberME().
                Login();
        String expectedResult = "https://staging.quote-m.dev/business/home";
        String actualResult = Utils.getCurrentURL(DriverFactory.getDriver(), expectedResult);

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test(groups = {" "})
    public void loginMobileNumber() throws FileNotFoundException {
        new P01_LoginPage(DriverFactory.getDriver()).addnumber(DataUtils.getJsonData("LoginData", "starterMobile")).
                changenumberCode(DataUtils.getJsonData("LoginData", "partialMobile")).
                addPassword(DataUtils.getJsonData("LoginData", "password")).
                rememberME().
                Login();
        String expectedResult = "https://staging.quote-m.dev/business/home";
        String actualResult = Utils.getCurrentURL(DriverFactory.getDriver(), expectedResult);

        Assert.assertEquals(actualResult, expectedResult);
    }
@Test(groups = "invalid")
public void invalidemail() throws FileNotFoundException {

    new P01_LoginPage(DriverFactory.getDriver()).addEmail(invalidEmail).
            addPassword(DataUtils.getJsonData("LoginData", "password")).
            rememberME().
            Login();
}
  }
