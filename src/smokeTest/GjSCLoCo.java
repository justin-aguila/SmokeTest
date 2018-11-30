
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


public class GjSCLoCo {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://o2ebrands.my.salesforce.com/";
	final String HOME_TITLE = "Login | Salesforce";
	final String USER_LOGIN ="gj.sc@1800gotjunk.com.prod";
	final String PASSWORD_LOGIN = "gotjunkaccesspw2";
	final String TEST_USER_BUSINESS = "QA Justin Business Test";
	final String TEST_USER_FIRSTNAME = "QA_Justin";
	final String TEST_USER_LASTNAME = "SC AutoTest";
	final String TEST_USER_EMAILADDRESS = "justin.aguila@o2ebrands.com";
	final String TEST_USER_PHONENUMBER = "9999999999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_PROVINCE = "BC";
	final String TEST_USER_CITY = "Testerville";
	final String PROMO_CODE = "Justin$PromoGJ";
	final String ZIPFIELD ="W1N1W1";
	

	
	final By LOGIN_USER_NAME_BOX = By.id("username");
	final By LOGIN_PASSWORD_BOX = By.id("password");
	final By LOGIN_BUTTON = By.id("Login");
	final By ACCOUNT_BUSINESS = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:business-name");
	final By ACCOUNT_FIRSTNAME = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:first-name");
	final By ACCOUNT_LASTNAME = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:last-name");
	final By ACCOUNT_PHONENUMBER = By.id("j_id0:opp-detail:phone");
	final By ACCOUNT_EMAIL = By.id("j_id0:opp-detail:j_id190:BookingOppDetailCustomerInfoForm:email");
	final By ACCOUNT_ADDRESS = By.xpath("//input[@name='service-address-street']");
	final By ACCOUNT_CITY = By.xpath("//input[@name='service-address-city']");
	final By ACCOUNT_STATE = By.xpath("//input[@name='service-address-state']");
	final By ZIP_BOX = By.id("zipcode-search-input");
	final By SEARCH_BOX = By.id("franchise-search-btn");
	final By COM_RADIO = By.xpath("//label[@for='commercial-radio']//span[@class='slds-radio--faux residential-radio']");
	final By OVERRIDE_SEARCH = By.xpath("//div[@title='Override search results']//span[@class='onoffswitch-switch']");
	final By PROMO_FIELD = By.id("tracking-code");
	final By PROMO_LOOKUP = By.xpath("//*[@id=\"j_id0:opp-detail:tracking-code-section\"]/div/div[1]/div/span[2]/img");
	final By PROMOCODE =By.id("j_id0:j_id588:j_id589:j_id607");
	final By TIME_SLOT = By.xpath("//*[@id=\"j_id0:j_id385:time-list\"]/div[2]/div[2]");
	final By SAVE_CONFIRM = By.id("save-opp-confirm");
	final By CALL_DISPOSITION = By.id("j_id0:j_id633:BookingOppDetailCallDisposition:call-disposition-form:call-disposition-jnk");
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
		
		WebElement comClick = wait.until(
				ExpectedConditions.elementToBeClickable(COM_RADIO));
				comClick.click();
		
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
		
		WebElement comName = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_BUSINESS));
				comName.sendKeys(TEST_USER_BUSINESS);
		
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
				
		Select comAccount = new Select(driver.findElement(By.id("j_id0:opp-detail:commercial-account-type")));
				comAccount.selectByVisibleText("Local");
				
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
				
		Select durationChoice = new Select(driver.findElement(By.id("j_id0:opp-detail:suggested-duration")));
				durationChoice.selectByVisibleText("15 min");
				
		Thread.sleep(2000);
				
		Select durationChoice2 = new Select(driver.findElement(By.id("j_id0:opp-detail:suggested-duration")));
				durationChoice2.selectByVisibleText("30 min");	
				
		Thread.sleep(3000);
			
				
		WebElement timeSelect = wait.until(
				ExpectedConditions.elementToBeClickable(TIME_SLOT));
				timeSelect.click();
				
		Thread.sleep(3000);
				
		WebElement promoInput = wait.until(
				ExpectedConditions.elementToBeClickable(PROMO_FIELD));
				promoInput.sendKeys(PROMO_CODE); 
		
		Thread.sleep(1000);
				
		WebElement promoSearch = wait.until(
				ExpectedConditions.elementToBeClickable(PROMO_LOOKUP));
				promoSearch.click();
			
		Thread.sleep(1000);
				
		WebElement promoSelect = wait.until(
				ExpectedConditions.elementToBeClickable(PROMOCODE));
				promoSelect.click();
			
		Thread.sleep(1000);	
		
		WebElement saveConfirm = wait.until(
				ExpectedConditions.elementToBeClickable(SAVE_CONFIRM));
				saveConfirm.click();
				
		Thread.sleep(2000);
				
		Select callReason = new Select(driver.findElement(CALL_DISPOSITION));
				callReason.selectByVisibleText("Purging");
				
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
		
		driver.quit();
		
		
		
	
		
	}
	

}

