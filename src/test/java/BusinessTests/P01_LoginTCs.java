package BusinessTests;
import Pages.P01_LoginPage;
import Utilities.DataUtils;
import Utilities.Utils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class P01_LoginTCs {
// LoginTCs loginTcs=new LoginTCs();
    WebDriver driver;
String invalidEmail=new Faker().name()+"@teml.net";
    @BeforeSuite(alwaysRun = true)
    public void setup() throws IOException {
        driver = new ChromeDriver();
        driver.get(DataUtils.getPropertyData("environments", "BUSINESS_STAGING_URL"));
        driver.manage().window().maximize();
    }

    @Test(groups = "valid")
    public void validLogin() throws FileNotFoundException {
        new P01_LoginPage(driver).addEmail(DataUtils.getJsonData("LoginData", "email")).
                addPassword(DataUtils.getJsonData("LoginData", "password")).
                rememberME().
                Login();
        String expectedResult = "https://staging.quote-m.dev/business/home";
        String actualResult = Utils.getCurrentURL(driver, expectedResult);

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test(groups = {" "})
    public void loginMobileNumber() throws FileNotFoundException {
        new P01_LoginPage(driver).addnumber(DataUtils.getJsonData("LoginData", "starterMobile")).
                changenumberCode(DataUtils.getJsonData("LoginData", "partialMobile")).
                addPassword(DataUtils.getJsonData("LoginData", "password")).
                rememberME().
                Login();
        String expectedResult = "https://staging.quote-m.dev/business/home";
        String actualResult = Utils.getCurrentURL(driver, expectedResult);

        Assert.assertEquals(actualResult, expectedResult);
    }
@Test(groups = "invalid")
public void invalidemail() throws FileNotFoundException {

    new P01_LoginPage(driver).addEmail(invalidEmail).
            addPassword(DataUtils.getJsonData("LoginData", "password")).
            rememberME().
            Login();
}
   /* @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    */}
