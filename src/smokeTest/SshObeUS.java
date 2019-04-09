
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


public class SshObeUS {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://request.shackshine.com/onlinebooking/";
	final String HOME_TITLE = "Shack Shine | Online Booking Engine";
	final String TEXT_CONTENT = "This is a test booking.";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "OBE Auto Test";
	final String TEST_USER_EMAILADDRESS = "o2esqa@yahoo.com";
	final String TEST_USER_UNIT = "123";
	final String TEST_USER_PHONENUMBER1 = "999-999-9999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_STATE = "BC";
	final String TEST_USER_CITY = "Testerville";
	final String TEST_USER_COUNTRY = "Canada";
	final String TEST_ZIP = "00006";
	final String TEST_NOTES = "This is a test note.";

	
	final By ZIP_BOX = By.id("edit-zipcode");
	final By GO_BUTTON = By.id("edit-submit");
	final By MEDSHACK_CHECK = By.xpath("//span[contains(text(),'Medium Shack')]");
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
				stateSelect.selectByVisibleText("California");
				
					
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
			
	

				
		}

	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		driver.get(SITE_URL);
		
		stepZero();
		
		stepOne();
		
		stepTwo();
		
		stepThree();
		
		
		driver.quit();
		
	}

	

}

