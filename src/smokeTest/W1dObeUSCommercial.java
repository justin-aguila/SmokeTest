
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


public class W1dObeUSCommercial {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL = "https://request.wow1day.com/";       
	final String HOME_TITLE = "WOW 1 DAY PAINTING | Online Booking Engine";
	final String TEXT_CONTENT = "This is a test booking.";
	final String TEST_USER_FIRSTNAME = "QA Justin";
	final String TEST_USER_LASTNAME = "OBE Auto Test";
	final String TEST_USER_EMAILADDRESS = "o2esqa@yahoo.com";
	final String TEST_USER_UNIT = "123";
	final String TEST_USER_PHONENUMBER1 = "999-999-9999";
	final String TEST_USER_STREET = "123 Test Street";
	final String TEST_USER_STATE = "CA";
	final String TEST_USER_CITY = "Testerville";
	final String TEST_USER_COUNTRY = "United States";
	final String TEST_ZIP = "00001";
	final String TEST_NOTES = "This is a test note.";

	
	final By ZIP_BOX = By.id("edit-zipcode");
	final By GO_BUTTON = By.id("edit-submit");
	final By INTERIOR_CHECK = By.xpath("//label[contains(text(),'Commercial')]");       
	final By TEXT_BOX = By.id("edit-details");
	final By DAY_SELECTION = By.xpath("//*[@id=\"edit-wrapper3--2\"]/div/div[2]/label/div");
	final By TIME_SELECTION = By.xpath("//*[@id=\"edit-day3-morning-appointments--2\"]/div[1]/label");
	final By ADDRESS_BOX = By.id("street_number");
	final By CITY_BOX = By.id("locality");
	final By STATE_BOX = By.id("administrative_area_level_1");
	final By FIRSTNAME_BOX = By.id("edit-first-name");
	final By LASTNAME_BOX = By.id("edit-last-name");
	final By EMAIL_BOX = By.id("edit-email");
	final By PHONE_BOX1 = By.id("edit-phone");
	final By NOTES_BOX = By.id("edit-notes");



	
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
				
				
		Thread.sleep(1500);
		
		}

	public void stepTwo() throws InterruptedException {
		
		WebElement interiorSelect = wait.until(
				ExpectedConditions.elementToBeClickable(INTERIOR_CHECK));
				interiorSelect.click();
	
		WebElement textBox = wait.until(
				ExpectedConditions.elementToBeClickable(TEXT_BOX));
				textBox.sendKeys(TEXT_CONTENT);

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
		
		WebElement addressBox = wait.until(
				ExpectedConditions.elementToBeClickable(ADDRESS_BOX));
				addressBox.sendKeys(TEST_USER_STREET);			
				
		WebElement cityBox = wait.until(
				ExpectedConditions.elementToBeClickable(CITY_BOX));
				cityBox.sendKeys(TEST_USER_CITY);	
								
		Select stateSelect = new Select(driver.findElement(STATE_BOX));
			   stateSelect.selectByVisibleText("California");
			   
		WebElement notesBox = wait.until(
				ExpectedConditions.elementToBeClickable(NOTES_BOX));
				notesBox.sendKeys(TEST_NOTES);
				
		Thread.sleep(3000);
				
				WebElement daySelect = wait.until(
				ExpectedConditions.elementToBeClickable(DAY_SELECTION));
				daySelect.click();	
						
	    Thread.sleep(1000);	
						
						
				WebElement timeSelect = wait.until(
				ExpectedConditions.elementToBeClickable(TIME_SELECTION));
				timeSelect.click();	
				
		
																									
		WebElement goStepFour = wait.until(
				ExpectedConditions.elementToBeClickable(GO_BUTTON));
				goStepFour.click();	
				
				
			Thread.sleep(1000);		
				
		}
	
	public void stepThree() throws InterruptedException {
		
	
			
	String bodyText = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/h1")).getText();
		Assert.assertTrue(bodyText.contains("THANK YOU"));
		System.out.println("Thank you message was displayed.");
				
		}

	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		driver.get(SITE_URL);
		
		stepOne();
		
		stepTwo();
		
		stepThree();
		
		
		driver.quit();
		
	}

	

}

