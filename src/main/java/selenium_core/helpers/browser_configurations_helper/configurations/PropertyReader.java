package selenium_core.helpers.browser_configurations_helper.configurations;

import selenium_core.helpers.resource_helper.ResourceHelper;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader implements ConfigReader
{
    //----------------------------------------------------------------------------------------------------------------||
    private static FileInputStream file;
    private static Properties OR;
    //----------------------------------------------------------------------------------------------------------------||
    // Constructor
    public PropertyReader()  //  Automatically Load the property file to the memory of PC
    {
        String filePath = ResourceHelper.getRecoursePath("src/main/resources/config.properties");
        //String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_firefox.properties");
        //String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_chrome.properties");
        //String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_safari.properties");
        //String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_zalenium.properties");
        try
        {
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public int getImplicitWait()
    {
        return Integer.parseInt(OR.getProperty("implicitWait"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public int getExplicitWait()
    {
        return Integer.parseInt(OR.getProperty("explicitWait"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public int getPageLoadTime()
    {
        return Integer.parseInt(OR.getProperty("pageLoadTime"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    @Override
    public selenium_core.helpers.browser_configurations_helper.BrowserType getBrowserType()
    {
        return selenium_core.helpers.browser_configurations_helper.BrowserType.valueOf(OR.getProperty("browserType"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    // To read data from config.file 49 lesson
//    @Override
//    public String getApplicationUrl()
//    {
//        System.out.println(OR.getProperty("applicationUrl"));
//        return OR.getProperty("applicationUrl");
//    }
//    //--------------------------------------------------------------------------------------------------------------||
//    We can read the data from POM.xml
    @Override
    public String getApplicationUrl()
    {
        if(System.getProperty("applicationUrl") != null)
         System.out.println(OR.getProperty("applicationUrl"));
        return System.getProperty("applicationUrl");
    }
//  //----------------------------------------------------------------------------------------------------------------||
@Override
public String getUserName()
{
    if(System.getProperty("userName") != null)
    {
        System.out.println(OR.getProperty("userName"));
    }
    return System.getProperty("userName");
}
//    @Override
//    public String getUserName()
//    {
//        System.out.println(OR.getProperty("userName"));
//        return OR.getProperty("userName");
//    }
    //----------------------------------------------------------------------------------------------------------------||
@Override
public String getPassword()
{
    if(System.getProperty("password") != null)
    {
        System.out.println(OR.getProperty("password"));
    }
    return System.getProperty("password");
}
//    @Override
//    public String getPassword()
//    {
//        System.out.println(OR.getProperty("password"));
//        return OR.getProperty("password");
//    }
    //----------------------------------------------------------------------------------------------------------------||
}
