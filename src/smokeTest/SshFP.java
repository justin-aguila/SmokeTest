
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


public class SshFP {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://o2ebrands.force.com/shackshine/login";
	final String HOME_TITLE = "Login | Shack Shine";
	final String USER_LOGIN ="sshcanada.fp.tester@shackshine.com.prod";
	final String PASSWORD_LOGIN = "sshaccesspw2";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "AutoTest";
	final String TEST_USER_EMAILADDRESS = "o2esqa@yahoo.com";
	final String TEST_USER_PHONENUMBER = "9999999999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_PROVINCE = "BC";
	final String TEST_USER_CITY = "Testerville";
	final String TEST_USER_COUNTRY = "Canada";
	final String TEST_USER_ZIP = "W6W6W6";
	final String LINE_ITEM_QUANTITY = "420";
	final String PROMO_CODE = "Justin$PromoSSH";
	final String PAYMENT_AMOUNT ="168.63";
	
	
	final By LOGIN_USER_NAME_BOX = By.id("username");
	final By LOGIN_PASSWORD_BOX = By.id("password");
	final By LOGIN_BUTTON = By.id("Login");
	final By ACCOUNT_BUTTON = By.id("Account_Tab");
	final By NEW_ACCOUNT_BUTTON = By.xpath("//input[@name='new']");
	final By NEW_ACCOUNT_CONTINUE_BUTTON = By.xpath("//input[@title='Continue']");
	final By ACCOUNT_FIRSTNAME = By.id("name_firstacc2");
	final By ACCOUNT_LASTNAME = By.id("name_lastacc2");
	final By ACCOUNT_PHONENUMBER = By.id("acc10");
	final By ACCOUNT_EMAIL = By.id("PersonEmail");
	final By COPY_BILLING_ADDRESS_CHECKBOX = By.xpath("//input[@type='checkbox']");
	final By ACCOUNT_STREET = By.id("PersonMailingAddressstreet");
	final By ACCOUNT_CITY = By.id("PersonMailingAddresscity");
	final By ACCOUNT_PROVICE = By.id("PersonMailingAddressstate");
	final By ACCOUNT_ZIPCODE = By.id("PersonMailingAddresszip");
	final By ACCOUNT_COUNTRY = By.id("PersonMailingAddresscountry");
	final By ACCOUNT_SAVE = By.xpath("(//input[@title = 'Save'])[1]");
	final By CREATE_OPPORTUNITY = By.xpath("(//input[@name = 'new_opportunity'])[1]");
	final By NAVIGATE_TO_OPPORTUNITY = By.xpath("//a[contains(text(),'Back to Shack Shine')]");
	final By CLICK_GET_APPOINTMENTS = By.xpath("//*[@id=\"AN-BookAppointmentForm\"]/div[8]");
	final By SELECT_APPOINTMENT = By.xpath("//*[@id=\"AN-SlotsContainer\"]/div[5]/div[2]");
	final By CONFIRM_BOOKING = By.xpath("//*[@id=\"topButtonRow\"]/input[9]");
	final By NAV_TO_ESTIMATE = By.xpath("//a[contains(text(),'Shack Shine - QA Justin AutoTest')]");
	final By ADD_LINE_ITEM = By.xpath("//input[@title='Add Line Item']");
	final By FIRST_LINE_ITEM = By.id("01u1500000Pajyx");
	final By ESTIMATE_SELECT = By.xpath("//input[@title='Select']");
	final By QUANTITY_FIELD = By.id("Quantity01u1500000Pajyx");
	final By ESTIMATE_SAVE = By.xpath("//input[@title='Save']");
	final By ESTIMATE_EDIT = By.xpath("//input[@title='Edit']");
	final By PROMO_FIELD = By.id("CF00N1500000H6ank");
	final By GENERATE_SDOCS = By.xpath("//input[@title='Generate Docs']");
	final By ESTIMATE_SDOC = By.xpath("//input[@name='j_id0:j_id5:j_id49:j_id51:j_id52:j_id57:1:j_id59']");
	final By PROPOSAL_SDOC = By.xpath("//input[@name='j_id0:j_id5:j_id49:j_id51:j_id52:j_id57:8:j_id59']");
	final By NEXT_STEP_SDOC = By.xpath("//input[@name='j_id0:j_id5:j_id49:j_id51:j_id52:j_id55']");
	final By GENERATED = By.xpath("//span[contains(text(),'Generated')]");
	final By EMAIL_SELECTED = By.xpath("//a[contains(text(),'Email Selected Docs')]");
	final By EMAIL_TO_FIELD = By.id("j_id0:mainform:lookup:pbsPanel:emailTo");
	final By SEND_SDOCS = By.xpath("//input[@value='Send']");
	final By ADD_PAYMENT = By.xpath("//input[@title='New Payment']");
	final By PAYMENT_SAVE = By.xpath("//input[@title='Save']");
	final By PAYMENT_AMOUNT_FIELD = By.id("00N1500000H6alj");
	final By NAV_TO_OPPORTUNITY = By.xpath("//a[contains(text(),'Shack Shine - QA Justin AutoTest')]");
	
	
	
	
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
		
				boolean fpHomeDisplayed = wait.until(
				ExpectedConditions.titleIs("Shack Shine"));
		
				assertTrue(fpHomeDisplayed == true, "Franchise page is not displayed!");
		}

	public void createAccount() throws InterruptedException {
		WebElement accountLink = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_BUTTON));
				accountLink.click();
		
				boolean accountPageDisplayed = wait.until(
				ExpectedConditions.titleIs("Accounts: Home ~ Shack Shine"));
		
				assertTrue(accountPageDisplayed == true, "Account page is not displayed!");
		
		WebElement newAccount = wait.until(
				ExpectedConditions.elementToBeClickable(NEW_ACCOUNT_BUTTON));
				newAccount.click();
		
				/* Include a list box method here for person account - right now just testing for default value
					which is 'Person Account' */
				
				boolean newAccountSelectionDisplayed = wait.until(
				ExpectedConditions.urlContains("setup/ui/recordtypeselect.jsp?ent=Account"));
		
				assertTrue(newAccountSelectionDisplayed == true, "New account page is not displayed!");
		
		WebElement continueAccount = wait.until(
				ExpectedConditions.elementToBeClickable(NEW_ACCOUNT_CONTINUE_BUTTON));
				continueAccount.click();
		
		Thread.sleep(1000);
			
		WebElement inputFirstName = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_FIRSTNAME));
				inputFirstName.sendKeys(TEST_USER_FIRSTNAME);
		
		WebElement inputLastName = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_LASTNAME));
				inputLastName.sendKeys(TEST_USER_LASTNAME);
		
		WebElement inputPhoneNumber = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_PHONENUMBER));
				inputPhoneNumber.sendKeys(TEST_USER_PHONENUMBER);
				
		WebElement inputEmail = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_EMAIL));
				inputEmail.sendKeys(TEST_USER_EMAILADDRESS);
				
		WebElement inputStreetName = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_STREET));
				inputStreetName.sendKeys(TEST_USER_STREET);
				
		WebElement inputCity = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_CITY));
				inputCity.sendKeys(TEST_USER_CITY);		
						
		WebElement inputProvince = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_PROVICE));
				inputProvince.sendKeys(TEST_USER_PROVINCE);		
		
		WebElement inputZip = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_ZIPCODE));
				inputZip.sendKeys(TEST_USER_ZIP);
				
		WebElement inputCountry = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_COUNTRY));
				inputCountry.sendKeys(TEST_USER_COUNTRY);
		
		WebElement inputCopyBillingAddress = wait.until(
				ExpectedConditions.elementToBeClickable(COPY_BILLING_ADDRESS_CHECKBOX));
				inputCopyBillingAddress.click();

		WebElement saveAccount = wait.until(
				ExpectedConditions.elementToBeClickable(ACCOUNT_SAVE));
				saveAccount.click();
		
				
		}


	
	public void createOpportunity() {

		WebElement createOp = wait.until(
				ExpectedConditions.elementToBeClickable(CREATE_OPPORTUNITY));
				createOp.click();
		
		
		WebElement navigateOpportunity = wait.until(
				ExpectedConditions.elementToBeClickable(NAVIGATE_TO_OPPORTUNITY));
				navigateOpportunity.click();
	}
	
	public void scheduleService() throws InterruptedException {

		Thread.sleep(2500);
				
		driver.switchTo().frame("09D15000001SVUf_06615000003N7hK");
		
		Select ServiceType = new Select(driver.findElement(By.id("AN-ServiceTypeInput")));
		   ServiceType.selectByVisibleText("SS - On-Site Estimate");
		
		WebElement getAppointment = wait.until(
				ExpectedConditions.elementToBeClickable(CLICK_GET_APPOINTMENTS));
				getAppointment.click();
		
		Thread.sleep(7000);
		
		WebElement selectAppointment = wait.until(
				ExpectedConditions.elementToBeClickable(SELECT_APPOINTMENT));
				selectAppointment.click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		WebElement confirmBooking = wait.until(
				ExpectedConditions.elementToBeClickable(CONFIRM_BOOKING));
				confirmBooking.click();
				
	    Thread.sleep(4000);
	    
	    String bodyText2 = driver.findElement(By.id("lookup01s15000001zfs3Pricebook2")).getText();
		Assert.assertTrue(bodyText2.contains("Test Franchise Canada - SSH Residential"));
		System.out.println("Opportunity has correct pricebook: CA Residential");

	    
	    String bodyText = driver.findElement(By.id("00N1500000H6ak1_ileinner")).getText();
		Assert.assertTrue(bodyText.contains("On-Site Estimate Booked"));
		System.out.println("Status is correct: On-Site Estimate Booked");
					
	}
	
	/*Estimate - Adding line item, adding promo code*/
	
	public void EstimateWorkflow() {
		
		WebElement toEstimate = wait.until(
				ExpectedConditions.elementToBeClickable(NAV_TO_ESTIMATE));
				toEstimate.click();
				
		WebElement AddLineItemButton = wait.until(
						ExpectedConditions.elementToBeClickable(ADD_LINE_ITEM));
						AddLineItemButton.click();
						
		WebElement firstLineItem = wait.until(
						ExpectedConditions.elementToBeClickable(FIRST_LINE_ITEM));
						firstLineItem.click();
		
		WebElement estimateSelect = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_SELECT));
						estimateSelect.click();
		
		WebElement inputQuantity = wait.until(
						ExpectedConditions.elementToBeClickable(QUANTITY_FIELD));
						inputQuantity.sendKeys(LINE_ITEM_QUANTITY);
						
		WebElement saveLineItem = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_SAVE));
						saveLineItem.click();
								
						
		WebElement editEstimate = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_EDIT));
						editEstimate.click();
						
		WebElement inputPromo = wait.until(
						ExpectedConditions.elementToBeClickable(PROMO_FIELD));
						inputPromo.sendKeys(PROMO_CODE);
						
		WebElement saveEstimate = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_SAVE));
						saveEstimate.click();
						
	}
						
	
		/*SDOCS*/
		
		public void SdocWorkflow() throws InterruptedException {
			
		WebElement generateSdoc = wait.until(
						ExpectedConditions.elementToBeClickable(GENERATE_SDOCS));
						generateSdoc.click();
						
		Thread.sleep(1000);
			
		WebElement estimateSdoc = wait.until(
						ExpectedConditions.elementToBeClickable(ESTIMATE_SDOC));
						estimateSdoc.click();
		
		Thread.sleep(1000);
						
		WebElement proposalSdoc = wait.until(
						ExpectedConditions.elementToBeClickable(PROPOSAL_SDOC));
						proposalSdoc.click();
		
		Thread.sleep(1000);
						
		WebElement nextStepButton = wait.until(
						ExpectedConditions.elementToBeClickable(NEXT_STEP_SDOC));
						nextStepButton.click();
	
		Thread.sleep(20000);	
		
		WebElement emailSelectedSdocs = wait.until(
						ExpectedConditions.elementToBeClickable(EMAIL_SELECTED));
						emailSelectedSdocs.click();
				
		/*WebElement emailFill = wait.until(
						ExpectedConditions.elementToBeClickable(EMAIL_TO_FIELD));
						emailFill.sendKeys(TEST_USER_EMAILADDRESS); 
						
						-use this if email to field is not automatically populated
						*/
						
		Thread.sleep(1000);
				
		WebElement sendSdocs = wait.until(
						ExpectedConditions.elementToBeClickable(SEND_SDOCS));
						sendSdocs.click();
						
		Thread.sleep(1000);			
		
		WebElement navigateOpportunity = wait.until(
						ExpectedConditions.elementToBeClickable(NAVIGATE_TO_OPPORTUNITY));
						navigateOpportunity.click();
	
		String bodyText = driver.findElement(By.id("00N1500000H6ak1_ileinner")).getText();
		Assert.assertTrue(bodyText.contains("Estimate Presented"));
		System.out.println("Status is correct: Estimate Presented");	
				
		Thread.sleep(15000);	
		
		driver.navigate().refresh();
						
		String bodyText2 = driver.findElement(By.id("00N1500000H6ak1_ileinner")).getText();
		Assert.assertTrue(bodyText2.contains("Sold - Not Yet Scheduled"));
		System.out.println("Status is correct: Sold - Not Yet Scheduled");						
		
	}
		
		
		public void PaymentWorkflow() throws InterruptedException {
			
		WebElement NewPayment = wait.until(
					ExpectedConditions.elementToBeClickable(ADD_PAYMENT));
					NewPayment.click();
			
		WebElement inputAmount = wait.until(
					ExpectedConditions.elementToBeClickable(PAYMENT_AMOUNT_FIELD));
					inputAmount.sendKeys(PAYMENT_AMOUNT);
			
		Select TypePayment = new Select(driver.findElement(By.id("00N1500000H6alr")));
		TypePayment.selectByVisibleText("Cash");
		
		WebElement SavePayment = wait.until(
					ExpectedConditions.elementToBeClickable(PAYMENT_SAVE));
					SavePayment.click();
			
		WebElement navigateOpportunity = wait.until(
					ExpectedConditions.elementToBeClickable(NAV_TO_OPPORTUNITY));
					navigateOpportunity.click();
			
		
		String bodyText3 = driver.findElement(By.id("00N1500000H6ak1_ileinner")).getText();
			   Assert.assertTrue(bodyText3.contains("Paid"));
			   System.out.println("Status is correct: Paid");					
					
		}
	
	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		driver.get(SITE_URL);
		
		logIn();
		
		createAccount();
		
		createOpportunity();
		
		scheduleService();
		
		EstimateWorkflow();
		
		SdocWorkflow();
		
		PaymentWorkflow();
		
		//driver.quit();
		
	}

	

}

