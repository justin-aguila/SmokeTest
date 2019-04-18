
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


public class SshObeCaXmasLights {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://request.shackshine.com/onlinebooking/";
	final String SITE_URL2 = "https://o2ebrands.force.com/shackshine/login";
	final String HOME_TITLE = "Shack Shine | Online Booking Engine";
	final String HOME_TITLE2 = "Login | Shack Shine";
	final String TEXT_CONTENT = "This is a test booking.";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "OBE Auto Test XmasLights";
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
	final String SEARCHBOX_VALUE = "OBE Auto Test XmasLights";
	final String CHRISTMAS_SEARCH = "Christmas";
	final String LINE_ITEM_QUANTITY1 = "100";
	final String LINE_ITEM_QUANTITY2 = "100";
	final String CANCELED_STATUS = "Canceled";



	final By LOGIN_USER_NAME_BOX = By.id("username");
	final By LOGIN_PASSWORD_BOX = By.id("password");
	final By LOGIN_BUTTON = By.id("Login");
	final By ACCOUNT_BUTTON = By.id("Account_Tab");
	final By ZIP_BOX = By.id("edit-zipcode");
	final By GO_BUTTON = By.id("edit-submit");
	final By MEDSHACK_CHECK = By.xpath("//span[contains(text(),'Medium Shack')]");
	final By CHRISTMAS_CHECK = By.xpath("//div[contains(text(),'Christmas Lights')]");
	final By CHRISTMAS_LIGHTS = By.xpath("//*[@id=\"edit-christmas-wrap\"]/div/div[1]/label");
	final By DAY_SELECTION = By.xpath("//*[@id=\"edit-wrapper3--2\"]/div/div[3]/label/div");
	final By TIME_SELECTION = By.xpath("//*[@id=\"edit-day3-afternoon-appointments--2\"]/div[1]/label");
	final By ADDRESS_BOX = By.id("street_number");
	final By NAVIGATE_TO_OPPORTUNITY = By.xpath("//a[contains(text(),'Back to Shack Shine')]");
	final By CITY_BOX = By.id("route");
	final By STATE_BOX = By.id("administrative_area_level_1");
	final By FIRSTNAME_BOX = By.id("edit-first-name");
	final By LASTNAME_BOX = By.id("edit-last-name");
	final By EMAIL_BOX = By.id("edit-email");
	final By PHONE_BOX1 = By.id("edit-phone");
	final By CLICK_GET_APPOINTMENTS = By.xpath("//*[@id=\"AN-BookAppointmentForm\"]/div[8]");
	final By SELECT_APPOINTMENT = By.xpath("//*[@id=\"AN-SlotsContainer\"]/div[5]/div[2]");
	final By CONFIRM_BOOKING = By.xpath("//input[@title='Confirm Booking']");
	final By SECOND_SERVICE = By.xpath("//*[@id=\"AN-ResultsContainer\"]/div[2]");
	final By SEARCHBOX = By.id("phSearchInput");
	final By SEARCH_BUTTON = By.id("phSearchButton");
	final By XMAS_SELECT = By.xpath("//*[@id=\"Opportunity_body\"]/table/tbody/tr[2]/th/a");
	final By NAV_TO_ESTIMATE = By.xpath("//a[contains(text(),'Shack Shine -  OBE Guest')]");
	final By ADD_LINE_ITEM = By.xpath("//input[@title='Add Line Item']");
	final By LINEITEM_SEARCHBOX = By.id("search");
	final By LINEITEM_SEARCHBUTTON = By.id("save_filter_PricebookEntry");
	final By ESTIMATE_SAVE = By.xpath("//input[@title='Save']");
	final By LINEITEM_NEXTPAGE = By.xpath("//*[@id=\"lineItemView_bottomNav\"]/div[1]/span[3]/input");
	final By LINE_ITEM1 = By.id("01u1500000PA7Vj");
	final By LINE_ITEM2 = By.id("01u1C00000PuN6G");
	final By QUANTITY_FIELD1 = By.id("Quantity01u1500000PA7Vj");
	final By QUANTITY_FIELD2 = By.id("Quantity01u1C00000PuN6G");
	final By ESTIMATE_SELECT = By.xpath("//input[@title='Select']");
	final By SERVICE = By.xpath("//a[contains(text(),'S-')]");
	final By SEND_RESCHEDULE = By.xpath("//*[@id=\"topButtonRow\"]/input[7]");
	final By EDIT_BUTTON = By.xpath("//input[@title='Edit']");
	final By STATUS_FIELD = By.id("00N1500000EPC2G");
	final By SAVE_BUTTON = By.xpath("//input[@title='Save']");



	
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
				ExpectedConditions.elementToBeClickable(CHRISTMAS_CHECK));
				exteriorSelect.click();	
				
		WebElement exteriorWindow = wait.until(
				ExpectedConditions.elementToBeClickable(CHRISTMAS_LIGHTS));
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
				ExpectedConditions.elementToBeClickable(XMAS_SELECT));
				oppClick.click();

				
	}
	
	public void scheduleService() throws InterruptedException {

		Thread.sleep(2500);
				
		driver.switchTo().frame("09D15000001SVUf_06615000003N7hK");
		
		Select ServiceType = new Select(driver.findElement(By.id("AN-ServiceTypeInput")));
		   ServiceType.selectByVisibleText("SSh - Christmas Lights Install");   
		
		WebElement getAppointment = wait.until(
				ExpectedConditions.elementToBeClickable(CLICK_GET_APPOINTMENTS));
				getAppointment.click();
		
		Thread.sleep(7000);
		
		WebElement selectAppointment = wait.until(
				ExpectedConditions.elementToBeClickable(SELECT_APPOINTMENT));
				selectAppointment.click();
				
		WebElement secondService = wait.until(
				ExpectedConditions.elementToBeClickable(SECOND_SERVICE));
				secondService.click();
		
		Thread.sleep(2500);
		
		Select ServiceType2 = new Select(driver.findElement(By.id("AN-ServiceTypeInput")));
		   ServiceType2.selectByVisibleText("SSh - Christmas Lights Takedown");
		   
		WebElement getAppointment2 = wait.until(
				ExpectedConditions.elementToBeClickable(CLICK_GET_APPOINTMENTS));
				getAppointment2.click();
				
		Thread.sleep(7000);
		
		WebElement selectAppointment2 = wait.until(
				ExpectedConditions.elementToBeClickable(SELECT_APPOINTMENT));
				selectAppointment2.click();
	
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		WebElement confirmBooking = wait.until(
				ExpectedConditions.elementToBeClickable(CONFIRM_BOOKING));
				confirmBooking.click();
				
				
	    Thread.sleep(3000);

	}
	
public void EstimateWorkflow() throws InterruptedException {
		
		WebElement toEstimate = wait.until(
				ExpectedConditions.elementToBeClickable(NAV_TO_ESTIMATE));
				toEstimate.click();
				
		WebElement AddLineItemButton = wait.until(
						ExpectedConditions.elementToBeClickable(ADD_LINE_ITEM));
						AddLineItemButton.click();
						
		WebElement inputSearch = wait.until(
						ExpectedConditions.elementToBeClickable(LINEITEM_SEARCHBOX));
						inputSearch.sendKeys(CHRISTMAS_SEARCH);
						
		WebElement searchPress = wait.until(
						ExpectedConditions.elementToBeClickable(LINEITEM_SEARCHBUTTON));
						searchPress.click();
						
		Thread.sleep(1000);
						
		WebElement AddLineItem1 = wait.until(
						ExpectedConditions.elementToBeClickable(LINE_ITEM1));
						AddLineItem1.click();

		WebElement AddLineItem2 = wait.until(
						ExpectedConditions.elementToBeClickable(LINE_ITEM2));
						AddLineItem2.click();	
								
		WebElement estimateSelect = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_SELECT));
						estimateSelect.click();
							
		WebElement inputQuantity1 = wait.until(
						ExpectedConditions.elementToBeClickable(QUANTITY_FIELD1));
						inputQuantity1.sendKeys(LINE_ITEM_QUANTITY1);
						
		WebElement inputQuantity2 = wait.until(
						ExpectedConditions.elementToBeClickable(QUANTITY_FIELD2));
						inputQuantity2.sendKeys(LINE_ITEM_QUANTITY2);						
								
						
		WebElement saveEstimate = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_SAVE));
						saveEstimate.click();
						
		WebElement navigateOpportunity = wait.until(
						ExpectedConditions.elementToBeClickable(NAVIGATE_TO_OPPORTUNITY));
						navigateOpportunity.click();
						
	}

	public void CancelService () throws InterruptedException {
		
		WebElement servClick = wait.until(
				ExpectedConditions.elementToBeClickable(SERVICE));
				servClick.click();
				
		WebElement editClick = wait.until(
				ExpectedConditions.elementToBeClickable(EDIT_BUTTON));
				editClick.click();
				
			
		Select statusType2 = new Select(driver.findElement(By.id("00N1500000EPC2G")));
				   statusType2.selectByVisibleText("Canceled");
				   
		WebElement saveClick = wait.until(
					ExpectedConditions.elementToBeClickable(SAVE_BUTTON ));
					saveClick.click();
	}

	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
	 /* driver.get(SITE_URL);
		
		stepZero();
		
		stepOne();
		
		stepTwo();
		
		stepThree();    */
		
		driver.get(SITE_URL2); 
		
		logIn();
		
		searchOpp();
		
		scheduleService();
		
		EstimateWorkflow();
		
		CancelService();
		
		
		//driver.quit();
		
	}

	

}

