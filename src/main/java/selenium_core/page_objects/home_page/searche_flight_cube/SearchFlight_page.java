package selenium_core.page_objects.home_page.searche_flight_cube;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium_core.helpers.assertion_helper.VerificationHelper;
import selenium_core.helpers.browser_configurations_helper.configurations.ObjectReader;
import selenium_core.helpers.logger_helper.LoggerHelper;
import selenium_core.helpers.wait_helper.WaitHelper;
import selenium_core.test_base.TestBase;

public class SearchFlight_page
{
    //----------------------------------------------------------------------------------------------------------------||
    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(SearchFlight_page.class);
    //----------------------------------------------------------------------------------------------------------------||
    WaitHelper waitHelper; // WaiteHelper object reference
    VerificationHelper verificationHelper = new VerificationHelper(driver);
    //----------------------------------------------------------------------------------------------------------------|| Locators
    @FindBy(xpath="//button[@id='SEARCH_WIDGET_FORM_BUTTONS_ROUND_TRIP']")
    WebElement ROUND_TRIP_button;

    @FindBy(xpath="//button[@id='SEARCH_WIDGET_FORM_BUTTONS_ONE_WAY']")
    WebElement ONE_WAY_button;

    @FindBy(xpath="//button[@id='SEARCH_WIDGET_FORM_BUTTONS_MULTICITY']")
    WebElement MULTICITY_button;

    @FindBy(xpath="//*[@id='SEARCH_WIDGET_FORM_INPUTS_DEPARTURE']/div/div[2]/input")
    WebElement DEPARTURE_field;

    @FindBy(xpath="//*[@id='SEARCH_WIDGET_FORM_INPUTS_ARRIVAL']/div/div[2]/input")
    WebElement ARRIVAL_field;

    @FindBy(xpath="//*[@id='1']/div/sw-root/sw-search-flights/div[2]/form/div[3]/div[1]/sw-form-control-datepicker/div[1]/div[2]/div")
    WebElement departure_home_date_datepicker_button;

    @FindBy(xpath="//*[@id='1']/div/sw-root/sw-search-flights/div[2]/form/div[3]/div[1]/sw-form-control-datepicker[2]/div[1]/div[2]/div")
    WebElement departure_guest_date_datepicker_button;

    @FindBy(xpath="//*[@id='1']/div/sw-root/sw-search-flights/div[2]/form/div[4]/div[1]/sw-form-control-passengers/div[1]/div[2]/div")
    WebElement passengers_button_picker;

    @FindBy(xpath="//*[@id='1']/div/sw-root/sw-search-flights/div[2]/form/div[4]/div[1]/sw-form-control-container/div/div[2]/input")
    WebElement promo_code_field;

    @FindBy(xpath="//button[@id='SEARCH_WIDGET_FORM_BUTTONS_SEARCH_FLIGHTS']")
    WebElement SEARCH_FLIGHT_button;

    @FindBy(xpath="/html/body/header/nav/div/div[1]/div[1]/a[1]/img")
    WebElement homeButton;

    @FindBy(xpath="/html/body/div[1]/div/div/div/div/a")
    WebElement AGREE_button;

    @FindBy(xpath="/html/body/header/div/div[1]/i")
    WebElement ENTRANCE_OF_FOREIGNERS_TO_UKRAINE_IS_PERMITTED_close_button;

    @FindBy(xpath="/html/body/div[3]/div/div/div[1]/span")
    WebElement banner_Subscribe_to_special_offers_close_button;

    @FindBy(xpath="/html/body/div[3]/div/div")
    WebElement Subscribe_to_special_offers_modal_content;

    @FindBy(xpath="")
    WebElement po;

    @FindBy(xpath="")
    WebElement op;
    //----------------------------------------------------------------------------------------------------------------|| Constructor
    public SearchFlight_page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Elements of page are read
        waitHelper = new WaitHelper(driver); // Waite driver is started
        waitHelper.waitForElement(homeButton, ObjectReader.reader.getExplicitWait()); // Waite page is loaded

        //new TestBase().getNavigationScreen(driver); // Capture screenshot every navigated screen
        logExtentReport("Login Page Object Created"); // Log to report Extent
    }
    //----------------------------------------------------------------------------------------------------------------|| Methods
    public void clickOnRoundTripButton()
    {
        if(verificationHelper.isDisplayed(ROUND_TRIP_button))
        {
            ROUND_TRIP_button.click();
        }
        else
        {
            verificationHelper.isNotDisplayed(ROUND_TRIP_button);
        }

        log.info("clicked on " +ROUND_TRIP_button.getText()+ " button.");
        logExtentReport("clicked on ROUND-TRIP button...");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnAgreeButton()
    {
        if(verificationHelper.isDisplayed(AGREE_button))
        {
            AGREE_button.click();
        }
        else
        {
            verificationHelper.isNotDisplayed(AGREE_button);
        }

        log.info("clicked on " +AGREE_button.getText()+ " button.");
        logExtentReport("clicked on AGREE button button...");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnENTRANCE_OF_FOREIGNERS_TO_UKRAINE_IS_PERMITTED_close_Button()
    {
        ENTRANCE_OF_FOREIGNERS_TO_UKRAINE_IS_PERMITTED_close_button.click();

        log.info("clicked on " +ENTRANCE_OF_FOREIGNERS_TO_UKRAINE_IS_PERMITTED_close_button.getText()+ " button");
        logExtentReport("clicked on ENTRANCE OF FOREIGNERS TO UKRAINE_IS PERMITTED close button...");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnBanner_Subscribe_to_special_offers_close_button()
    {
        if(verificationHelper.isDisplayed(banner_Subscribe_to_special_offers_close_button))
        {
            banner_Subscribe_to_special_offers_close_button.click();
        }
        else
        {
            verificationHelper.isNotDisplayed(banner_Subscribe_to_special_offers_close_button);
        }

        log.info("clicked on " +banner_Subscribe_to_special_offers_close_button.getText()+ " button.");
        logExtentReport("clicked on banner_Subscribe_to_special_offers_close button...");
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void enterDeparturePoint(String departureCity)
    {

        if( DEPARTURE_field.isDisplayed())
        {
            DEPARTURE_field.sendKeys(departureCity);
        }
        log.info("entering the departure point.... "+departureCity);
        logExtentReport(" entering the departure point.... "+departureCity);
    }
    //----------------------------------------------------------------------------------------------------------------||
    public void enterArrivalPoint(String arrivalCity)
    {
        if( ARRIVAL_field.isDisplayed())
        {
            ARRIVAL_field.sendKeys(arrivalCity);
        }
        log.info("entering arrival city.... "+arrivalCity);
        logExtentReport("entering arrival city .... "+arrivalCity);
    }
    // It requires Development
    //----------------------------------------------------------------------------------------------------------------||
//    public HomePage clickOnSubmitButton()
//    {
//        log.info("clicking on submit button...");
//        logExtentReport("clicking on submit button...");
//        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
//        javaScriptHelper.scrollDownVertically();
//        new JavaScriptHelper(driver).scrollDownVertically();
//        SEARCH_FLIGHT_button.click();
//        return new HomePage(driver);
//    }
    //----------------------------------------------------------------------------------------------------------------||
    public void clickOnSearchFlightsButton()
    {
        if( SEARCH_FLIGHT_button.isEnabled())
        {
            SEARCH_FLIGHT_button.click();
        }
        log.info(SEARCH_FLIGHT_button.getText()+" button clicked");
        logExtentReport(SEARCH_FLIGHT_button.getText()+" button clicked");

    }
    //----------------------------------------------------------------------------------------------------------------||
    //It requires Development
    //----------------------------------------------------------------------------------------------------------------||
//    public boolean verifySuccessLoginMsg()
//    {
//        return new VerificationHelper(driver).isDisplayed(successMsgObject);
//    }
    //----------------------------------------------------------------------------------------------------------------||
//    public void enterRegistrationEmail()
//    {
//        String email = System.currentTimeMillis()+"@gmail.com";
//        log.info("entering registration email.."+email);
//        registrationEmailAddress.sendKeys(email);
//    }
    //----------------------------------------------------------------------------------------------------------------||
//    public RegistrationPage clickOnCreateAnAccount()
//    {
//        createAnAccountButton.click();
//        return new RegistrationPage(driver);
//    }
    //----------------------------------------------------------------------------------------------------------------||
    public void roundTripSearchFlights(String departureFrom, String arrivalTo) throws InterruptedException
    {
        clickOnAgreeButton();
        Thread.sleep(10000);
        clickOnBanner_Subscribe_to_special_offers_close_button();
        Thread.sleep(10000);
        clickOnENTRANCE_OF_FOREIGNERS_TO_UKRAINE_IS_PERMITTED_close_Button();
        Thread.sleep(10000);
        clickOnRoundTripButton();
        Thread.sleep(10000);
        enterDeparturePoint(departureFrom);
        Thread.sleep(10000);
        enterArrivalPoint(arrivalTo);
        Thread.sleep(10000);
        //enter departure date to visit the country
        //enter departure date from the visit country
        //enter amount of passengers
        //enter promo-code
        clickOnSearchFlightsButton();
    }

    public void oneWeyTripSearchFlights(String departureFrom, String arrivalTo)
    {
        //click one-way button

        enterDeparturePoint(departureFrom);
        enterArrivalPoint(arrivalTo);

        //enter departure date to visit the country

        //enter amount of passengers
        //enter promo-code

        clickOnSearchFlightsButton();
    }

    public void multiCityTripSearchFlights(String departureFrom, String arrivalTo)
    {
        //click multi city  button

        enterDeparturePoint(departureFrom);
        enterArrivalPoint(arrivalTo);

        //enter departure date to visit the country
        //enter departure date from the visit country

        //enter amount of passengers
        //enter promo-code

        clickOnSearchFlightsButton();
    }
    //----------------------------------------------------------------------------------------------------------------||
//    public void logout()
//    {
//        logout.click();
//        log.info("clicked on logout link");
//        waitHelper.waitForElementClickable(sign_in, ObjectReader.reader.getExplicitWait());
//    }
    //----------------------------------------------------------------------------------------------------------------||
    // Method for this class exactly
    public void logExtentReport(String s1)
    {
        TestBase.test.log(Status.INFO, s1);
    }
    //----------------------------------------------------------------------------------------------------------------||
}
