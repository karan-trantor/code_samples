package com.cucumber.stepdefinition;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import adbeat.api.automation.GetCardValues;
import adbeat.qa.automation.Base;
import adbeat.qa.automation.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import junit.framework.AssertionFailedError;

public class HomePageSteps{
	static WebDriver driver=new Base().getDriver();

	
	
	@And("^I launch adbeat url$")
	public void I_launch_adbeat_url() throws Throwable {
		Base b = new Base();
		driver = b.lauchUrl();
	}
	
	@And("^I close the browser$")
	public void I_close_browser() throws Throwable {
		//driver.quit();
	}

	@And("^I can see \"([^\"]*)\" as url title$")
	public void I_can_see_as_url_title(String arg1) throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.getTitle().equals(arg1)) {
			throw new AssertionFailedError(
					"Browser tile expected: " + arg1 + " does not macth with actual: " + homePage.getTitle());
		}

	}

	@And("^I can see adbeat logo at home page$")
	public void can_see_logo_on_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyLogoPresent()) {
			throw new AssertionFailedError("Logo image not present or changed");
		}
	}

	@And("^I can see adbeat basic link at home page$")
	public void can_see_adbeat_basic_link_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyadbeatBasicLink()) {
			throw new AssertionFailedError("Adbeat basic link not present");
		}
	}

	@And("^I can see adbeat Pro link at home page$")
	public void can_see_adbeat_pro_link_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyadbeatProLink()) {
			throw new AssertionFailedError("Adbeat pro link not present");
		}
	}

	@And("^I can see log in link at home page$")
	public void can_see_log_in_link_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyLoginLink()) {
			throw new AssertionFailedError("Adbeat login link not present");
		}
	}

	@And("^I can see sign up button at home page$")
	public void can_see_sign_up_button_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifySignUpButton()) {
			throw new AssertionFailedError("sign up button not present");
		}
	}

	@And("^I can see live demo button at home page$")
	public void can_see_live_demo_button_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifySeeLiveDemoButton()) {
			throw new AssertionFailedError("live demo button not present");
		}
	}

	@And("^I can see search text box at home page$")
	public void can_see_search_text_box_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifySearchTextBox()) {
			throw new AssertionFailedError("search text box not present");
		}
	}

	@And("^I type \"([^\"]*)\" in search box at home page$")
	public void I_type_insearch_box_title(String arg1) throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.typeInSearchTextBox(arg1);

	}

	@And("^I ?(|can|cannot) see smart search dropdown at home page$")
	public void can_see_smart_search_pop_up_homepage(String canOrCannot) throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (canOrCannot.equalsIgnoreCase("can")) {
			if (!homePage.verifySmartSearchpopUp()) {
				throw new AssertionFailedError("smart search popup not present");
			}
		}

		if (canOrCannot.equalsIgnoreCase("cannot")) {
			homePage.verifySmartSearchpopUpNotPresent();
		}

	}
	
	@And("^I click on 'view ad' button for \"([^\"]*)\" search drop down at home page$")
	public void click_view_ad_button_at_homepage(String searchString) throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickViewAdButton(searchString);

	}
	
	@And("^I click on 'view profile' button for \"([^\"]*)\" search drop down at home page$")
	public void click_view_profile_button_at_homepage(String searchString) throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickViewProfileButton(searchString);
	}

	@And("^I can see following 'Advertiser Cards' at home page$")
	public void i_can_see_following_cards_present_on_carousel_list(DataTable data) throws Throwable {
		List<String> expectedCards = data.asList(String.class);
		HomePage homePage = new HomePage(driver);
		List<String> actualcards = homePage.getCardValues();
		for (int i = 0; i < expectedCards.size(); i++) {
			if (!actualcards.contains(expectedCards.get(i))) {
				throw new AssertionFailedError(expectedCards.get(i) + " card not present not present");
			}
		}

	}

	@And("^I can see following 'Advertiser Cards' and there monthly spend at home page$")
	public void i_can_see_following_cards_And_monthly_spend_on_carousel_list(DataTable data) throws Throwable {
		List<String> expectedCards = data.asList(String.class);
		Map<String, String> expectedCardData = new HashMap<String, String>();
		for (int i = 0; i < expectedCards.size(); i++) {
			System.out.println("Expected Card data: " + expectedCards.get(i));
			System.out.println(
					"Expected Card value: " + new GetCardValues().parseCardValueObtainedFromApi(expectedCards.get(i)));

			expectedCardData.put(expectedCards.get(i),
					new GetCardValues().parseCardValueObtainedFromApi(expectedCards.get(i)));
		}
		HomePage homePage = new HomePage(driver);
		Map<String, String> actualCardData = homePage.getCardMonthlySpend();
		if (!expectedCardData.equals(actualCardData)) {
			throw new AssertionFailedError(
					"expectedCardData: " + expectedCardData + " does not equals actal: " + actualCardData);
		}
	}

	@And("^I can see 'advitisers' button at home page$")
	public void can_see_advertisers_button_at_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyAdvertisersButton()) {
			throw new AssertionFailedError("advitisers button not present");
		}
	}

	@And("^I can see 'agencies' button at home page$")
	public void can_see_agencies_button_at_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyAgenciesButton()) {
			throw new AssertionFailedError("agencies button not present");
		}
	}

	@And("^I can see 'Ad Networks & Publishers' button at home page$")
	public void can_see_ad_network_pub_button_at_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		if (!homePage.verifyAdNetworkPubButton()) {
			throw new AssertionFailedError("Ad Networks & Publishers button not present");
		}
	}

	@And("^I ?(|can|cannot) see ?('advitisers'|'agencies'|'Ad Networks & Publishers') image at home page$")
	public void can_see_custom_image_at_homepage(String canOrCannot, String customType) throws Throwable {
		HomePage homePage = new HomePage(driver);
		switch (customType) {
		case "'advitisers'":
			if (canOrCannot.equalsIgnoreCase("can")) {
				if (!homePage.verifyAdvertisersImage()) {
					throw new AssertionFailedError("advitisers image not present");
				}
			} else {
				if (homePage.verifyAdvertisersImage()) {
					throw new AssertionFailedError("advitisers image not present");
				}
			}
			break;

		case "'agencies'":
			if (canOrCannot.equalsIgnoreCase("can")) {
				if (!homePage.verifyAgenciesImage()) {
					throw new AssertionFailedError("agencies image not present");
				}
			} else {
				if (homePage.verifyAdvertisersImage()) {
					throw new AssertionFailedError("agencies image not present");
				}
			}
			break;

		case "'Ad Networks & Publishers'":
			if (canOrCannot.equalsIgnoreCase("can")) {
				if (!homePage.verifyAdNetworkAndPubImage()) {
					throw new AssertionFailedError("Ad Networks & Publishers image not present");
				}
			} else {
				if (homePage.verifyAdvertisersImage()) {
					throw new AssertionFailedError("Ad Networks & Publishers image not present");
				}
			}
			break;
		}

	}

	@And("^I can see following text under ?('advitisers'|'agencies'|'Ad Networks & Publishers') image at home page$")
	public void i_can_see_following_text_under_custom_tag_image_at_home_page(String customType, String expectedText)
			throws Throwable {
		HomePage homePage = new HomePage(driver);
		switch (customType) {
		case "'advitisers'":
			if (!homePage.getAdvertisersTextUnderImage().contains(expectedText)) {
				throw new AssertionFailedError(
						"Actual advitisers text under image: " + homePage.getAdvertisersTextUnderImage()
								+ " does not contains expected text: " + expectedText);
			}
			break;
		case "'agencies'":
			System.out.println("Actual Test:\n" + homePage.getAgenciesTextUnderImage());
			System.out.println("Expected Test:\n" + expectedText);
			if (!homePage.getAgenciesTextUnderImage().contains(expectedText)) {
				throw new AssertionFailedError("Actual agancies text under image: "
						+ homePage.getAgenciesTextUnderImage() + " does not contains expected text: " + expectedText);
			}
			break;
		case "'Ad Networks & Publishers'":
			if (!homePage.getAdNetworkAndPubTextUnderImage().contains(expectedText)) {
				throw new AssertionFailedError("Actual 'Ad Networks & Publishers' text under image: "
						+ homePage.getAdNetworkAndPubTextUnderImage() + " does not contains expected text: "
						+ expectedText);
			}
			break;
		}

	}

	@And("^I can see following header text adjacent to ?('advitisers'|'agencies'|'Ad Networks & Publishers') image at home page$")
	public void i_can_see_following_header_text_adjacent_custom_image_at_home_page(String customType,
			String expectedText) throws Throwable {
		HomePage homePage = new HomePage(driver);
		switch (customType) {
		case "'advitisers'":
			if (!homePage.getAdvertisersHeaderTextAdjacentToImage().contains(expectedText)) {
				throw new AssertionFailedError("Actual header advitisers text adjacent image: "
						+ homePage.getAdvertisersHeaderTextAdjacentToImage() + " does not contains expected text: "
						+ expectedText);
			}
			break;
		case "'agencies'":
			if (!homePage.getAgenciesHeaderTextAdjacentToImage().contains(expectedText)) {
				throw new AssertionFailedError(
						"Actual header agencies text adjacent image: " + homePage.getAgenciesHeaderTextAdjacentToImage()
								+ " does not contains expected text: " + expectedText);
			}
			break;
		case "'Ad Networks & Publishers'":
			if (!homePage.getAdNetworkAndPubHeaderTextAdjacentToImage().contains(expectedText)) {
				throw new AssertionFailedError("Actual header Ad Networks & Publishers text adjacent image: "
						+ homePage.getAdNetworkAndPubHeaderTextAdjacentToImage() + " does not contains expected text: "
						+ expectedText);
			}
			break;
		}

	}

	@And("^I can see following text adjacent to ?('advitisers'|'agencies'|'Ad Networks & Publishers') image at home page$")
	public void i_can_see_following_text_adjacent_custom_image_at_home_page(String customType, String expectedText) {
		HomePage homePage = new HomePage(driver);
		switch (customType) {
		case "'advitisers'":
			if (!homePage.getAdvertisersTextAdjacentToImage().contains(expectedText)) {
				throw new AssertionFailedError(
						"Actual advitisers text adjacent image: " + homePage.getAdvertisersTextAdjacentToImage()
								+ " does not contains expected text: " + expectedText);
			}
			break;
		case "'agencies'":
			if (!homePage.getAgenciesTextAdjacentToImage().contains(expectedText)) {
				throw new AssertionFailedError(
						"Actual agencies text adjacent image: " + homePage.getAgenciesTextAdjacentToImage()
								+ " does not contains expected text: " + expectedText);
			}
			break;
		case "'Ad Networks & Publishers'":
			if (!homePage.getAdNetworkAndPubTextAdjacentToImage().contains(expectedText)) {
				throw new AssertionFailedError("Actual Ad Networks & Publishers text adjacent image: "
						+ homePage.getAdNetworkAndPubTextAdjacentToImage() + " does not contains expected text: "
						+ expectedText);
			}
			break;
		}
	}

	@And("^I click on 'advitisers' button at home page$")
	public void click_advitisers_button_at_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickAdvertisersButton();
		;
	}

	@And("^I click on 'agencies' button at home page$")
	public void click_agencies_button_at_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickAgenciesButton();
	}

	@And("^I click on 'Ad Networks & Publishers' button at home page$")
	public void click_Ad_Networks_Publishers_button_at_homepage() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.clickAdNetworkAndPubButton();
	}

	
	//POSITIONING
	@And("^I can see adbeat ?('logo'|'basic link'|'pro link'|'login link'|'signup button'|'see live demo button'|'search box') with static position and size at home page$")
	public void can_see_logo_position_size_on_homepage(String element) throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.verifyElementPositionSizePresent(element);
	}

}