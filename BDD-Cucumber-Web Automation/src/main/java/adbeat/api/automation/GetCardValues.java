package adbeat.api.automation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import adbeat.qa.automation.Base;
import junit.framework.AssertionFailedError;

public class GetCardValues {

	public static void main(String[] args) {

		// String resultString=new
		// GetCardValues().parseCardValueObtainedFromApi("sling.com");
		// System.out.println(resultString);

	}

	public String getCardValueFromApi(String cardType) {
		String resultString = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(Base.monthlySpendsApi+""+ cardType);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			String result = EntityUtils.toString(response.getEntity());
			String[] splittedResponse = result.split(",");
			for (int i = 0; i < splittedResponse.length; i++) {
				if (splittedResponse[i].contains("\"30\"")) {
					String[] finalS = splittedResponse[i].split(":");
					resultString = finalS[1];
				}

			}
			httpClient.getConnectionManager().shutdown();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e);
		}
		return resultString;
	}

	public String parseCardValueObtainedFromApi(String cardType) {
		cardType = new GetCardValues().getcardUrl(cardType);
		String resultStringFromApi = getCardValueFromApi(cardType);
		String finalMonthlySpent;
		int resultStringSize = resultStringFromApi.length();
		int convertedresultStringFromApiToInt = Integer.parseInt(resultStringFromApi);
		String convertedResultStringToUsNumberFormat = NumberFormat.getNumberInstance(Locale.US)
				.format(convertedresultStringFromApiToInt);
		String getSplittedString[] = convertedResultStringToUsNumberFormat.split(",");
		String joinSplitted = getSplittedString[0] + "." + getSplittedString[1]+ getSplittedString[2];
		float jointString = Float.valueOf(joinSplitted);

		if (resultStringSize == 3 || resultStringSize == 4 || resultStringSize == 5) {
			System.out.println("$" + String.format("%.2f", jointString) + "K");
			finalMonthlySpent = "$" + String.format("%.2f", jointString) + "K";
		}

		else if (resultStringSize == 6 || resultStringSize == 7 || resultStringSize == 8) {
			System.out.println("$" + String.format("%.2f", jointString) + "M");
			finalMonthlySpent = "$" + String.format("%.2f", jointString) + "M";
		}

		else if (resultStringSize == 9 || resultStringSize == 10 || resultStringSize == 11) {
			System.out.println("$" + String.format("%.2f", jointString) + "B");
			finalMonthlySpent = "$" + String.format("%.2f", jointString) + "B";
		}

		else if (resultStringSize == 12 || resultStringSize == 13 || resultStringSize == 14) {
			System.out.println("$" + String.format("%.2f", jointString) + "T");
			finalMonthlySpent = "$" + String.format("%.2f", jointString) + "T";
		} else {
			finalMonthlySpent = "$" + String.format("%.2f", jointString);
		}
		return finalMonthlySpent + " monthly spend";
	}

	public String getcardUrl(String cardType) {
		switch (cardType) {
		case "Amazon":
			return "amazon.com";

		case "Sling TV":
			return "sling.com";

		case "Fidelity Investments":
			return "fidelity.com";

		case "Jet":
			return "jet.com";

		case "LowerMyBills.com":
			return "lowermybills.com";
		}
		deafult: throw new AssertionFailedError(
				"cardType nust be in the list : [Sling TV , Amazon , Fidelity Investments , Jet, LowerMyBills.com] but you sent: "
						+ cardType);
	}

}
