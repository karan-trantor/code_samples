package adbeat.qa.automation;

import java.util.ArrayList;
import java.util.Scanner;
import adbeat.api.automation.GetAdGraphLegends;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import adbeat.api.automation.GetAdGraphLegends;

public class AdPage {
	static WebDriver driver;
	WebDriverWait wait;

	
	By searchDataAds = By.id("searchdata");
	By title = By.cssSelector("title");
	
	
	public AdPage(WebDriver currentDriver) {
		this.driver = currentDriver;
		wait = new WebDriverWait(driver, 50);

	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifySearchAdsGraphPresent(String adWebsite) {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchDataAds));
		//Actions builder = new Actions(driver);
		WebElement element = driver.findElement(searchDataAds);
		//builder.moveToElement(element).perform();
		ArrayList responseFromUi=new ArrayList();
		ArrayList responseFromApi=new GetAdGraphLegends().getAdScreenMouseOverGraphLegends(adWebsite);
		
		String pageSource=driver.getPageSource();
		String requiredString=null;
		//if search from home page-> click view ad[function render_graphs() is there]
		if(pageSource.contains("function render_graphs()")){
			requiredString = pageSource.substring(pageSource.indexOf("function render_graphs(){") , pageSource.indexOf("</script></div></div>"));
		}//if search from home page-> click view profile->search profie and click ad[function render_graphs() is not there]
		else{
			requiredString = pageSource.substring(pageSource.indexOf("/* Spends data received from API start */") , pageSource.indexOf("<!-- Checkout Popup -->"));
		}
		//String requiredString = pageSource.substring(pageSource.indexOf("function render_graphs(){") , pageSource.indexOf("</script></div></div>"));
		//String requiredString = pageSource.substring(pageSource.indexOf("/* Spends data received from API start */") , pageSource.indexOf("<!-- Checkout Popup -->"));
		System.out.println("requiredString"+requiredString);
		Scanner scanner = new Scanner(requiredString);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		 if(line.contains("var spends = ")){
			 responseFromUi.add(line.substring(line.indexOf("["), line.indexOf("]")+1));
			 System.out.println(""+line.substring(line.indexOf("["), line.indexOf("]")+1));
		 }
		}
		scanner.close();
		System.out.println("BELOW IS THE ARRAY LIST FROM UI:\n"+responseFromUi);
		System.out.println("BELOW IS THE ARRAY LIST FROM API:\n"+responseFromApi);
		if(!responseFromApi.equals(responseFromUi)){
		 new AssertionError("UI Graph Legends: \n"+responseFromUi+"\nDoes not match API legends:\n"+responseFromApi);
		}
		return driver.findElement(searchDataAds).isDisplayed();
	}
	

}
