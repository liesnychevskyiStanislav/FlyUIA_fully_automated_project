package selenium_core.helpers.logger_helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import selenium_core.helpers.resource_helper.ResourceHelper;

public class LoggerHelper
{
    //----------------------------------------------------------------------------------------------------------------||
    private static boolean root = false;
    //----------------------------------------------------------------------------------------------------------------||
    public static Logger getLogger(Class cls)
    {
        if (root) // if logger created by some class or utility
        {
            return Logger.getLogger(cls);
        }
        //For Windows //PropertyConfigurator.configure(ResourceHelper.getRecoursePath("\\src\\main\\resources\\log4j.properties"));
        PropertyConfigurator.configure(ResourceHelper.getRecoursePath("/src/main/resources/log4j.properties"));
        root = true;
        return Logger.getLogger(cls);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args)
    {
        Logger log = selenium_core.helpers.logger_helper.LoggerHelper.getLogger(selenium_core.helpers.logger_helper.LoggerHelper.class);
        log.info("Configured");
        log.error("Error");
        log.debug("Debug");
    }
    //----------------------------------------------------------------------------------------------------------------||
}
