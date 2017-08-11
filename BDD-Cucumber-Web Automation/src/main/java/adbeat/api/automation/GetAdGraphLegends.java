package adbeat.api.automation;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import com.jayway.jsonpath.JsonPath;


public class GetAdGraphLegends {
	static Properties properties = null;

	public static void getElemenetDetailFromConfig() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList getAdScreenMouseOverGraphLegends(String adWebsite) {
		getElemenetDetailFromConfig();
		ArrayList responseFromApi = new ArrayList();
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
					properties.getProperty("ad_screen_mouseover_graph_legends_url") + "" + adWebsite);
			getRequest.addHeader("accept", "application/json");
			HttpResponse result = httpClient.execute(getRequest);

			String json = EntityUtils.toString(result.getEntity(), "UTF-8");
			String numHitsToString = JsonPath.read(json, "$..numHits").toString();
			int totalNumberOfAds = Integer.parseInt(numHitsToString.substring(numHitsToString.indexOf("[") + 1, numHitsToString.indexOf("]")));
			for (int i = 0; i < totalNumberOfAds; i++) {
				List<String> author = JsonPath.parse(json).read("$..hits[" + i + "]..adSpendsDaily..adSpends");
				responseFromApi.add(getLegends(author.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e);
		}
		return responseFromApi;
	}

	public String getLegends(String responseFromApi) {
		String removebraces = responseFromApi.substring(responseFromApi.indexOf("[[") + 2,
				responseFromApi.indexOf("]]"));
		String[] splitString = removebraces.split(",");
		String finalLegends = "[";
		int[] convertedToInt = Arrays.stream(splitString).mapToInt(Integer::parseInt).toArray();
		int lastIndexWithNonZeroValue = 0;
		for (int j = convertedToInt.length - 1; j >= 0; j--) {
			if (convertedToInt[j] > 0) {
				System.out.println("Found last greater than 0 value :" + convertedToInt[j]);
				lastIndexWithNonZeroValue = j;
				break;
			}
		}
		for (int i = lastIndexWithNonZeroValue - 6; i <= lastIndexWithNonZeroValue; i++) {
			finalLegends = finalLegends + convertedToInt[i] + ", ";
		}
		System.out.println("lastIndexWithNonZeroValue : " + lastIndexWithNonZeroValue);
		return finalLegends.substring(0, finalLegends.lastIndexOf(",")) + "]";

	}

	public static void main(String[] args) {
		new GetAdGraphLegends().getAdScreenMouseOverGraphLegends("drfirst.com");
	}
}