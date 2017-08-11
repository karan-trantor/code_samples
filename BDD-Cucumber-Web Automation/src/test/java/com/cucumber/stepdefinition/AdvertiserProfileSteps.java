package com.cucumber.stepdefinition;

import org.openqa.selenium.WebDriver;

import adbeat.qa.automation.AdvertiserProfilePage;
import adbeat.qa.automation.Base;
import adbeat.qa.automation.HomePage;
import cucumber.api.java.en.And;

public class AdvertiserProfileSteps{
	//static WebDriver driver=new Base().getDriver();
	
	
	
	@And("^I click on 'view ad' button for \"([^\"]*)\" search drop down at advertiser profile page$")
	public void click_view_ad_button_at_advertiser_profile_page(String searchString) throws Throwable {
		AdvertiserProfilePage advertiserProfilePage = new AdvertiserProfilePage(Base.driver);
		advertiserProfilePage.clickViewAdButton(searchString);

	}
	
	@And("^I click on 'view profile' button for \"([^\"]*)\" search drop down at advertiser profile page$")
	public void click_view_profile_button_at_advertiser_profile_page(String searchString) throws Throwable {
		AdvertiserProfilePage advertiserProfilePage = new AdvertiserProfilePage(Base.driver);
		advertiserProfilePage.clickViewProfileButton(searchString);
	}
	
	@And("^I type \"([^\"]*)\" in search box at advertiser profile page$")
	public void I_type_in_search_box_title_at_advertiser_profile_page(String arg1) throws Throwable {
		AdvertiserProfilePage advertiserProfilePage = new AdvertiserProfilePage(Base.driver);
		advertiserProfilePage.typeInSearchTextBox(arg1);

	}
	
	@And("^I click ?('Search for Ads'|'Adbeat Locker'|'Advertiser Profile'|'Publisher Profile'|'Advertising Trends'|'Get More') link at advertiser profile page$")
	public void click_link_at_advertiser_profile_page(String clickLink) throws Throwable {
		AdvertiserProfilePage advertiserProfilePage = new AdvertiserProfilePage(Base.driver);
		advertiserProfilePage.clickSearchForAdlink(clickLink);
	}

}
