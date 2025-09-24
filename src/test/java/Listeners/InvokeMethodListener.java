package Listeners;

//import Utilities.Utility;
import Utilities.LogsUtils;
import Utilities.Utils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static java.sql.DriverManager.getDriver;

public class InvokeMethodListener implements IInvokedMethodListener {

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        //Utility.takeFullScreenshot(getDriver(), new P02_LandingPage(getDriver()).getNumberOfSelectedProductsOnCart());
        switch (testResult.getStatus()) {
            case ITestResult.FAILURE:
                LogsUtils.info("Test Case " + testResult.getName() + " failed");
                try {
                    Utils.takeScreenShot(getDriver(), testResult.getName()); //validLoginTC-2024-03-03-8-17pm
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case ITestResult.SUCCESS:
                LogsUtils.info("Test Case " + testResult.getName() + " passed");
                break;
            case ITestResult.SKIP:
                LogsUtils.info("Test Case " + testResult.getName() + " skipped");
                break;
        }
        try {
            File logFile = Utils.getLatestFile(LogsUtils.LOGS_PATH);
            assert logFile != null;
          //  Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
        }

    }
}