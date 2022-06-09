package selenium_core.helpers.browser_configurations_helper.configurations;

import selenium_core.helpers.browser_configurations_helper.BrowserType;
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
        String filePath = ResourceHelper.getRecoursePath("/src/main/resources/config.properties");
//        filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_firefox.properties");
//        filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_chrome.properties");
//        filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_safari.properties");
//        filePath = ResourceHelper.getRecoursePath("/src/main/resources/config_zalenium.properties");
        try
        {
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);

//            file = new FileInputStream(new File(filePath)); // If we need to add more config.properties files, just copy 3 lines of current code
//            OR = new Properties();
//            OR.load(file);
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
    public BrowserType getBrowserType()
    {
        return BrowserType.valueOf(OR.getProperty("browserType"));
    }
    //----------------------------------------------------------------------------------------------------------------||
    // To read data from config.file 49 lesson
//    @Override
//    public String getApplicationUrl()
//    {
//        System.out.println(OR.getProperty("applicationUrl"));
//        return OR.getProperty("applicationUrl");
//    }
//    We can read the data from POM.xml
    @Override
    public String getApplicationUrl()
    {
        if(System.getProperty("url_xml") != null) // try to read data from the Pom.xml
        {
            return System.getProperty("url_xml");
        }
        return OR.getProperty("applicationUrl");  // if not, we return data from the property file
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
