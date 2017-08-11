package outlook.main;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.service.item.Appointment;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.property.complex.StringList;

public class EventHandler {
	private static final String OUTLOOK_EMAIL = Utils.readConfig("outlook_user_email");
	private static final String OUTLOOK_PASS = Utils.readConfig("outlook_user_password");
	private static final String LIFERAY_EMAIL = "email";
	private static final String LIFERAY_PASS = "pass";
	private static final String EWS_URL = Utils.readConfig("ews_url");
	protected static ExchangeService service;
	// Event
		public static boolean createAppointment(String subject, String body, String startdate, String enddate,String[] categories) {
			try {
				service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
				ExchangeCredentials credentials = new WebCredentials(OUTLOOK_EMAIL, OUTLOOK_PASS);
				service.setCredentials(credentials);
				service.setUrl(new URI(EWS_URL));
				Appointment appointment = new Appointment(service);
				appointment.setSubject(subject);
				appointment.setBody(MessageBody.getMessageBodyFromText(body));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate = formatter.parse(startdate);
				Date endDate = formatter.parse(enddate);
				appointment.setStart(startDate);
				appointment.setEnd(endDate);
				StringList sl = new StringList();
				for(int i=0;i<categories.length;i++){
					sl.add(categories[i]);
				}
				//sl.add("Publicity");
				//sl.add("Marketing");
				appointment.setCategories(sl);
				appointment.save();
				System.out.println("Appointment created successfully:"+appointment.getSubject());
				return true;
			} catch (Exception e) {
				//e.printStackTrace();
				return false;
			}
		}


}
