package test_scripts_cases.real_tests;

import org.testng.annotations.Test;
import selenium_core.helpers.assertion_helper.AssertionHelper;
import selenium_core.helpers.browser_configurations_helper.configurations.ObjectReader;
import selenium_core.page_objects.home_page.searche_flight_cube.SearchFlight_page;
import selenium_core.test_base.TestBase;

public class SearchFlightTest extends TestBase
{
    @Test(description = "Search flight test")
    public void searchFlight() throws Exception
    {
        getApplicationUrl(ObjectReader.reader.getApplicationUrl());
        SearchFlight_page searchFlightPage = new SearchFlight_page(driver);
        searchFlightPage.roundTripSearchFlights("Tel Aviv", "Kharkiv");
        Thread.sleep(10000);
        //boolean status =
        // AssertionHelper.updateTestStatus(status);

    }
}
