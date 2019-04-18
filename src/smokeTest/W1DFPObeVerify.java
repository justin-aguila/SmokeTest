
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


public class W1DFPObeVerify {

	ChromeDriver driver;
	WebDriverWait wait;
	
	final String SITE_URL2 = "https://o2ebrands.force.com/wow1day/login";
	final String HOME_TITLE2 = "Login | WOW 1 DAY PAINTING";
	final String USER_LOGIN ="w1dusa.fp.tester@wow1day.com.prod";
	final String PASSWORD_LOGIN = "wow1dayaccesspw1";
	final String SEARCHBOX_VALUE = "QA Justin OBE Auto Test";

	
	final By LOGIN_USER_NAME_BOX = By.id("username");
	final By LOGIN_PASSWORD_BOX = By.id("password");
	final By LOGIN_BUTTON = By.id("Login");
	final By ZIP_BOX = By.id("edit-zipcode");
	final By GO_BUTTON = By.id("edit-submit");
	final By SEARCHBOX = By.id("phSearchInput");
	final By SEARCH_BUTTON = By.id("phSearchButton");
	final By OPP_SELECT = By.xpath("//*[@id=\"Opportunity_body\"]/table/tbody/tr[2]/th/a");
	final By EDIT_BUTTON = By.xpath("//input[@title='Edit']");
	final By STATUS_FIELD = By.id("00N1500000H6ak1");
	final By CANCEL_REASON = By.id("00N1500000H6ajI");
	final By SAVE_BUTTON = By.xpath("//input[@title='Save']");






	
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
				ExpectedConditions.titleIs("WOW 1 DAY PAINTING"));
		
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
		
		//PIP-1784
		
		String bodyText = driver.findElement(By.id("00N1500000H6ak1_ileinner")).getText();
		Assert.assertTrue(bodyText.contains("On-Site Estimate Booked"));
		System.out.println("Status is correct: On-Site Estimate Booked");
		


		
		String bodyText3 = driver.findElement(By.id("00N1500000H6akM_ileinner")).getText();
		Assert.assertTrue(bodyText3.contains("QA Justin OBE Auto Test"));
		System.out.println("Onsite Contact Name is correct"); 
		
		String bodyText4 = driver.findElement(By.id("lookup00515000007TgIYopp1")).getText();
		Assert.assertTrue(bodyText4.contains("W1D USA FP Tester"));
		System.out.println("Account owner is correct: W1D USA FP Tester"); 
		
		

		
	}
	
	public void CancelOpp() throws InterruptedException {
		
		WebElement editClick = wait.until(
				ExpectedConditions.elementToBeClickable(EDIT_BUTTON));
				editClick.click();
				
			
		Select statusType2 = new Select(driver.findElement(STATUS_FIELD));
				   statusType2.selectByVisibleText("Canceled");
				  
				   
		Select cancelReason = new Select(driver.findElement(CANCEL_REASON));
				   cancelReason.selectByVisibleText("Not Ready");
				   
		WebElement saveClick = wait.until(
					ExpectedConditions.elementToBeClickable(SAVE_BUTTON ));
					saveClick.click();
		
		
	}

	
 
	@Test
	public void CompleteOpportunity() throws InterruptedException {
		
		
		driver.get(SITE_URL2); 
		
		logIn();
		
		searchOpp();
		
		OppVerify();
		
		CancelOpp();
		
		
		//driver.quit();
		
	}

	

}

