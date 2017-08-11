@regression @custom_tabs
Feature: Custom segment tabs

  Scenario: Verify customer segment tabs
    When I launch adbeat url
    And I can see 'advitisers' button at home page
    And I can see 'agencies' button at home page
    And I can see 'Ad Networks & Publishers' button at home page
    And I close the browser

  @test
   Scenario: Verify custom tag images
    When I launch adbeat url
    And I can see 'advitisers' image at home page
    And I click on 'agencies' button at home page
    And I can see 'agencies' image at home page
    And I click on 'Ad Networks & Publishers' button at home page
    And I can see 'Ad Networks & Publishers' image at home page
    And I click on 'advitisers' button at home page
    And I can see 'advitisers' image at home page
    And I close the browser

  Scenario: Verify default custom tag 'Advertisers' selected
    When I launch adbeat url
    And I can see 'advitisers' image at home page
    And I can see following text under 'advitisers' image at home page
      """
      A leader in secure file sharing, Box uses Adbeat to keep tabs on how competitors in their industry are using digital channels to get their message out. Adbeat helps Box to make smarter decisions about their own messaging and strategy.
      """
    And I can see following header text adjacent to 'advitisers' image at home page
      """
      Adbeat provides unparalleled insights into the complex world of digital advertising. It makes perfect sense that leading companies like Box, Ancestry, and Lending Tree use Adbeat.
      """
    And I can see following text adjacent to 'advitisers' image at home page
      """
      With Adbeat, advertisers can see what direct competitors are doing and how they're doing it. Besides just seeing ads and the messaging being used, we're also able to show you the sources of traffic including how the media was purchased and what publishers the ads were running on.
      
      As your business grows, Adbeat helps you spend your advertising dollars smarter.
      """
    And I close the browser

  Scenario: Verify custom tag 'Agencies' details
    When I launch adbeat url
    And I click on 'agencies' button at home page
    And I can see 'agencies' image at home page
    And I can see following text under 'agencies' image at home page
      """
      To help deliver on their core promise of being results and performance focused, full service digital agency IMM uses Adbeat to exceed their client's expectations by delivering near real-time insights into how and where their competitors are advertising online.
      """
    And I can see following header text adjacent to 'agencies' image at home page
      """
      Successful agencies use Adbeat to exceed client expectations and turn themselves into a more valuable partner.
      """
    And I can see following text adjacent to 'agencies' image at home page
      """
      With Adbeat, advertisers can see what direct competitors are doing and how they're doing it. Besides just seeing ads and the messaging being used, we're also able to show you the sources of traffic including how the media was purchased and what publishers the ads were running on.
      
      As your business grows, Adbeat helps you spend your advertising dollars smarter.
      """
    And I close the browser

  Scenario: Verify custom tag 'Ad Networks & Publishers' details
    When I launch adbeat url
    And I click on 'Ad Networks & Publishers' button at home page
    And I can see 'Ad Networks & Publishers' image at home page
    And I can see following text under 'Ad Networks & Publishers' image at home page
      """
      Ad network CPXi specializes in selling media to performance marketers. As they continue to expand, they use Adbeat to prospect for new advertisers and publishers. These new prospects help them sell more inventory and drive 
      """
    And I can see following header text adjacent to 'Ad Networks & Publishers' image at home page
      """
      Adbeat is built with publishers and ad networks in mind. For any given publisher, you'll see the ad networks they're using to sell inventory and advertisers that are buying it.
      """
    And I can see following text adjacent to 'Ad Networks & Publishers' image at home page
      """
      With Adbeat you're able to spot trends that are impossible to see any other way. Easily see when advertiser are increasing their spends on other networks and publishers. If you're an ad network, you'll appreciate how Adbeat can show you when competing networks add new strong publishers to their offerings.
      
      Adbeat lets you prospect for new revenue, smarter and more efficiently.
      """
    And I close the browser
