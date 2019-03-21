
package smokeTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class SshSCUS {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://o2ebrands.my.salesforce.com/";
	final String HOME_TITLE = "Login | Salesforce";
	final String USER_LOGIN ="ssh.sc@shackshine.com.prod";
	final String PASSWORD_LOGIN = "sshaccesspw2";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "SC AutoTest US";
	final String TEST_USER_EMAILADDRESS = "o2esqa@yahoo.com";
	final String TEST_USER_PHONENUMBER = "9999999999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_PROVINCE = "CA";
	final String TEST_USER_CITY = "Testerville";
	final String ZIPFIELD ="00006";
	

	
	final By LOGIN_USER_NAME_BOX = By.id("username");
	final By LOGIN_PASSWORD_BOX = By.id("password");
	final By LOGIN_BUTTON = By.id("Login");
	final By ACCOUNT_FIRSTNAME = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:first-name");
	final By ACCOUNT_LASTNAME = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:last-name");
	final By ACCOUNT_PHONENUMBER = By.id("j_id0:opp-detail:phone");
	final By ACCOUNT_EMAIL = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:email");
	final By ACCOUNT_ADDRESS = By.xpath("//input[@name='service-address-street']");
	final By ACCOUNT_CITY = By.xpath("//input[@name='service-address-city']");
	final By ACCOUNT_STATE = By.xpath("//input[@name='service-address-state']");
	final By SHACK_SIZE = By.id("j_id0:opp-detail:j_id37");
	final By ZIP_BOX = By.id("zipcode-search-input");
	final By SEARCH_BOX = By.id("franchise-search-btn");
	final By OVERRIDE_SEARCH = By.xpath("//div[@title='Override search results']//span[@class='onoffswitch-switch']");
	final By TIME_SLOT = By.xpath("//*[@id=\"j_id0:j_id385:time-list\"]/div[2]/div[2]");
	final By SAVE_CONFIRM = By.id("save-opp-confirm");
	final By CALL_DISPOSITION = By.id("j_id0:j_id633:BookingOppDetailCallDisposition:call-disposition-form:call-disposition-ssh");
	final By CALL_SAVE = By.xpath("//button[@class='call-disposition-save-btn slds-button slds-button--neutral']");
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"c:/Selenium/chromedriver.exe");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}
	
	
	
	public void logIn() {
		boolean isHomeDisplayed = wait.until(
                ExpectedConditions.titleIs(HOME_TITLE));

		assertTrue(isHomeDisplayed == true, "home page is not displayed!");
		
		WebElement usernameBox = wait.until(
				ExpectedConditions.elementToBeClickable(LOGIN_USER_NAME_BOX));
		
				usernameBox.sendKeys(USER_LOGIN);
		
		WebElement passwordBox = wait.until(
				ExpectedConditions.elementToBeClickable(LOGIN_PASSWORD_BOX));
					
				passwordBox.sendKeys(PASSWORD_LOGIN);
		
		WebElement logInButton = wait.until(
				ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
				logInButton.click();
		
		}

	

	public void zipLookup() throws InterruptedException {
		
		Thread.sleep(1000);

		driver.switchTo().frame("ext-comp-1005");
		
		WebElement zipInput = wait.until(
				ExpectedConditions.elementToBeClickable(ZIP_BOX));
				zipInput.sendKeys(ZIPFIELD);
				
		WebElement searchClick = wait.until(
				ExpectedConditions.elementToBeClickable(SEARCH_BOX));
				searchClick.click();
				
		driver.switchTo().defaultContent();
		
	}
	
	
	public void bos2Workflow() throws InterruptedException {
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'https://o2ebrands')]")));
		
		Thread.sleep(2000);
		
		WebElement firstName = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_FIRSTNAME));
				firstName.sendKeys(TEST_USER_FIRSTNAME);
				
		WebElement lastName = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_LASTNAME));
				lastName.sendKeys(TEST_USER_LASTNAME);
				
		WebElement emailInput = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_EMAIL));
				emailInput.sendKeys(TEST_USER_EMAILADDRESS);
				
		WebElement phoneNumber = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_PHONENUMBER));
				phoneNumber.sendKeys(TEST_USER_PHONENUMBER);
				
		WebElement searchClick = wait.until(
				ExpectedConditions.elementToBeClickable(OVERRIDE_SEARCH));
				searchClick.click();
				
		WebElement streetAddress = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_ADDRESS));
				streetAddress.sendKeys(TEST_USER_STREET);
						
		WebElement cityAddress = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_CITY));
				cityAddress.sendKeys(TEST_USER_CITY);
						
		WebElement stateAddress = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_STATE));
				stateAddress.sendKeys(TEST_USER_PROVINCE);
				
		Select shackSize = new Select(driver.findElement(SHACK_SIZE));
				shackSize.selectByVisibleText("Small Shack (1200 - 1800 sq ft)");
				
		WebElement timeSelect = wait.until(
				ExpectedConditions.elementToBeClickable(TIME_SLOT));
				timeSelect.click();
				
		Thread.sleep(3000);
				
		
		WebElement saveConfirm = wait.until(
				ExpectedConditions.elementToBeClickable(SAVE_CONFIRM));
				saveConfirm.click();
				
		Thread.sleep(2000);
				
		Select callReason = new Select(driver.findElement(CALL_DISPOSITION));
				callReason.selectByVisibleText("Selling House");
				
		WebElement saveBooking = wait.until(
				ExpectedConditions.elementToBeClickable(CALL_SAVE));
				saveBooking.click();
				
		driver.switchTo().defaultContent();
				
		Thread.sleep(9000);
				
	}
	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		driver.get(SITE_URL);
		
		logIn();
		
		zipLookup();
		
		bos2Workflow();
		
		//driver.quit();
		
		
		
	
		
	}
	

}

