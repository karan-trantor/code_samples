$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("verify_ap_tasks2.feature");
formatter.feature({
  "line": 1,
  "name": "Verify AP tasks",
  "description": "Create office 365 tasks using microsoft EWS APIs and verify timeline items response",
  "id": "verify-ap-tasks",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Verify timeline API Tasks created using EWS",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@ap_tasks2"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I create a task with following details",
  "rows": [
    {
      "cells": [
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "\u003csubject\u003e",
        "\u003cbody\u003e",
        "\u003cstart_date\u003e",
        "\u003cdue_date\u003e",
        "\u003cstatus\u003e"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see following details in get time line items API response",
  "rows": [
    {
      "cells": [
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status",
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 13
    },
    {
      "cells": [
        "\u003creq_type\u003e",
        "\u003creq_startIndex\u003e",
        "\u003creq_limit\u003e",
        "\u003creq_userId\u003e",
        "\u003creq_status\u003e",
        "\u003csubject\u003e",
        "\u003cbody\u003e",
        "\u003cstart_date\u003e",
        "\u003cdue_date\u003e",
        "\u003cstatus\u003e"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;",
  "rows": [
    {
      "cells": [
        "subject",
        "body",
        "start_date",
        "due_date",
        "status",
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status"
      ],
      "line": 17,
      "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;1"
    },
    {
      "cells": [
        "Verify AP Tasks with status inProgress",
        "this is a test task",
        "${today}+1",
        "${today}+2",
        "InProgress",
        "Task",
        "0",
        "20",
        "${userId}",
        ""
      ],
      "line": 18,
      "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;2"
    },
    {
      "cells": [
        "Verify AP Tasks with status completed",
        "this is a test task",
        "${today}",
        "${today}",
        "Completed",
        "Task",
        "0",
        "20",
        "${userId}",
        ""
      ],
      "line": 19,
      "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;3"
    },
    {
      "cells": [
        "Verify AP Tasks with due date 1 year later",
        "this is a test task",
        "${today}",
        "${today}+365",
        "Completed",
        "Task",
        "0",
        "20",
        "${userId}",
        ""
      ],
      "line": 20,
      "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;4"
    },
    {
      "cells": [
        "Verify AP Tasks with due date past",
        "this is a test task",
        "${today}-2",
        "${today}-2",
        "Completed",
        "Task",
        "0",
        "20",
        "${userId}",
        ""
      ],
      "line": 21,
      "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;5"
    },
    {
      "cells": [
        "Verify OTC Tasks response with no request type",
        "this is a test task",
        "${today}",
        "${today}",
        "Completed",
        "",
        "0",
        "20",
        "${userId}",
        ""
      ],
      "line": 22,
      "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I clean users tasks",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateTasks.i_clean_users_tasks()"
});
formatter.result({
  "duration": 3192559246,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Verify timeline API Tasks created using EWS",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@ap_tasks2"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I create a task with following details",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "Verify AP Tasks with status inProgress",
        "this is a test task",
        "${today}+1",
        "${today}+2",
        "InProgress"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see following details in get time line items API response",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status",
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 13
    },
    {
      "cells": [
        "Task",
        "0",
        "20",
        "${userId}",
        "",
        "Verify AP Tasks with status inProgress",
        "this is a test task",
        "${today}+1",
        "${today}+2",
        "InProgress"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateTasks.i_create_a_task_with_following_details(DataTable)"
});
formatter.result({
  "duration": 872048268,
  "status": "passed"
});
formatter.match({
  "location": "CreateTasks.i_can_see_following_details_in_get_time_line_items__API_response(DataTable)"
});
formatter.result({
  "duration": 31845065622,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I clean users tasks",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateTasks.i_clean_users_tasks()"
});
formatter.result({
  "duration": 2839316415,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify timeline API Tasks created using EWS",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@ap_tasks2"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I create a task with following details",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "Verify AP Tasks with status completed",
        "this is a test task",
        "${today}",
        "${today}",
        "Completed"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see following details in get time line items API response",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status",
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 13
    },
    {
      "cells": [
        "Task",
        "0",
        "20",
        "${userId}",
        "",
        "Verify AP Tasks with status completed",
        "this is a test task",
        "${today}",
        "${today}",
        "Completed"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateTasks.i_create_a_task_with_following_details(DataTable)"
});
formatter.result({
  "duration": 1232949867,
  "status": "passed"
});
formatter.match({
  "location": "CreateTasks.i_can_see_following_details_in_get_time_line_items__API_response(DataTable)"
});
formatter.result({
  "duration": 31466641786,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I clean users tasks",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateTasks.i_clean_users_tasks()"
});
formatter.result({
  "duration": 3029859115,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Verify timeline API Tasks created using EWS",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@ap_tasks2"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I create a task with following details",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "Verify AP Tasks with due date 1 year later",
        "this is a test task",
        "${today}",
        "${today}+365",
        "Completed"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see following details in get time line items API response",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status",
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 13
    },
    {
      "cells": [
        "Task",
        "0",
        "20",
        "${userId}",
        "",
        "Verify AP Tasks with due date 1 year later",
        "this is a test task",
        "${today}",
        "${today}+365",
        "Completed"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateTasks.i_create_a_task_with_following_details(DataTable)"
});
formatter.result({
  "duration": 1360672389,
  "status": "passed"
});
formatter.match({
  "location": "CreateTasks.i_can_see_following_details_in_get_time_line_items__API_response(DataTable)"
});
formatter.result({
  "duration": 31728026684,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I clean users tasks",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateTasks.i_clean_users_tasks()"
});
formatter.result({
  "duration": 1042002239,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Verify timeline API Tasks created using EWS",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@ap_tasks2"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I create a task with following details",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "Verify AP Tasks with due date past",
        "this is a test task",
        "${today}-2",
        "${today}-2",
        "Completed"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see following details in get time line items API response",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status",
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 13
    },
    {
      "cells": [
        "Task",
        "0",
        "20",
        "${userId}",
        "",
        "Verify AP Tasks with due date past",
        "this is a test task",
        "${today}-2",
        "${today}-2",
        "Completed"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateTasks.i_create_a_task_with_following_details(DataTable)"
});
formatter.result({
  "duration": 1866445544,
  "status": "passed"
});
formatter.match({
  "location": "CreateTasks.i_can_see_following_details_in_get_time_line_items__API_response(DataTable)"
});
formatter.result({
  "duration": 31472997761,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I clean users tasks",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateTasks.i_clean_users_tasks()"
});
formatter.result({
  "duration": 2452562668,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Verify timeline API Tasks created using EWS",
  "description": "",
  "id": "verify-ap-tasks;verify-timeline-api-tasks-created-using-ews;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@ap_tasks2"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I create a task with following details",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "rows": [
    {
      "cells": [
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "Verify OTC Tasks response with no request type",
        "this is a test task",
        "${today}",
        "${today}",
        "Completed"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I can see following details in get time line items API response",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "rows": [
    {
      "cells": [
        "req_type",
        "req_startIndex",
        "req_limit",
        "req_userId",
        "req_status",
        "task_subject",
        "body",
        "start_date",
        "due_date",
        "status"
      ],
      "line": 13
    },
    {
      "cells": [
        "",
        "0",
        "20",
        "${userId}",
        "",
        "Verify OTC Tasks response with no request type",
        "this is a test task",
        "${today}",
        "${today}",
        "Completed"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateTasks.i_create_a_task_with_following_details(DataTable)"
});
formatter.result({
  "duration": 902360515,
  "status": "passed"
});
formatter.match({
  "location": "CreateTasks.i_can_see_following_details_in_get_time_line_items__API_response(DataTable)"
});
formatter.result({
  "duration": 32752822044,
  "status": "passed"
});
});