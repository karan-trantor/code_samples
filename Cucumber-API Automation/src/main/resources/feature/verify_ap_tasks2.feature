Feature: Verify AP tasks
  Create office 365 tasks using microsoft EWS APIs and verify timeline items response

  Background: 
    Given I clean users tasks

  @ap_tasks2
  Scenario Outline: Verify timeline API Tasks created using EWS
    And I create a task with following details
      | task_subject | body   | start_date   | due_date   | status   |
      | <subject>    | <body> | <start_date> | <due_date> | <status> |
    And I can see following details in get time line items API response
      | req_type   | req_startIndex   | req_limit   | req_userId   | req_status   | task_subject | body   | start_date   | due_date   | status   |
      | <req_type> | <req_startIndex> | <req_limit> | <req_userId> | <req_status> | <subject>    | <body> | <start_date> | <due_date> | <status> |

    Examples: 
      | subject                                        | body                | start_date | due_date     | status     | req_type | req_startIndex | req_limit | req_userId | req_status |
      | Verify AP Tasks with status inProgress         | this is a test task | ${today}+1 | ${today}+2   | InProgress | Task     |              0 |        20 | ${userId}  |            |
      | Verify AP Tasks with status completed          | this is a test task | ${today}   | ${today}     | Completed  | Task     |              0 |        20 | ${userId}  |            |
      | Verify AP Tasks with due date 1 year later     | this is a test task | ${today}   | ${today}+365 | Completed  | Task     |              0 |        20 | ${userId}  |            |
      | Verify AP Tasks with due date past             | this is a test task | ${today}-2 | ${today}-2   | Completed  | Task     |              0 |        20 | ${userId}  |            |
      | Verify AP Tasks response with no request type | this is a test task | ${today}   | ${today}     | Completed  |          |              0 |        20 | ${userId}  |            |
