@ap_events
Feature: Verify OTC tasks
  Create office 365 tasks using microsoft EWS APIs and verify timeline items response

  Background: 
    Given I clean users tasks

  Scenario: Verify AP Tasks with status inProgress
    And I create a task with following details
      | task_subject                              | body                | start_date | due_date   | status     |
      | Verify OTC Tasks with status inProgress-2 | this is a test task | ${today}+1 | ${today}+2 | InProgress |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                              | body                | start_date | due_date   | status     |
      | Task     |              0 |        50 | ${userId}  |            | Verify OTC Tasks with status inProgress-2 | this is a test task | ${today}+1 | ${today}+2 | InProgress |

  Scenario: Verify AP Tasks with status completed
    And I create a task with following details
      | task_subject                           | body                | start_date | due_date   | status    |
      | Verify OTC Tasks with status completed | this is a test task | ${today}-3 | ${today}-1 | completed |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                           | body                | start_date | due_date   | status    |
      | Task     |              0 |        20 | ${userId}  | Completed  | Verify OTC Tasks with status completed | this is a test task | ${today}-3 | ${today}-1 | Completed |

  Scenario: Verify AP Tasks with due date 1 year later
    And I create a task with following details
      | task_subject                                | body                | start_date   | due_date     | status     |
      | Verify OTC Tasks with due date 1 year later | this is a test task | ${today}+365 | ${today}+365 | InProgress |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                                | body                | start_date   | due_date     | status     |
      | Task     |              0 |        20 | ${userId}  | InProgress | Verify OTC Tasks with due date 1 year later | this is a test task | ${today}+365 | ${today}+365 | InProgress |

  Scenario: Verify AP Tasks response with no request type
    And I create a task with following details
      | task_subject                                   | body                | start_date | due_date | status     |
      | Verify OTC Tasks response with no request type | this is a test task | ${today}   | ${today} | InProgress |
    And I can see following details in get time line items API response
      | req_type | req_startIndex | req_limit | req_userId | req_status | task_subject                                   | body                | start_date | due_date | status     |
      |          |              0 |        60 | ${userId}  | InProgress | Verify OTC Tasks response with no request type | this is a test task | ${today}   | ${today} | InProgress |
