
package smokeTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class SshObeCaVerify {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://request.shackshine.com/onlinebooking/";
	final String SITE_URL2 = "https://o2ebrands.force.com/shackshine/login";
	final String HOME_TITLE = "Shack Shine | Online Booking Engine";
	final String HOME_TITLE2 = "Login | Shack Shine";
	final String TEXT_CONTENT = "This is a test booking.";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "OBE Auto Test Verify";
	final String TEST_USER_EMAILADDRESS = "o2esqa@yahoo.com";
	final String TEST_USER_UNIT = "123";
	final String TEST_USER_PHONENUMBER1 = "999-999-9999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_STATE = "BC";
	final String TEST_USER_CITY = "Testerville";
	final String TEST_USER_COUNTRY = "Canada";
	final String TEST_ZIP = "W6W6W6";
	final String TEST_NOTES = "This is a test note.";
	final String USER_LOGIN ="sshcanada.fp.tester@shackshine.com.prod";
	final String PASSWORD_LOGIN = "sshaccesspw2";
	final String SEARCHBOX_VALUE = "OBE Auto Test Verify";



	final By LOGIN_USER_NAME_BOX = By.id("username");
	final By LOGIN_PASSWORD_BOX = By.id("password");
	final By LOGIN_BUTTON = By.id("Login");
	final By ZIP_BOX = By.id("edit-zipcode");
	final By GO_BUTTON = By.id("edit-submit");
	final By MEDSHACK_CHECK = By.xpath("//span[contains(text(),'Massive Shack')]");
	final By EXTERIOR_CHECK = By.xpath("//div[contains(text(),'Exterior Window Washing')]");
	final By EXTERIOR_WINDOW = By.xpath("//label[contains(text(),'Exterior Window Washing')]");
	final By DAY_SELECTION = By.xpath("//*[@id=\"edit-wrapper3--2\"]/div/div[3]/label/div");
	final By TIME_SELECTION = By.xpath("//*[@id=\"edit-day3-afternoon-appointments--2\"]/div[1]/label");
	final By ADDRESS_BOX = By.id("street_number");
	final By CITY_BOX = By.id("route");
	final By STATE_BOX = By.id("administrative_area_level_1");
	final By FIRSTNAME_BOX = By.id("edit-first-name");
	final By LASTNAME_BOX = By.id("edit-last-name");
	final By EMAIL_BOX = By.id("edit-email");
	final By PHONE_BOX1 = By.id("edit-phone");
	final By CLICK_GET_APPOINTMENTS = By.xpath("//*[@id=\"AN-BookAppointmentForm\"]/div[8]");
	final By SELECT_APPOINTMENT = By.xpath("//*[@id=\"AN-SlotsContainer\"]/div[5]/div[2]");
	final By CONFIRM_BOOKING = By.xpath("//*[@id=\"topButtonRow\"]/input[9]");
	final By SECOND_SERVICE = By.xpath("//*[@id=\"AN-ResultsContainer\"]/div[2]");
	final By SEARCHBOX = By.id("phSearchInput");
	final By SEARCH_BUTTON = By.id("phSearchButton");
	final By OPP_SELECT = By.xpath("//*[@id=\"Opportunity_body\"]/table/tbody/tr[2]/th/a");
	final By NAV_TO_ESTIMATE = By.xpath("//a[contains(text(),'Shack Shine -  OBE Guest')]");
	final By SERVICE = By.xpath("//a[contains(text(),'S-')]");



	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"c:/Selenium/chromedriver.exe");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}
	
	
	
	public void stepZero() throws InterruptedException {
		boolean isHomeDisplayed = wait.until(
                ExpectedConditions.titleIs(HOME_TITLE));

		assertTrue(isHomeDisplayed == true, "home page is not displayed!");
		
		WebElement zipBox = wait.until(
				ExpectedConditions.elementToBeClickable(ZIP_BOX));
				zipBox.sendKeys(TEST_ZIP);
				
		WebElement shackSelect = wait.until(
				ExpectedConditions.elementToBeClickable(MEDSHACK_CHECK));
				shackSelect.click();
				
		WebElement goStepTwo = wait.until(
						ExpectedConditions.elementToBeClickable(GO_BUTTON));
						goStepTwo.click();	
				
				
		Thread.sleep(1000);
		
		
		}
	

	public void stepOne() throws InterruptedException {
		
		WebElement exteriorSelect = wait.until(
				ExpectedConditions.elementToBeClickable(EXTERIOR_CHECK));
				exteriorSelect.click();	
				
		WebElement exteriorWindow = wait.until(
				ExpectedConditions.elementToBeClickable(EXTERIOR_WINDOW));
				exteriorWindow.click();
				
		WebElement goStepThree = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goStepThree.click();	
	
	
	
	  }		
	
	public void stepTwo() throws InterruptedException {
				
		 Thread.sleep(3000);
		
		WebElement daySelect = wait.until(
				ExpectedConditions.elementToBeClickable(DAY_SELECTION));
				daySelect.click();		
						
						
				WebElement timeSelect = wait.until(
				ExpectedConditions.elementToBeClickable(TIME_SELECTION));
				timeSelect.click();	
				
																										
		WebElement goStepThree = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goStepThree.click();	
				
	}
				
	public void stepThree() throws InterruptedException {	
		
		Thread.sleep(3000);
		
		WebElement addressBox = wait.until(
				ExpectedConditions.elementToBeClickable(ADDRESS_BOX));
				addressBox.sendKeys(TEST_USER_STREET);		
				
		WebElement cityBox = wait.until(
				ExpectedConditions.elementToBeClickable(CITY_BOX));
				cityBox.sendKeys(TEST_USER_CITY);	
										
		Select stateSelect = new Select(driver.findElement(STATE_BOX));
				stateSelect.selectByVisibleText("British Columbia");
				
					
		WebElement firstNameBox = wait.until(
				ExpectedConditions.elementToBeClickable(FIRSTNAME_BOX));
				firstNameBox.sendKeys(TEST_USER_FIRSTNAME);
								
		WebElement secondNameBox = wait.until(
				ExpectedConditions.elementToBeClickable(LASTNAME_BOX));
				secondNameBox.sendKeys(TEST_USER_LASTNAME);
				
				WebElement phoneOneBox = wait.until(
						ExpectedConditions.elementToBeClickable(PHONE_BOX1));
						phoneOneBox.sendKeys(TEST_USER_PHONENUMBER1);				
										
		WebElement emailBox = wait.until(
				ExpectedConditions.elementToBeClickable(EMAIL_BOX));
				emailBox.sendKeys(TEST_USER_EMAILADDRESS);
												
		WebElement goConfirm = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goConfirm.click();		
		
	
				
	   Thread.sleep(1000);	
	   
	   WebElement confirmBooking = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				confirmBooking.click();	
			
	 Thread.sleep(3000);

	
				
		}
	
	
	public void logIn() {
		boolean isHomeDisplayed = wait.until(
                ExpectedConditions.titleIs(HOME_TITLE2));

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
		
				boolean fpHomeDisplayed = wait.until(
				ExpectedConditions.titleIs("Shack Shine"));
		
				assertTrue(fpHomeDisplayed == true, "Franchise page is not displayed!");
		}
	
	
	public void searchOpp() throws InterruptedException {
		
		
		WebElement inputPromo = wait.until(
				ExpectedConditions.elementToBeClickable(SEARCHBOX));
				inputPromo.sendKeys(SEARCHBOX_VALUE);
				
		WebElement searchClick = wait.until(
				ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
				searchClick.click();
				
		WebElement oppClick = wait.until(
				ExpectedConditions.elementToBeClickable(OPP_SELECT));
				oppClick.click();

				
	}
	
	public void OppVerify() throws InterruptedException {
		
		
		String bodyText = driver.findElement(By.id("00N1500000H6ak1_ileinner")).getText();
		Assert.assertTrue(bodyText.contains("On-Site Estimate Booked"));
		System.out.println("Status is correct: On-Site Estimate Booked");
		

		
		String bodyText2 = driver.findElement(By.id("00N1500000H6aku_ileinner")).getText();
		Assert.assertTrue(bodyText2.contains("SELECTED PRODUCTS: Exterior Window Washing"));
		System.out.println("Product Selection is correct: Exterior Window Washing");
		
		String bodyText3 = driver.findElement(By.id("00N1500000H6akM_ileinner")).getText();
		Assert.assertTrue(bodyText3.contains("QA Justin OBE Auto Test Verify"));
		System.out.println("Onsite Contact Name is correct"); 
		
		
		WebElement servClick = wait.until(
				ExpectedConditions.elementToBeClickable(SERVICE));
				servClick.click();
				
		String bodyText5 = driver.findElement(By.id("00N1500000EPC0x_ileinner")).getText();
		Assert.assertTrue(bodyText5.contains("1"));
		System.out.println("Estimate Hours is correct: 1");
		
	}
	


	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		driver.get(SITE_URL);
		
		stepZero();
		
		stepOne();
		
		stepTwo();
		
		stepThree();  
		
		driver.get(SITE_URL2); 
		
		logIn();
		
		searchOpp();
		
		OppVerify();
		
		//driver.quit();
		
	}

	

}

