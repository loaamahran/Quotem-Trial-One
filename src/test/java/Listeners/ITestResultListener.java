package Listeners;

import Utilities.LogsUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestResultListener implements ITestListener {

    public void onTestStart(ITestResult result) {
   //test case start deh blnsbaly info
        LogsUtils.info("Test Case: "+result.getTestName()+" Started");
        }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test Case: "+result.getTestName()+" Passed");}

    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test Case: "+result.getTestName()+" Failed"); }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test Case: "+result.getTestName()+" Skipped");  }
}
