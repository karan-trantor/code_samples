package adbeat.qa.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvertiserProfilePage {
		static WebDriver driver;
		WebDriverWait wait;

		
		By searchTextBox = By.xpath("//input[@id='autosearch']");
		By title = By.cssSelector("title");
		By searchDropdown = By.id("search-auto-complete");
		By searchForAdLinkText = By.linkText("Search for Ads");
		
		
		
		
		
		public AdvertiserProfilePage(WebDriver currentDriver) {
			this.driver = currentDriver;
			wait = new WebDriverWait(driver, 50);
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("return document.readyState").toString().equals("complete");



		}
		public String getTitle() {
			return driver.getTitle();
		}
		
		public void typeInSearchTextBox(String searchText){
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
			WebElement element = driver.findElement(searchTextBox);
			element.sendKeys(searchText);
		}
		public void clickViewAdButton(String searchString) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchDropdown));
			WebElement element = driver.findElement(By.xpath("//a[@data-adv='"+searchString+"']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			// driver.findElement(advertisersButton).click();
		}
		
		public void clickViewProfileButton(String searchString) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchDropdown));
			WebElement element = driver.findElement(By.xpath("//a[@data-adv='"+searchString+"']/following-sibling::a"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			// driver.findElement(advertisersButton).click();
		}
		
		public void clickSearchForAdlink(String clickLink) {
			 driver.findElement(searchForAdLinkText).click();
		}
		
		
		
}
