package selenium_core.test_base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import selenium_core.helpers.browser_configurations_helper.BrowserType;
import selenium_core.helpers.browser_configurations_helper.ChromeBrowser;
import selenium_core.helpers.browser_configurations_helper.FirefoxBrowser;
import selenium_core.helpers.browser_configurations_helper.configurations.ConfigReader;
import selenium_core.helpers.browser_configurations_helper.configurations.ObjectReader;
import selenium_core.helpers.browser_configurations_helper.configurations.PropertyReader;
import selenium_core.helpers.excel_helper.ExcelHelper;
import selenium_core.helpers.logger_helper.LoggerHelper;
import selenium_core.helpers.resource_helper.ResourceHelper;
import selenium_core.helpers.wait_helper.WaitHelper;
import selenium_core.utils.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    //----------------------------------------------------------------------------------------------------------------||
    public static ExtentReports extentReports;
    public static ExtentTest test;
    private Logger log = LoggerHelper.getLogger(TestBase.class);
    public WebDriver driver;
    public static File reportDirectory;
    public static ConfigReader reader = new PropertyReader();// The same (Initialize data in RUNTIME for reading data from configuration file)
    //----------------------------------------------------------------------------------------------------------------||
    @BeforeTest
    public void beforeTest() throws Exception
    {
    //****************************************************************************************************************||
        //Access to the references of the Interfaces of the  class (configurations.ConfigReader)
        //ConfigReader reader = new PropertyReader();// The same (Initialize data in RUNTIME for reading data from configuration file)
        ObjectReader.reader = new PropertyReader(); // Initialize data in RUNTIME for reading data from configuration file
        log.info("Property file is loaded into a memory successfully");
    //****************************************************************************************************************||
        //reportDirectory = new File(ResourceHelper.getRecoursePath("\\src\\main\\java\\core\\screenshots\\"));
        reportDirectory = new File(ResourceHelper.getRecoursePath("screenshots"));
        System.out.println("Report Directory: " + reportDirectory);
        setUpDriver(reader.getBrowserType()); // Launch the browser + and browser type
        //test = extentReports.createTest(getClass().getName());
    }
    //----------------------------------------------------------------------------------------------------------------||
    @BeforeSuite
    public void beforeSuite() // Getting instance of ExtentManager class
    {
        extentReports = ExtentManager.getInstance(); // Getting by default instance from the class ExtentManager
    }
    //----------------------------------------------------------------------------------------------------------------||
    @BeforeClass
    public void beforeClass()
    {
        test = extentReports.createTest(getClass().getName().toUpperCase(Locale.ROOT)); // Printing info to HTML report
    }
    //----------------------------------------------------------------------------------------------------------------||
    @AfterClass
    public void afterClass()
    {
        if(driver != null)
        {
            driverClose();
        }
            driverQuit();
    }
    //----------------------------------------------------------------------------------------------------------------||
    @BeforeMethod
    public void beforeMethod(Method method)
    {
        test.log(Status.INFO, method.getName() + "test started...(from --> @BeforeMethod)");
    }
    //----------------------------------------------------------------------------------------------------------------||
    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getThrowable());
            test.log(Status.FAIL, result.getName());
            //String imagePath = captureScreenShot(result.getName(), driver);
            log.info("<<!!! Report: Test failed !!!>>");
            //test.addScreenCaptureFromPath(imagePath);
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, result.getName() + " is pass - (from --> @AfterMethod)");
            //String imagePath = captureScreenShot(result.getName(), driver);
            //log.info("<<< Adding ScreenShot to report file ... >>>");
            //test.addScreenCaptureFromPath(imagePath);
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            log.info("<<<Skipping test...>>>");
            test.log(Status.SKIP, result.getThrowable());
        }
        extentReports.flush();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public WebDriver getBrowserObject(BrowserType browser_type) throws Exception
    {
        try
        {
            switch (browser_type)
            {
    //****************************************************************************************************************||
                //Get object of ChromeBrowser class
                case Chrome:
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance(); //Instance of Chrome browser class
                    ChromeOptions options_0 = chrome.getChromeOptions();
                    return chrome.getChromeDriver(options_0);
    //****************************************************************************************************************||
                //Get object of Firefox class
                case Firefox:
                    FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
                    FirefoxOptions options_1 = firefox.getFirefoxOptions();
                    return  firefox.getFirefoxDriver(options_1);
    //****************************************************************************************************************||
                //Get object of Edge class
                case IExplorer:
                    //IExplorerBrowser ie = IExplorerBrowser.class.newInstance();
                    //InternetExplorerOptions cap = ie.getIExplorerCapabilities();
                    //return ie.getInternetExplorerDriver(cap);
    //****************************************************************************************************************||
                //Get object of Safari class
                case Safari:
    //****************************************************************************************************************||
                //Get object of Safari class
                case Edge:
    //****************************************************************************************************************||

                //Get object of Zalenium_docker class
                case Zalenium_docker:
                    //Zalenium_docker zalenium = new Zalenium_docker(); //Instance of chrome browser class
                    //zalenium.setUp("");
                    //return chrome.getChromeDriver(options_0);
    //****************************************************************************************************************||
                default:
                    throw new Exception("Driver not found: " + browser_type.name());
            }
        }
        catch (Exception e)
        {
            log.info(e.getMessage());
            throw e;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void setUpDriver(BrowserType btype) throws Exception
    {
        driver = getBrowserObject(btype);
        log.info("Initialize Web driver hash-code: " + driver.hashCode());
        WaitHelper wait = new WaitHelper(driver);
        wait.setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS); //Reading from the config.properties file
        wait.pageLoadTime(reader.getPageLoadTime(), TimeUnit.SECONDS); //Reading from the config.properties file
        driver.manage().window().maximize();
    }
    //----------------------------------------------------------------------------------------------------------------||
    public  String captureScreenshot(String fileName)
    {
        //***********************************************************************************************************//
        if(this.driver == null)
        {
            log.info("Driver is null...");
            return null;
        }
        if (fileName == "")
        {
            fileName = "blank";
        }
        //************************************************************************************************************//
        Reporter.log("CaptureScreen method called"); // Add comment to TestNG HTML report description
        File screenshot_image_path = null; //
        Calendar calendar = Calendar.getInstance(); // calendar for name of the screenshot
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");// date format for name of the screenshot
        File screenshot_image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // take a screenshot
        //************************************************************************************************************//
        try
        {
            screenshot_image_path = new File(reportDirectory +"/"+fileName+"_"+formatter.format(calendar.getTime())+".png");
            //screenshot_image_path = new File(ResourceHelper.getRecoursePath("/src/screenshots/") + driver.getTitle() + ".png");
            log.info("Taking a pass...");
            Files.copy(screenshot_image.toPath(), screenshot_image_path.toPath());
            //FileUtils.copyFile(screenshotFile, filePath);
            //Reporter.log(" <a href='" + screenshot_image_path.getAbsolutePath() + "'> <img src='"+screenshot_image_path.getAbsolutePath()+"'height='400' width='400'/></a>"); //Adding link to TestNG report html
            Reporter.log("<a href='" + screenshot_image_path.getAbsolutePath() + "'> <br><img src='"+screenshot_image_path.getAbsolutePath()+"' height='400' width='400'/></br>");
            System.out.println("screenshot image path: "+screenshot_image_path);
        }
        //************************************************************************************************************//
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return screenshot_image_path.toString();
    }
//    //----------------------------------------------------------------------------------------------------------------||
//    public void getNavigationScreen(WebDriver driver)
//    {
//        log.info("Capturing UI navigation screen..");
//        new JavaScriptHelper(driver).zoomInBy60Percentage();
//        String screen = captureScreenShot("", driver);
//        new JavaScriptHelper(driver).zoomInBy100Percentage();
//        try
//        {
//            test.addScreenCaptureFromPath(screen);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//    //----------------------------------------------------------------------------------------------------------------||
    public static void logExtentReport(String log)
    {
        test.log(Status.INFO, log);
    }
//    //----------------------------------------------------------------------------------------------------------------||
    public void getApplicationUrl(String url)
    {
        driver.get(url);
        logExtentReport("Navigate to ... " + url);
    }
//    //----------------------------------------------------------------------------------------------------------------||
    public void driverQuit()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }
//    //----------------------------------------------------------------------------------------------------------------||
    public void driverClose()
    {
        if(driver != null)
        {
            driver.close();
        }
    }
//    //----------------------------------------------------------------------------------------------------------------||
    public Object[][] getExcelData(String excelName, String sheetName)
    {
        String excelLocation = ResourceHelper.getRecoursePath("/src/main/java/selenium_core/excel_sheets_data/")+excelName;
        log.info("excel location "+excelLocation);
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
        return data;
    }
    //----------------------------------------------------------------------------------------------------------------||
}
