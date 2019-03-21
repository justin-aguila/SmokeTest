
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


public class GjObeAU {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://request.1800gotjunk.com/";
	final String HOME_TITLE = "Online Booking Engine | 1-800-GOT-JUNK?";
	final String TEXT_CONTENT = "This is a test booking.";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "OBE Auto Test AU";
	final String TEST_USER_EMAILADDRESS = "o2esqa@yahoo.com";
	final String TEST_USER_UNIT = "123";
	final String TEST_USER_PHONENUMBER1 = "999";
	final String TEST_USER_PHONENUMBER2 = "9999999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_STATE = "BC";
	final String TEST_USER_CITY = "Testerville";
	final String TEST_USER_COUNTRY = "Australia";
	final String TEST_ZIP = "0001";
	final String PROMO_CODE = "Justin$PromoGJ";

	
	final By ZIP_BOX = By.id("frmZip");
	final By GO_BUTTON = By.id("edit-submit");
	final By TEXT_BOX = By.id("edit-jobdetails");
	final By DAY_SELECTION = By.xpath("//span[contains(text(),'Evening')]");
	final By TIME_SELECTION = By.xpath("//label[contains(text(),'pm')]");
	final By BUSINESS_CHECKBOX = By.id("edit-client-type-2");
	final By BUSINESS_NAME = By.id("edit-businessvalue");
	final By ADDRESS_BOX = By.id("street_number");
	final By ADDRESS_BOX_UNIT = By.id("edit-unitno");
	final By CITY_BOX = By.id("locality");
	final By STATE_BOX = By.id("administrative_area_level_1");
	final By FIRSTNAME_BOX = By.id("edit-firstname");
	final By LASTNAME_BOX = By.id("edit-lastname");
	final By EMAIL_BOX = By.id("edit-email");
	final By PHONE_BOX1 = By.id("areaCode");
	final By PHONE_BOX2 = By.id("phoneNo");
	final By PROMO_CHECKBOX = By.id("edit-promocode-notify");
	final By PROMO_BOX = By.id("edit-promocodevalue");
	


	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"c:/Selenium/chromedriver.exe");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}
	
	
	
	public void stepOne() throws InterruptedException {
		boolean isHomeDisplayed = wait.until(
                ExpectedConditions.titleIs(HOME_TITLE));

		assertTrue(isHomeDisplayed == true, "home page is not displayed!");
		
		WebElement zipBox = wait.until(
				ExpectedConditions.elementToBeClickable(ZIP_BOX));
				zipBox.sendKeys(TEST_ZIP);
				
		WebElement goStepTwo = wait.until(
						ExpectedConditions.elementToBeClickable(GO_BUTTON));
						goStepTwo.click();	
				
				
		Thread.sleep(2000);
		
		}

	public void stepTwo() throws InterruptedException {
	
		WebElement textBox = wait.until(
				ExpectedConditions.elementToBeClickable(TEXT_BOX));
				textBox.sendKeys(TEXT_CONTENT);
				
		Thread.sleep(1500);
				
		WebElement daySelect = wait.until(
				ExpectedConditions.elementToBeClickable(DAY_SELECTION));
				daySelect.click();	
				
		Thread.sleep(1000);	
				
				
		WebElement timeSelect = wait.until(
				ExpectedConditions.elementToBeClickable(TIME_SELECTION));
				timeSelect.click();	
				
	    Thread.sleep(1000);	
				
				
		WebElement goStepThree = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goStepThree.click();	
								
				
			Thread.sleep(1000);		
				
		}
	
	public void stepThree() throws InterruptedException {
		
		WebElement addressBox = wait.until(
				ExpectedConditions.elementToBeClickable(ADDRESS_BOX));
				addressBox.sendKeys(TEST_USER_STREET);
				
		WebElement unitBox = wait.until(
				ExpectedConditions.elementToBeClickable(ADDRESS_BOX_UNIT));
				unitBox.sendKeys(TEST_USER_UNIT);			
				
		WebElement cityBox = wait.until(
				ExpectedConditions.elementToBeClickable(CITY_BOX));
				cityBox.sendKeys(TEST_USER_CITY);	
								
		WebElement stateBox = wait.until(
				ExpectedConditions.elementToBeClickable(STATE_BOX));
				stateBox.sendKeys(TEST_USER_STATE);
				
		WebElement firstNameBox = wait.until(
				ExpectedConditions.elementToBeClickable(FIRSTNAME_BOX));
				firstNameBox.sendKeys(TEST_USER_FIRSTNAME);
						
		WebElement secondNameBox = wait.until(
				ExpectedConditions.elementToBeClickable(LASTNAME_BOX));
				secondNameBox.sendKeys(TEST_USER_LASTNAME);
								
		WebElement emailBox = wait.until(
				ExpectedConditions.elementToBeClickable(EMAIL_BOX));
				emailBox.sendKeys(TEST_USER_EMAILADDRESS);
										
		WebElement phoneOneBox = wait.until(
				ExpectedConditions.elementToBeClickable(PHONE_BOX1));
				phoneOneBox.sendKeys(TEST_USER_PHONENUMBER1);
				
		WebElement phoneTwoBox = wait.until(
				ExpectedConditions.elementToBeClickable(PHONE_BOX2));
				phoneTwoBox.sendKeys(TEST_USER_PHONENUMBER2);
				
		WebElement promoCheck = wait.until(
				ExpectedConditions.elementToBeClickable(PROMO_CHECKBOX));
				promoCheck.click();	
				
				
		WebElement promoInput = wait.until(
				ExpectedConditions.elementToBeClickable(PROMO_BOX));
				promoInput.sendKeys(PROMO_CODE);
				
																									
		WebElement goStepFour = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goStepFour.click();	
				
				
			Thread.sleep(1000);		
				
		}
	
	public void stepFour() throws InterruptedException {
		
								
		WebElement goStepThree = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goStepThree.click();	
								
				
			Thread.sleep(1500);	
			
	String bodyText = driver.findElement(By.xpath("//div[contains(text(),'Thank you')]")).getText();
		Assert.assertTrue(bodyText.contains("Thank you"));
		System.out.println("Thank you message was displayed.");
				
		}

	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		driver.get(SITE_URL);
		
		stepOne();
		
		stepTwo();
		
		stepThree();
		
		stepFour();
		
		
		driver.quit();
		
	}

	

}

