package com.cucumber.stepdefinition;

import org.openqa.selenium.WebDriver;

import adbeat.qa.automation.AdPage;
import adbeat.qa.automation.Base;
import adbeat.qa.automation.HomePage;
import cucumber.api.java.en.And;
import junit.framework.AssertionFailedError;

public class AdsPageSteps {
		static WebDriver driver=new Base().getDriver();
		
		
		@And("^I ?(|can|cannot) see 'ad divs graphs' for \"([^\"]*)\" at ads page$")
		public void can_see_smart_search_pop_up_homepage(String canOrCannot, String searchString) throws Throwable {
			AdPage adsPage = new AdPage(Base.driver);
			if (canOrCannot.equalsIgnoreCase("can")) {
				if (!adsPage.verifySearchAdsGraphPresent(searchString)) {
					throw new AssertionFailedError("ads are not visible where expected ads should be visible");
				}
			}

			if (canOrCannot.equalsIgnoreCase("cannot")) {
				if (adsPage.verifySearchAdsGraphPresent(searchString)) {
					throw new AssertionFailedError("ads are visible where expeceted ads should not be visible");
				}
			}

		}

}
