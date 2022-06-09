package selenium_core.helpers.browser_configurations_helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import selenium_core.helpers.resource_helper.ResourceHelper;

public class ChromeBrowser
{
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will give us Chrome options and Capabilities
     * @return
     */
    public ChromeOptions getChromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type--");
        options.addArguments("--disable-popup-blocking");

        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.setJavascriptEnabled(true);
        options.setCapability(ChromeOptions.CAPABILITY, chrome);
    //Linux
        if(System.getProperty("os.name").contains("Linux"))
        {
            options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        }
        return options;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public WebDriver getChromeDriver(ChromeOptions cap)
    {
        if(System.getProperty("os.name").contains("Mac"))
        {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getRecoursePath("path"));
            return new ChromeDriver(cap);
        }
        else if(System.getProperty("os.name").contains("Windows"))
        {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getRecoursePath("/drivers/chromedriver.exe"));
            // return new ChromeDriver(cap);
            return new ChromeDriver();
        }
        else if(System.getProperty("os.name").contains("Linux"))
        {
            System.setProperty("webdriver.chrome.driver", "path");
            return new ChromeDriver(cap);
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------------------------||
}
