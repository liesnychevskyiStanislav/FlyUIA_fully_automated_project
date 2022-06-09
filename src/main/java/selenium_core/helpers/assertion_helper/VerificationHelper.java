package selenium_core.helpers.assertion_helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium_core.helpers.logger_helper.LoggerHelper;
import selenium_core.test_base.TestBase;

public class VerificationHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(selenium_core.helpers.assertion_helper.VerificationHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public VerificationHelper(WebDriver driver)
    {
        log.info("VerificationHelper constructor is initialized..");
        TestBase.logExtentReport("VerificationHelper constructor is initialized..");
        this.driver = driver;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public boolean isDisplayed(WebElement element)
    {
        try
        {
            element.isDisplayed();
            log.info("Element is present >>> " + element.getText());
            TestBase.logExtentReport("Element is present >>> " + element.getText());

            return true;
        }
        catch (Exception e)
        {
            log.error("Error, element is not present >>> ", e.getCause());
            TestBase.logExtentReport("Error, element is not present >>> "+ e.getMessage());
            return false;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public boolean isNotDisplayed(WebElement element)
    {
        try
        {
            element.isDisplayed();
            log.info(" Error :: Element is displayed >>> " + element.getText());
            return false;
        }
        catch (Exception e)
        {
            log.error("Element is not displayed >>> ");
            return true;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public String getText(WebElement element)
    {
        if(null == element)
        {
            log.info("WebElement is null.. ");
            return null;
        }
        boolean status = isDisplayed(element);
        if(status)
        {
            log.info("Element text is : " + element.getText());
            return element.getText();
        }
        else
        {
            return null;
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
}
