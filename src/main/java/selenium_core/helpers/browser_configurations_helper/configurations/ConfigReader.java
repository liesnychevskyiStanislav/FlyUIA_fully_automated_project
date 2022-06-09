package selenium_core.helpers.browser_configurations_helper.configurations;

import selenium_core.helpers.browser_configurations_helper.BrowserType;

public interface ConfigReader
{
    public int getImplicitWait();
    public int getExplicitWait();
    public int getPageLoadTime();
    public BrowserType getBrowserType();
    public String getApplicationUrl();
    public String getUserName();
    public String getPassword();
}
