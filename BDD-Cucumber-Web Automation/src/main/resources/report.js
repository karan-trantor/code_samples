$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/cucumber/feature/homepage_validations.feature");
formatter.feature({
  "line": 2,
  "name": "adbeat UI test",
  "description": "",
  "id": "adbeat-ui-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@test"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Verify adbeat header locators",
  "description": "",
  "id": "adbeat-ui-test;verify-adbeat-header-locators",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I launch adbeat url",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I can see \"Adbeat :: Home\" as url title",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I can see adbeat logo at home page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I can see adbeat basic link at home page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I can see adbeat Pro link at home page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I can see log in link at home page",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I can see sign up button at home page",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see live demo button at home page",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.I_launch_adbeat_url()"
});
formatter.result({
  "duration": 22429379067,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Adbeat :: Home",
      "offset": 11
    }
  ],
  "location": "HomePageSteps.I_can_see_as_url_title(String)"
});
formatter.result({
  "duration": 9783008,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_logo_on_homepage()"
});
formatter.result({
  "duration": 42722286,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_adbeat_basic_link_homepage()"
});
formatter.result({
  "duration": 45782275,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_adbeat_pro_link_homepage()"
});
formatter.result({
  "duration": 40000672,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_log_in_link_homepage()"
});
formatter.result({
  "duration": 40636369,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_sign_up_button_homepage()"
});
formatter.result({
  "duration": 38468656,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_live_demo_button_homepage()"
});
formatter.result({
  "duration": 34781990,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.I_close_browser()"
});
formatter.result({
  "duration": 737013241,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify search text box",
  "description": "",
  "id": "adbeat-ui-test;verify-search-text-box",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "I launch adbeat url",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I can see search text box at home page",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I cannot see smart search dropdown at home page",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I type \"mobile\" in search box at home page",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I can see smart search dropdown at home page",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.I_launch_adbeat_url()"
});
formatter.result({
  "duration": 14694257055,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.can_see_search_text_box_homepage()"
});
formatter.result({
  "duration": 38974974,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cannot",
      "offset": 2
    }
  ],
  "location": "HomePageSteps.can_see_smart_search_pop_up_homepage(String)"
});
formatter.result({
  "duration": 5014447166,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mobile",
      "offset": 8
    }
  ],
  "location": "HomePageSteps.I_type_insearch_box_title(String)"
});
formatter.result({
  "duration": 101550957,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "can",
      "offset": 2
    }
  ],
  "location": "HomePageSteps.can_see_smart_search_pop_up_homepage(String)"
});
formatter.result({
  "duration": 1316526771,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.I_close_browser()"
});
formatter.result({
  "duration": 579876164,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Verify advertisers list",
  "description": "",
  "id": "adbeat-ui-test;verify-advertisers-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "I launch adbeat url",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I can see following cards present on carousel list",
  "rows": [
    {
      "cells": [
        "Sling TV"
      ],
      "line": 27
    },
    {
      "cells": [
        "Amazon"
      ],
      "line": 28
    },
    {
      "cells": [
        "Fidelity Investments"
      ],
      "line": 29
    },
    {
      "cells": [
        "Jet"
      ],
      "line": 30
    },
    {
      "cells": [
        "LowerMyBills.com"
      ],
      "line": 31
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.I_launch_adbeat_url()"
});
formatter.result({
  "duration": 15725429507,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.i_can_see_following_cards_present_on_carousel_list(DataTable)"
});
formatter.result({
  "duration": 2134020926,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.I_close_browser()"
});
formatter.result({
  "duration": 629732618,
  "status": "passed"
});
});