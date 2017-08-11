package stepDefinition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import microsoft.exchange.webservices.data.core.ExchangeService;
import outlook.main.ApiHandler;
import outlook.main.ExchangeServiceApiMainClass;
import outlook.main.TaskHandler;
import outlook.main.Utils;

public class CreateTasks extends ExchangeServiceApiMainClass {
	// private static ExchangeService service;

	@Given("^I clean users tasks$")
	public void i_clean_users_tasks() {
		new ExchangeServiceApiMainClass().deleteAllTasks(ExchangeServiceApiMainClass.service);
		System.out.println("ALL TASKS DELETED");

	}

	@Given("^I create a task with following details$")
	public void i_create_a_task_with_following_details(DataTable dataTable) {
		String taskSubject = null;
		String body = null;
		String startDate = null;
		String dueDate = null;
		String status = null;

		List<Map<String, String>> detailsList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> details : detailsList) {
			taskSubject = details.get("task_subject");
			body = details.get("body");
			startDate = ExchangeServiceApiMainClass.parseDate(details.get("start_date")) + " 12:00:00";
			// startDate = details.get("start_date");
			dueDate = ExchangeServiceApiMainClass.parseDate(details.get("due_date")) + " 14:00:00";
			status = details.get("status");
			if (status.equalsIgnoreCase("Completed")) {
				if ((new TaskHandler().createCompletedTask(taskSubject, body, startDate, dueDate))) {
					System.out.println("TASK CREATED WITH SUBJECT: " + taskSubject);
				} else {
					System.out.println("TASK NOT CREATED WITH SUBJECT: " + taskSubject);
				}
			} else if (status.equalsIgnoreCase("inProgress")) {
				if ((new TaskHandler().createOpenTask(taskSubject, body, startDate, dueDate))) {
					System.out.println("TASK CREATED WITH SUBJECT: " + taskSubject);
				} else {
					System.out.println("TASK NOT CREATED WITH SUBJECT: " + taskSubject);
				}
			}

		}

	}

	@Given("^I can see following details in get time line items API response$")
	public void i_can_see_following_details_in_get_time_line_items__API_response(DataTable dataTable) {
		String taskSubject = null;
		String body = null;
		String startDate = null;
		String endDate = null;
		String dueDate = null;
		String status = null;
		String categories = null;
		String req_type = null;
		String req_startIndex = null;
		String req_limit = null;
		String req_userId = null;
		String req_status = null;
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
		}

		List<Map<String, String>> detailsList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> details : detailsList) {
			req_type = details.get("req_type");
			req_startIndex = details.get("req_startIndex");
			req_limit = details.get("req_limit");
			req_userId = details.get("req_userId");
			if(req_userId.contains("${")){
				req_userId=Utils.readConfig("outlook_user_hbh_userId");
			}
			req_status = details.get("req_status");

			taskSubject = details.get("task_subject");
			body = details.get("body");
			startDate = ExchangeServiceApiMainClass.parseDate(details.get("start_date"));
			status = details.get("status");
			categories = details.get("categories");
			String jsonResponse = ApiHandler.getTimeLineItems(req_type, req_startIndex, "", req_limit, req_userId, "",
					req_status);
			System.out.println("BELOW IS THE JSON RESPONSE:\n" + jsonResponse + "\n");
			ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "subject", taskSubject);
			ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "body", body);
			ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "startDate", startDate);
			if(!(details.get("end_date")==null)){
				endDate = ExchangeServiceApiMainClass.parseDate(details.get("end_date"));
			ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "endDate", endDate);
			}
			if(!(details.get("due_date")==null)){
				dueDate = ExchangeServiceApiMainClass.parseDate(details.get("due_date"));
			ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "dueDate", dueDate);
			}
			if(!(status==null)){
				ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "status", status);
				
			}
			if(!(categories==null)){
				ApiHandler.verifyJsonElementPresentInTimeLineItems(jsonResponse, "categories", categories);
				
			}
		}

	}

}
