@regression
Feature: adbeat UI positioning test

  Background: 
    Given I launch adbeat url

  @search
  Scenario Outline: Verify adbeat ad page graphs from advertiser profile screen
    When I type "<ad_name>" in search box at home page
    Then I can see smart search dropdown at home page
    And I click on 'view profile' button for "<ad_name>" search drop down at home page
    And I click 'Search for Ads' link at advertiser profile page
    And I can see 'ad divs graphs' for "<ad_name>" at ads page

    Examples: 
      | ad_name             |
      | sling.com           |
      | jet.com             |
      | amazon.com          |
      | americanexpress.com |

# Scenario: Verify adbeat ad page graphs
#   When I type "drfirst.com" in search box at home page
#   Then I can see smart search dropdown at home page
#   And I click on 'view ad' button for "drfirst.com" search drop down at home page
#   And I can see 'ad divs graphs' for "drfirst.com" at ads page
#
#Scenario Outline: Verify adbeat ad page graphs from advertiser profile screen
#   When I type "<ad_name>" in search box at home page
#   Then I can see smart search dropdown at home page
#   And I click on 'view profile' button for "<ad_name>" search drop down at home page
#   And I click 'Search for Ads' link at advertiser profile page
#   And I can see 'ad divs graphs' for "<ad_name>" at ads page
#
#   Examples: 
#     | ad_name             |
#     | sling.com           |
#     | jet.com             |
#     | amazon.com          |
#     | americanexpress.com |
#