package selenium_core.helpers.window_helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import selenium_core.helpers.logger_helper.LoggerHelper;

import java.util.Set;

public class WindowHelper //This class will help us with tabs of browser.
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(selenium_core.helpers.window_helper.WindowHelper.class);
    //----------------------------------------------------------------------------------------------------------------||
    public WindowHelper(WebDriver driver)
    {
        log.info("WindowHelper constructor is created");
        this.driver = driver;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow()
    {
        log.info("Switch to parent window...");
        driver.switchTo().defaultContent();
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will switch to child window based on index
     */
    public void switchToWindow(int index)
    {
        log.info("Switch to parent window...");
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for(String window : windows)
        {
            if(i == index)
            {
                log.info("Switched to : " + index + " window");
                driver.switchTo().window(window);
            }
            else
            {
                i++;
            }
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will close all tabbed windows and switch to main window
     */
    public void closeAllTabsSwitchToMainWindow()
    {
        Set<String> windows = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();

        for(String window : windows)
        {
            if(!window.equalsIgnoreCase(mainWindow))
            {
                driver.close();
            }
        }
        log.info("Switched to main window");
        driver.switchTo().window(mainWindow);
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will do back step navigation
     */
    public void navigateBack()
    {
        driver.navigate().back();
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will do step forward
     */
    public void navigateForward()
    {
        driver.navigate().forward();
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will do refreshing of the current page
     */
    public void refreshThePage()
    {
        driver.navigate().refresh();
    }
    //----------------------------------------------------------------------------------------------------------------||
}
