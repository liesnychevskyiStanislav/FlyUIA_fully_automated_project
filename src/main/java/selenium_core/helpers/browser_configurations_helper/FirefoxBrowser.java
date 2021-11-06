package selenium_core.helpers.browser_configurations_helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import selenium_core.helpers.resource_helper.ResourceHelper;

public class FirefoxBrowser
{
    //----------------------------------------------------------------------------------------------------------------||
    public FirefoxOptions getFirefoxOptions()
    {
        DesiredCapabilities firefox = DesiredCapabilities.firefox();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefox.setCapability(FirefoxDriver.PROFILE, profile);
        firefox.setCapability("marionette", true);

        FirefoxOptions firefoxOptions  = new FirefoxOptions(firefox);
        //Linux
        if(System.getProperty("os.name").contains("Linux"))
        {
            firefoxOptions.addArguments("--headless", "windows-size=1024,768", "--no-sandbox");
        }
        return firefoxOptions;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public WebDriver getFirefoxDriver(FirefoxOptions cap)
    {
        if(System.getProperty("os.name").contains("Mac"))
        {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getRecoursePath("path"));
            return new FirefoxDriver(cap);
        }

        else if(System.getProperty("os.name").contains("Windows"))
        {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getRecoursePath("/drivers/chromedriver.exe"));
            return new FirefoxDriver(cap);
        }

        else if(System.getProperty("os.name").contains("Linux"))
        {
            System.setProperty("webdriver.chrome.driver", "path");
            return new FirefoxDriver(cap);
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public WebDriver getFirefoxDriverEmpty()
    {
        if(System.getProperty("os.name").contains("Mac"))
        {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getRecoursePath("path"));
        }

        else if(System.getProperty("os.name").contains("Windows"))
        {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getRecoursePath("/drivers/chromedriver.exe"));
        }

        else if(System.getProperty("os.name").contains("Linux"))
        {
            System.setProperty("webdriver.chrome.driver", "path");
        }
        return null;
    }
    //----------------------------------------------------------------------------------------------------------------||
}
