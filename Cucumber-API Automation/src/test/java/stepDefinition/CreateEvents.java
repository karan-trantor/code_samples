package stepDefinition;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import outlook.main.EventHandler;
import outlook.main.ExchangeServiceApiMainClass;

public class CreateEvents {
	@Given("^I clean users events$")
	public void i_clean_users_events() {
		new ExchangeServiceApiMainClass().deleteAllAppoinitments(ExchangeServiceApiMainClass.service);
		System.out.println("ALL TASKS DELETED");

	}

	@Given("^I create a event with following details$")
	public void i_create_a_task_with_following_details(DataTable dataTable) {
		String taskSubject = null;
		String body = null;
		String startDate = null;
		String endDate = null;
		String category = null;

		List<Map<String, String>> detailsList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> details : detailsList) {
			taskSubject = details.get("task_subject");
			body = details.get("body");
			startDate = ExchangeServiceApiMainClass.parseDate(details.get("start_date")) + " 12:00:00";
			endDate = ExchangeServiceApiMainClass.parseDate(details.get("end_date")) + " 14:00:00";
			category=details.get("category");
			String[] splittedCategories=category.split(",");
			
			if ((new EventHandler().createAppointment(taskSubject, body, startDate, endDate, splittedCategories))) {
				System.out.println("EVENT CREATED WITH SUBJECT: " + taskSubject);
			} else {
				System.out.println("EVENT NOT CREATED WITH SUBJECT: " + taskSubject);
			}

		}

	}

}
