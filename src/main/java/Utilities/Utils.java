package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Utils {
    static WebDriver driver;
    private static String SCREENSHOTS_PATH = "Test-output/Screenshots/";

    //TODO:SendKeys
    public static void sendData(WebDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    //TODO:Click
    public static void click(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //TODO:UploadFile
    public static void uploadFile(WebDriver driver, By locator, String path) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(path);
    }

    //TODO:TimeStamp
    public static String timeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    //TODO:Screenshot
    public static void takeScreenShot(WebDriver driver, String ImgName) throws IOException {
       generalWait(driver);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dst = new File(SCREENSHOTS_PATH + ImgName + timeStamp() + ".png");
        Files.copy(src, dst);
//Allure.addAttachment(screenShotName, Files.newInputStream(Path.of(dest.getPath())));}
    }

    //TODO:GeneralWait
    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static WebElement findWebElement(By locator) {
        return driver.findElement(locator);
    }

    //TODO:GetCurrentURL
    public static String getCurrentURL(WebDriver driver, String url) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(url));
        return driver.getCurrentUrl();
    }

    //TODO:CheckBox
    public static void checkBox(WebDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementSelectionStateToBe(locator, false));
        driver.findElement(locator).click();
    }

    //TODO:Scroll
    public void scroll(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findWebElement(locator));
    }

    //TODO:GetText
    public static String getText(WebDriver driver, By locator, String text) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(locator, text));
        return driver.findElement(locator).getText();
    }

    //TODO:GetFullScreenShot
    public static void captureFullScreenShot(WebDriver driver, By locator) {
        Shutterbug.shootPage(driver, Capture.FULL_SCROLL).highlight(findWebElement(locator)).save(SCREENSHOTS_PATH);
    }

    //TODO:Generate RandomNumber
    public static int generateRandomumber(int upperBound) {
        return new Random().nextInt(upperBound) + 1;
    }

    //TODO: Scroll DropDown
    public static void selectFromDropDown(WebDriver driver, By locator, int number) {
        List<WebElement> dropDownOptions = driver.findElements(locator);
        for (int i = 1; i <= dropDownOptions.size(); i++) {

        }
        }
   //TODO:getCookies
   public static Set<Cookie> getAllCookies(WebDriver driver){
    return  driver.manage().getCookies();
        }
    //TODO:AddCookies
    public static void restoreSession(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);

        }
    }
    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        if (files.length == 0)
            return null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        return files[0];
    }

    }

