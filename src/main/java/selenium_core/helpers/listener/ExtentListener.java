package selenium_core.helpers.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import selenium_core.helpers.logger_helper.LoggerHelper;
import selenium_core.utils.ExtentManager;

public class ExtentListener implements ITestListener
{
    //----------------------------------------------------------------------------------------------------------------||
    private Logger log = LoggerHelper.getLogger(selenium_core.helpers.listener.ExtentListener.class);
    public static ExtentReports extentReports;
    public static ExtentTest test;
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onTestStart(ITestResult result)
    {
        test.log(Status.INFO, result.getName() + " started...");
        Reporter.log(result.getMethod().getMethodName() + " Test Started "); // Printing log to TestNG report
        log.info(result.getMethod().getMethodName() + " Test Started ");
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.log(Status.INFO, result.getName() + " passed...");
        Reporter.log(result.getMethod().getMethodName() + " Test Passed");// Printing log to TestNG report
        log.info(result.getMethod().getMethodName() + " Test Passed ");
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onTestFailure(ITestResult result)
    {
        test.log(Status.FAIL, result.getThrowable());
        Reporter.log(result.getMethod().getMethodName() + " Test Failed..." + result.getThrowable());// Printing log to TestNG report
        log.error(result.getMethod().getMethodName() + " Test Failed " + result.getThrowable());
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onTestSkipped(ITestResult result)
    {
        test.log(Status.SKIP, result.getThrowable());
        Reporter.log(result.getMethod().getMethodName() + " Test Skipped..." + result.getThrowable());// Printing log to TestNG report
        log.warn(result.getMethod().getMethodName() + " Test Skipped " + result.getThrowable());
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onStart(ITestContext context)
    {
        extentReports = ExtentManager.getInstance();
        test = extentReports.createTest(context.getName());
        //test = extentReports.createTest(context.getCurrentXmlTest().getName());
        //Reporter.log(context.getName() + " Test Started...");
        Reporter.log(context.getCurrentXmlTest().getName() + " Class Started...");// Printing log to TestNG report
        log.info(context.getCurrentXmlTest().getName() + " Class Started...");
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public void onFinish(ITestContext context)
    {
        extentReports.flush(); // Generate report on finish
        Reporter.log(context.getName() + " Test Finished.");// Printing log to TestNG report
        log.info(context.getName() + " Test Finished.");
    }
    //----------------------------------------------------------------------------------------------------------------||
}
