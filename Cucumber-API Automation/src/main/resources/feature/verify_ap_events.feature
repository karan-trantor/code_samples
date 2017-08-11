@ap_events
Feature: Verify OTC tasks
  Create office 365 events using microsoft EWS APIs and verify timeline items response

  Background: 
    Given I clean users events

  Scenario: Verify AP Event with today start date
    And I create a event with following details
      | task_subject                                  | body                 | start_date | end_date   | category  |
      | Verify AP event created with today start date | this is a test event | ${today}   | ${today}+1 | Publicity |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                                  | body                 | start_date | end_date   | categories |
      | Event    |              0 |        50 | ${userId}  |            | Verify AP event created with today start date | this is a test event | ${today}   | ${today}+1 | Publicity  |

  Scenario: Verify AP Event with tomorrow start date
    And I create a event with following details
      | task_subject                                     | body                 | start_date | end_date   | category  |
      | Verify AP event created with tomorrow start date | this is a test event | ${today}+1 | ${today}+2 | Publicity |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                                     | body                 | start_date | end_date   | categories |
      | Event    |              0 |        50 | ${userId}  |            | Verify AP event created with tomorrow start date | this is a test event | ${today}+1 | ${today}+2 | Publicity  |

  Scenario: Verify AP Event with past start date
    And I create a event with following details
      | task_subject                                 | body                 | start_date | end_date   | category  |
      | Verify AP event created with past start date | this is a test event | ${today}-1 | ${today}-1 | Publicity |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                                 | body                 | start_date | end_date   | categories |
      | Event    |              0 |        50 | ${userId}  |            | Verify AP event created with past start date | this is a test event | ${today}-1 | ${today}-1 | Publicity  |

  Scenario: Verify AP Event with category Publicity
    And I create a event with following details
      | task_subject                            | body                 | start_date | end_date   | category  |
      | Verify AP Event with category Publicity | this is a test event | ${today}   | ${today}+1 | Publicity |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                            | body                 | start_date | end_date   | categories |
      | Event    |              0 |        50 | ${userId}  |            | Verify AP Event with category Publicity | this is a test event | ${today}   | ${today}+1 | Publicity  |

  Scenario: Verify AP Event with category Marketing
    And I create a event with following details
      | task_subject                            | body                 | start_date | end_date   | category  |
      | Verify AP Event with category Marketing | this is a test event | ${today}   | ${today}+1 | Marketing |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                            | body                 | start_date | end_date   | categories |
      | Event    |              0 |        50 | ${userId}  |            | Verify AP Event with category Marketing | this is a test event | ${today}   | ${today}+1 | Marketing  |

  Scenario: Verify AP Event with category multiple categories
    And I create a event with following details
      | task_subject                                      | body                 | start_date | end_date   | category            |
      | Verify AP Event with category multiple categories | this is a test event | ${today}   | ${today}+1 | Publicity,Marketing |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                                      | body                 | start_date | end_date   | categories          |
      | Event    |              0 |        50 | ${userId}  |            | Verify AP Event with category multiple categories | this is a test event | ${today}   | ${today}+1 | Publicity,Marketing |
