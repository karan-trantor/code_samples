package adbeat.qa.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Base {
	public static WebDriver driver=null;
	public Scenario scenario;
	public static String browser;
	public static String adBeatUrl;
	public static String monthlySpendsApi;

	public WebDriver getDriver() {
		return this.driver;
	}

	public WebDriver lauchUrl() {
		driver.get(adBeatUrl);
		System.out.println(driver.getTitle());
		return driver;
	}

	@Before
	public void test(Scenario scenario) {
		System.out.println("*****RUNNING SCENARIO***** ************************** *****RUNNING SCENARIO*****");
		System.out.println("\t\t "+scenario.getName());
		System.out.println("************************** ************************** **************************");
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		browser = properties.getProperty("browser");
		adBeatUrl = properties.getProperty("adbeat_url");
		monthlySpendsApi = properties.getProperty("monthly_spends_api_url");
		
		System.out.println("Browser:" + browser);
		System.out.println("Adbeat Url:" + adBeatUrl);
		System.out.println("Initializing Web Driver...");
        if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    }else
		if (browser.equalsIgnoreCase("internet explorer")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}else
		if (browser.equalsIgnoreCase("firefox")) {
			File  pathToBinary=new File ("C:\\Users\\harpreet2.singh\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();  
			driver = new FirefoxDriver(ffBinary,firefoxProfile);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1365, 725));
	}

	@After
	public void cleanUp(Scenario scenario) {
		if (scenario.isFailed()) {
		System.out.println("TAKING SCREEN SHOT..."); 
			       final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    }

		driver.quit();
		System.out.println("Closing browser...");

	}

}
