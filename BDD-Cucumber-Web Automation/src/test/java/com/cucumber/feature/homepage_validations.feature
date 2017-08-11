@regression
Feature: adbeat UI test

  @header @static
  Scenario: Verify adbeat header locators
    Given I launch adbeat url
    And I can see "Adbeat :: Home" as url title
    And I can see adbeat logo at home page
    And I can see adbeat basic link at home page
    And I can see adbeat Pro link at home page
    And I can see log in link at home page
    And I can see sign up button at home page
    And I can see live demo button at home page
    And I close the browser

  @smoke 
  Scenario: Verify search text box behaviour
    Given I launch adbeat url
    And I can see search text box at home page
    And I cannot see smart search dropdown at home page
    When I type "mobile" in search box at home page
    Then I can see smart search dropdown at home page
    And I close the browser

  
  Scenario: Verify advertisers list cards
    Given I launch adbeat url
    And I can see following 'Advertiser Cards' at home page
      | Sling TV             |
      | Amazon               |
      | Fidelity Investments |
      | Jet                  |
      | LowerMyBills.com     |
    And I close the browser

  @api @happy
  Scenario: Verify monthly spends on advertisers list cards
    Given I launch adbeat url
    And I can see following 'Advertiser Cards' and there monthly spend at home page
      | Sling TV             |
      | Amazon               |
      | Fidelity Investments |
      | Jet                  |
      | LowerMyBills.com     |
    And I close the browser

  
    