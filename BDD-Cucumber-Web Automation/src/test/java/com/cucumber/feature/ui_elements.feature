@regression 
Feature: adbeat UI positioning test

@header @uipositioning
  Scenario: Verify adbeat header locators positions and size
    Given I launch adbeat url
    And I can see adbeat 'logo' with static position and size at home page
    And I can see adbeat 'basic link' with static position and size at home page
    And I can see adbeat 'pro link' with static position and size at home page
    And I can see adbeat 'login link' with static position and size at home page
    And I can see adbeat 'signup button' with static position and size at home page
    And I can see adbeat 'see live demo button' with static position and size at home page
    
    
@searchbox @uipositioning
  Scenario: Verify adbeat search box locators positions and size
    Given I launch adbeat url
    And I can see adbeat 'search box' with static position and size at home page
   