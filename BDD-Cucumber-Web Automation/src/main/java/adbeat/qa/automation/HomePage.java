package adbeat.qa.automation;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.AssertionFailedError;

public class HomePage {
	static Properties properties;
	By title = By.cssSelector("title");
	By logo = By.cssSelector("img[src='/static/images/logo.png']");
	By adbeatbasics = By.linkText("Adbeat Basic");
	By adbeatPro = By.linkText("Adbeat Pro");
	By logIn = By.linkText("Log in");
	By signUpButton = By.cssSelector("a[class='btn btn-primary blue-btn']");
	By seeLiveDemoButton = By.cssSelector("a[class='btn btn-success blue-btn green-btn']");

	By searchBox = By.id("autosearch");
	By viewAdButton = By.xpath("//a[@data-adv='drfirst.com']");
	By smartSearchPopUp = By.id("search-auto-complete");

	By cardDiv = By.cssSelector("div.search-card h1");
	By rightCarosel = By.cssSelector("a.right.carousel-control");

	By advertisersButton = By.cssSelector("a[href$='advertisers']");
	By agenciesButton = By.cssSelector("a[href$='agencies']");
	By adNetworkPubButton = By.cssSelector("a[href$='networks']");

	By advertiserImage = By.cssSelector("img[src='/static/images/box2.png']");
	By advertiserTextUnderImage = By.cssSelector("img[src='/static/images/box.png']+p");
	By advertiserHeaderTextadjacentImage = By.cssSelector("div[id='advertisers'] h2");
	By advertiserTextadjacentImage = By.cssSelector("div#advertisers div[class='col-xs-12 col-sm-6 col-md-6']>p");

	By agenciesImage = By.cssSelector("img[src='/static/images/agencies.png']");
	By agenciesTextUnderImage = By.cssSelector("img[src='/static/images/IMM.png']+p");
	By agenciesHeaderTextadjacentImage = By.cssSelector("div[id='agencies'] h2");
	By agenciesTextadjacentImage = By.cssSelector("div#agencies div[class='col-xs-12 col-sm-6 col-md-6']>p");

	By adNetworkAndPubImage = By.cssSelector("img[src='/static/images/networks.png']");
	By adNetworkAndPubTextUnderImage = By.cssSelector("img[src='/static/images/cpxi.png']+p");
	By adNetworkAndPubHeaderTextadjacentImage = By.cssSelector("div[id='networks'] h2");
	By adNetworkAndPubTextadjacentImage = By.cssSelector("div#networks div[class='col-xs-12 col-sm-6 col-md-6']>p");

	static WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver currentDriver) {
		this.driver = currentDriver;
		wait = new WebDriverWait(driver, 50);

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Boolean verifyLogoPresent() {
		WebElement element = driver.findElement(logo);
		System.out.println("location of logo:" + element.getLocation() + " \nx axis:" + element.getLocation().getX()
				+ " \ny axis:" + element.getLocation().getY());
		return driver.findElement(logo).isDisplayed();

	}

	public Boolean verifyadbeatBasicLink() {
		WebElement element = driver.findElement(adbeatbasics);
		System.out.println("location of adbeat basic link:" + element.getLocation() + " \nx axis:"
				+ element.getLocation().getX() + " \ny axis:" + element.getLocation().getY());
		return driver.findElement(adbeatbasics).isDisplayed();
	}

	public Boolean verifyadbeatProLink() {
		WebElement element = driver.findElement(adbeatPro);
		System.out.println("location of adbeat pro link:" + element.getLocation() + " \nx axis:"
				+ element.getLocation().getX() + " \ny axis:" + element.getLocation().getY());
		return driver.findElement(adbeatPro).isDisplayed();
	}

	public Boolean verifyLoginLink() {
		WebElement element = driver.findElement(logIn);
		System.out.println("location of login link:" + element.getLocation() + " \nx axis:"
				+ element.getLocation().getX() + " \ny axis:" + element.getLocation().getY());
		return driver.findElement(logIn).isDisplayed();
	}

	public Boolean verifySignUpButton() {
		return driver.findElement(signUpButton).isDisplayed();
	}

	public Boolean verifySeeLiveDemoButton() {
		return driver.findElement(seeLiveDemoButton).isDisplayed();
	}

	public Boolean verifySearchTextBox() {
		return driver.findElement(searchBox).isDisplayed();
	}

	public void typeInSearchTextBox(String text) {
		driver.findElement(searchBox).sendKeys(text);
	}

	public Boolean verifySmartSearchpopUp() {
		wait.until(ExpectedConditions.elementToBeClickable(smartSearchPopUp));
		return driver.findElement(smartSearchPopUp).isDisplayed();
	}

	public void verifySmartSearchpopUpNotPresent() {
		if (!(driver.findElements(smartSearchPopUp).size() < 1)) {
			throw new AssertionFailedError("Smart Search Popup should not be there");
		}
	}

	public void clickViewAdButton(String searchString) {
		WebElement element = driver.findElement(By.xpath("//a[@data-adv='"+searchString+"']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(advertisersButton).click();
	}
	
	public void clickViewProfileButton(String searchString) {
		WebElement element = driver.findElement(By.xpath("//a[@data-adv='"+searchString+"']/following-sibling::a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(advertisersButton).click();
	}
	public List<String> getCardValues() {
		List<String> uniqueCards = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			List<WebElement> getText = driver.findElements(cardDiv);
			for (WebElement temp : getText) {
				uniqueCards.add(temp.getText());
			}
			driver.findElement(rightCarosel).click();
		}
		return uniqueCards;

	}
	

	public Boolean verifyAdvertisersButton() {
		return driver.findElement(advertisersButton).isDisplayed();
	}

	public Boolean verifyAgenciesButton() {
		return driver.findElement(agenciesButton).isDisplayed();
	}

	public Boolean verifyAdNetworkPubButton() {
		return driver.findElement(adNetworkPubButton).isDisplayed();
	}

	public void clickAdvertisersButton() {
		WebElement element = driver.findElement(advertisersButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(advertisersButton).click();
	}

	public Boolean verifyAdvertisersImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(advertiserImage));
		return driver.findElement(advertiserImage).isDisplayed();
	}

	public String getAdvertisersTextUnderImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(advertiserTextUnderImage));
		return driver.findElement(advertiserTextUnderImage).getText();
	}

	public String getAdvertisersHeaderTextAdjacentToImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(advertiserHeaderTextadjacentImage));
		return driver.findElement(advertiserHeaderTextadjacentImage).getText();
	}

	public String getAdvertisersTextAdjacentToImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(advertiserTextadjacentImage));
		return driver.findElement(advertiserTextadjacentImage).getText();
	}

	public void clickAgenciesButton() {

		WebElement element = driver.findElement(agenciesButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(agenciesButton).click();
	}

	public Boolean verifyAgenciesImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(agenciesImage));
		return driver.findElement(agenciesImage).isDisplayed();
	}

	public String getAgenciesTextUnderImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(agenciesTextUnderImage));
		return driver.findElement(agenciesTextUnderImage).getText();
	}

	public String getAgenciesHeaderTextAdjacentToImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(agenciesHeaderTextadjacentImage));
		return driver.findElement(agenciesHeaderTextadjacentImage).getText();
	}

	public String getAgenciesTextAdjacentToImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(agenciesTextadjacentImage));
		return driver.findElement(agenciesTextadjacentImage).getText();
	}

	public void clickAdNetworkAndPubButton() {
		WebElement element = driver.findElement(adNetworkPubButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(adNetworkPubButton).click();
	}

	public Boolean verifyAdNetworkAndPubImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(adNetworkAndPubImage));
		return driver.findElement(adNetworkAndPubImage).isDisplayed();
	}

	public String getAdNetworkAndPubTextUnderImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(adNetworkAndPubTextUnderImage));
		return driver.findElement(adNetworkAndPubTextUnderImage).getText();
	}

	public String getAdNetworkAndPubHeaderTextAdjacentToImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(adNetworkAndPubHeaderTextadjacentImage));
		return driver.findElement(adNetworkAndPubHeaderTextadjacentImage).getText();
	}

	public String getAdNetworkAndPubTextAdjacentToImage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(adNetworkAndPubTextadjacentImage));
		return driver.findElement(adNetworkAndPubTextadjacentImage).getText();
	}

	public Map<String, String> getCardMonthlySpend() {
		Map<String, String> cardData = new HashMap<String, String>();

		List<String> uniqueCards = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			List<WebElement> getText = driver.findElements(cardDiv);
			for (WebElement temp : getText) {
				uniqueCards.add(temp.getText());
				if (temp.getText().length() > 0) {
					String monthlySpend = driver
							.findElement(By.xpath("//div[@class='search-card']//h1[contains(.,'" + temp.getText()
									+ "')]//parent::div//preceding-sibling::div[@class='card-info']//div[2]"))
							.getText();
					String key = temp.getText().trim();
					if (monthlySpend.length() > 1 && key.length() > 2 && key != null && monthlySpend != null) {
						cardData.put(key, monthlySpend);
					}

				}

			}

			driver.findElement(rightCarosel).click();
		}
		System.out.println("RESULT : \n" + cardData);
		return cardData;

	}

	// POSITION

	public static void getElemenetDetailFromConfig() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("element.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyElementPositionSizePresent(String element) {
		System.out.println("element: " + element);
		switch (element) {
		case ("'logo'"): {
			verifyElemetPos(logo, "logo");
			break;
		}
		case ("'basic link'"): {
			verifyElemetPos(adbeatbasics, "basic_link");
			break;
		}
		case ("'pro link'"): {
			verifyElemetPos(adbeatPro, "pro_link");
			break;
		}
		case ("'login link'"): {
			verifyElemetPos(logIn, "login_link");
			break;
		}
		case ("'signup button'"): {
			verifyElemetPos(signUpButton, "signup_button");
			break;
		}
		case ("'see live demo button'"): {
			verifyElemetPos(seeLiveDemoButton, "see_live_demo_button");
			break;
		}
		
		case ("'search box'"): {
			verifyElemetPos(searchBox, "search_box");
			break;
		}

		}

	}

	public void verifyElemetPos(By elem, String elementName) {
		int buttonCount=0;
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		System.out.println("Total number of Elements: "+allElements.size());

		
		List<WebElement> inputElements = driver.findElements(By.xpath("//input"));
		System.out.println("Total number of inputs: "+inputElements.size());

		List<WebElement> buttonElements = driver.findElements(By.xpath("//button"));
		System.out.println("Total number of buttons: "+buttonElements.size());

		List<WebElement> imageElements = driver.findElements(By.xpath("//img"));
		System.out.println("Total number of images: "+imageElements.size());

		List<WebElement> anchorElements = driver.findElements(By.xpath("//a"));
		System.out.println("Total number of anchor: "+anchorElements.size());
        for(WebElement we: buttonElements){
        	if(we.isDisplayed()){
        		buttonCount++;
        	}
        	
        }
		System.out.println("BUTTON COUNT: "+buttonCount);
		
		System.out.println("INSIDE POSITION VERIFICATION METHOD");
		WebElement element = driver.findElement(elem);
		
		getElemenetDetailFromConfig();
		String element_x_axis = String.valueOf(element.getLocation().getX());
		String element_y_axis = String.valueOf(element.getLocation().getY());
		String element_width = String.valueOf(element.getSize().getWidth());
		String element_height = String.valueOf(element.getSize().getHeight());

		if (!(properties.getProperty("adbeat_" + elementName + "_position_x_axis").contains(element_x_axis))) {
			throw new AssertionFailedError(
					"Expeceted element x axis " + properties.getProperty("adbeat_" + elementName + "_position_x_axis")
							+ " not equals Actual x axis: " + element_x_axis);
		}
		if (!(properties.getProperty("adbeat_" + elementName + "_position_y_axis").contains(element_y_axis))) {
			throw new AssertionFailedError(
					"Expeceted element y axis " + properties.getProperty("adbeat_" + elementName + "_position_y_axis")
							+ " not equals Actual y axis: " + element_y_axis);
		}

		if (!(properties.getProperty("adbeat_" + elementName + "_width").contains(element_width))) {
			throw new AssertionFailedError(
					"Expeceted element width " + properties.getProperty("adbeat_" + elementName + "_width")
							+ " not equals Actual width: " + element_width);
		}

		if (!element_height.equals(properties.getProperty("adbeat_" + elementName + "_height"))) {
			throw new AssertionFailedError(
					"Expeceted element height " + properties.getProperty("adbeat_" + elementName + "_height")
							+ " not equals Actual height: " + element_height);
		}

		System.out.println(elementName +" location:" + element.getLocation() + " \n|| x axis:" + element.getLocation().getX()
				+ " || y axis:" + element.getLocation().getY()+" || width:" + element.getSize().getWidth() + " || height:" + element.getSize().getHeight() +" ||");
	
	}
}
