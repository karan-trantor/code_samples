Feature: Verify OTC tasks
  Create office 365 events using microsoft EWS APIs and verify timeline items response

  Background: 
    Given I clean users events
    And I clean users tasks

  @ap_events2
  Scenario Outline: Verify timeline API Event created using EWS
    And I create a event with following details
      | task_subject | body   | start_date   | end_date   | category   |
      | <subject>    | <body> | <start_date> | <end_date> | <category> |
    And I can see following details in get time line items API response
      | req_type   | req_startIndex   | req_limit   | req_userId   | req_status | task_subject | body   | start_date   | end_date   | categories |
      | <req_type> | <req_startIndex> | <req_limit> | <req_userId> |            | <subject>    | <body> | <start_date> | <end_date> | <category> |

    Examples: 
      | subject                                           | body                 | start_date | end_date   | category            | req_type | req_startIndex | req_limit | req_userId | req_status |
      | Verify AP event created with today start date     | this is a test event | ${today}   | ${today}+1 | Publicity           | Event    |              0 |        10 | ${userId}  |            |
      | Verify AP event created with tomorrow start date  | this is a test event | ${today}+1 | ${today}+1 | Publicity           | Event    |              0 |        10 | ${userId}  |            |
      | Verify AP event created with past start date      | this is a test event | ${today}-1 | ${today}-1 | Publicity           | Event    |              0 |        10 | ${userId}  |            |
      | Verify AP Event with category Publicity           | this is a test event | ${today}   | ${today}+1 | Publicity           | Event    |              0 |        10 | ${userId}  |            |
      | Verify AP Event with category Marketing           | this is a test event | ${today}   | ${today}+1 | Marketing           | Event    |              0 |        10 | ${userId}  |            |
      | Verify AP Event with category multiple categories | this is a test event | ${today}   | ${today}+1 | Publicity,Marketing | Event    |              0 |        10 | ${userId}  |            |

      