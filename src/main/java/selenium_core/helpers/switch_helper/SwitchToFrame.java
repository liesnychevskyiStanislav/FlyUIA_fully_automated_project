package selenium_core.helpers.switch_helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium_core.helpers.logger_helper.LoggerHelper;

public class SwitchToFrame // This class will help us with frames to switch to.
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(selenium_core.helpers.switch_helper.SwitchToFrame.class);
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * Constructor for using the driver
     * @param driver
     */
    public SwitchToFrame(WebDriver driver)
    {
        log.info("FrameHelper constructor is created..");
        this.driver = driver;
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will switch to frame base on fame index
     * @param frameIndex
     */
    public void switchToFrame(int frameIndex)
    {
        driver.switchTo().frame(frameIndex);
        log.info("Switch to : " + frameIndex + " frame");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will switch frame based on name of frame
     * @param frameName
     */
    public void switchToFrame(String frameName)
    {
        driver.switchTo().frame(frameName);
        log.info("Switch to : " + frameName + " frame");
    }
    //----------------------------------------------------------------------------------------------------------------||
    /**
     * This method will switch frame based on WebElement of frame
     * @param element
     */
    public void switchToFrame(WebElement element)
    {
        driver.switchTo().frame(element);
        log.info("Switch to frame " + element.toString());
    }
    //----------------------------------------------------------------------------------------------------------------||
}
